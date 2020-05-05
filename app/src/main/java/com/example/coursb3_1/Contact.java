package com.example.coursb3_1;

public class Contact {
    // Attributs :
    private String nom;
    private String numero;

    Contact(String nom, String numero)
    {
        this.nom = nom;
        this.numero = numero;
    }

    public String getName()
    {
        return nom;
    }

    public String getPhoneNumber()
    {
        return numero;
    }
}
