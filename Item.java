public class Item{
   private String item;
   private String statement;
   private double confidence;
   
   public Item(String item, String statement, double confidence){
     this.item=item;
     this.statement=statement;
     this.confidence=confidence;
     }
     
   public Item(Item value){
    this.item=value.item;
    this.statement=value.statement;
    this.confidence=value.confidence;
    }
  //return the term   
  public String getItem(){
     return item;
     }
  //return the statement   
  public String getStatement(){
      return statement;
      }
  //return the confidence level    
  public double getConfidence(){
     return confidence;
     }
  //set a new term   
  public void setItem(){
     this.item=item+"\t";
     }
  //set a new statement   
 public void  setStatement(String statement){
    this.statement=statement+"\t";
    }
  //set a new confidence score  
 public void setConfidence(double confidence){
     this.confidence=confidence;
     }
  //convert to string   
 public String toString(){
    return ""+item+statement+confidence+".";
    }
   }