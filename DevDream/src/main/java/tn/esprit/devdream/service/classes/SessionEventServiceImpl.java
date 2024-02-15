package tn.esprit.devdream.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devdream.entities.SessionEvent;
import tn.esprit.devdream.repositories.SessionEventRepository;
import tn.esprit.devdream.service.interfaces.ISessionEventService;

@Service
@Slf4j
public class SessionEventServiceImpl implements ISessionEventService
{

    @Autowired
    SessionEventRepository sessionEventRep;
    @Override
    public SessionEvent addSessionEvent(SessionEvent s) {
        sessionEventRep.save(s);
        return s;
    }
}
