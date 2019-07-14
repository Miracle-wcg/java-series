package com.poi.utils;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author Miracle.wzhucg
 * @Date 2019-07-14 21:53
 */
public class Doc4jConvert2Html {

    /**
     * 把.docx转成html
     *
     * @param docxPath 需要被转换的 docx 文件的路径
     * @param htmlPath 转换后保存的 html 文件的路径
     * @throws Exception
     */
    private static void convertDocxToHtml(String docxPath, String htmlPath) throws Exception {
        //加载.docx文件
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(docxPath));
        //设置输出HTML
        FileOutputStream outputStream = new FileOutputStream(new File(htmlPath));
        Docx4J.toHTML(wordMLPackage, "", "", outputStream);
        //删除嵌入字体的临时文件
        if (wordMLPackage.getMainDocumentPart().getFontTablePart() != null) {
            wordMLPackage.getMainDocumentPart().getFontTablePart().deleteEmbeddedFontTempFiles();
        }
        wordMLPackage = null;
    }

    public static void main(String[] args) throws Exception {
        convertDocxToHtml("/Users/chengangw/Desktop/test/lijuan.docx", "/Users/chengangw/Desktop/test/lijuan.html");
    }

}
