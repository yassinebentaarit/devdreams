package tn.esprit.devdream.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_event")
    private Long Id_event;
    @NotEmpty
    private String eventName;
    @NotEmpty
    private String description;
    @Temporal(TemporalType.DATE)
    @NotEmpty
    @Future
    private Date eventStart;
    @Temporal(TemporalType.DATE)
    @NotEmpty
    @Future
    private Date eventEnd;
    private float budget;
    private String feedback;
    private String poster;
    @OneToOne(mappedBy = "event")
    private Logistiques logistiques;
    @OneToMany(mappedBy = "event")
    private List<SessionEvent> sessionEventList;
    @OneToMany(mappedBy = "event")
    private List<OCTeam> ocTeamList;
    @ManyToOne
    private User organisateur;
    @ManyToMany
    private List<User> participantslist;
}
