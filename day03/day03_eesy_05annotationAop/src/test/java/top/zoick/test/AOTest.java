package top.zoick.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.zoick.service.IAccountService;

/**
 * @author zoick
 * @date 2019/8/6 19:26
 */
public class AOTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        accountService.saveAccount();
    }
}
