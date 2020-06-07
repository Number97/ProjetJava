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
public class Utilisateur {
    int id,droit;
    String email,password,nom,prenom;
    
    public Utilisateur(int id, int droit, String email, String password, String nom, String prenom) {
        this.id = id;
        this.droit=droit;
        this.email=email;
        this.password=password;
        this.nom=nom;
        this.prenom=prenom;
    }
    
    public int getID(){
        return this.id;
    }
    
    public int getDroit(){
        return this.droit;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
}
