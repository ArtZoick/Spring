package top.zoick.ui;

import top.zoick.factory.BeanFactory;
import top.zoick.service.IAccountService;
import top.zoick.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
       IAccountService accountService = new AccountServiceImpl();

       accountService.saveAccount();

        for(int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}
