package tn.esprit.devdream.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String identifiant;
    private String Nom;
    private String Prenom;
    private String CIN;
    @Email(message = "Invalid email address")
    private String email;
    private String mdp;
    @Enumerated(EnumType.STRING)
    private Niveau Niveau;
    @Enumerated(EnumType.STRING)
    private Specialte Specialite;
    @Enumerated(EnumType.STRING)
    private Role Rolee;
    private Boolean Disponibilite;
    private String Image;
    private String ChargeTravail;

    @OneToMany(mappedBy = "creator")
    private List<Offre> offreList;

    @OneToMany(mappedBy = "encadrant")
    public List<Tache> taches_encadrant;

    @OneToMany(mappedBy = "etudiant")
    public List<Tache> taches_etudiant;



    @OneToOne(mappedBy = "envois")
    private Message msgenv;

    @OneToOne(mappedBy = "recevois")
    private Message msgrecu;

    @OneToMany(mappedBy = "posteur")
    private List<Post> posts;

    @OneToMany(mappedBy = "reclamateur")
    private List<Reclamation> reclamations;

    @OneToMany(mappedBy = "cible_reclamation")
    private List<Reclamation> reclamations_recu;
    @OneToMany(mappedBy = "etudiant")
    private List<Application> applicationList;

    @OneToMany(mappedBy = "etudiant")
    private List<Depot> depotList;




    private List<Interaction> interactions;
    @OneToMany(mappedBy = "user")
    public List<Interaction> getInteractions(){


        return interactions;
    }
    public void setInteractions(List<Interaction> interactions){

        this.interactions=interactions;
    }



    private List<CommentairePost> commentairePostList;
    @OneToMany(mappedBy = "user")
    public List<CommentairePost> getCommentairePostList(){


        return commentairePostList;
    }
    public void setCommentairePostList(List<CommentairePost> commentairePostList){

        this.commentairePostList=commentairePostList;
    }



    private List<Evaluation> evaluations;
    @OneToMany(mappedBy = "user")
    public List<Evaluation> getEvaluations(){


        return evaluations;
    }
    public void setEvaluations(List<Evaluation> evaluations){

        this.evaluations=evaluations;
    }

    @OneToMany(mappedBy = "organisateur")
    private List<Event> eventList;

    @ManyToMany(mappedBy = "participantslist")
    private List<Event> participantsEventList;

    @OneToMany(mappedBy = "Createur_formation")
    private List<Formation> formationscreee; //chkoun 3mal el formation

    @ManyToMany(mappedBy = "participantsList")
    private List<Formation> participations_formations; //lista mta3 anehom les formation elli el user hatha charek fehom

/*
    @OneToMany(mappedBy = "encadreur")
    private List<Encadrement> encadrementList;

    @ManyToOne
    private Encadrement encadrement;*/
    @OneToMany(mappedBy = "encadrant")
    private List<Encadrement> encadrementsEncadrant;

    @OneToMany(mappedBy = "etudiant")
    private List<Encadrement> encadrementsEtudiant;
}

