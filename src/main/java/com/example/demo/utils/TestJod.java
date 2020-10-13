package com.example.demo.utils;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.config.ConfigureBuilder;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.local.JodConverter;
import org.jodconverter.local.office.LocalOfficeManager;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：ligh
 * @date ：Created in 2020/10/9 0009 14:36
 */
public class TestJod {

    private static LocalOfficeManager officeManager;

    public static void main(String[] args) throws Exception{
        Map<String, Object> datas = new HashMap<String, Object>() {
            {
                put("time", "2019-05-31");
            };
        };

        Map map = new HashMap();
        map.put("time", "dkjfdlsj");
        map.put("aa","dfdsagfsdgffdsg");
        map.put("userName","lllll");
        map.put("orderNo","222222");
        map.put("youlu","youlu");

        System.out.println(datas);
        System.out.println(map);

        initOfficeManager();
        ConfigureBuilder builder = Configure.newBuilder();
        builder.setValidErrorHandler(new Configure.ClearHandler()); // 清除标签
        XWPFTemplate template = XWPFTemplate.compile("F:/测试/2.docx", builder.build()).render(
                map);
        String doc = "F:/测试/output.docx";
        FileOutputStream out = new FileOutputStream(doc);
        template.write(out);
        out.flush();
        out.close();
        template.close();

        JodConverter.convert(new File(doc)).to(new File("F:/测试/output.html")).execute();
        JodConverter.convert(new File(doc)).to(new File("F:/测试/output.pdf")).execute();

        OfficeUtils.stopQuietly(officeManager);

    }


    public static String word2Html(String file) throws Exception{
        String html;
        try {
            Map map = new HashMap();
            map.put("time", "dkjfdlsj");
            map.put("aa","dfdsagfsdgffdsg");
            map.put("userName","我我我");
            map.put("orderNo","123456789999999");
            map.put("youlu","youlu");

            initOfficeManager();
            ConfigureBuilder builder = Configure.newBuilder();
            builder.setValidErrorHandler(new Configure.ClearHandler()); // 清除标签
            XWPFTemplate template = XWPFTemplate.compile(file, builder.build()).render(
                    map);
            String doc = file.substring(0,file.lastIndexOf(".")) + "temp.docx";
            html = file.substring(0,file.lastIndexOf(".")) + "temp.html";

            FileOutputStream out = new FileOutputStream(doc);
            template.write(out);
            out.flush();
            out.close();
            template.close();
            JodConverter.convert(new File(doc)).to(new File(html)).execute();
        } finally {

            OfficeUtils.stopQuietly(officeManager);
        }

        return html;
    }

    public static String word2Pdf(String file) throws Exception{
        Map map = new HashMap();
        map.put("time", "dkjfdlsj");
        map.put("aa","dfdsagfsdgffdsg");
        map.put("userName","我我我");
        map.put("orderNo","123456789999999");
        map.put("youlu","youlu");

        initOfficeManager();
        ConfigureBuilder builder = Configure.newBuilder();
        builder.setValidErrorHandler(new Configure.ClearHandler()); // 清除标签
        XWPFTemplate template = XWPFTemplate.compile(file, builder.build()).render(
                map);
        String doc = file.substring(0,file.lastIndexOf(".")) + "temp.docx";
        String pdf = file.substring(0,file.lastIndexOf(".")) + "temp.pdf";

        FileOutputStream out = new FileOutputStream(doc);
        template.write(out);
        out.flush();
        out.close();
        template.close();
        JodConverter.convert(new File(doc)).to(new File(pdf)).execute();
        OfficeUtils.stopQuietly(officeManager);

        return pdf;
    }

    private static  void initOfficeManager() {
        try {
            officeManager = LocalOfficeManager.install();
            officeManager.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
