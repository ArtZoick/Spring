package top.zoick.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import top.zoick.dao.IAccountDao;

/**
 * 账户的持久层实现类
 * @author zoick
 * @date 2019/7/28 14:50
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {

    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        System.out.println("Baocunle zhang hu11111111111111");
    }
}
