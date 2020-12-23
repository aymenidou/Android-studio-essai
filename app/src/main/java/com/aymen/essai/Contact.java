package com.aymen.essai;

public class Contact {
    private String nom;
//        private int id;
    private String prenom;
    private int age;
    private String sexe;
    private int phone;

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Contact() {
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

//    @Override
//    public String toString() {
//        return "Contact{" +
//                "nom='" + nom + '\'' +
//                ", prenom='" + prenom + '\'' +
//                ", age=" + age +
//                ", sexe='" + sexe + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
