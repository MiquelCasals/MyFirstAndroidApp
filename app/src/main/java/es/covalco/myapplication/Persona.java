package es.covalco.myapplication;

import java.io.Serializable;

/*
  Persona:
 */
public class Persona implements Serializable {
  private String nom;
  private String eMail;
  private String password;
  private String provincia;
  private String sexe;
  private String aficions;
  private String dataNaixement;

  public Persona(String nom,
                 String eMail,
                 String password,
                 String provincia,
                 String sexe,
                 String aficions,
                 String dataNaixement) {
    this.nom            = nom;
    this.eMail          = eMail;
    this.password       = password;
    this.provincia      = provincia;
    this.sexe           = sexe;
    this.aficions       = aficions;
    this.dataNaixement  = dataNaixement;
  }

  public String getNom() {
    return this.nom;
  }
  public String getEMail() {
    return this.eMail;
  }
  public String getPassword() {
    return this.password;
  }
  public String getProvincia() {
    return this.provincia;
  }
  public String getSexe() {
    return this.sexe;
  }
  public String getAficions() {
    return this.aficions;
  }
  public String getDataNaixement() {
    return this.dataNaixement;
  }
}
