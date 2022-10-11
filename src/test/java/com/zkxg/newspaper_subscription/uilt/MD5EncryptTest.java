package com.zkxg.newspaper_subscription.uilt;

import com.zkxg.newspaper_subscription.util.MD5EncryptUtil;
import org.junit.Test;
import sun.security.provider.MD5;

/**
 * @author xiaohu
 * @date 2022/10/11/ 16:25
 * @description
 */
public class MD5EncryptTest {
    @Test
    public void test(){
        String s = "love";
        String encrypt = MD5EncryptUtil.string2MD5(s);
        System.out.println("加密：" + encrypt);
    }
}
