package org.tmpk.back2024.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tmpk.back2024.entity.ServiceTariff;
import org.tmpk.back2024.repos.ServiceTariffRepo;
import org.tmpk.back2024.repos.TariffsRepo;
import org.tmpk.back2024.service.ServiceData;

import java.util.List;

@RestController("service")
public class ServiceController {
    @Autowired
    ServiceData serviceData;
    @PostMapping("/getAllServicesTariff")
    public ResponseEntity<List<ServiceTariff>> getAllServicesTariff(
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        return ResponseEntity.ok(serviceData.getAllServicesTariff(operatorId));
    }
    @PostMapping("/getServicesTariffByClientId")
    public ResponseEntity<List<ServiceTariff>> getServicesTariffByClientId(
            @RequestParam(value = "clientId") Long clientId,
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        return ResponseEntity.ok(serviceData.getServicesTariffByClientId(clientId, operatorId));
    }
    @DeleteMapping("/deleteAllServicesTariffByClientId")
    public ResponseEntity<String> deleteAllServicesTariffByClientId(
            @RequestParam(value = "clientId") Long clientId,
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        serviceData.deleteAllServicesTariffByClientId(clientId, operatorId);
        return ResponseEntity.ok("Удалено успешно");
    }
    @DeleteMapping("/deleteServicesTariffByItId")
    public ResponseEntity<String> deleteAllServicesTariffById(
            @RequestParam(value = "servicesTariffId") Long itId,
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        serviceData.deleteServicesTariffByItId(itId, operatorId);
        return ResponseEntity.ok("Удалено успешно");
    }
    @PostMapping("/addServicesTariff")
    public ResponseEntity<Long> addServicesTariff(
            @RequestParam(value = "clientId") Long clientId,
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "serviceId") Long serviceId,
            @RequestParam(value = "serviceId") Long tariffId
    ) {//return id
        return ResponseEntity.ok(serviceData.addServicesTariff(clientId, serviceId, tariffId, operatorId));
    }

}
