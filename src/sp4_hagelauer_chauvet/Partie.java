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
   void initialiserPartie(){//on créé une grille et on associe les jetons aux joueurs
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
       int colonneAleatoire = (int)(Math.random()*7);
       int ligneAleatoire = (int)(Math.random()*6);
       int g=0;
       while(g<5){
           if (grilleJeu.cellule[ligneAleatoire][colonneAleatoire].TrouNoir==false){
               grilleJeu.placerTrouNoir(ligneAleatoire, colonneAleatoire);
               ligneAleatoire=(int)(Math.random()*6);
               colonneAleatoire=(int)(Math.random()*7);
               g=g+1;
           }else{
               ligneAleatoire=(int)(Math.random()*6);
               colonneAleatoire=(int)(Math.random()*7);
           }
       }
   }
   void debuterPartie(){
       this.initialiserPartie();//initialiser la partie et choisit le joueur qui commence
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
       while (grilleJeu.etreremplie()==false){//tant que la grille n'est pas pleine, la partie continue
           a= JoueurCourant.nombreJetonsRestant;
           jeton= JoueurCourant.ListeJetons[a-1];
           sc= new Scanner(System.in);
           System.out.println("\nJoue "+JoueurCourant.Nom);
           colonne= sc.nextInt();
           while (colonne>8 || colonne<1){//empêche les joueurs de taper de mauvais chiffre
               System.out.println("\nRejouez !");
               colonne= sc.nextInt();
               }
           if (grilleJeu.colonneRemplie(colonne)== true){//Si la colonne est pleine, le joueur rejoue
               colonne2=colonne;
               while(colonne2 == colonne){
                   System.out.println("\nRejouez !");
                   colonne2= sc.nextInt();
               }
               grilleJeu.ajouterJetonDansColonne(jeton,colonne2);
           }else{
               grilleJeu.ajouterJetonDansColonne(jeton,colonne);
           }
           grilleJeu.afficherGrilleSurConsole();
           if (grilleJeu.etreGagnantePourJoueur(JoueurCourant)==true){//si la grille est gagnante, la partie s'arrête
               System.out.println("\nle joueur "+JoueurCourant.Nom+" a gagné !");
               break;
           }
           if (JoueurCourant==ListeJoueurs[0]){//le joueur courant change
           JoueurCourant= ListeJoueurs[1];
           }else{
               JoueurCourant= ListeJoueurs[0];
           }
       }
       if(grilleJeu.etreGagnantePourJoueur(JoueurCourant)==false){//si la grille est pleine et que personne n'a gagner, il y a égalité
           System.out.println("\négalité !");
       }   
   }
}
