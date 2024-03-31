package org.tmpk.back2024.conroller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tmpk.back2024.entity.Session;
import org.tmpk.back2024.service.AuthService;
import org.tmpk.back2024.service.OperatorData;

@RestController("auth")
@Slf4j
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    OperatorData operatorData;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/logIn")
    public ResponseEntity<Session> logIn(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password
    ) {
        Session session = authService.logIn(login, password);
        if (session != null) {
            log.info(session.toString());
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/logOut")
    public ResponseEntity<?> logOut(
            HttpServletRequest request
    ) {
        String token = request.getHeader("Authorization");
        log.info("token = {}", token);
        if (!authService.checkAuth(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        Session session = authService.logOut(token.split(" ")[1]);
        if (session != null) {
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
