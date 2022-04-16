package com.chasion.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName FileUpAndDownController
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/14 9:49
 */
@Controller
public class FileUpAndDownController {

    @RequestMapping(value = "/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        FileInputStream fis = new FileInputStream(realPath);
        //创建字节数组
        // available()是获取输入流字节
        byte[] bytes = new byte[fis.available()];
        //将流读到字节数组中
        fis.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers =  new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        //这一行必须要有
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus httpStatus = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, httpStatus);
        //关闭输入流
        fis.close();
        return responseEntity;

    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //处理文件重名问题，名字用uuid代替，后缀不变
        // 获取上传文件的文件名
        String filename = photo.getOriginalFilename();
        // 获取文件的后缀
        String suffixName = filename.substring(filename.lastIndexOf("."));
        // 将uuid作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 将uuid和后缀名拼接
        filename =  uuid + suffixName;
        // 通过ServletContext获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if (!file.exists()){
            file.mkdir();
        }
        String realPath = photoPath + File.separator + filename;
        photo.transferTo(new File(realPath));
        return "success";


    }

}
