package org.tmpk.back2024.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tmpk.back2024.entity.ServiceTariff;
import org.tmpk.back2024.entity.Services;
import org.tmpk.back2024.entity.Tariffs;
import org.tmpk.back2024.service.ServiceData;

import java.util.List;

@RestController("service")
@RequestMapping("/api/service")
public class ServiceController {
    @Autowired
    ServiceData serviceData;
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAllServicesTariff")//все связки тариф услуга
    public ResponseEntity<List<ServiceTariff>> getAllServicesTariff(
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        return ResponseEntity.ok(serviceData.getAllServicesTariff(operatorId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getServicesTariffByClientId")//все связки тариф услуга по ид клиента
    public ResponseEntity<List<ServiceTariff>> getServicesTariffByClientId(
            @RequestParam(value = "clientId") Long clientId,
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        return ResponseEntity.ok(serviceData.getServicesTariffByClientId(clientId, operatorId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/deleteAllServicesTariffByClientId")//Удаляет все услуги у клиента
    public ResponseEntity<String> deleteAllServicesTariffByClientId(
            @RequestParam(value = "clientId") Long clientId,
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        serviceData.deleteAllServicesTariffByClientId(clientId, operatorId);
        return ResponseEntity.ok("Удалено успешно");
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/deleteServicesTariffByItId")//Удаляет все услуги по ид клиента
    public ResponseEntity<String> deleteAllServicesTariffById(
            @RequestParam(value = "targetId") Long itId,
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        serviceData.deleteServicesTariffByItId(itId, operatorId);
        return ResponseEntity.ok("Удалено успешно");
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/addServicesTariff")// добавляет клиенту связку тариф услуга
    public ResponseEntity<Long> addServicesTariff(
            @RequestParam(value = "clientId") Long clientId,
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "serviceId") Long serviceId,
            @RequestParam(value = "tariffId") Long tariffId
    ) {//return id
        return ResponseEntity.ok(serviceData.addServicesTariff(clientId, serviceId, tariffId, operatorId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAllTariffs")//все тарифы
    public ResponseEntity<List<Tariffs>> getAllTariffs(
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        return ResponseEntity.ok(serviceData.getAllTariffs(operatorId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getTariffsById")//тариф по ид
    public ResponseEntity<Tariffs> getTariffsById(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
    ) {
        return ResponseEntity.ok(serviceData.getTariffsById(operatorId, targetId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/changeTariffById")//тариф меняется по новму телу
    public ResponseEntity<String> changeTariffById(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestBody Tariffs newValue

    ) {
        serviceData.changeTariff(operatorId, newValue);
        return ResponseEntity.ok("Тариф изменен");
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/addTariff")//тариф меняется по новму телу
    public ResponseEntity<Long> addTariff(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestBody Tariffs value
    ) {
        return ResponseEntity.ok(serviceData.addTariff(operatorId, value));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping ("/deleteTariffById")//тариф меняется по новму телу
    public ResponseEntity<String> deleteTariffById(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
    ) {
        serviceData.deleteTariffById(operatorId, targetId);
        return ResponseEntity.ok("Тариф удален");
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAllServices")//все услуги
    public ResponseEntity<List<Services>> getAllServices(
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        return ResponseEntity.ok(serviceData.getAllServices(operatorId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getServicesById")//услуга по ид
    public ResponseEntity<Services> getServicesById(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
    ) {
        return ResponseEntity.ok(serviceData.getServicesById(operatorId, targetId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/changeService")//услуга по ид
    public ResponseEntity<String> changeService(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestBody Services services
    ) {
        serviceData.changeService(operatorId, services);
        return ResponseEntity.ok("Услуга изменена");
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/addService")//добавить услугу
    public ResponseEntity<Long> addService(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestBody Services services
    ) {

        return ResponseEntity.ok(serviceData.addService(operatorId, services));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping ("/deleteServiceById")//Удаление услуги
    public ResponseEntity<String> deleteServiceById(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
    ) {
        serviceData.deleteServiceById(operatorId, targetId);
        return ResponseEntity.ok("Тариф удален");
    }
}
