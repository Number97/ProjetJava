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
public class Etudiant extends Utilisateur{
    int numero,groupe,promotion;
    
    public Etudiant(int id, int droit, String email, String password, String nom, String prenom,int numero, int groupe, int promotion) {
        super(id, droit, email, password, nom, prenom);
        this.numero=numero;
        this.groupe=groupe;
        this.promotion=promotion;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public int getGroupe(){
        return this.numero;
    }
    
    public int getPromotion(){
        return this.numero;
    }
}
