package org.tmpk.back2024.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmpk.back2024.entity.OperatorInfo;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.entity.Roles;
import org.tmpk.back2024.entity.ServiceTariff;
import org.tmpk.back2024.repos.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperatorData {
    @Autowired
    LoggerService loggerService;
    @Autowired
    OperatorInfoRepo operatorInfoRepo;
    @Autowired
    RolesRepo rolesRepo;
    @Autowired
    OperatorRepo operatorRepo;

    @Autowired
    EntityManager entityManager;
    public List<Operators> getAllOperators(Long operatorId) {
        loggerService.addLog("getAllOperators", null, operatorId);
        return operatorRepo.findAll();
    }
    public Operators getOperatorById(Long operatorId, Long targetId) {
        loggerService.addLog(String.format("getOperatorById target id = %d", targetId), null, operatorId);
        return operatorRepo.findById(targetId).get();
    }
    @Transactional
    public Long addOperator(Long operatorId, Operators operator) {
        var oirId = operatorInfoRepo.saveAndFlush(operator.getOperatorInfo()).getId();
        rolesRepo.saveAndFlush(operator.getRole());
        operator.setCreated(LocalDateTime.now());
        var id = operatorRepo.saveAndFlush(operator).getId();
        loggerService.addLog(String.format("addOperator id = %d", id), null, operatorId);
        return id;
    }
    public void changeOperator(Long operatorId, Operators operator) {
        operatorInfoRepo.save(operator.getOperatorInfo());
        rolesRepo.save(operator.getRole());
        operator.setModified(LocalDateTime.now());
        var id = operatorRepo.save(operator).getId();
        loggerService.addLog(String.format("changeOperator id = %d", id), null, operatorId);
    }

    public void deleteOperatorById(Long operatorId, Long targetId) {
        var operator = operatorRepo.findById(targetId).get();
        operatorInfoRepo.delete(operator.getOperatorInfo());
        operatorRepo.delete(operator);
        loggerService.addLog(String.format("deleteOperatorById id = %d", targetId), null, operatorId);
    }
}
