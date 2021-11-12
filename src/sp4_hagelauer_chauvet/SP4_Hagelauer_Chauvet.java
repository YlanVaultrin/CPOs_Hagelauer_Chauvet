/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_hagelauer_chauvet;

/**
 *
 * @author ylanc
 */
public class SP4_Hagelauer_Chauvet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grille grilletest = new Grille();
        Jeton jet = new Jeton("Rouge");
        grilletest.ajouterJetonDansColonne(jet, 3);
        grilletest.afficherGrilleSurConsole();
    }
    
}
