/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_hagelauer_chauvet;

/**
 *
 * @author ylanc
 */
public class Partie {
   Joueur ListeJoueurs[]= new Joueur[2];//création d'un objet Joueur
   Joueur joueurCourant;//création d'un objet Joueur
   Grille grilleJeu= new Grille();//création d'un objet Grille
   
   void attribuerCouleursAuxJoueurs(){ //Associe une couleur aux 2 joueurs stocké dans Couleurs
       double a= Math.random();//création d'une variable aléatoire entre 0 et 1
       if (a==1){
           ListeJoueurs[0].Couleur= "Rouge";
           ListeJoueurs[1].Couleur= "Jaune";
       }
       if (a==0){
           ListeJoueurs[1].Couleur= "Rouge";
           ListeJoueurs[0].Couleur= "Jaune";
       }
   }
   void initialiserPartie(){
       //grilleJeu.viderGrille();
   }
}
