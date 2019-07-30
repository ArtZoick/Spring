package top.zoick.service.impl;

import top.zoick.dao.IAccountDao;
import top.zoick.dao.impl.AccountDaoImpl;
import top.zoick.service.IAccountService;

/**
 * @author zoick
 * @date 2019/7/28 14:44
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
