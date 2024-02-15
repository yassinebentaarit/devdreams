package tn.esprit.devdream.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devdream.entities.OCTeam;
import tn.esprit.devdream.repositories.OCTeamRepository;
import tn.esprit.devdream.service.interfaces.IOCTeamService;

@Service
@Slf4j
public class OCTeamServiceImpl implements IOCTeamService {

    @Autowired
    OCTeamRepository oCTeamRep;
    @Override
    public OCTeam addOCTeam(OCTeam o) {
        oCTeamRep.save(o);
        return o;
    }
}
