package com.poi;

import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Base64;

/**
 * @author miracle.wcg
 * @date 2019-07-08 22:02
 */
public class ImageWordToHtmlConverter extends WordToHtmlConverter {
    public ImageWordToHtmlConverter(Document document) {
        super(document);
    }

    @Override
    protected void processImageWithoutPicturesManager(Element currentBlock,
                                                      boolean inlined, Picture picture) {
        Element imgNode = currentBlock.getOwnerDocument().createElement("img");
        StringBuilder sb = new StringBuilder();
        sb.append(Base64.getMimeEncoder().encodeToString(picture.getRawContent()));
        sb.insert(0, "data:" + picture.getMimeType() + ";base64,");
        imgNode.setAttribute("src", sb.toString());
        currentBlock.appendChild(imgNode);
    }

}
