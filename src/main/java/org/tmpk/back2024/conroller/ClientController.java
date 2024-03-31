package org.tmpk.back2024.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tmpk.back2024.entity.Balance;
import org.tmpk.back2024.entity.Clients;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.service.ClientData;
import org.tmpk.back2024.service.OperatorData;

import java.util.List;

@RestController("client")
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientData clientData;
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAllClients")//все клиенты
    public ResponseEntity<List<Clients>> getAllClients(
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        return ResponseEntity.ok(clientData.getAllClients(operatorId));
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getClientById")//получение клиента по ид
    public ResponseEntity<Clients> getClientById(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
            ) {
        return ResponseEntity.ok(clientData.getClientById(operatorId, targetId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/addClient")//добавить оператора
    public ResponseEntity<Long> addClient(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestBody Clients client
    ) {
        return ResponseEntity.ok(clientData.addClient(operatorId, client));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/changeClient")//обновить Клиента
    public ResponseEntity<String> changeClient(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestBody Clients client
    ) {
        clientData.changeClient(operatorId, client);
        return ResponseEntity.ok("Клиент обновлен");
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/deleteClientById")//обновить оператора
    public ResponseEntity<String> deleteClientById(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
    ) {
        clientData.deleteClientById(operatorId, targetId);
        return ResponseEntity.ok("Оператор удален");
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getClientBalanceById")//все клиенты
    public ResponseEntity<Balance> getClientBalanceById(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
    ) {
        return ResponseEntity.ok(clientData.getClientBalanceById(operatorId, targetId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/terminateContract")
    public ResponseEntity<String> terminateContract(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
    ) {
        return clientData.terminateContract(operatorId, targetId);
    }

}
