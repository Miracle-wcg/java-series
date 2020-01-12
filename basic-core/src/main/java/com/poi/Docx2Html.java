package com.poi;

import org.docx4j.Docx4J;
import org.docx4j.Docx4jProperties;
import org.docx4j.convert.out.HTMLSettings;
import org.docx4j.model.images.AbstractWordXmlPicture;
import org.docx4j.model.images.ConversionImageHandler;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.samples.AbstractSample;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author miracle.wcg
 * @date 2019-07-08 23:52
 */
public class Docx2Html extends AbstractSample {
    public static void main(String[] args) throws Exception {
        String inputfilepath = "/Users/chengangw/Desktop/test/lijuan.docx";
        boolean nestLists = true;

        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
                .load(new File("/Users/chengangw/Desktop/test/lijuan.docx"));

        HTMLSettings htmlSettings = Docx4J.createHTMLSettings();

        htmlSettings.setImageDirPath(inputfilepath + "_files");
        htmlSettings.setImageTargetUri(inputfilepath.substring(inputfilepath.lastIndexOf("/") + 1) + "_files");
        htmlSettings.setWmlPackage(wordMLPackage);

        String userCSS = null;
        if (nestLists) {
            userCSS = "html, body, div, span, h1, h2, h3, h4, h5, h6, p, a, img,  table, caption, tbody, tfoot, thead, tr, th, td "
                    + "{ margin: 0; padding: 0; border: 0;}" + "body {line-height: 1;} ";
        } else {
            userCSS = "html, body, div, span, h1, h2, h3, h4, h5, h6, p, a, img,  ol, ul, li, table, caption, tbody, tfoot, thead, tr, th, td "
                    + "{ margin: 0; padding: 0; border: 0;}" + "body {line-height: 1;} ";

        }
        userCSS = "body {padding: 30px;}";
        htmlSettings.setUserCSS(userCSS);

        Docx4jProperties.setProperty("docx4j.Convert.Out.HTML.OutputMethodXML", true);
        FileOutputStream outputStream = new FileOutputStream(new File("/Users/chengangw/Desktop/test/lijuan.html"));

//        Docx4J.toHTML(htmlSettings, outputStream, Docx4J.FLAG_EXPORT_PREFER_XSL);
        Docx4J.toHTML(wordMLPackage, "", "", outputStream);

        if (wordMLPackage.getMainDocumentPart().getFontTablePart() != null) {
            wordMLPackage.getMainDocumentPart().getFontTablePart().deleteEmbeddedFontTempFiles();
        }
        htmlSettings = null;
        wordMLPackage = null;
    }
}
