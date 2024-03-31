package org.tmpk.back2024.service;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmpk.back2024.entity.Correction;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.repos.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CorrectionData {
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private CorrectionRepo correctionRepo;
    @Autowired
    private ClientsRepo clientsRepo;

    public List<Correction> getAllCorrectionByClientId(Long clientId,Long operatorId) {
        loggerService.addLog("getAllCorrectionByClientId", clientId, operatorId);
        return correctionRepo.findAllByClientId(clientId);
    }
    public Correction getAllCorrectionById(Long targetId,Long operatorId) {
        loggerService.addLog("getAllCorrectionById", null, operatorId);
        return correctionRepo.findById(targetId).get();
    }

    public Long addCorrection(Long operatorId, Correction correction) {
        var client = clientsRepo.findById(correction.getClientId()).get();
        client.getBalance().setBalanceValue(Double.sum(client.getBalance().getBalanceValue(), correction.getValue()));
        client.getBalance().setModified(LocalDateTime.now());
        clientsRepo.save(client);
        correction.setCreated(LocalDateTime.now());
        var id = correctionRepo.save(correction).getId();
        loggerService.addLog(String.format("addCorrection cor id = %s", id), correction.getClientId(), operatorId);
        return id;
    }

//    public void changeOperator(Long operatorId, Operators operator) {
//        operator.setModified(LocalDateTime.now());
//        var id = operatorRepo.save(operator).getId();
//        loggerService.addLog(String.format("changeOperator id = %d", id), null, operatorId);
//    }
//
//    public void deleteOperatorById(Long operatorId, Long targetId) {
//        var operator = operatorRepo.findById(targetId).get();
//        operatorRepo.delete(operator);
//        loggerService.addLog(String.format("deleteOperatorById id = %d", targetId), null, operatorId);
//    }
//    public Operators getOperatorByLogin(String login) {
//        return operatorRepo.findByLogin(login);
//    }
}
