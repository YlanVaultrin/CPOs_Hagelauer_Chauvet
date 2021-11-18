/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_hagelauer_chauvet;
import java.util.Scanner;

/**
 *
 * @author ylanc
 */
public class Partie {
   Joueur ListeJoueurs[]= new Joueur[2];//création d'un objet Joueur
   Joueur JoueurCourant;//création d'un objet Joueur
   Grille grilleJeu;//création d'un objet Grille
   Partie(Joueur joueur1, Joueur joueur2){
       ListeJoueurs[0]= joueur1;
       ListeJoueurs[1]= joueur2;
   }
   
   void attribuerCouleursAuxJoueurs(){ //Associe une couleur aux 2 joueurs stocké dans Couleurs
       double a= Math.random();//création d'une variable aléatoire entre 0 et 1
       
       if (a<0.5){
           ListeJoueurs[0].Couleur = "Rouge";
           ListeJoueurs[1].Couleur = "Jaune";
       }
       if (a>0.5){
           ListeJoueurs[1].Couleur = "Rouge";
           ListeJoueurs[0].Couleur = "Jaune";
       }
   }
   void initialiserPartie(){
       attribuerCouleursAuxJoueurs();
       grilleJeu= new Grille();
       grilleJeu.vidergrille();
       String couleur= ListeJoueurs[0].Couleur;
       Jeton jeton= new Jeton(couleur);
       for (int i=0;i<21;i++){
           ListeJoueurs[0].ajouterJeton(jeton);
       }
       String couleur2= ListeJoueurs[1].Couleur;
       Jeton jeton2= new Jeton(couleur2);
       for (int i=0;i<21;i++){
           ListeJoueurs[1].ajouterJeton(jeton2);
       }
   }
   void debuterPartie(){
       this.initialiserPartie();
       if ("Rouge".equals(ListeJoueurs[0].Couleur)){
           JoueurCourant= ListeJoueurs[0];
       }else{
           JoueurCourant= ListeJoueurs[1];
       }
       int a;
       Jeton jeton;
       int colonne;
       int colonne2;
       Scanner sc;
       while (grilleJeu.etreremplie()==false){
           a= JoueurCourant.nombreJetonsRestant;
           jeton= JoueurCourant.ListeJetons[a-1];
           sc= new Scanner(System.in);
           System.out.println("Joue "+JoueurCourant.Nom);
           colonne= sc.nextInt();
           if (grilleJeu.colonneRemplie(colonne)== true){
               colonne2=colonne;
               while(colonne2 == colonne){
                   System.out.println("Rejouez !");
                   colonne2= sc.nextInt();
               }
               grilleJeu.ajouterJetonDansColonne(jeton,colonne2);
           }else{
               grilleJeu.ajouterJetonDansColonne(jeton,colonne);
           }
           grilleJeu.afficherGrilleSurConsole();
           if (grilleJeu.etreGagnantePourJoueur(JoueurCourant)==true){
               System.out.println("le joueur "+JoueurCourant.Nom+" a gagné !");
               break;
           }
           if (JoueurCourant==ListeJoueurs[0]){
           JoueurCourant= ListeJoueurs[1];
           }else{
               JoueurCourant= ListeJoueurs[0];
           }
       }
       if(grilleJeu.etreGagnantePourJoueur(JoueurCourant)==false){
           System.out.println("égalité !");
       }
   }//vérifie grille + demande colonne
}
