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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author hp
 */
public class Branch {
    //Attribute declaration
   // private IAddress theAddress=new IAddress();
    private IAddress theAddress;
    private String workingHours;
    private String sortCode;
    private String manager;
    //private String file="branchaddressfile.txt";
    //private Account Account[];
    
    //Default constructor for branch
    public Branch(){
     //theAddress= new IAddress("", "", 0, "", "", "", "Middlesex", "UK");
     theAddress=new IAddress();
     this.workingHours = "";
     this.sortCode = "";
     this.manager = "";
    this.SaveToFile(true);
   //  this.LoadFromFile();
    // theAddress= new IAddress("Barclays", "Temple Fortune Parade", 802, "Hampstead Way", "Finchley Road", "NW11 6XJ", "Middlesex", "UK");
    //this.Edit("9:00-17:00", "00-00-00", "TBA");
     
     
     //this.LoadFromFile(jHeadOfficeTextArea);
    }
    
    //Parameterized constructor for branch
    public Branch(String strname, String str_house_name, Integer int_house_no, String str_street, String str_area, String str_post_code, String str_town, String str_country, String workingHours, String sortCode, String manager){
        theAddress=new IAddress(strname, str_house_name, int_house_no, str_street, str_area, str_post_code, str_town,str_country);
         this.Edit(manager,workingHours, sortCode );
         this.SaveToFile(true);
       // this.LoadFromFile();
    }
    public Branch(String dontcare,String strname, String str_house_name, Integer int_house_no, String str_street, String str_area, String str_post_code, String str_town, String str_country, String workingHours, String sortCode, String manager){
        theAddress=new IAddress(strname, str_house_name, int_house_no, str_street, str_area, str_post_code, str_town,str_country);
         this.Edit(manager,workingHours, sortCode);
       //  this.SaveToFile(true);
       // this.LoadFromFile();
    }
    
    //Edit method for editing working hours, sort code, manager with theAddress atrributes set as given in line 1 using Edit method from IAddress class
    public void Edit(String manager, String workingHours, String sortCode){
     //theAddress.Edit("Barclays", "Temple Fortune Parade", 802, "Hampstead Way", "Finchley Road", "NW11 6XJ", "Middlesex", "UK"); 
     this.workingHours= workingHours;
     this.sortCode= sortCode;
     this.manager=manager;
    }
    
    public void EditHeadOfficeAddress(String name, String house_name, Integer house_no, String street, String area, String post_code, String town, String country){
        theAddress.Edit(name, house_name, house_no, street, area, post_code, town, country); 
    }
    
    //Method for displaying branch information in text area using Display method of IAddress class added to the ToString method's output in this class
    public void Display(JTextArea jOutputTextArea){
     
     jOutputTextArea.append(ToString());
     
     
     //jOutputTextArea.setText(ToString());
     //jOutputTextArea.setText(LoadFromFile());
    }
    
    //Method outputting branch info excluding branch address
    public String ToString(){
        return    manager + System.lineSeparator() + workingHours + System.lineSeparator() + sortCode + System.lineSeparator() + theAddress.ToString() + "#######################" + System.lineSeparator(); 
    }
    
    //Method EditAll implemented to edit all the parameters including the branch address and other branch details at once and for reusing it for parameterized constructor
   public void EditAll(String strname, String str_house_name, Integer int_house_no, String str_street, String str_area, String str_post_code, String str_town, String str_country, String workingHours, String sortCode, String manager ){
        theAddress.Edit(strname, str_house_name, int_house_no, str_street, str_area, str_post_code, str_town, str_country );
        this.workingHours= workingHours;
        this.sortCode= sortCode;
        this.manager=manager;
    }
   
   public void LoadFromFile(){
       try{
            FileReader areader=new FileReader("BranchListFile.txt");
           BufferedReader bin= new BufferedReader(areader);
          String line=bin.readLine();
          this.LoadFromFileBranch(bin);
           areader.close();
           
       }
       catch (Exception e){
           System.out.println("Error while loading head office details");
           
       }
   }
   
   public IAddress gettheAddress(){
       return theAddress;
   }
   
  public void SaveToFile(boolean append){
      try{
           FileWriter writer= new FileWriter(new File("BranchListFile.txt"), append);
           BufferedWriter awriter= new BufferedWriter(writer);
           this.SaveToFileBranch(awriter);
            awriter.flush();
            awriter.close();}
       catch(IOException ioe){
           System.out.println("Error while saving head office details");
       }
  }
  public void SaveToFileBranch(BufferedWriter awriter) throws IOException{
      awriter.write("@@@@"+System.lineSeparator());
      theAddress.SaveToFile(awriter);
        
        try {
            awriter.write(manager + System.lineSeparator() + workingHours + System.lineSeparator() + sortCode + System.lineSeparator());
        } catch (IOException ex) {
            System.out.println("Error while saving head office details");
        }
        
            
  }
  
  public void LoadFromFileBranch(BufferedReader bin){
       this.theAddress.LoadFromFile(bin);
        try {
            String manager = bin.readLine();
            String workingHours = bin.readLine();
            String sortCode = bin.readLine();
            this.Edit(manager,workingHours,sortCode);
        } catch (IOException e) {
             System.out.println("Error while loading head office details");
        }
           
  }
   
}
