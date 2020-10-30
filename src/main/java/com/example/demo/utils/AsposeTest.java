package com.example.demo.utils;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

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

    }

    public String fomathtml(String text){
        StringBuilder builder = new StringBuilder(text);


        return null;

    }

}
