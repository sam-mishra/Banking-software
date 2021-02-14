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
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author hp
 */
public class BranchList {
    public ArrayList <Branch> Branches = new ArrayList();
     public BranchList(){
        //theHeadOfficeBranch=new Branch();
      //  this.saveToFile(true);
    //  this.loadFromFile();
    this.loadConstructor();
    }
    
    public void add(Branch src){
        Branches.add(src);
    }
    
    public void remove (Customer src){
        Branches.remove(src);
    }
    
     public void Display(JTextArea jBranchTextArea){
        for (int i=0; i<Branches.size(); i++){
            Branches.get(i).Display(jBranchTextArea);
            
        }
     }
     
     public void saveToFile(boolean append){
     try{
     FileWriter writer= new FileWriter(new File("BranchListFile.txt"), append);
     BufferedWriter awriter= new BufferedWriter(writer);
     for(int i=0; i<Branches.size(); i++){
     Branches.get(i).SaveToFileBranch(awriter);
     }
     awriter.flush();
     awriter.close();}
     catch(IOException ioe){
     System.out.println("Error while saving branch list");
     }
       
      }
     
      public void loadFromFile(){
       try   {  FileReader areader=new FileReader("BranchListFile.txt");
          BufferedReader bin= new BufferedReader(areader);
         for(int i=0; i<Branches.size(); i++){
        Branches.get(i).LoadFromFileBranch(bin);
        
     }  
         areader.close();
       }
       catch(Exception e){
              System.out.println("Error while loading branch list");
       }
                
}
      public int listsize(){
      return Branches.size();
      }
      public void loadConstructor(){
    try{
    FileReader areader=new FileReader("BranchListFile.txt");
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
        String manager = bin.readLine();
        String workingHours = bin.readLine();
        String sortCode = bin.readLine();
        this.add(new Branch("",name,house_name,house_no,street,area,post_code,town,country,workingHours,sortCode,manager));
        
        }
    }
    catch(Exception e){
    System.out.println("Something went wrong while initialising branch details");
    }
    }
      
   
}
