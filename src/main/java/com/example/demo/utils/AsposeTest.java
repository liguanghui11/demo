package com.example.demo.utils;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author ：ligh
 * @date ：Created in 2020/10/29 0029 14:12
 */
public class AsposeTest {

    private static final String dir = "E:\\协议\\20200423--整合后协议\\新版\\";

    public static void main(String[] args) throws Exception{

        // load the file to be converted
        Document wpd = new Document(dir + "11.doc");
        // convert doc to docx, PDF and HTML
        wpd.save(dir + "output.docx", SaveFormat.DOCX);
        wpd.save(dir + "output.pdf", SaveFormat.PDF);
        wpd.save(dir + "output.html", SaveFormat.HTML);

        fomathtml(dir + "output.pdf");

    }

    public static  String fomathtml(String file) throws Exception{
        //StringBuilder builder = new StringBuilder(text);

        FileInputStream inputStream = new FileInputStream(new File(file));
        byte[] bytes = new byte[2048];
        int i = 0;
        while ((i = inputStream.read(bytes)) > 0){
            String s = new String(bytes);
            System.out.println(s);
        }

        return null;

    }

}
