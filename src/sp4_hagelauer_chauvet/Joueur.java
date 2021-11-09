/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_hagelauer_chauvet;

/**
 *
 * @author ylanc
 */
public class Joueur {
    String Couleur;
    String Nom;
    Jeton ListeJetons[]= new Jeton [21]; //Création d'un objet de classe Jeton représentant la liste des jetons
    int nombreJetonsRestant;
    Joueur(String nom){
        Nom= nom;
        //Associe le nom du joueur à la variable Nom
    }
    void affecterCouleur(String RouJ){
        Couleur= RouJ;
        //Affecte la couleur du jeton à la variable Couleur
    }
    void ajouterJeton(Jeton jeton){
        ListeJetons[nombreJetonsRestant+1]= jeton;
        //affecte à la variable ListeJetons le nombre de jetons restant
    }
}
