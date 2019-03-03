package exoDeezer.entity;

import javax.persistence.*;

@Entity
@Table(name = "test.MORCEAU")
public class Morceau {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMorceau;
    private String artiste;
    private String titre;


    public Morceau(String artiste, String titre) {
        this.artiste = artiste;
        this.titre = titre;
    }

    public Morceau(){
    }

    public String getTitre ()  {
        return this.titre;
    }

    public void setTitre (String value)  {
        this.titre = value;
    }

    public int getIdMorceau ()  {
        return this.idMorceau;
    }

    public void setIdMorceau (int value)  {
        this.idMorceau = value;
    }

    public String getArtiste ()  {
        return this.artiste;
    }

    public void setArtiste (String value)  {
        this.artiste = value; 
    }



}
