package exoDeezer.session;

import exoDeezer.entity.Morceau;

import javax.ejb.Remote;

// l'interface des services avec abonnement
@Remote()
public interface deezerAAItf {
	public String identifier(String pseudo, String passwd);
	public int[] listerPlayList();
	public String jouerPlaylist(int idPlaylist);
	public int creerPlaylist(String nom);
	public boolean peuplerPlaylist(int num, int[] lesMorceaux);
	public String findTitreMorceau(int id);
	}
