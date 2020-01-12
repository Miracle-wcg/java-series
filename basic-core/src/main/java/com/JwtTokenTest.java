package com;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;

/**
 * @author miracle.wcg
 * @date 2019-06-27 23:23
 */
public class JwtTokenTest {
    public static void main(String[] args) {
        try {
            String token = JWT.create().withAudience("111").sign(Algorithm.HMAC256("aaa"));
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
