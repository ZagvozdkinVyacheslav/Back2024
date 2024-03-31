package org.tmpk.back2024.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tmpk.back2024.entity.Correction;
import org.tmpk.back2024.entity.PaymentType;
import org.tmpk.back2024.entity.Payments;
import org.tmpk.back2024.service.CorrectionData;
import org.tmpk.back2024.service.PaymentsData;

import java.util.List;

@RestController("payments")
@RequestMapping("/api/payments")
public class PaymentsController {
    @Autowired
    PaymentsData paymentsData;
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/addPaymentType")
    public ResponseEntity<Long> addPaymentType(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "paymentName") String name
    ) {
        return ResponseEntity.ok(paymentsData.addPaymentType(operatorId, name));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAllPaymentType")
    public ResponseEntity<List<PaymentType>> getAllPaymentType(
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        return ResponseEntity.ok(paymentsData.getAllPaymentType(operatorId));
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getPaymentsByClientId")
    public ResponseEntity<List<Payments>> getPaymentsByClientId(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
            ) {
        return ResponseEntity.ok(paymentsData.getPaymentsByClientId(targetId, operatorId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/getPaymentId")
    public ResponseEntity<Payments> getPaymentId(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
    ) {
        return ResponseEntity.ok(paymentsData.getPaymentId(targetId, operatorId));
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/addPayment")
    public ResponseEntity<Long> addPayment(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestBody Payments payments
    ) {
        return ResponseEntity.ok(paymentsData.addPayment(operatorId, payments));
    }


}
