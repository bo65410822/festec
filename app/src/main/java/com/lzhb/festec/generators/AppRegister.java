package com.lzhb.festec.generators;


import com.lzhb.latte.wechat.templates.AppRegisterTemplate;
import com.lzhb.latte_annotations.annotation.AppRegisterGenerator;

/**
 * author: Lzhb
 * created on: 2018/8/21 11:14
 * description:
 */
@AppRegisterGenerator(packageName = "com.lzhb.festec", registerTemplete = AppRegisterTemplate.class)
public interface AppRegister {

}
