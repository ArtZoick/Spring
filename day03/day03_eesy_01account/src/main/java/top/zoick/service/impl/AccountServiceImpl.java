package top.zoick.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AccountServiceImpl implements IAccountService {


    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行事务
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //有错误则回滚
            txManager.rollback();
            throw new  RuntimeException(e);
        } finally {
            //释放连接
            txManager.release();
        }
    }

    /**
     * 查询一个
     *
     * @param accountId
     * @return
     */
    @Override
    public Account findAccountByID(Integer accountId) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行事务
            Account account = accountDao.findAccountByID(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        } catch (Exception e) {
            //有错误则回滚
            txManager.rollback();
            throw new  RuntimeException(e);
        } finally {
            //释放连接
            txManager.release();
        }

    }

    /**
     * 保存
     *
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行事务
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //有错误则回滚
            txManager.rollback();
            throw new  RuntimeException(e);
        } finally {
            //释放连接
            txManager.release();
        }

    }

    /**
     * 更新
     *
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行事务
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //有错误则回滚
            txManager.rollback();
            throw new  RuntimeException(e);
        } finally {
            //释放连接
            txManager.release();
        }


    }

    /**
     * 删除
     *
     * @param accountId
     */
    @Override
    public void deleteAccount(Integer accountId) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行事务
            accountDao.deleteAccount(accountId);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //有错误则回滚
            txManager.rollback();
            throw new  RuntimeException(e);
        } finally {
            //释放连接
            txManager.release();
        }

    }

    /**
     * 转账
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {


        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作

            //2.1根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney() - money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney() + money);
            //2.5更新转出账户
            accountDao.updateAccount(source);

            int i=1/0;

            //2.6更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();

        } catch (Exception e) {
            //4.回滚操作
            txManager.rollback();
            e.printStackTrace();
        } finally {
            //5.释放连接
            txManager.release();
        }

    }
}