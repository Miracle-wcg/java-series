package com.cm.MutilThread.Chapter01.t4_threadsafe;

/**
 * @author chengawu
 * @date 1/11/2019 5:32 PM
 */
public class LoginServlet {
    private static String usenameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username, String password) {
        try {
            usenameRef = username;
            if ("a".equals(username)) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username=" + usenameRef + ",password=" + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
