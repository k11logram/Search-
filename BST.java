//DBXKAG003
//Dube Kagiso
// Hussein Suleman
// 26 February 2024

/*The class creates a binary search tree
  It allows the user to insert a generic truth , search for a generic truth or update a already existing generic truth
  */
public class BST{
  public static Term root;
  // define the root node which is the base of our tree
   public BST(){
     root=null;
     }
   //search for a generic truth using the term only  
   public Term find(String term){
     if(root==null){
        return null;
       }
     else{
       return find(term,root);
       }
      }
      
  public Term find(String term, Term node){
     int comparison = term.compareTo(node.term.getItem());
     if(comparison==0){
       return node;
       }
    //if the term of the generic truth is less than the node it is being compared to(alphabetically)   
    else if(comparison<0){
      if(node.left==null){
        return null;
        }
      return find(term,node.left);
      }
       //if the term of the generic truth is greater than the node it is being compared to(alphabetically)   

    else{
      if(node.right==null){
        return null;
        }
      return find(term,node.right);
      }
     }
 //insert the generic truth to the tree    
 public void insert(Item term){
    if (root==null){
       root=new Term(term,null,null);
       }
    else{
       insert(term,root);
      }
     }
     
 public void insert(Item item,Term root){
    int compare =item.getItem().compareTo(root.term.getItem());
    
     //if the term of the generic truth is less than the node it is being compared to(alphabetically) add to the left  
    if(compare<0){ 
        if(root.left==null){
         root.left=new Term(item,null,null);
         }
         else{
           insert(item,root.left);
           }
         }
      //if the term of the generic truth is less than the node it is being compared to(alphabetically) add to the right  
    
    else{
         if(root.right==null){
            root.right=new Term(item);
            }
         else{
            insert(item,root.right);
            }
         }
       }
       
       /* replace an existing generic truth with a new one if the confidence score of the new one is greater than the previous
       do nothing if the score is not greater
       if the term doesn't exist add it to the tree
       */
     public String Replace(Item term){
     if(root==null){
      insert(term);
      }
    return Replace(term,root);
     }
       
   public String Replace(Item term, Term node){
         
     if(find(term.getItem()) != null){
         Term newNode = find(term.getItem());
        if(term.getConfidence()>=newNode.term.getConfidence()){
           newNode.term.setStatement(term.getStatement());
           newNode.term.setConfidence(term.getConfidence());
           return "Statement for term "+term.getItem()+" has been updated.";
       }
       return "Confidence score below the original confidence score";
     }
      
     insert(term);
     return "Statement has been added to database.";
    }
    }


    
        

     