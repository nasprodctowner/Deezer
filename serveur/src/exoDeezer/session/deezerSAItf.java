package exoDeezer.session;

import javax.ejb.Remote;
import java.util.*;

// l'interface des services sans abonnement
@Remote()
public interface deezerSAItf {
	public Collection<Object[]> listerMorceau(String titre);
	public String jouerMorceau(int idMorceau);
	public boolean abonner(String nom, String prenom, String pseudo, String passwd);
	}
