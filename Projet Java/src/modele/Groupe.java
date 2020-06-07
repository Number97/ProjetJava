/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author ernestpopovici
 */
public class Groupe {
    int id,promotion;
    String nom;
    
    public Groupe(int id, int promotion, String nom){
        this.id=id;
        this.promotion=promotion;
        this.nom=nom;
    }
    
    public int getIT(){
        return this.id;
    }
    
    public int getPromotion(){
        return this.promotion;
    }
    
    public String getNom(){
        return this.nom;
    }
}
