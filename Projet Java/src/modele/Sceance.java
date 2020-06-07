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
    String id,debut,fin,etat,cours,type;
    String semaine,date;
    
    public Sceance(String id,String debut,String fin,String etat,String cours,String type,String semaine,String date){
        this.id=id;
        this.debut=debut;
        this.fin=fin;
        this.etat=etat;
        this.cours=cours;
        this.type=type;
        this.semaine=semaine;
        this.date=date;
    }
    
    public String getID(){
        return this.id;
    }
    
    public String getDebut(){
        return this.debut;
    }
    
    public String getFin(){
        return this.fin;
    }
    
    public String getEtat(){
        return this.etat;
    }
    
    public String getCours(){
        return this.cours;
    }
    
    public String getType(){
        return this.type;
    }
    
    public String getSemaine(){
        return this.semaine;
    }
    
    public String getDate(){
        return this.date;
    }
}
