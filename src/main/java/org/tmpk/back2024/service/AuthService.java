package org.tmpk.back2024.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmpk.back2024.entity.Operators;
import org.tmpk.back2024.entity.Sessions;
import org.tmpk.back2024.repos.LoggerRepo;
import org.tmpk.back2024.repos.OperatorRepo;
import org.tmpk.back2024.repos.SessionsRepo;

import java.time.LocalDateTime;
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

    public Sessions logIn(String login, String password) {
        Long operatorId = checkAuth(login, password);
        if (operatorId != null) {
            return createOrUpdateSession(operatorId);
        }
        return null;
    }

    public Sessions logOut(Long operatorId) {
        Sessions sessions = getNonExpiredSessionByOperatorId(operatorId);
        if (sessions != null) {
            sessions.setExpiryTime(LocalDateTime.now());
            sessionsRepo.save(sessions);
            return sessions;
        }
        return null;
    }

    public Sessions logOut(String token) {
        Sessions sessions = getNonExpiredSessionByToken(token);
        if (sessions != null) {
            sessions.setExpiryTime(LocalDateTime.now());
            sessionsRepo.save(sessions);
            return sessions;
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

    public Sessions getNonExpiredSessionByToken(String token) {
        return sessionsRepo.findNonExpiredSessionByToken(token);
    }

    public Sessions getNonExpiredSessionByOperatorId(Long operatorId) {
        return sessionsRepo.findNonExpiredSessionByOperatorId(operatorId);
    }

    private Sessions createOrUpdateSession(Long operatorId) {
        Sessions sessions = getNonExpiredSessionByOperatorId(operatorId);
        if (sessions != null) {
            sessions.setExpiryTime(LocalDateTime.now().plusMinutes(30));
            sessionsRepo.save(sessions);
            return sessions;
        }
        sessions = Sessions.builder()
                .operatorId(operatorId)
                .created(LocalDateTime.now())
                .expiryTime(LocalDateTime.now().plusMinutes(30))
                .token(UUID.randomUUID().toString().replaceAll("-", ""))
                .build();
        sessionsRepo.save(sessions);
        return sessions;
    }

}
