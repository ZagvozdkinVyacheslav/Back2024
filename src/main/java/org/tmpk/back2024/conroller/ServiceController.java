package org.tmpk.back2024.conroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tmpk.back2024.entity.Balance;

@RestController("service")
public class ServiceController {
    @PostMapping("/getAllServices")

    public ResponseEntity<String> getAllServices(
    ) {


        return ResponseEntity.ok("sd");
    }
}
