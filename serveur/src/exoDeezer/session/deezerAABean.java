package exoDeezer.session;

import exoDeezer.entity.Abonne;
import exoDeezer.entity.Morceau;
import exoDeezer.entity.Playlist;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import exoDeezer.session.deezerSABean;


// le bean stateless des services sans abonnement
@Stateful(mappedName="deezerAA")
public class deezerAABean implements deezerAAItf {

    private static exoDeezer.session.deezerSAItf dsa;
    @PersistenceContext(unitName="deezerAAPU")
    private EntityManager em;

    private boolean isConnected = false;

    @Override
    public String identifier(String pseudo, String passwd) {

        String connected = "prbl Connexion, recommencez";
        try {
            List abonne =  em.createQuery ("SELECT a FROM Abonne a WHERE a.pseudo = :pseudo AND a.passwd = :passwd ")
                    .setParameter("pseudo",pseudo)
                    .setParameter("passwd",passwd)
                    .getResultList();

            isConnected = !abonne.isEmpty();
            if(isConnected) connected = "Connection OK !";

        }catch (Exception e){
            System.out.println("Erreur");
        }

        return connected;
    }

    @Override
    public int[] listerPlayList() {


        if (isConnected){
            Collection<Integer> ids = em.createQuery("Select pl.idPlaylist FROM Playlist pl").getResultList();
            int tab[ ];
            tab = new int[ids.size()];
            int i = 0;
            for (int obj : ids) {
                tab[i] = obj;
                i++;
            }
            return tab;
        }else {
            System.out.println("cc");
        }
      return null;
    }

    @Override
    public String jouerPlaylist(int idPlaylist) {


        try {
            InitialContext ctx = new InitialContext();
            dsa = (deezerSAItf) ctx.lookup("deezerSA");
        } catch (Exception ex) {
            System.err.println("erreur dans le client prbl nommage");
            ex.printStackTrace();
        }


        ArrayList<String> playlist = new ArrayList<>();

        Playlist playlistPlaying = (Playlist) em.createQuery("Select pl FROM Playlist pl WHERE pl.idPlaylist = :id").setParameter("id",idPlaylist).getSingleResult();
        for (Morceau morceau : playlistPlaying.getLesMorceaux()
             ) {
            playlist.add(dsa.jouerMorceau(morceau.getIdMorceau()));
        }

        StringBuilder sb = new StringBuilder();

        for (String morceau : playlist
             ) {
            sb.append(morceau);
        }

        String s = sb.toString()+"   ";

        return  s;
    }

    @Override
    public int creerPlaylist(String nom) {

        int i = 0;
        if (isConnected) {
            Playlist playlist = new Playlist(nom);
            em.persist(playlist);
            em.flush();

            i = (int) em.createQuery ("SELECT pl.idPlaylist FROM Playlist pl WHERE  pl.nom = :nom ").setParameter("nom",nom).getSingleResult();

        }
        else {
            return i;
        }
        return i;
    }

    @Override
    public boolean peuplerPlaylist(int num, int[] lesMorceaux) {

        try {
            if (isConnected) {
                Collection<Morceau> morcaux = new ArrayList<Morceau>();

                for (int aLesMorceaux : lesMorceaux) {
                    morcaux.add(em.find(Morceau.class, aLesMorceaux));
                }

                Playlist playlist = em.find(Playlist.class, num);
                playlist.setLesMorceaux(morcaux);
                em.persist(playlist);
                em.flush();
                return true;

            } else {
                return false;
            }

        }catch (Exception e){
            return false;
        }

    }

    @Override
    public String findTitreMorceau(int id){
        return (String) em.createQuery("SELECT morceau.titre FROM Morceau morceau WHERE morceau.idMorceau = :id").setParameter("id",id).getSingleResult();
    }


}

