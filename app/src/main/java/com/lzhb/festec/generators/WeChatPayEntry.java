package com.lzhb.festec.generators;

import com.lzhb.latte.wechat.templates.WXPayEntryTemplate;
import com.lzhb.latte_annotations.annotation.PayEntryGenerator;

/**
 * author: Lzhb
 * created on: 2018/8/21 11:14
 * description:
 */
@PayEntryGenerator(packageName = "com.lzhb.festec", payEntryTemplete = WXPayEntryTemplate.class)
public interface WeChatPayEntry {
}
