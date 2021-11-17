/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_hagelauer_chauvet;
import java.util.Scanner;

/**
 *
 * @author ylanc
 */
public class SP4_Hagelauer_Chauvet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                System.out.println("Veuillez démarrer la partie!");
                Joueur joueur1= new Joueur("nom");
                //nextLine
                Joueur joueur2= new Joueur("nom");
                Partie partie= new Partie(joueur1,joueur2);
                partie.initialiserPartie();
                partie.debuterPartie();
    }
    
}
