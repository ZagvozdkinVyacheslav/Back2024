package org.tmpk.back2024.service;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmpk.back2024.entity.Clients;
import org.tmpk.back2024.entity.Logger;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.repos.ClientsRepo;
import org.tmpk.back2024.repos.LoggerRepo;
import org.tmpk.back2024.repos.OperatorRepo;

import java.time.LocalDateTime;

@Service
public class LoggerService {
    @Autowired
    private ClientsRepo clientsRepo;
    @Autowired
    private OperatorRepo operatorRepo;
    @Autowired
    private LoggerRepo loggerRepo;
    public void addLog(String actionType, Long clientId, Long operatorId){
        var logger = new Logger();
        logger.setActionType(actionType);
        logger.setCreated(LocalDateTime.now());
        if(clientId != null)
            logger.setClientId(clientsRepo.findById(clientId).get());
        if(operatorId != null)
            logger.setOperatorId(operatorRepo.findById(operatorId).get());
        loggerRepo.save(logger);
    }
}
