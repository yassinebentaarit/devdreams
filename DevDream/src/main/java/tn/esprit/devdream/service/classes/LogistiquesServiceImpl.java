package tn.esprit.devdream.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devdream.entities.Event;
import tn.esprit.devdream.entities.Logistiques;
import tn.esprit.devdream.repositories.LogistiquesRepository;
import tn.esprit.devdream.service.interfaces.ILogistiquesService;

@Service
@Slf4j
public class LogistiquesServiceImpl implements ILogistiquesService {

    @Autowired
    LogistiquesRepository logistiquesRep;
    @Override
    public Logistiques addLogistiques (Logistiques l) {
        logistiquesRep.save(l);
        return l;
    }
//    @Override
//    public Logistiques updateLogistiques ()
}
