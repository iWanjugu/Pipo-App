package com.miniprojects.pipo;

/**
 * Created by iWanjugu on 13/11/2015.
 */
public class PeopleData {
    int id;
    String first_name;
    String last_name;
    String email;
    String country;
    String company_name;
    String credit_card;

    public PeopleData(String first_name, String last_name, String email, String country,
            String company_name, String credit_card) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.country = country;
        this.company_name = company_name;
        this.credit_card = credit_card;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getCompanyName() {
        return company_name;
    }

    public String getCreditCard() {
        return credit_card;
    }
}


