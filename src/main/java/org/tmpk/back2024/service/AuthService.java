package org.tmpk.back2024.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.entity.Session;
import org.tmpk.back2024.repos.LoggerRepo;
import org.tmpk.back2024.repos.OperatorRepo;
import org.tmpk.back2024.repos.SessionsRepo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@Slf4j
public class AuthService {
    @Autowired
    private OperatorRepo operatorRepo;
    @Autowired
    private LoggerRepo loggerRepo;
    @Autowired
    private SessionsRepo sessionsRepo;
    @Autowired
    private OperatorData operatorData;

    public Session logIn(String login, String password) {
        Long operatorId = checkAuth(login, password);
        if (operatorId != null) {
            return createOrUpdateSession(operatorId);
        }
        return null;
    }

    public Session logOut(Long operatorId) {
        Session session = getNonExpiredSessionByOperatorId(operatorId);
        if (session != null) {
            session.setExpiryTime(LocalDateTime.now());
            sessionsRepo.save(session);
            return session;
        }
        return null;
    }

    public Session logOut(String token) {
        Session session = getNonExpiredSessionByToken(token);
        if (session != null) {
            session.setExpiryTime(LocalDateTime.now());
            sessionsRepo.save(session);
            return session;
        }
        return null;
    }

    public Long checkAuth(String login, String password) {
        Operators operator = operatorData.getOperatorByLogin(login);
        if (operator != null) {
            if (operator.getPassword().equals(password)) {
                return operator.getId();
            }
        }
        return null;
    }

    public boolean checkAuth(String token) {
        try {
            return getNonExpiredSessionByToken(token.split(" ")[1]) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkAuth(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            return getNonExpiredSessionByToken(token.split(" ")[1]) != null;
        } catch (Exception e) {
            log.error("{}  -  {}", e.getClass(), e.getMessage());
            return false;
        }
    }

    public Session getNonExpiredSessionByToken(String token) {
        return sessionsRepo.findNonExpiredSessionByToken(token);
    }

    public Session getNonExpiredSessionByOperatorId(Long operatorId) {
        return sessionsRepo.findNonExpiredSessionByOperatorId(operatorId);
    }

    private Session createOrUpdateSession(Long operatorId) {
        Session session = getNonExpiredSessionByOperatorId(operatorId);
        if (session != null) {
            session.setExpiryTime(LocalDateTime.now().plusMinutes(30));
            sessionsRepo.save(session);
            return session;
        }
        session = Session.builder()
                .operatorId(operatorId)
                .created(LocalDateTime.now())
                .expiryTime(LocalDateTime.now().plusMinutes(30))
                .token(UUID.randomUUID().toString().replaceAll("-", ""))
                .build();
        sessionsRepo.save(session);
        return session;
    }

}
