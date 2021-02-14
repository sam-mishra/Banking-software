/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author hp
 */
public class IAddress {
    //attribute declaration
    private String name;
    private String house_name;
    private Integer house_no;
    private String street;
    private String area;
    private String post_code;
    private String town;
    private String country;
    
    //default constructor
    public IAddress(){
        this.Edit("", "", 0, "", "", "", "", "");
    }
    
    //parameterized constructor
    public IAddress(String name, String house_name, Integer house_no, String street, String area, String post_code, String town, String country){
        this.Edit(name, house_name, house_no, street, area, post_code, town, country);
    }
    
    //Display method
    public void Display(JTextArea src){
       // src.setLineWrap(true);
        src.append(ToString());
    }
    
    //Edit method
    public void Edit(String name, String house_name, Integer house_no, String street, String area, String post_code, String town, String country ){
        this.name=name;
        this.house_name=house_name;
        this.house_no=house_no;
        this.street=street;
        this.area=area;
        this.post_code=post_code;
        this.town=town;
        this.country=country;  
    } 
    
    //ToString method
    public String ToString(){
      return    name + System.lineSeparator() + house_name + System.lineSeparator() + String.valueOf(house_no) + System.lineSeparator() + street + System.lineSeparator() + area + System.lineSeparator() + post_code + System.lineSeparator() + town + System.lineSeparator() + country + System.lineSeparator();
    }
    
    //SaveToFile method which was instrcuted to be declared in the class diagram
    public void SaveToFile(BufferedWriter awriter){
        try{
            awriter.write(ToString());
        }
        catch(IOException ioe){
            System.out.println("Failed to save");
        }
    }
    
    public void LoadFromFile(BufferedReader bin){
       
        try {
        String name=bin.readLine();
        String house_name=bin.readLine();
        int house_no=Integer.parseInt(bin.readLine());
        String street=bin.readLine();
        String area=bin.readLine();
        String post_code=bin.readLine();
        String town=bin.readLine();
        String country=bin.readLine();  
            this.Edit(name,house_name,house_no,street,area,post_code,town,country);
        } catch (IOException ex) {
            System.out.println("Failed to load information");
        }
            
        
    }
}
