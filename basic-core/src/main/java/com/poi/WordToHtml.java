package com.poi;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.converter.WordToHtmlUtils;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * @author miracle.wcg
 * @date 2019-07-08 22:03
 */
public class WordToHtml {

    // doc转换为html
    public String docToHtml(String sourceFileName, String targetFileName, String imagePathStr) throws Exception {
        sourceFileName = "/Users/chengangw/Desktop/test/中文_WCG (1).doc";
        targetFileName = "/Users/chengangw/Desktop/test/中文_WCG (1).html";
        imagePathStr = "/Users/chengangw/Desktop/test/image/";
        HWPFDocumentCore wordDocument = WordToHtmlUtils.loadDoc(new FileInputStream(sourceFileName));
        WordToHtmlConverter wordToHtmlConverter = new ImageWordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        .newDocument());
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(new File(targetFileName));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        File file = new File(targetFileName);//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s = bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
//            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
        return str;
    }


    //docx转换html
    public String docxToHtml(String fileName) throws IOException {
        XWPFDocument docxDocument = new XWPFDocument(new FileInputStream(fileName));
        // 配置
        XHTMLOptions options = XHTMLOptions.create();
        // 设置图片存储路径
        String path = System.getProperty("java.io.tmpdir");
        String firstImagePathStr = path + String.valueOf(System.currentTimeMillis());
        options.setExtractor(new FileImageExtractor(new File(firstImagePathStr)));
        options.URIResolver(new BasicURIResolver(firstImagePathStr));
        // 转换html
        ByteArrayOutputStream htmlStream = new ByteArrayOutputStream();
        XHTMLConverter.getInstance().convert(docxDocument, htmlStream, null);
        String htmlStr = htmlStream.toString();
        // 将image文件转换为base64并替换到html字符串里
        String middleImageDirStr = "/word/media";
        String imageDirStr = firstImagePathStr + middleImageDirStr;
        File imageDir = new File(imageDirStr);
        String[] imageList = imageDir.list();
        if (imageList != null) {
            for (int i = 0; i < imageList.length; i++) {
                String oneImagePathStr = imageDirStr + "/" + imageList[i];
                File oneImageFile = new File(oneImagePathStr);
                String imageBase64Str = new String(Base64.encodeBase64(FileUtils.readFileToByteArray(oneImageFile)), "UTF-8");
                htmlStr = htmlStr.replace(oneImagePathStr, "data:image/png;base64," + imageBase64Str);
            }
        }
        //删除图片路径
        File firstImagePath = new File(firstImagePathStr);
        FileUtils.deleteDirectory(firstImagePath);
        System.out.println(htmlStr);

        byte[] htmlStrBytes = htmlStr.getBytes();
        OutputStream outputStream = null;
        String targetFileName = "/Users/chengangw/Desktop/test/aaa.html";
        outputStream = new FileOutputStream(targetFileName);
        outputStream.write(htmlStrBytes, 0, htmlStrBytes.length);

        outputStream.close();
        return htmlStr;
    }

    public static void main(String arg[]) throws Exception {
        WordToHtml test = new WordToHtml();
//        test.docToHtml("", "", "");
        test.docxToHtml("/Users/chengangw/Desktop/test/aaa.docx");
//        System.out.println(test.docxToHtml("F://舆情分析.docx").toString());

    }
}
