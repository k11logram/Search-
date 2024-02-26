import java.io.BufferedReader;
import java.io.FileReader;import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

public class ReadFile{
 public int countline=0;
 //public int count=;
 public String file;
 public Item[] sentences = new Item[2000000];
 
 public ReadFile(String file){
  this.file=file;
  }
  
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
                  
         sentences[countline]=fact;
         countline++;
        }
        read.close();
        }
        
    catch (IOException e){
       e.printStackTrace();
     }
    }
    public String search(String item){
   for(int i=0;i<countline;i++){
     if(sentences[i].getItem().equals(item+"\t")){
      return ""+"Statement found: "+sentences[i].getStatement().trim()+" (Confidence score: "+Double.toString(sentences[i].getConfidence())+")";
      }
    }
    return null;
    }
    
public String search(String item, String statement){
   for( int i=0;i<countline;i++){
     if((sentences[i].getItem().equals(item+"\t")) &&(sentences[i].getStatement().equals(statement+"\t"))){
      return "The statement was found and has a confidence score of"+sentences[i].getConfidence();
      }
    }
    return "Term and statement cannot be found:" ;
    }
  
public String Update_database(String item, String statement, double confidence){
     for(int i=0;i<countline;i++){
     if(sentences[i].getItem().equals(item+"\t")){
      if(confidence>sentences[i].getConfidence()){
        sentences[i].setStatement(statement); sentences[i].setConfidence(confidence);
        return "Statement for term "+sentences[i].getItem()+" has been updated.";
      }
      
    }
    else{
        sentences[countline]=new Item(item,statement,confidence);
        }
    
    }
    return "Statement has been added to database.";
   }
   }

            
               