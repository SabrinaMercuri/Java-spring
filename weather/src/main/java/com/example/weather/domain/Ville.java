package com.example.weather.domain;

import io.swagger.annotations.ApiModelProperty;

public class Ville {
    @ApiModelProperty(notes = "Nom de la ville",name="nom",required=true,value="test nom")
	private String nom;
    @ApiModelProperty(notes = "Code postal de la ville",name="codePostal",required=true,value="test codePostal")
	private int codePostal;
    @ApiModelProperty(notes = "Meteo de la cille",name="meteo",required=true,value="test meteo")
	private String meteo;

	public Ville () {
    }

    public Ville (String nom, int cp, String meteo) {
	    this.nom=nom;
	    this.codePostal=cp;
	    this.meteo=meteo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    @Override
    public String toString() {
        return "Ville [nom=" + nom + ", code postal=" + codePostal + ", meteo=" + meteo +"]";
    }
}
