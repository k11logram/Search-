public class Item{
   public String item;
   public String statement;
   public double confidence;
   
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
     
  public String getItem(){
     return item;
     }
     
  public String getStatement(){
      return statement;
      }
      
  public double getConfidence(){
     return confidence;
     }
     
  public void setItem(){
     this.item=item;
     }
     
 public void  setStatement(String statement){
    this.statement=statement;
    }
    
 public void setConfidence(double confidence){
     this.confidence=confidence;
     }
     
 public String toString(){
    return ""+item+statement+confidence+".";
    }
   }