package com.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestZookeeper {

    private String connectString = "192.168.3.14:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> childs = null;
                try {
                    childs = zkClient.getChildren("/", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (String child : childs) {
                    System.out.println(child);
                }
            }
        });
    }

    @Test
    public void create() throws KeeperException, InterruptedException {
        String nodeName = zkClient.create("/node1", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(nodeName);
    }

    @Test
    public void getChildren() throws KeeperException, InterruptedException {
        List<String> childs = zkClient.getChildren("/", true);
        for (String child : childs) {
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/aaa", false);
        System.out.println(null == stat ? "not exist" : "exist");
    }
}
