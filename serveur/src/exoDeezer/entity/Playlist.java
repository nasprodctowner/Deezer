package exoDeezer.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "test.PLAYLIST")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlaylist;
    private String nom;
    private Collection<Morceau> lesMorceaux;

    public Playlist(String nom) {
        this.nom = nom;
    }

    public Playlist() {
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @ManyToMany
    @JoinTable(
            name = "test.PLAYLIST_MORCEAU",
            joinColumns = @JoinColumn(name = "PLAYLIST_idPlaylist"),
            inverseJoinColumns = @JoinColumn(name = "lesMorceaux_idMorceau"))
    public Collection<Morceau> getLesMorceaux() {
        return lesMorceaux;
    }


    public void setLesMorceaux(Collection<Morceau> lesMorceaux) {
        this.lesMorceaux = lesMorceaux;
    }
}
