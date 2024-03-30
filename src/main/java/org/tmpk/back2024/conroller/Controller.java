package org.tmpk.back2024.conroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tmpk.back2024.entity.Balance;

@RestController("service")
public class Controller {
    @Autowired
    private ObjectMapper mapper;
    @PostMapping("/addWorker")

    public ResponseEntity<String> addWorker(
            @RequestBody() String json
    ) throws JsonProcessingException {
        Balance balance = mapper.readValue(json, Balance.class);


        return ResponseEntity.ok("sd");
    }

}
