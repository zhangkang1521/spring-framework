package org.zk.service;

import org.zk.service.bank.BankService;

/**
 * Created by Administrator on 5/26/2018.
 */
public class PayService {
    private BankService bankService;

    public BankService getBankService() {
        return bankService;
    }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }
}
