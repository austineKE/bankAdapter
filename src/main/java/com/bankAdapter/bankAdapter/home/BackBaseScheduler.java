//package com.bankAdapter.bankAdapter.home;
//
//import com.bankAdapter.bankAdapter.service.BackBase;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@EnableScheduling
//@Component
//public class BackBaseScheduler {
//    @Autowired
//    BackBase backBase;
//    @Scheduled(fixedRate = 500)
//    private void scheduleCalls(){
//        System.out.println("----------TNX--------");
//        System.out.println(backBase.getAllTransactions());
//    }
//}
