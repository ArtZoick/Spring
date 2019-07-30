package top.zoick.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.zoick.dao.IAccountDao;
import top.zoick.service.IAccountService;
import top.zoick.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取spring的ioc容器，并根据id获取对象
     *
     * ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
     * FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
     * AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
     * 核心容器的两个接口引发出的问题：
     *      ApplicationContext:     单例对象适用              采用此接口
     *          它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
     *
     *      BeanFactory:            多例对象使用
     *          它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象,两种方式
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);


        System.out.println(as);
        System.out.println(adao);
    }
}
