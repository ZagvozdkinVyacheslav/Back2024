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

    public Long addOperator(Long operatorId, Operators operator) {
        operator.setCreated(LocalDateTime.now());
        operator.setRole(rolesRepo.findByName(operator.getRole().getName()));
        var id = operatorRepo.save(operator).getId();
        loggerService.addLog(String.format("addOperator id = %d", id), null, operatorId);
        return id;
    }
    public void changeOperator(Long operatorId, Operators operator) {
        operator.setModified(LocalDateTime.now());
        var id = operatorRepo.save(operator).getId();
        loggerService.addLog(String.format("changeOperator id = %d", id), null, operatorId);
    }

    public void deleteOperatorById(Long operatorId, Long targetId) {
        var operator = operatorRepo.findById(targetId).get();
        operatorRepo.delete(operator);
        loggerService.addLog(String.format("deleteOperatorById id = %d", targetId), null, operatorId);
    }
    public Operators getOperatorByLogin(String login) {
        return operatorRepo.findByLogin(login);
    }
}
