package org.tmpk.back2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmpk.back2024.entity.OperatorInfo;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.entity.Roles;
import org.tmpk.back2024.entity.ServiceTariff;
import org.tmpk.back2024.repos.*;

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

    public List<Operators> getAllOperators(Long operatorId) {
        loggerService.addLog("getAllOperators", null, operatorId);
        return operatorRepo.findAll();
    }
    public Operators getOperatorById(Long operatorId, Long targetId) {
        loggerService.addLog(String.format("getOperatorById target id = %d", targetId), null, operatorId);
        return operatorRepo.findById(targetId).get();
    }


}
