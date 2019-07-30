package top.zoick.service.impl;


import top.zoick.service.IAccountService;

import java.util.Date;

/**
 * @author zoick
 * @date 2019/7/28 14:44
 */
public class AccountServiceImpl implements IAccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }


    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    @Override
    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了");
    }

}
