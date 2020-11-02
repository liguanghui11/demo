package com.example.demo.utils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

/**
 * 把pdf转换为word格式
 *
 * @author ligh
 * @date 2020/10/9 0018.
 */
public class PdfToWord {
    /**
     * 转换
     */
    public void convertText(String pdfPath) {
        PDDocument doc = null;
        OutputStream fos = null;
        Writer writer = null;
        PDFTextStripper stripper = null;
        try {

            doc = PDDocument.load(new File(pdfPath));

            fos = new FileOutputStream(pdfPath.substring(0, pdfPath.indexOf(".")) + ".doc");

            writer = new OutputStreamWriter(fos, "UTF-8");
            stripper = new PDFTextStripper();

            int pageNumber = doc.getNumberOfPages();

            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pageNumber);
            stripper.writeText(doc, writer);

            writer.close();
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end..");
    }
}

class MainClass {
    public static void main(String[] args) {
        PdfToWord convert=new PdfToWord();
        convert.convertText("E:\\协议\\e文件\\2020_10_30_14_50_01.pdf");
    }
}