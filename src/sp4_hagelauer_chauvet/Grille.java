/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_hagelauer_chauvet;

/**
 *
 * @author ylanc
 */
public class Grille {
    Cellule cellule[][]=new Cellule[6][7];
    //création d'un objet cellule de la classe Cellule représantant la grille
    Grille(){
        for (int i=0; i<6;i++){
            for (int j=0;j<7;j++){
                cellule[i][j]= new Cellule();
            }
            //création de la grille
        }
    }
     boolean ajouterJetonDansColonne(Jeton J,int colonne){
         for (int i=0; i<6;i++){
             if (cellule[i][colonne-1].JetonCourant==null){
                 cellule[i][colonne-1].JetonCourant= J;
                 return true; //ajoute un jeton que si l'emplacement est vide
             }
         }
         return false;  
     }
     boolean etreremplie(){
         int a=0;
         for (int i=0; i<6;i++){
             for (int j=0; j<7;j++){
                 if (cellule[i][j].JetonCourant!=null){
                     a=a+1;
                 }
             }
         }
         if (a==42){
             return true;
         }else{
             return false; //nous indique si la grille est pleine est donc l'égalité 
         }
     }
     void vidergrille(){
         for (int i=0; i<6;i++){
            for (int j=0;j<7;j++){
                cellule[i][j].JetonCourant=null;
            }
         }
     }
     public static final String ANSI_YELLOW = "\u001B[33m";
     public static final String ANSI_RED = "\u001B[31m";
     public static final String ANSI_WHITE = "\u001B[37m";
     public static final String ANSI_RESET = "\u001B[0m"; //importation des couleurs
     void afficherGrilleSurConsole(){
         for (int i=5; i>=0;i--){
             System.out.print("\n");
            for (int j=0;j<7;j++){
                String couleur= cellule[i][j].lireCouleurDuJeton();
                if (couleur=="Rouge"){
                    System.out.print(ANSI_RED + "\u2022"+ ANSI_RESET);
                }
                if (couleur=="Jaune"){
                    System.out.print(ANSI_YELLOW+"\u2022"+ANSI_RESET);
                }
                if (couleur=="vide"){
                    System.out.print(ANSI_WHITE+"\u2022"+ANSI_RESET);
                }
                //attribution des couleurs aux éléments
            }
         }
     }
     boolean celluleOccupee(int i,int j){
         if (cellule[i][j]!=null){
             return true;
         }
         return false; //nous indique si la cellule est occupé
     }
     String lireCouleurDuJeton(int i, int j){
         String couleur= cellule[i][j].JetonCourant.Couleur;
         return couleur; //nous indique la couleur du jeton
     }
     boolean etreGagnantePourJoueur(Joueur joueur){
         String a = joueur.Couleur;
         String b;
         for (int i=0; i<6;i++){
            for (int j=0;j<7;j++){ //on lit les couleurs de chaque jeton de toutes les cellules
                b = cellule[i][j].lireCouleurDuJeton();
                if (a==b){
                    //on vérifie une ligne gagnante
                            for (j=0;j<4;j++){
                                String jetons2= cellule[i][j+1].lireCouleurDuJeton();
                                String jetons3= cellule[i][j+2].lireCouleurDuJeton();
                                String jetons4= cellule[i][j+3].lireCouleurDuJeton();
                                if (b==jetons2 && b==jetons3 && b==jetons4){
                                    return true;
                                }
                            }//on vérifie une colonne gagnante
                            for (i=0; i<3;i++){
                                String jetons2= cellule[i+1][j].lireCouleurDuJeton();
                                String jetons3= cellule[i+2][j].lireCouleurDuJeton();
                                String jetons4= cellule[i+3][j].lireCouleurDuJeton();
                                if (b==jetons2 && b==jetons3 && b==jetons4){
                                    return true;
                                }
                            }
                            for (i=0; i<3;i++){
                                for (j=0;j<4;j++){ //on vérifie une diagonale gagnante
                                    String jetons2= cellule[i+1][j+1].lireCouleurDuJeton();
                                    String jetons3= cellule[i+2][j+2].lireCouleurDuJeton();
                                    String jetons4= cellule[i+3][j+3].lireCouleurDuJeton();
                                    if (b==jetons2 && b==jetons3 && b==jetons4){
                                        return true;
                                    }
                                }
                                }
                            for (i=3; i<5;i++){
                                for (j=0;j<4;j++){ //on vérifie une diagonale en partant du haut gagnante
                                    String jetons2= cellule[i-1][j+1].lireCouleurDuJeton();
                                    String jetons3= cellule[i-2][j+2].lireCouleurDuJeton();
                                    String jetons4= cellule[i-3][j+3].lireCouleurDuJeton();
                                    if (b==jetons2 && b==jetons3 && b==jetons4){
                                        return true;
                                    }
                                }
                            }
                }
            
            }
         } //personne ne gagne encore
         return false;
     }
     boolean colonneRemplie(int colonne){
             if (cellule[5][colonne-1].lireCouleurDuJeton()!="vide"){
                 return true;
             }
             return false;
     }
}
