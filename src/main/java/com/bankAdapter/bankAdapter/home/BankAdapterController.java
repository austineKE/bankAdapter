package com.bankAdapter.bankAdapter.home;


import com.bankAdapter.bankAdapter.dto.BackBaseObj;
import com.bankAdapter.bankAdapter.openBankObj.Transaction;
import com.bankAdapter.bankAdapter.service.BackBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BankAdapterController {

    @Autowired
    BackBase backBase;

    @GetMapping("/transaction/list")
    List<BackBaseObj> getAllTransactions() {
        return backBase.getAllTransactions();
    }

    @GetMapping("/transaction/list/{type}")
    List<BackBaseObj> transactionsInType(@PathVariable String type) {
        return backBase.getAllTransactionsBasedOnType(type);
    }

    @GetMapping("/totalAmount/{type}")
    Double totalAmountInType(@PathVariable String type) {
        return backBase.getTotalTransactionsAmountBasedOnType(type);
    }

}
