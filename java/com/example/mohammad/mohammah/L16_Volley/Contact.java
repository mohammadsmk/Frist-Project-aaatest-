package com.example.mohammad.aaatest.L16_Volloy;

import java.io.Serializable;

/**
 * Created by Mohammad on 8/30/2018.
 */

public class Contact implements Serializable
{
    private String Name ;
    private String Phone;
    private String Email;

    public Contact (String Name , String Phone , String Email)
    {
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
