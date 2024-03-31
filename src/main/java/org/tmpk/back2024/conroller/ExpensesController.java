//package org.tmpk.back2024.conroller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.tmpk.back2024.entity.Expenses;
//import org.tmpk.back2024.entity.ServiceTariff;
//import org.tmpk.back2024.entity.Services;
//import org.tmpk.back2024.entity.Tariffs;
//import org.tmpk.back2024.service.ExpensesService;
//import org.tmpk.back2024.service.ServiceData;
//
//import java.util.List;
//
//@RestController("expenses")
//@RequestMapping("/api/expenses")
//public class ExpensesController {
//    @Autowired
//    ExpensesService expensesService;
//    @CrossOrigin(origins = "http://localhost:5173")
//    @GetMapping("/getExpensesById")
//    public ResponseEntity<Expenses> getExpensesById(
//            @RequestParam(value = "operatorId") Long operatorId
//    ) {
//        return ResponseEntity.ok(expensesService.getExpensesById(operatorId));
//    }
//    @CrossOrigin(origins = "http://localhost:5173")
//    @GetMapping("/getAllExpensesByClientId")
//    public ResponseEntity<Expenses> getAllExpensesByClientId(
//            @RequestParam(value = "clientId") Long clientId,
//            @RequestParam(value = "operatorId") Long operatorId
//    ) {
//        return ResponseEntity.ok(expensesService.getAllExpensesByClientId(operatorId, clientId));
//    }
//
//
//}
