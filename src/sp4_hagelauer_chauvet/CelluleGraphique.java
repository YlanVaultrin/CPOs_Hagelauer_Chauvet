/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_hagelauer_chauvet;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author ylanc
 */
public class CelluleGraphique extends JButton {
    Cellule celluleAssociee;
    ImageIcon img_vide= new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_jaune= new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_rouge= new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir= new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    
    public CelluleGraphique (Cellule uneCellule){
        celluleAssociee = uneCellule;
    }
    
    @Override
    public void paintComponent (Graphics G){
        super.paintComponent(G);
        if (celluleAssociee.presenceTrouNoir()==true){
            setIcon(img_trouNoir); //on attribue l'image Trou noir
        }
        else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton();
            switch(couleur_jeton){
                case "vide":
                    setIcon(img_vide); //on attribue l'image cellule vide
                    break;
                case "Rouge":
                    setIcon(img_rouge); //on attribue l'image aux jetons rouge
                    break;
                case "Jaune":
                    setIcon(img_jaune);//on attribue l'image aux jetons jaune
                    break;
            }
        }
    }
}

