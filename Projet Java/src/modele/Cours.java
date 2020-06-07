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
public class Cours {
    int id;
    String nom;
    
    public Cours(int id,String nom){
        this.id=id;
        this.nom=nom;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
}
