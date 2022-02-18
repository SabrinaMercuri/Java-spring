package com.example.weather.domain;

public class Ville {
	private String nom;
	private int codePostal;
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
