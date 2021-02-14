/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;

import java.util.Date;
import javax.swing.JTextArea;

/**
 *
 * @author hp
 */
public class Person {
    //Attribute Declaration
    private String firstName;
    private String surName;
    private IAddress homeAddress;
    private Date DOB;
    private Date customerSince;
    //private IAddress theAddress;
    
    
    //Default constrcutor
    public Person(){
        homeAddress = new IAddress();
        DOB= new Date("01-01-1900"); //date passed in as a string
        customerSince=new Date(); //will set by default the date as the current date and time which could be edited if needed
        this.Edit("", "");
    }
    
    //Edit method which sets address and dates value to null and zero and sets the first and last name
    public void Edit(String firstName, String surName){
         homeAddress = new IAddress();
        DOB= new Date("01-01-1900"); //date passed in as a string
        customerSince=new Date();
        homeAddress.Edit("", "", 0, "", "", "", "", "");
        this.firstName=firstName;
        this.surName=surName;
        this.EditDates(0, 0, 0, 0, 0, 0);
    }
    
    //EditAll method for editing objects of address class, objects of date class and attributes of person class at once
    public void EditAll(String strname, String str_house_name, Integer int_house_no, String str_street, String str_area, String str_post_code, String str_town, String str_country, int DOBDay, int DOBMonth, int DOBYear, int customerSinceDay, int customerSinceMonth, int customerSinceYear, String firstName, String surName){
        this.EditAddress( strname, str_house_name, int_house_no, str_street, str_area, str_post_code, str_town, str_country );
        this.EditDates(DOBDay, DOBMonth, DOBYear, customerSinceDay, customerSinceMonth, customerSinceYear);
         this.firstName=firstName;
        this.surName=surName;
    }
    
    //EditAddress method for editing home address
    public void EditAddress(String strname, String str_house_name, Integer int_house_no, String str_street, String str_area, String str_post_code, String str_town, String str_country ){
        homeAddress.Edit(strname, str_house_name, int_house_no, str_street, str_area, str_post_code, str_town, str_country );
    }
    
    //EditDate method for editing dates
    public void EditDates(int DOBDay, int DOBMonth, int DOBYear, int customerSinceDay, int customerSinceMonth, int customerSinceYear){
        DOB.setDate(DOBDay);
        DOB.setMonth(DOBMonth);
        DOB.setYear(DOBYear);
        customerSince.setDate(customerSinceDay);
        customerSince.setMonth(customerSinceMonth);
        customerSince.setYear(customerSinceYear);
    }
    
    //method to check if the date equals 01-01-1900
    public boolean checkDOB(Date DOB){
        return DOB.toString().equals("01-01-1900");
    }
    
    //method to return the attributes as strings including home address and dates
    public String ToString(){
        return "First Name: " + firstName + System.lineSeparator() + "Sur Name: " + surName + System.lineSeparator() + "Home Address: " + homeAddress.ToString() + System.lineSeparator() + "Date Of Birth: " + DOB.toString()  + System.lineSeparator() + "Customer Service: " + customerSince.toString() + System.lineSeparator();
    }
    
    //method to display Person info in the text area
    public void Display(JTextArea src){
        src.setText(ToString());
    }
    
    //Methods instructed to be declared according to the class diagram
    public void SaveToFile(){
        
    }
    
    public void LoadFromFile(){
        
    }
}
