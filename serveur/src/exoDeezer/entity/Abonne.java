package exoDeezer.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "test.ABONNE")
public class Abonne {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAbonne;
    private Collection<Playlist> lesPlaylists;

    public Abonne(String nom, String prenom, String pseudo, String passwd) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.passwd = passwd;
    }

    public Abonne()
    {
    }

    public int getIdAbonne ()  {
        return this.idAbonne;
    }

    public void setIdAbonne (int value)  {
        this.idAbonne = value; 
    }

    private String nom;
    public String getNom ()  {
        return this.nom;
    }

    public void setNom (String value)  {
        this.nom = value; 
    }

    private String prenom;
    public String getPrenom ()  {
        return this.prenom;
    }

    public void setPrenom (String value)  {
        this.prenom = value; 
    }

    private String pseudo;
    public String getPseudo ()  {
        return this.pseudo;
    }

    public void setPseudo (String value)  {
        this.pseudo = value; 
    }

    private String passwd;
    public String getPasswd ()  {
        return this.passwd;
    }

    public void setPasswd (String value)  {
        this.passwd = value; 
    }

    @OneToMany
    @JoinTable(
            name = "test.ABONNE_PLAYLIST",
            joinColumns = @JoinColumn(name = "ABONNE_idAbonne"),
            inverseJoinColumns = @JoinColumn(name = "lesPlaylist_idPlaylist"))
    public Collection<Playlist> getLesPlaylists() {
        return lesPlaylists;
    }

    public void setLesPlaylists(Collection<Playlist> lesPlaylists) {
        this.lesPlaylists = lesPlaylists;
    }
}
