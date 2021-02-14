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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author hp
 */
public class CustomerList {
    public ArrayList <Customer> Clients = new ArrayList();
   
    //Customer client;
    
    public CustomerList(){
       // this.saveToFile(true);
      // this.loadFromFile();
        //client=new Customer();
        this.loadConstructor();
    }
    
    public void add(Customer src){
        Clients.add(src);
    }
    
    public void remove (Customer src){
        Clients.remove(src);
    }
    
    public void remove (String Surname){
        for (int i=0; i<Clients.size(); i++){
            if(Clients.get(i).getSurname().equals(Surname)){
                Clients.remove(i);
            }
        }
    }
    
    public void Display(JTextArea jClientsTextArea){
        for (int i=0; i<Clients.size(); i++){
            Clients.get(i).Display(jClientsTextArea);
        }
    }
    
    /*public void create(){
    for(int i=0; i<Clients.size(); i++){
    Clients.get(i).EditAll(fName, lName, date, name, house_name, house_no, street, area, post_code, town, country, customerSince);
    }
    }*/
    
  
    
    /*public search(){
    
    }
    
    public initialise(){
    
    }*/
    
    public void saveToFile(boolean append){
       try{
           FileWriter writer= new FileWriter(new File("CustomerListFile.txt"), append);
           BufferedWriter awriter=new BufferedWriter(writer);
           for(int i=0; i<Clients.size(); i++){
           Clients.get(i).SaveToFileCustomer(awriter);
        //     awriter.write(Clients.get(i).ToString());
           }             
            awriter.flush();
            awriter.close();}
       catch(IOException ioe){
           
           System.out.println("Error while saving Customer address");
       }
   }
    
    
    public void loadFromFile(){
         try   {  FileReader areader=new FileReader("CustomerListFile.txt");
        BufferedReader bin= new BufferedReader(areader);
         for(int i=0; i<Clients.size(); i++){
        Clients.get(i).LoadFromFileCustomer(bin);
        
     }  
         areader.close();
       }
       catch(Exception e){
              System.out.println("Error while loading Customer list");
       }
    }
    public void loadConstructor(){
    try{
    FileReader areader=new FileReader("CustomerListFile.txt");
        BufferedReader bin= new BufferedReader(areader);
        while(bin.readLine()!=null){
        String name = bin.readLine();
        String house_name = bin.readLine();
        int house_no = Integer.parseInt(bin.readLine());
        String street = bin.readLine();
        String area = bin.readLine();
        String post_code = bin.readLine();
        String town = bin.readLine();
        String country = bin.readLine();
        String first_name = bin.readLine();
        String sur_name = bin.readLine();
        String DOB = bin.readLine();
        String customerSinceDate = bin.readLine();
        this.add(new Customer("",first_name,sur_name,DOB,customerSinceDate,name,house_name,house_no,street,area,post_code,town,country));
        
        }
    }
    catch(Exception e){
    System.out.println("Something went wrong while initialising client details");
    }
    }
    
    public Customer find(Customer src){
       for(int i=0; i < Clients.size(); i++){
           if(( ((Clients.get(i)).getFirstName()).equals(src.getFirstName()))&& (Clients.get(i).getSurname().equals(src.getSurname())) && (Clients.get(i).getDOB().equals(src.getDOB())) && (Clients.get(i).getcustomerSince().equals(src.getcustomerSince())) && ((Clients.get(i).getAddress().ToString()).equals(src.getAddress().ToString()))){   
       //        System.out.println("1");
       //       if((Clients.get(i).getSurname().equals(src.getSurname()))){
       //            System.out.println("2");
        //           if((Clients.get(i).getDOB().equals(src.getDOB()))){
        //               System.out.println("3");
        //               if((Clients.get(i).getcustomerSince().equals(src.getcustomerSince()))){
         //                  System.out.println("4");
         //                  if(((Clients.get(i).getAddress().ToString()).equals(src.getAddress().ToString()))){
          //                     System.out.println("5");
                 return Clients.get(i);
                   }
         //  }
     //  }
   // }
          }
             /*else{
             return src;
             }*/
   //    } 
        return null;
  //  }
}
}
