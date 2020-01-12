package com.poi;

import org.docx4j.convert.out.html.AbstractHtmlExporter;
import org.docx4j.convert.out.html.AbstractHtmlExporter.HtmlSettings;
import org.docx4j.convert.out.html.HtmlExporterNG2;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * @author miracle.wcg
 * @date 2019-07-09 00:45
 */
public class HelloWorldToHTML {
    public static void main(String[] args) {
        createHTML();
    }

    private static void createHTML() {
        try {
            long start = System.currentTimeMillis();

            // 1) Load DOCX into WordprocessingMLPackage
            InputStream is = new FileInputStream(new File(
                    "/Users/chengangw/Desktop/test/aaa.docx"));
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
                    .load(is);

            // 2) Prepare HTML settings
            HtmlSettings htmlSettings = new HtmlSettings();

            // 3) Convert WordprocessingMLPackage to HTML
            OutputStream out = new FileOutputStream(new File(
                    "/Users/chengangw/Desktop/test/aaa.html"));
            AbstractHtmlExporter exporter = new HtmlExporterNG2();
            StreamResult result = new StreamResult(out);
            exporter.html(wordMLPackage, result, htmlSettings);

            System.err.println("Generate html/HelloWorld.html with "
                    + (System.currentTimeMillis() - start) + "ms");

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
