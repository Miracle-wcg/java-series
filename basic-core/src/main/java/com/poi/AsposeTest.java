package com.poi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.Iterator;

/**
 * @author miracle.wcg
 * @date 2019-07-11 00:01
 */
public class AsposeTest {
    public static void main(String[] args) {
        try {
//            Document document = new Document("/Users/chengangw/Desktop/test/lijuan.docx");
//            document.save("/Users/chengangw/Desktop/test/lijuan.html", SaveFormat.HTML_FIXED);
            File input = new File("/Users/chengangw/Desktop/test/lijuan.html");
            Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
            Elements allElements = doc.getAllElements();
//            Elements elements = doc.select("style='color:#ff0000;left:0pt;top:0.74pt;'");
//            Elements elements = doc.select("span:contains('Aspose')");
//            Elements elements = doc.select("span[style='color:#ff0000; left:0pt; top:0.74pt;']");
//            Elements elements1 = doc.select("span[style='color:#ff0000; left:0pt; top:21.64pt;']");
            Elements elements = doc.select("span[style*='color:#ff0000; left:0pt;']");
            Elements elements1 = doc.select("img[style*='left:21pt; top:304.53pt; width:674pt; height:366.3pt;']");
            elements.addAll(elements1);
            Iterator<Element> iterator = elements.iterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                element.attr("style","display:none");
            }
            String string = doc.toString();
//            <span class="awspan awtext001" style="color:#ff0000; left:0pt; top:0.74pt;">Created with an evaluation copy of Aspose.Words. To discover the full versions of our APIs please visit: </span>
            System.out.println(111);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
