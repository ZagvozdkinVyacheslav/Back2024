//package org.tmpk.back2024.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.tmpk.back2024.entity.Expenses;
//import org.tmpk.back2024.entity.Logger;
//import org.tmpk.back2024.entity.ServiceTariff;
//import org.tmpk.back2024.repos.ExpensesRepo;
//import org.tmpk.back2024.repos.LoggerRepo;
//
//import java.util.List;
//
//@Service
//public class ExpensesService {
//    @Autowired
//    ExpensesRepo expensesRepo;
//    @Autowired
//    LoggerService loggerService;
//    public Expenses getExpensesById(Long operatorId) {
//        loggerService.addLog("getAllServicesTariff", null, operatorId);
//        return expensesRepo.findById(operatorId).get();
//    }
//    public Expenses getAllExpensesByClientId(Long clientId, Long operatorId) {
//        loggerService.addLog("getAllExpensesByClientId", clientId, operatorId);
//        return expensesRepo.findByClientId(clientId);
//    }
//}
