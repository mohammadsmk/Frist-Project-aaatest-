package com.example.mohammad.aaatest.L7_CustomList;

/**
 * Created by Mohammad on 7/17/2018.
 */

//public class MyContact {
//    private String name; private String phonenumber; private int id;
//
//    public MyContact(String name , String phonenumber , int id){
//        this.name = name;
//        this.phonenumber = phonenumber;
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPhonenumber() {
//        return phonenumber;
//    }
//
//    public void setPhonenumber(String phone) {
//        this.phonenumber = phone;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String toString(){return name;}
//}
//
public class MyContact {
    String name;
    String PhoneNumber;
    int id;
    public MyContact(String name ,String PhoneNumber , int id){
        this.name = name;
        this.PhoneNumber = PhoneNumber;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String toString() {return name;}
}
