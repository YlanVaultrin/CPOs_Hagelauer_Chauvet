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
             if (cellule[i][colonne]==null){
                 cellule[i][colonne].JetonCourant= J;
                 return true;
             }
         }
         return false;  
     }
     boolean etreremplie(){
         int a=0;
         for (int i=0; i<6;i++){
             for (int j=0; j<7;i++){
                 if (cellule[i][j]!=null){
                     a=a+1;
                 }
             }
         }
         if (a==42){
             return true;
         }else{
             return false;
         }
     }
     void vidergrille(){
         for (int i=0; i<6;i++){
            for (int j=0;j<7;j++){
                cellule[i][j]=null;
            }
         }
     }
     public static final String ANSI_YELLOW = "\u001B[33m";
     public static final String ANSI_RED = "\u001B[31m";
     public static final String ANSI_WHITE = "\u001B[37m";
     public static final String ANSI_RESET = "\u001B[0m";
     void afficherGrilleSurConsole(){
         for (int i=0; i<6;i++){
            for (int j=0;j<7;j++){
                String couleur= cellule[i][j].lireCouleurDuJeton();
                if (couleur=="Rouge"){
                    System.out.println(ANSI_RED + "\u2022"+ ANSI_RESET);
                }
                if (couleur=="Jaune"){
                    System.out.println(ANSI_YELLOW+"\u2022"+ANSI_RESET);
                }
                if (couleur=="vide"){
                    System.out.println(ANSI_WHITE+"\u2022"+ANSI_RESET);
                }
                
            }
         }
     }
     boolean celluleOccupee(int i,int j){
         if (cellule[i][j]!=null){
             return true;
         }
         return false;
     }
     String lireCouleurDuJeton(int i, int j){
         String couleur= cellule[i][j].JetonCourant.Couleur;
         return couleur;
     }
     boolean etreGagnantePourJoueur(Joueur joueur){
         String a = joueur.Couleur;
         for (int i=0; i<6;i++){
            for (int j=0;j<7;j++){
                String b = cellule[i][j].lireCouleurDuJeton();
                if (a==b){
                    //on vérifie une ligne gagnante
                            for (j=0;j<4;j++){
                                String jetons2= cellule[i][j+1].lireCouleurDuJeton();
                                String jetons3= cellule[i][j+2].lireCouleurDuJeton();
                                String jetons4= cellule[i][j+3].lireCouleurDuJeton();
                                if (b==jetons2 && b==jetons3 && b==jetons4){
                                    return true;
                                }
                            }
                            for (i=0; i<3;i++){
                                String jetons2= cellule[i+1][j].lireCouleurDuJeton();
                                String jetons3= cellule[i+2][j].lireCouleurDuJeton();
                                String jetons4= cellule[i+3][j].lireCouleurDuJeton();
                                if (b==jetons2 && b==jetons3 && b==jetons4){
                                    return true;
                                }
                            }
                            for (i=0; i<3;i++){
                                for (j=0;j<4;j++){
                                    String jetons2= cellule[i+1][j+1].lireCouleurDuJeton();
                                    String jetons3= cellule[i+2][j+2].lireCouleurDuJeton();
                                    String jetons4= cellule[i+3][j+3].lireCouleurDuJeton();
                                    if (b==jetons2 && b==jetons3 && b==jetons4){
                                        return true;
                                    }
                                }
                                }
                            for (i=0; i>2;i++){
                                for (j=0;j<4;j++){
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
         }
         return false;
     }
     boolean colonneRemplie(int colonne){
         for (int i=0; i<6;i++){
             int a=0;
             if (cellule[i][colonne]!=null){
                 a=a+1;
             }
             if (a==6){
                 return true;
             }
         }
         return false;
     }
}
