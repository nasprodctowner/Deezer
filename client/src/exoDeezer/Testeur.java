package exoDeezer;

import java.util.*;
import javax.naming.InitialContext;
import java.io.*;

public class Testeur {
    private static exoDeezer.session.deezerSAItf dsa;

    public static void main(String[] args) throws Exception {

        try {
            InitialContext ctx = new InitialContext();
            dsa = (exoDeezer.session.deezerSAItf) ctx.lookup("deezerSA");
        } catch (Exception ex) {
            System.err.println("erreur dans le client prbl nommage");
            ex.printStackTrace();
        }


        //utilisaer cette technique pour elections
        Collection<Object[]> laListe = dsa.listerMorceau("");
        for (Object[] obj : laListe) {
            int idMorceau = (Integer) obj[0];
            String artiste = (String) obj[1];
            System.out.println(idMorceau + "     " + artiste);
        }

        if(dsa.abonner("nos", "nos", "nos", "nos")) System.out.println("ok");

        System.out.println(dsa.jouerMorceau(7));

        /*
	laListe = dsa.listerMorceau("");
	for (Object[] obj: laListe)
            {
				Integer leMorceau = (Integer)obj[0];
				int idMorceau = leMorceau.intValue();
				String artiste = (String)obj[1]; 
				System.out.println(idMorceau + "     "+artiste);
			}*/
    }
}
