package com.bankAdapter.bankAdapter.service;

import com.bankAdapter.bankAdapter.dto.BackBaseObj;
import com.bankAdapter.bankAdapter.openBankObj.Transaction;
import com.bankAdapter.bankAdapter.service.BackBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackBaseImpl implements BackBase {
    @Autowired
    OpenBankService openBankService;

    @Override
    public List<BackBaseObj> getAllTransactions() {
        List<BackBaseObj> backBaseObjs = new ArrayList<>();
        BackBaseObj backBaseObj = new BackBaseObj();
        if (openBankService != null) {
            for (Transaction transaction : openBankService.getAllTransactions()) {
                backBaseObj.setId(transaction.getId());
                backBaseObj.setAccountId(transaction.getThis_account().getId());
                backBaseObj.setCounterpartyAccount(transaction.getOther_account().getNumber());
                backBaseObj.setCounterpartyName(transaction.getOther_account().getHolder().getName());
                backBaseObj.setCounterPartyLogoPath(transaction.getOther_account().getMetadata().getImage_URL());
                backBaseObj.setInstructedAmount(transaction.getDetails().getValue().getAmount());
                backBaseObj.setInstructedCurrency(transaction.getDetails().getValue().getCurrency());
                backBaseObj.setTransactionAmount(transaction.getDetails().getValue().getAmount());
                backBaseObj.setTransactionCurrency(transaction.getDetails().getValue().getCurrency());
                backBaseObj.setTransactionType(transaction.getDetails().getType());
                backBaseObj.setDescription(transaction.getDetails().getDescription());
                backBaseObjs.add(backBaseObj);
            }
        }
        return backBaseObjs;
    }

    @Override
    public List<BackBaseObj> getAllTransactionsBasedOnType(String type) {
        List<BackBaseObj> list=new ArrayList<>();
        BackBaseObj baseObj = new BackBaseObj();
        if (openBankService != null){
            for (Transaction trans : openBankService.getAllTransactionsBasedOnType(type)){
                baseObj.setId(trans.getId());
                baseObj.setAccountId(trans.getThis_account().getId());
                baseObj.setCounterpartyAccount(trans.getOther_account().getNumber());
                baseObj.setCounterpartyName(trans.getOther_account().getHolder().getName());
                baseObj.setCounterPartyLogoPath(trans.getOther_account().getMetadata().getImage_URL());
                baseObj.setInstructedAmount(trans.getDetails().getValue().getAmount());
                baseObj.setInstructedCurrency(trans.getDetails().getValue().getCurrency());
                baseObj.setTransactionAmount(trans.getDetails().getValue().getAmount());
                baseObj.setTransactionCurrency(trans.getDetails().getValue().getCurrency());
                baseObj.setTransactionType(trans.getDetails().getType());
                baseObj.setDescription(trans.getDetails().getDescription());
                list.add(baseObj);
            }
        }
        return list;
    }

    @Override
    public Double getTotalTransactionsAmountBasedOnType(String type) {
        double amount=openBankService.getTotalTransactionsAmountBasedOnType(type);
        return amount;
    }
}
