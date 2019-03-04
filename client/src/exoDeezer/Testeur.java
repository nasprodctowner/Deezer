package exoDeezer;

import exoDeezer.session.deezerAAItf;
import exoDeezer.session.deezerSAItf;

import java.util.*;
import javax.naming.InitialContext;
import java.io.*;

public class Testeur {
    private static exoDeezer.session.deezerSAItf dsa;
    private static exoDeezer.session.deezerAAItf daa;

    public static void main(String[] args) throws Exception {

        try {
            InitialContext ctx = new InitialContext();
            dsa = (deezerSAItf) ctx.lookup("deezerSA");
            daa = (deezerAAItf) ctx.lookup("deezerAA");
        } catch (Exception ex) {
            System.err.println("erreur dans le client prbl nommage");
            ex.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("nas nas : "+daa.identifier("nas","nas"));


        //utilisaer cette technique pour elections
        Collection<Object[]> laListe = dsa.listerMorceau("");
        for (Object[] obj : laListe) {
            int idMorceau = (Integer) obj[0];
            String artiste = (String) obj[1];
            System.out.println(idMorceau + "     " + artiste);
        }

        System.out.println(dsa.jouerMorceau(1));
        System.out.println(dsa.jouerMorceau(7));

        System.out.println("Playlists dispo : ");
        for (int playlist : daa.listerPlayList()) {
            System.out.println("Playlist : "+playlist);
        }


        System.out.println("Quel est le nom de la nouvelle playlist ?");
        String nom = scanner.nextLine();

        int numPlaylist = daa.creerPlaylist(nom);
        System.out.println("Numéro  de Playlist créé : "+numPlaylist);

        int n;
        System.out.println("combien de titre");
        n=scanner.nextInt();

        int tab[ ] = new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("quel titre ?");
            tab[i]=scanner.nextInt();
        }


        System.out.println("quel id de playlist ??");
        int id = scanner.nextInt();

        if(daa.peuplerPlaylist(id,tab)) System.out.println("Playlist créé !");


        System.out.println("quel id de playlist à jouer ??");
        int idPlaylistJoue = scanner.nextInt();

        System.out.println(daa.jouerPlaylist(idPlaylistJoue));


    }
}
