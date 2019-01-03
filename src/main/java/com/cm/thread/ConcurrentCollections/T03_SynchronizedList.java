package com.cm.thread.ConcurrentCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chengawu
 * @date 12/24/2018 3:56 PM
 */
public class T03_SynchronizedList {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        List<String> syncLs = Collections.synchronizedList(ls);
    }
}
