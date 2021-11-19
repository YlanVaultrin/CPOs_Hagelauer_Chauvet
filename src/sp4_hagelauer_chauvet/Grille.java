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
     public static final String ANSI_BLACK = "\u001B[30m";
     public static final String ANSI_RESET = "\u001B[0m"; //importation des couleurs
     void afficherGrilleSurConsole(){ //attribution des couleurs aux éléments
         for (int i=5; i>=0;i--){
             System.out.print("\n");
            for (int j=0;j<7;j++){
                String couleur= cellule[i][j].lireCouleurDuJeton();
                if (cellule[i][j].TrouNoir==true){
                    System.out.print(ANSI_BLACK+"\u2022"+ANSI_RESET);
                }else{
                    if (couleur=="Rouge"){
                        System.out.print(ANSI_RED + "\u2022"+ ANSI_RESET);
                    }else{
                        if (couleur=="Jaune"){
                            System.out.print(ANSI_YELLOW+"\u2022"+ANSI_RESET);
                        }else{
                            if (couleur=="vide"){
                                System.out.print(ANSI_WHITE+"\u2022"+ANSI_RESET);
                            }
                        }
                    }
                }
            }
         }
     }
public boolean etreGagnantePourJoueur(Joueur joueur){
       String couleur = joueur.Couleur;
       for (int i=0; i<6; i++){
           for (int j=0; j<4; j++){ //on vérifie une ligne gagnante
               String jeton1 = cellule[i][j].lireCouleurDuJeton();
               String jeton2 = cellule[i][j+1].lireCouleurDuJeton();
               String jeton3 = cellule[i][j+2].lireCouleurDuJeton();
               String jeton4 = cellule[i][j+3].lireCouleurDuJeton();
               if (jeton1==couleur && jeton2==couleur && jeton3==couleur && jeton4==couleur){
                   return true;
               }
           }
       } 
       for (int i=0; i<3; i++){
           for (int j=0; j<7; j++){ //on vérifie une colonne gagnante 
               String jeton1 = cellule[i][j].lireCouleurDuJeton();
               String jeton2 = cellule[i+1][j].lireCouleurDuJeton();
               String jeton3 = cellule[i+2][j].lireCouleurDuJeton();
               String jeton4 = cellule[i+3][j].lireCouleurDuJeton();
               if (jeton1==couleur && jeton2==couleur && jeton3==couleur && jeton4==couleur){
                   return true;
               }
           }
       }
       for (int i=0; i<3; i++){
           for (int j=0; j<4; j++){ //on vérifie une diagonale gagnante
               String jeton1 = cellule[i][j].lireCouleurDuJeton();
               String jeton2 = cellule[i+1][j+1].lireCouleurDuJeton();
               String jeton3 = cellule[i+2][j+2].lireCouleurDuJeton();
               String jeton4 = cellule[i+3][j+3].lireCouleurDuJeton();
               if (jeton1==couleur && jeton2==couleur && jeton3==couleur && jeton4==couleur){
                   return true;
               }
           }
       }
       for (int i=3; i<6; i++){
           for (int j=0; j<4; j++){ //on vérifie une diagonale gagnante
               String jeton1 = cellule[i][j].lireCouleurDuJeton();
               String jeton2 = cellule[i-1][j+1].lireCouleurDuJeton();
               String jeton3 = cellule[i-2][j+2].lireCouleurDuJeton();
               String jeton4 = cellule[i-3][j+3].lireCouleurDuJeton();
               if (jeton1==couleur && jeton2==couleur && jeton3==couleur && jeton4==couleur){
                   return true;
               }
           }
       }
       return false;
   }
     boolean colonneRemplie(int colonne){//vérifie si la colonne est remplie
             if (cellule[5][colonne-1].lireCouleurDuJeton()!="vide"){
                 return true;
             }
             return false;
     }
     boolean placerTrouNoir(int ligne,int colonne){
                 if (cellule[ligne][colonne].TrouNoir==true){
                     return false; //ajoute un TrouNoir sur une cellule de la grille si la cellule posséde l'attribut Trou Noir en true
                 }else{
                     cellule[ligne][colonne].placerTrouNoir();
                     return true;
                 }
             }
}
