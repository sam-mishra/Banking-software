/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;

/**
 *
 * @author hp
 */
public class Customer {
    private String FirstName;
    private String SurName;
    private IAddress HomeAddress;
    private Date DOB;
    private Date customerSinceDate;
    private String DOBDateToString;
    private String customerSinceDateToString;
    
    public Customer() throws ParseException{
        HomeAddress=new IAddress();
        DOB=new SimpleDateFormat("dd/MM/yyyy").parse("00/00/0000");
        customerSinceDate=new SimpleDateFormat("dd/MM/yyyy").parse("00/00/0000");
        this.SaveToFile(true);
        this.LoadFromFile();
        //DOB=new Date();
       this.Edit("","","","");
    }
    
     public Customer(String fName, String lName, String date, String customerSince, String name, String house_name, Integer house_no, String street, String area, String post_code, String town, String country) throws ParseException{
       this.EditAll(fName, lName, date, name, house_name, house_no, street, area, post_code, town, country, customerSince);
     this.SaveToFile(true);
     // this.LoadFromFile();
     }
     public Customer(String dontcare,String fName, String lName, String date, String customerSince, String name, String house_name, Integer house_no, String street, String area, String post_code, String town, String country) throws ParseException{
       this.EditAll(fName, lName, date, name, house_name, house_no, street, area, post_code, town, country, customerSince);
   //  this.SaveToFile(true);
     // this.LoadFromFile();
     }
    
    public void Edit(String FirstName, String SurName, String date, String customerSince) throws ParseException{
        this.FirstName=FirstName;
        this.SurName=SurName;
        DOB=new SimpleDateFormat("dd-MM-yyyy").parse(date);
        customerSinceDate=new SimpleDateFormat("dd-MM-yyyy").parse(customerSince);
    }
    
    public void EditAll(String fName, String lName, String date, String name, String house_name, Integer house_no, String street, String area, String post_code, String town, String country, String customerSince) throws ParseException{
        HomeAddress=new IAddress(name, house_name, house_no, street, area, post_code, town, country);
        this.Edit(fName ,lName, date, customerSince);
        
    }
    
    public void SaveToFile(){
        
    }
    //public boolean checkDOB

    public String getSurname() {
       return SurName;
    }
    
    public IAddress getAddress() {
    return HomeAddress;
    }
    
    //method to check if the date equals 01-01-1900
    public boolean checkDOB(Date DOB){
        return DOBDateToString.equals("01-01-1900");
    }
    
    //method to return the attributes as strings including home address and dates
    public String ToString(){
        return FirstName + System.lineSeparator() + SurName + System.lineSeparator() + DOB.toString()  + System.lineSeparator() + customerSinceDate.toString()+ System.lineSeparator() + this.getAddress().ToString() + "#######################" + System.lineSeparator();
    }
    
    //method to display Person info in the text area
    public void Display(JTextArea jClientsTextArea){
        jClientsTextArea.append(ToString());
    }
    
     public void LoadFromFile(){
       try{
            FileReader areader=new FileReader("CustomerListFile.txt");
           BufferedReader bin= new BufferedReader(areader);
          // String line=bin.readLine();
          this.LoadFromFileCustomer(bin);
           areader.close();
           
       }
       catch (Exception e){
           System.out.println("Error while loading Customer details");
           
       }
   }
     
     public void LoadFromFileCustomer(BufferedReader bin) throws ParseException{
       this.HomeAddress.LoadFromFile(bin);
        try {
            String FirstName = bin.readLine();
            String SurName = bin.readLine();
            String DOB = bin.readLine();
            String customerSinceDate = bin.readLine();
            this.Edit(FirstName,SurName,DOB,customerSinceDate);
            String dummy= bin.readLine();
        } catch (IOException e) {
             System.out.println("Error while loading Customer details");
        }
           
  }
     
      public void SaveToFile(boolean append){
      try{
           FileWriter writer= new FileWriter(new File("CustomerListFile.txt"), append);
           BufferedWriter awriter= new BufferedWriter(writer);
           this.SaveToFileCustomer(awriter);
            awriter.flush();
            awriter.close();}
       catch(IOException ioe){
           System.out.println("Error while saving Customer details");
       }
  }
  public void SaveToFileCustomer(BufferedWriter awriter){
        
        try {
            awriter.append("@@@@"+System.lineSeparator());
            HomeAddress.SaveToFile(awriter);
            SimpleDateFormat Formatter = new SimpleDateFormat("dd-MM-yyyy");
            awriter.write(FirstName + System.lineSeparator() + SurName + System.lineSeparator() + Formatter.format(DOB)  + System.lineSeparator() + Formatter.format(customerSinceDate)+ System.lineSeparator());
            
            
        } catch (IOException ex) {
            System.out.println("Error while saving Customer details");
        }
    }
  
  public String getFirstName(){
      return FirstName;
  }
  
  public String getDOB(){
      DOBDateToString=new SimpleDateFormat("dd-MM-yyyy").format(DOB);
      return DOBDateToString;
  }
  
  public String getcustomerSince(){
      customerSinceDateToString=new SimpleDateFormat("dd-MM-yyyy").format(customerSinceDate);
      return customerSinceDateToString;
  }
}
