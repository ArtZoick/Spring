package top.zoick.factory;

import top.zoick.service.IAccountService;
import top.zoick.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 * @author zoick
 * @date 2019/7/29 15:18
 */
public class StaticFactory {

    public static IAccountService getAccountService2(){
        return new AccountServiceImpl();
    }
}
