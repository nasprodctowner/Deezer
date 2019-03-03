package exoDeezer.session;

import exoDeezer.entity.Abonne;
import exoDeezer.entity.Morceau;
import javax.ejb.*;
import javax.persistence.*;
import java.util.*;


// le bean stateless des services sans abonnement
@Stateless (mappedName="deezerSA")
public class deezerSABean implements deezerSAItf {

    @PersistenceContext(unitName="deezerSAPU")
    private EntityManager em;

	public Collection<Object[]> listerMorceau(String titre) {

        Collection<Object[]> liste;
        //utilisaer cette technique pour elections
        //utilisaer cette technique pour elections
	    if(!titre.equals("")){
            liste = em.createQuery("SELECT morceau.idMorceau, morceau.artiste FROM Morceau morceau WHERE morceau.titre = :titre")
                    .setParameter("titre",titre)
                    .getResultList();
        }else {
            liste = em.createQuery("SELECT morceau.idMorceau, morceau.artiste FROM Morceau morceau")
                    .getResultList();
        }

		return liste;
	}
	
	public String jouerMorceau(int idMorceau) {

        return "voici le titre de ce morceau : "+em.find(Morceau.class, idMorceau).getTitre()+" ";
	}
	
	public boolean abonner(String nom, String prenom, String pseudo, String passwd) {
	    try {
            Abonne abonne = new Abonne(nom, prenom, pseudo, passwd);
            em.persist(abonne);
            em.flush();
            return true;
        }catch (Exception e){
	        return false;
        }
	}

}

