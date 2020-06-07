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
public class Enseignant extends Utilisateur{
    int cours;
    
    public Enseignant(int id, int droit, String email, String password, String nom, String prenom,int cours) {
        super(id, droit, email, password, nom, prenom);
        this.cours=cours;
    }
    
    public int getcours(){
        return this.cours;
    }
}
