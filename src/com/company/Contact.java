package com.company;

public class Contact
{
    private String name;        //ιδιότητες της class
    private String telephone;
    private String mail;
    private String address;
    private String profession;

    public Contact() //απλός constructor για δημιουργία object χωρίς παραμέτρους, θα χρειαστεί σε ένα σημείο της main
    {

    }

    public Contact(String n, String tel, String ml, String addr, String prof) //constructor της class με παραμέτρους
    {
        name = n;       //αρχικοποίηση ιδιοτήτων με την τιμή των arguments του constructor
        telephone = tel;
        mail = ml;
        address = addr;
        profession = prof;
    }

    public String getName()
    {
        return name;
    } //ανάκτηση ον/μου επαφής

    public String getTelephone()
    {
        return telephone;
    } //ανάκτηση τηλεφώνου επαφής

    public void setName(String newName) //αλλαγή ονόματος
    {
        name = newName;
    }

    public void setTelephone(String newTel) //αλλαγή τηλεφώνου
    {
        telephone = newTel;
    }

    public void setMail(String newMail) //αλλαγή email
    {
        mail = newMail;
    }

    public void setAddress(String newAdd) //αλλαγή διεύθυνσης
    {
        address = newAdd;
    }

    public void setProf(String newProf) //αλλαγή τίτλου επαγγέλματος
    {
        profession = newProf;
    }

    public void showContact() //προβολή όλων των στοιχείων της επαφής
    {
        System.out.println("Όνοματεπώνυμο: " + name);
        System.out.println("Τηλέφωνο: " + telephone);
        System.out.println("Email: " + mail);
        System.out.println("Διεύθυνση: " + address);
        System.out.println("Επάγγελμα: " + profession + "\n");
    }

    public void showFoundByName() //προβολή στοιχείων επαφής που βρέθηκε μέσω ονόματος
    {
        System.out.println("Τηλέφωνο: " + telephone);
        System.out.println("Email: " + mail);
        System.out.println("Διεύθυνση: " + address);
        System.out.println("Επάγγελμα: " + profession + "\n");
    }

    public void showFoundByTel() //προβολή στοιχείων επαφής που βρέθηκε μέσω τηλεφώνου
    {
        System.out.println("Όνοματεπώνυμο: " + name);
        System.out.println("Email: " + mail);
        System.out.println("Διεύθυνση: " + address);
        System.out.println("Επάγγελμα: " + profession + "\n");
    }

}
