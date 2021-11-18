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
                System.out.println("Joueur 1 comment vous appelez-vous ?");
                Scanner sc= new Scanner(System.in);
                String nom1= sc.nextLine();
                System.out.println("Joueur 2 comment vous appelez-vous ?");
                String nom2= sc.nextLine();
                Joueur joueur1= new Joueur(nom1);
                System.out.println("Le Joueur 1 est: "+nom1);
                Joueur joueur2= new Joueur(nom2);
                System.out.println("Le Joueur 2 est: "+nom2);
                Partie partie= new Partie(joueur1,joueur2);
                partie.debuterPartie();
                System.out.println();
    }
 
}
