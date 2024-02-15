package tn.esprit.devdream.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.devdream.entities.Event;

@Repository
public interface EventRepository extends CrudRepository <Event, Integer>{

}
