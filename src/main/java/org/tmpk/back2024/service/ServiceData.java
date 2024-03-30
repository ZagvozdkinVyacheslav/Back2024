package org.tmpk.back2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmpk.back2024.entity.Clients;
import org.tmpk.back2024.entity.ServiceTariff;
import org.tmpk.back2024.repos.ClientsRepo;
import org.tmpk.back2024.repos.ServiceTariffRepo;
import org.tmpk.back2024.repos.ServicesRepo;
import org.tmpk.back2024.repos.TariffsRepo;

import java.util.List;

@Service
public class ServiceData {
    @Autowired
    ServiceTariffRepo serviceTariffRepo;
    @Autowired
    ClientsRepo clientsRepo;
    @Autowired
    ServicesRepo serviceRepo;
    @Autowired
    TariffsRepo tariffsRepo;
    @Autowired
    LoggerService loggerService;
    public List<ServiceTariff> getAllServicesTariff(Long operatorId) {
        loggerService.addLog("getAllServicesTariff", null, operatorId);
        return serviceTariffRepo.findAll();
    }
    public List<ServiceTariff> getServicesTariffByClientId(Long clientId, Long operatorId) {
        loggerService.addLog("getServicesTariffByClientId", clientId, operatorId);
        return serviceTariffRepo.findAllByClientId(clientId);
    }
    public void deleteAllServicesTariffByClientId(Long clientId, Long operatorId) {
        loggerService.addLog("deleteAllServicesTariffByClientId", clientId, operatorId);
        for (var el: serviceTariffRepo.findAllByClientId(clientId)
             ) {
            serviceTariffRepo.deleteById(el.getId());
        }
    }

    public void deleteServicesTariffByItId(Long serviceTariffId, Long operatorId) {
        var msg = String.format("deleteServicesTariffByItId, client id = %s", serviceTariffRepo.findById(serviceTariffId).get().getClientId().getId());
        loggerService.addLog(msg, null, operatorId);
        serviceTariffRepo.deleteById(serviceTariffId);
    }
    public Long addServicesTariff(Long clientId, Long serviceId, Long tariffId, Long operatorId) {
        var serviceTariff = new ServiceTariff();
        serviceTariff.setClientId(clientsRepo.findById(clientId).get());
        serviceTariff.setServicesId(serviceRepo.findById(serviceId).get());
        serviceTariff.setTariffsId(tariffsRepo.findById(tariffId).get());
        var id = serviceTariffRepo.save(serviceTariff).getId();
        loggerService.addLog(String.format("addServicesTariff id = %s",id), clientId, operatorId);
        return id;
    }
}
