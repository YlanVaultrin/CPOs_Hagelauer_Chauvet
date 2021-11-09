/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_hagelauer_chauvet;

/**
 *
 * @author ylanc
 */
public class Jeton {
    String Couleur;
    
    Jeton(String RouJ){
        Couleur = RouJ;
        //attribution d'une couleur aux jetons
    }
    String lireCouleur(){
        return Couleur;
        //Lit la couleur et la renvoie en quelque chose de réutilisable dans d'autres classes
    }
    
}
