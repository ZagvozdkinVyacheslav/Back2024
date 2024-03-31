package org.tmpk.back2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmpk.back2024.entity.Correction;
import org.tmpk.back2024.entity.PaymentType;
import org.tmpk.back2024.entity.Payments;
import org.tmpk.back2024.repos.ClientsRepo;
import org.tmpk.back2024.repos.CorrectionRepo;
import org.tmpk.back2024.repos.PaymentTypeRepo;
import org.tmpk.back2024.repos.PaymentsRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentsData {
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private PaymentsRepo paymentsRepo;
    @Autowired
    private PaymentTypeRepo paymentTypeRepo;
    @Autowired
    private ClientsRepo clientsRepo;

    public Long addPaymentType(Long operatorId, String type) {
        var obj = new PaymentType();
        obj.setName(type);
        var id = paymentTypeRepo.save(obj).getId();
        loggerService.addLog(String.format("addPaymentType %s", type), null, operatorId);
        return id;
    }
    public List<PaymentType> getAllPaymentType(Long operatorId) {
        loggerService.addLog("getAllPaymentType", null, operatorId);
        return paymentTypeRepo.findAll();
    }
    public List<Payments> getPaymentsByClientId(Long clientId, Long operatorId) {
        loggerService.addLog("getAllCorrectionByClientId", clientId, operatorId);
        return paymentsRepo.findAllByClientId(clientId);
    }
    public Payments getPaymentId(Long targetId,Long operatorId) {
        loggerService.addLog("getAllCorrectionById", null, operatorId);
        return paymentsRepo.findById(targetId).get();
    }

    public Long addPayment(Long operatorId, Payments payment) {
        var client = clientsRepo.findById(payment.getClientId()).get();
        client.getBalance().setBalanceValue(Double.sum(client.getBalance().getBalanceValue(), payment.getValue()));
        client.getBalance().setModified(LocalDateTime.now());
        clientsRepo.save(client);
        payment.setPaymentType(paymentTypeRepo.findByName(payment.getPaymentType().getName()));
        var id = paymentsRepo.save(payment).getId();
        loggerService.addLog(String.format("addPayment id = ", id), payment.getClientId(), operatorId);
        return id;
    }


}
