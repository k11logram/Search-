/*Dube Kagiso
Hussein Suleman
DBXKAG003
26 February 2023
*/

public class Term{
      Item term;
      Term left;
      Term right;
      
  public Term(Item term){
       this.term=term;
       left=null;
       right=null;
       
       }
       
    public Term(Item term, Term left, Term right){
       this.term=term;
       this.left=left;
       this.right=right;
       
       }

  }
      