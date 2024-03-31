package org.tmpk.back2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmpk.back2024.entity.ServiceTariff;
import org.tmpk.back2024.entity.Services;
import org.tmpk.back2024.entity.Tariffs;
import org.tmpk.back2024.repos.*;

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
    ClientStatusTypeRepo clientStatusTypeRepo;
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
        var msg = String.format("deleteServicesTariffByItId, client id = %s", serviceTariffRepo.findById(serviceTariffId).get().getClientid());
        loggerService.addLog(msg, null, operatorId);
        serviceTariffRepo.deleteById(serviceTariffId);
    }
    public Long addServicesTariff(Long clientId, Long serviceId, Long tariffId, Long operatorId) {
        var client = clientsRepo.findById(clientId).get();
        client.setClientStatusType(clientStatusTypeRepo.findByName("Активен"));
        clientsRepo.save(client);
        var serviceTariff = new ServiceTariff();
        serviceTariff.setClientid(client.getId());
        serviceTariff.setServices(serviceRepo.findById(serviceId).get());
        serviceTariff.setTariffs(tariffsRepo.findById(tariffId).get());
        var id = serviceTariffRepo.save(serviceTariff).getId();
        loggerService.addLog(String.format("addServicesTariff id = %s",id), clientId, operatorId);
        return id;
    }
    public List<Tariffs> getAllTariffs(Long operatorId){
        loggerService.addLog("getAllTariffs", null, operatorId);
        return tariffsRepo.findAll();

    }
    public Tariffs getTariffsById(Long operatorId, Long targetId){
        loggerService.addLog(String.format("getTariffsById id = %s", targetId), null, operatorId);
        return tariffsRepo.findById(targetId).get();

    }
    public void changeTariff(Long operatorId, Tariffs tariff){
        loggerService.addLog(String.format("changeTariff id = %s", tariff.getId()), null, operatorId);
        tariffsRepo.save(tariff);
    }
    public Long addTariff (Long operatorId, Tariffs tariff){
        var id = tariffsRepo.save(tariff).getId();
        loggerService.addLog(String.format("addTariff id = %s", id), null, operatorId);
        return id;
    }
    public void deleteTariffById (Long operatorId, Long targetId){
        try {
            serviceTariffRepo.deleteAllByTariffId(targetId);
        }catch (Exception e){}
        tariffsRepo.deleteById(targetId);
        loggerService.addLog(String.format("deleteTariffById id = %s, all connected serviceTariffs deleted", targetId), null, operatorId);
    }
    public List<Services> getAllServices(Long operatorId){
        loggerService.addLog("getAllServices", null, operatorId);
        return serviceRepo.findAll();
    }

    public Services getServicesById(Long operatorId, Long targetId){
        loggerService.addLog(String.format("getTariffsById id = %s", targetId), null, operatorId);
        return serviceRepo.findById(targetId).get();

    }
    public void changeService (Long operatorId, Services services){
        loggerService.addLog(String.format("changeService id = %s", services.getId()), null, operatorId);
        serviceRepo.save(services);
    }
    public Long addService (Long operatorId, Services services){
        var id = serviceRepo.save(services).getId();
        loggerService.addLog(String.format("addService id = %s", id), null, operatorId);
        return id;
    }
    public void deleteServiceById (Long operatorId, Long targetId){
        try {
            serviceTariffRepo.deleteAllByServiceId(targetId);
        }catch (Exception e){}
        serviceRepo.deleteById(targetId);
        loggerService.addLog(String.format("deleteServiceById id = %s, all connected serviceTariffs deleted", targetId), null, operatorId);
    }
}
