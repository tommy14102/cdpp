package com.travelsky.b2g.b2gcommon.util;

import java.util.Random;

/**
 * Created by zhuxiaoyu on 16/4/24.
 */
public class IdentifyCode {
    /**
     * 产生6位随机数
     * @return
     */
    public static String generateIdentify() {
        Random random = new Random();
        // TODO 产生6位随机数 有问题
        int identifyingCode = random.nextInt(1000000);
        String identifying = String.format("%06d", identifyingCode);
        return identifying;
    }

}
