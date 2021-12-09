package com.study.springmvc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    public static final String SUCCESS = "success";

    /**
     * 传统方式文件上传
     *
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        //使用fileUpload组件完成文件上传
        //上传的位置，获取到上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //创建File对象，一会向该路径下上传文件
        File file = new File(path);
        //判断该路径是否存在
        if (!file.exists()) {
            file.mkdirs();
        }

        //解析request对象，获取上传文件项
        //创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        //遍历
        for (FileItem item : fileItems) {
            //判断，当前item对象是否是文件上传项
            if (item.isFormField()) {
                //说明是个普通表单项
            } else {
                //说明是个文件上传项
                //获取上传文件的名称
                String filename = item.getName();

                //设置文件名称为唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;

                //完成文件上传
                item.write(new File(path, filename));
                //删除临时文件
                item.delete();
            }
        }

        return SUCCESS;
    }

    /**
     * 基于SpringMVC实现文件上传
     *
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("基于SpringMVC文件上传");
        //使用fileUpload组件完成文件上传
        //上传的位置，获取到上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //创建File对象，一会向该路径下上传文件
        File file = new File(path);
        //判断该路径是否存在
        if (!file.exists()) {
            file.mkdirs();
        }

        //说明是个文件上传项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();

        //设置文件名称为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        //完成文件上传
        upload.transferTo(new File(path,filename));

        return SUCCESS;
    }

    /**
     * 基于SpringMVC跨服务器文件上传
     *
     * @return
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload) throws Exception {
        System.out.println("基于SpringMVC跨服务器文件上传");

        //定义上传服务器的路径
        String path = "http://localhost:9090/uploads/";

        //说明是个文件上传项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //将文件名进行URL编码，这一步是使得可以上传中文命名的文件
        filename = URLEncoder.encode(filename,"UTF-8");

        //设置文件名称为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        //创建客户端的对象
        Client client = Client.create();

        //和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);

        //上传文件
        webResource.put(upload.getBytes());

        return SUCCESS;
    }
}
