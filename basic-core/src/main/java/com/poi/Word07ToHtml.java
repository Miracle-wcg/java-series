package com.poi;

import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * @author miracle.wcg
 * @date 2019-07-08 23:31
 */
public class Word07ToHtml {
    public static void parseToHtml() throws IOException {
        File f = new File("/Users/chengangw/Desktop/test/aaa.docx");
        if (!f.exists()) {
            System.out.println("Sorry File does not Exists!");
        } else {
            if (f.getName().endsWith(".docx") || f.getName().endsWith(".DOCX")) {

                // 1) 加载XWPFDocument及文件
                InputStream in = new FileInputStream(f);
                XWPFDocument document = new XWPFDocument(in);

                // 2) 实例化XHTML内容(这里将会把图片等文件放到生成的"word/media"目录)
                File imageFolderFile = new File("/Users/chengangw/Desktop/test/opt");
                XHTMLOptions options = XHTMLOptions.create().URIResolver(
                        new FileURIResolver(imageFolderFile));
                options.setExtractor(new FileImageExtractor(imageFolderFile));
                //options.setIgnoreStylesIfUnused(false);
                //options.setFragment(true);

                // 3) 将XWPFDocument转成XHTML并生成文件
                OutputStream out = new FileOutputStream(new File(
                        "/Users/chengangw/Desktop/test/aaa.html"));
                XHTMLConverter.getInstance().convert(document, out, null);
            } else {
                System.out.println("Enter only MS Office 2007+ files");
            }
        }
    }

    public static void main(String args[]) {
        try {
            //String string = new String("寰蒋闆呴粦".getBytes("GBK"), "UTF-8");
            //System.out.println(string);
            parseToHtml();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
