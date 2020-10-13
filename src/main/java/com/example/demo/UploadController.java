package com.example.demo;

import com.example.demo.utils.TestJod;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 这是一个文件上传的demo
 */
@Controller
@ResponseBody
public class UploadController {

    @PostMapping("/up2html")
    public String accept(MultipartFile upload) {
        //判断文件是否为空
        if(upload.isEmpty()!=true){
            //获得文件名
            String name=upload.getOriginalFilename();
            //对文件名进行加工
            String filename=this.add(name);
            //获得目标文件夹路径
            ApplicationHome app=new ApplicationHome(getClass());
            String dirpath=app.getSource().getParentFile().toString();
            String filepath=dirpath+"\\classes\\upload\\" + filename;
            try {
                //保存文件
                upload.transferTo(new File(filepath));
                //保存文件
                String html = TestJod.word2Html(filepath);
                return  html;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("上传失败");
            }
        } else {
            System.out.println("上传文件为空！");
        }
        return "上传失败";
    }

    @PostMapping("/up2pdf")
    public String acceptpdf(MultipartFile upload) {
        //判断文件是否为空
        if(upload.isEmpty()!=true){
            //获得文件名
            String name=upload.getOriginalFilename();
            //对文件名进行加工
            String filename=this.add(name);
            //获得目标文件夹路径
            ApplicationHome app=new ApplicationHome(getClass());
            String dirpath=app.getSource().getParentFile().toString();
            String filepath=dirpath+"\\classes\\upload\\" + filename;
            try {
                //保存文件
                upload.transferTo(new File(filepath));
                //保存文件
                String html = TestJod.word2Pdf(filepath);
                return  html;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("上传失败");
            }
        } else {
            System.out.println("上传文件为空！");
        }
        return "上传失败";
    }

    public String add(String str){
        System.out.println(str);
        String name[]=str.split("\\.");
        System.out.println(Arrays.toString(name));
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String filename=name[0]+"-"+sdf.format(date)+"."+name[1];
        return filename;
    }
}
