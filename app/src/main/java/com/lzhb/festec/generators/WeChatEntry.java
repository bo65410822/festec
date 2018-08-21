package com.lzhb.festec.generators;

import com.lzhb.latte.wechat.templates.WXEntryTemplate;
import com.lzhb.latte_annotations.annotation.EntryGenerator;

/**
 * author: Lzhb
 * created on: 2018/8/21 11:14
 * description:
 */
@EntryGenerator(packageName = "com.lzhb.festec", entryTemplete = WXEntryTemplate.class)
public interface WeChatEntry {
}
