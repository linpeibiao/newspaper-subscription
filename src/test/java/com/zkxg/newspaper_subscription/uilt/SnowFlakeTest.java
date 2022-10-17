package com.zkxg.newspaper_subscription.uilt;

import com.zkxg.newspaper_subscription.util.SnowFlakeGenerateWorker;
import org.junit.Test;

/**
 * @author xiaohu
 * @date 2022/10/15/ 15:52
 * @description
 */
public class SnowFlakeTest {
    SnowFlakeGenerateWorker s = new SnowFlakeGenerateWorker(0L,0L);
    @Test
    public void test(){
        System.out.println(s.generateNextId());
    }
}
