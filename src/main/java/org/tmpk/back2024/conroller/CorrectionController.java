package org.tmpk.back2024.conroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tmpk.back2024.entity.Correction;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.service.AuthService;
import org.tmpk.back2024.service.CorrectionData;
import org.tmpk.back2024.service.OperatorData;

import java.util.List;

@RestController("correction")
@RequestMapping("/api/correction")
public class CorrectionController {
    @Autowired
    CorrectionData correctionData;
    @Autowired
    AuthService authService;
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAllCorrectionByClientId")//все операторы
    public ResponseEntity<List<Correction>> getAllCorrectionByClientId(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId, HttpServletRequest request
    ) {
        String token = request.getHeader("Authorization");
        if (!authService.checkAuth(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(correctionData.getAllCorrectionByClientId(targetId, operatorId));
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAllCorrectionById")//получение оператора по ид
    public ResponseEntity<Correction> getAllCorrectionById(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestParam(value = "targetId") Long targetId, HttpServletRequest request
            ) {
        String token = request.getHeader("Authorization");
        if (!authService.checkAuth(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(correctionData.getAllCorrectionById(targetId, operatorId));
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/addCorrection")//добавить correction
    public ResponseEntity<Long> addCorrection(
            @RequestParam(value = "operatorId") Long operatorId,
            @RequestBody Correction correction, HttpServletRequest request
    ) {
        String token = request.getHeader("Authorization");
        if (!authService.checkAuth(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(correctionData.addCorrection(operatorId, correction));
    }
   // у корректион нет удаления тк, не будет сохраняться данных
    //корекшн если надо удалять то делаем еще 1 коррекшн на зачисление

}
