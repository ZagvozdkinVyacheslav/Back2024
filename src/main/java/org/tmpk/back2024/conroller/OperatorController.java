package org.tmpk.back2024.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.entity.ServiceTariff;
import org.tmpk.back2024.service.OperatorData;
import org.tmpk.back2024.service.ServiceData;

import java.util.List;

@RestController("operator")
public class OperatorController {
    @Autowired
    OperatorData operatorData;
    @GetMapping("/getAllOperators")//все операторы
    public ResponseEntity<List<Operators>> getAllOperators(
            @RequestParam(value = "operatorId") Long operatorId
    ) {
        return ResponseEntity.ok(operatorData.getAllOperators(operatorId));
    }
    @GetMapping("/getOperatorById")//получение оператора по ид
    public ResponseEntity<Operators> getAllOperators(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId
            ) {
        return ResponseEntity.ok(operatorData.getOperatorById(operatorId, targetId));
    }


}
