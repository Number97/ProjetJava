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
public class Sceance {
    int id,debut,fin,etat,cours,type;
    String semaine,date;
    
    public Sceance(int id,int debut,int fin,int etat,int cours,int type,int capacite,int site,String semaine,String date){
        this.id=id;
        this.debut=debut;
        this.fin=fin;
        this.etat=etat;
        this.cours=cours;
        this.type=type;
        this.semaine=semaine;
        this.date=date;
    }
    
    public int getID(){
        return this.id;
    }
    
    public int getDebut(){
        return this.debut;
    }
    
    public int getFin(){
        return this.fin;
    }
    
    public int getEtat(){
        return this.etat;
    }
    
    public int getCours(){
        return this.cours;
    }
    
    public int getType(){
        return this.type;
    }
    
    public String getSemaine(){
        return this.semaine;
    }
    
    public String getDate(){
        return this.date;
    }
}
