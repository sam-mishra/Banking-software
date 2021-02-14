/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author hp
 */
public class User {
    //attribute declaration
  private String name;
  private String role;
  private String password;
  private String filename;
  
  public User(){
      //this.Edit("", "Bank Employee", "", "login.txt");
      this.Edit("", "", "", "login.txt");
  }
  
  public User( String name, String role, String password, String filename){
      this.Edit(name, role, password, "login.txt");
  }
  
  public void Edit( String name, String role, String password, String filename){
      this.name=name;
      this.role= role;
      this.password= password;
      this.filename=filename;
  }
  
  public boolean isUser(String newName, String newPassword, String newRole){
      name= newName;
      password=newPassword;
      role=newRole;
      boolean isFound= false;
      String record;
      FileReader reader;
      try{
          reader= new FileReader(filename);
          BufferedReader bin=new BufferedReader(reader);
          record= new String();
          while ((record=bin.readLine())!=null){
              if((name+"##"+password+"##"+role).contentEquals(record))
                  isFound=true;
              //*break can be used?
          }
         bin.close();
         bin=null;
      }catch(IOException ioe){
          isFound=false;
      }
      return isFound;
  }
  
  public boolean isManager(String newName, String newPassword, String newRole){
      return (newRole.equals("Manager")&&isUser(newName, newPassword, newRole));
  }
  
  public boolean isEmployee(String newName, String newPassword, String newRole){
      return (newRole.equals("Bank Employee")&&isUser(newName, newPassword, newRole));
  }
  
  public boolean isAdministrator(String newName, String newPassword, String newRole){
      return (newRole.equals("Administrator")&&isUser(newName, newPassword, newRole));
  }
  
  public boolean isAdvisor(String newName, String newPassword, String newRole){
      return (newRole.equals("Advisor")&&isUser(newName, newPassword, newRole));
  }
  
  public boolean isClient(String newName, String newPassword, String newRole){
      return (newRole.equals("Client")&&isUser(newName, newPassword, newRole));
  }
  
  public boolean isRegistered(String newName, String newPassword, String newRole){
      boolean isRegistered;
      name=newName;
      password=newPassword;
      role=newRole;
      FileWriter writer;
      try{
          writer=new FileWriter (filename, true);
          //writer.write(name+System.getProperty("line.separator"));
          //writer.write("##"+System.getProperty("line.separator"));
          writer.write(name+"##"+password+"##"+role+System.getProperty("line.separator"));
          isRegistered=true;
          writer.flush();
          writer.close();
          writer= null;
      }catch (IOException ioe){
          isRegistered=false;
      }
      return isRegistered;
  }
  
 // public boolean SaveToFile(){
      
 // }
  
  //public boolean LoadFromFile(){
      
  //}
}
