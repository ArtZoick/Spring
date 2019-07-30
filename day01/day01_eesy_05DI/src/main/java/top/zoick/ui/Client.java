package top.zoick.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.zoick.service.IAccountService;


/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {

        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象,两种方式
        IAccountService as = (IAccountService) ac.getBean("accountService3");

        as.saveAccount();

    }
}
