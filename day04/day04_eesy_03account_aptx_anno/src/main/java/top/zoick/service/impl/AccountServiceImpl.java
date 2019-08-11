package top.zoick.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zoick.dao.IAccountDao;
import top.zoick.domain.Account;
import top.zoick.service.IAccountService;
import top.zoick.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务控制应该都是在业务层
 */
/**
 * 账户的业务层实现类
 *
 * 事务控制应该都是在业务层
 */
@Service
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountByID(Integer accountId) {
        return accountDao.findAccountByID(accountId);

    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);

            int i=1/0;

        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}