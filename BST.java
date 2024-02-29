//DBXKAG003
//Dube Kagiso
// 26 February 2024

public class BST{
  public static Term root;
  
   public BST(){
     root=null;
     }
     
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
       
    else if(comparison<0){
      if(node.left==null){
        return null;
        }
      return find(term,node.left);
      }
      
    else{
      if(node.right==null){
        return null;
        }
      return find(term,node.right);
      }
     }
     
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
    if(compare<0){
        if(root.left==null){
         root.left=new Term(item,null,null);
         }
         else{
           insert(item,root.left);
           }
         }
      else{
         if(root.right==null){
            root.right=new Term(item);
            }
         else{
            insert(item,root.right);
            }
         }
       }
       
//  public void delete ( String d )
//  {
//  root = delete (d, root);
//  }
//  
//  public void delete(String term, Term node){
//    if (node==null){
//     return null;
//     }
//     
//      int cmp = term.compareTo (node.term.getItem());
//     if (cmp < 0){
//     node.left = delete (term, node.left);
//     }
//     else if (cmp > 0){
//     node.right = delete (term, node.right);
//     }
//     else if (node.left != null && node.right != null ){
//       
//        }
//        }
       
   public void Replace(Item term, Term node){
     int comparison = term.getItem().compareTo(node.term.getItem());
     if(comparison==0){
     if(term.getConfidence()>node.term.getConfidence()){
       node=new Term(term,node.left,node.right);}
       
       }
       
    else if(comparison<0){
      if(node.left==null){
         insert(term);
        }
      Replace(term,node.left);
      }
      
    else {
      if(node.right==null){
        insert(term);
        }
      Replace(term,node.right);
      }
     }
    }


    
        

     