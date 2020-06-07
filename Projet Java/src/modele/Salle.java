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
public class Salle {
    int id,capacite,site;
    String nom;
    
    public Salle(int id,int capacite,int site,String nom){
        this.id=id;
        this.capacite=capacite;
        this.site=site;
        this.nom=nom;
    }
    
    public int getID(){
        return this.id;
    }
    
    public int getCapacite(){
        return this.capacite;
    }
    
    public int getSite(){
        return this.site;
    }
    
    public String getNom(){
        return this.nom;
    }
}
