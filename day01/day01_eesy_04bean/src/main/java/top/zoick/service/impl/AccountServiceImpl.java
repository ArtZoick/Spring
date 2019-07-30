package top.zoick.service.impl;


import top.zoick.service.IAccountService;

/**
 * @author zoick
 * @date 2019/7/28 14:44
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了");
    }

    public void init(){
        System.out.println("对象初始化了");
    }

    public void destroy(){
        System.out.println("对象销毁了");
    }
}
