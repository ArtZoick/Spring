package top.zoick.service.impl;

import top.zoick.service.IAccountService;

/**
 * @author zoick
 * @date 2019/8/6 15:24
 */
public class AccountServiceImpl implements IAccountService {

    /**
     * 模拟保存账户
     */
    @Override
    public void saveAccount() {

        System.out.println("保存...");

    }

    /**
     * 模拟更新账户
     *
     * @param i
     */
    @Override
    public void updateAccount(int i) {
        System.out.println("更新...");

    }

    /**
     * 删除账户
     *
     * @return
     */
    @Override
    public int deleteAccount() {
        System.out.println("删除...");
        return 0;
    }
}
