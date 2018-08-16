package com.lzhb.latte.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: Lzhb
 * created on: 2018/8/16 14:42
 * description:
 */

public class LatteUtil {
    /**
     * 判断手机号是否符合规范
     *
     * @param mobiles 输入的手机号
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
