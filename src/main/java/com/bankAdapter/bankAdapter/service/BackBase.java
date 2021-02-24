package com.bankAdapter.bankAdapter.service;

import com.bankAdapter.bankAdapter.dto.BackBaseObj;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BackBase {
    List<BackBaseObj> getAllTransactions();
    List<BackBaseObj> getAllTransactionsBasedOnType(final String type);
    Double getTotalTransactionsAmountBasedOnType(final String type);
}
