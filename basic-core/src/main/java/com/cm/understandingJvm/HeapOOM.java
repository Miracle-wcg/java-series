package com.cm.understandingJvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengawu
 * @date 12/25/2018 10:47 AM
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
