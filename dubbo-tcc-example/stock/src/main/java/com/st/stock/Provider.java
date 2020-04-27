package com.st.stock;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by edolphin on 16-9-27.
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        String[] config = {"provider.xml", "tcc-transaction.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        com.alibaba.dubbo.container.Main.main(args);
    }
}
