/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_hagelauer_chauvet;

/**
 *
 * @author ylanc
 */
public class Cellule {
    Jeton JetonCourant; //crée un objet de classe Jeton 
    boolean TrouNoir;
    Cellule(){
        JetonCourant = null; //réinitialise chaque cellule de la grille
        TrouNoir = false;
    }
    
    boolean affecterJeton(Jeton jeton){
    if(JetonCourant==null){
        JetonCourant= jeton; //autorise l'apport d'un jeton sur une cellule vide
        return true;
    }else{
        return false;
    }
    }
    String lireCouleurDuJeton(){
        if (JetonCourant==null){
            return "vide";
        }else{
            return JetonCourant.Couleur;
        }
//lit la couleur du jeton se trouvant sur une cellule
//S'il n'y a aucun jeton renvoie vide
    }
    boolean placerTrouNoir(){
            if(TrouNoir==false){
                TrouNoir= true;
                return true;
            }else{
                return false;
        }
    }
    boolean presenceTrouNoir(){
        return TrouNoir;
    }
    boolean activerTrouNoir(){
        if(presenceTrouNoir()==true){
            if (JetonCourant!=null){
                JetonCourant=null;
                TrouNoir=false;
                return true;
            }
        }
        return false;
        }           
}
