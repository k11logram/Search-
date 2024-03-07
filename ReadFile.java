/*DBXKAG003
Dube Kagiso
25 February 2024
*/


import java.io.BufferedReader;
import java.io.FileReader;import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.JOptionPane;
/* 
 The class reads a file and stores all the generics truths in an array
 the class pre sets the size of the array
 the class allows the user to search for a fact or add a new fact.
 */
public class ReadFile{
 public int countline=0;
 public String file;
 public Item[] sentences = new Item[2000000];
 
 public ReadFile(String file){
  this.file=file;
  }
 //enters the generic truths are added into the array 
 public void setSentences(String file){         
    try{
      BufferedReader read = new BufferedReader(new FileReader(file));
      String fileLine ="";
      while((fileLine = read.readLine()) != null){
        String item = fileLine.substring(0, fileLine.indexOf("\t")+1);
        String no_item=fileLine.substring(fileLine.indexOf("\t")+1, fileLine.length());
        String statement = no_item.substring(0,no_item.indexOf("\t")+1);
        double confidence = Double.parseDouble(no_item.substring(no_item.indexOf("\t")+1,no_item.length()));
        
      
       Item fact = new Item(item,statement,confidence);
 //Add generic truth to array                  
         sentences[countline]=fact;
         countline++;
        }
        read.close();
        }
        
    catch (IOException e){
         JOptionPane.showMessageDialog(null,"Please enter proper file name or file location");}

      }
 // This method allows user to search for a generic truth using the term   
 public String search(String item){
   for(int i=0;i<countline;i++){
     if(sentences[i].getItem().equals(item+"\t")){
      return ""+"Statement found: "+sentences[i].getStatement().trim()+" (Confidence score: "+Double.toString(sentences[i].getConfidence())+")";
      }
    }
    return "term doesn't exist";
    }
  //This method allows to confirm if generic truth exists by using it's term and the statement  
 public String search(String item, String statement){
   for( int i=0;i<countline;i++){
     if((sentences[i].getItem().trim().equals(item)) &&(sentences[i].getStatement().trim().equals(statement))){
      return "The statement was found and has a confidence score of "+sentences[i].getConfidence();
      }
    }
    return "Term and statement cannot be found:" ;
    }
 //Checks if the is generic truth that has the term that the user has entered if not it adds it to the array 
 public String Update_database(String item, String statement, double confidence){
     for(int i=0;i<countline;i++){
     if(sentences[i].getItem().trim().equals(item)){
      if(confidence>=sentences[i].getConfidence()){
        sentences[i].setStatement(statement); sentences[i].setConfidence(confidence);
        return "Statement for term "+sentences[i].getItem().trim()+" has been updated.";
      }
      return "Confidence score below the original average score.";
      
    }
     sentences[countline]=new Item(item+"\t",statement+"\t",confidence);
     countline++;
           }
    
    
    return "Statement has been added to database.";
   }
   }

            
               