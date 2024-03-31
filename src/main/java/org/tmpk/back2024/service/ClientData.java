package org.tmpk.back2024.service;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tmpk.back2024.entity.Balance;
import org.tmpk.back2024.entity.Clients;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.repos.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientData {
    @Autowired
    LoggerService loggerService;
    @Autowired
    ClientsRepo clientsRepo;
    @Autowired
    ClientInfoRepo clientInfoRepo;
    @Autowired
    ClientTypeRepo clientTypeRepo;
    @Autowired
    ClientStatusTypeRepo clientStatusTypeRepo;
    @Autowired
    ServiceData serviceData;
    @Autowired
    BalanceRepo balanceRepo;
    public List<Clients> getAllClients(Long operatorId) {
        loggerService.addLog("getAllClients", null, operatorId);
        return clientsRepo.findAll();
    }
    public Clients getClientById(Long operatorId, Long targetId) {
        loggerService.addLog(String.format("getClientById target id = %d", targetId), null, operatorId);
        return clientsRepo.findById(targetId).get();
    }

    public Long addClient(Long operatorId, Clients client) {
        client.setCreated(LocalDateTime.now());
        client.setClientStatusType(clientStatusTypeRepo.findByName("Подключен"));
        var info = client.getClientInfo();
        info.setClientType(clientTypeRepo.findByName(client.getClientInfo().getClientType().getName()));
        clientInfoRepo.save(info);
        clientInfoRepo.flush();
        var id = clientsRepo.save(client).getId();
        loggerService.addLog("addClient", id, operatorId);
        return id;
    }
    public void changeClient(Long operatorId, Clients client) {
        client.setModified(LocalDateTime.now());
        var id = clientsRepo.save(client).getId();
        loggerService.addLog(String.format("changeClient id = %d", id), null, operatorId);
    }

    public void deleteClientById(Long operatorId, Long targetId) {
        var operator = clientsRepo.findById(targetId).get();
        clientsRepo.delete(operator);
        loggerService.addLog(String.format("deleteClientById id = %d", targetId), null, operatorId);
    }
    public Balance getClientBalanceById(Long operatorId, Long targetId) {
        loggerService.addLog("getClientBalanceById", targetId, operatorId);
        return balanceRepo.findById(clientsRepo.findById(targetId).get().getBalance().getId()).get();
    }

    public ResponseEntity<String> terminateContract(Long operatorId, Long targetId) {
        var client = clientsRepo.findById(targetId).get();
        if (client.getBalance().getBalanceValue() >= 0){
            client.setClientStatusType(clientStatusTypeRepo.findByName("Расторгнут"));
            clientsRepo.save(client);
            serviceData.deleteAllServicesTariffByClientId(targetId, operatorId);
            loggerService.addLog("terminateContract", targetId, operatorId);
            return ResponseEntity.ok("Контракт расторгнут");
        }
        return ResponseEntity.status(400).body("Контракт не расторгнут, баланс отрицательный");
    }
}
