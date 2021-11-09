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
 
}
