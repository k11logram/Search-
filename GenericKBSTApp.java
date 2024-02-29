import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

public class GenericKBSTApp{
   public static void main(String args[]){
      String input="";
      BST node=new BST();
      do{
      input=JOptionPane.showInputDialog(null,"Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit");
       if(input.equals("1")){
       try{
        String file=JOptionPane.showInputDialog(null,"Enter file name: ");
        BufferedReader read = new BufferedReader(new FileReader(file));
      String fileLine ="";
      while((fileLine = read.readLine()) != null){
        String item = fileLine.substring(0, fileLine.indexOf("\t")+1);
        String no_item=fileLine.substring(fileLine.indexOf("\t")+1, fileLine.length());
        String statement = no_item.substring(0,no_item.indexOf("\t")+1);
        double confidence = Double.parseDouble(no_item.substring(no_item.indexOf("\t")+1,no_item.length()));
        
      
       Item fact = new Item(item,statement,confidence);
       node.insert(fact);
       }
       read.close();
       }
       catch(IOException e){
       // e.printStackTrace();
        JOptionPane.showMessageDialog(null, "please enter a proper file name or enter proper location of the file");}       
      if(node != null){
        JOptionPane.showMessageDialog(null,"Knowledge base loaded successfully.");}
         }
         
       else if(input.equals("2")){
       String term=JOptionPane.showInputDialog(null,"Enter the term: ")+"\t";
       String statement=JOptionPane.showInputDialog(null,"Enter the statement: ")+"\t";
       double confidence= Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the confidence score: "));
       Item item = new Item(term,statement,confidence);
       node.Replace(item,node.root);
       JOptionPane.showMessageDialog(null,"Statement has been added to database.");
       
       }
       else if (input.equals("3")){
       String term=JOptionPane.showInputDialog(null,"Enter the term to search: ")+"\t";
       Term newNode=node.find(term);
       JOptionPane.showMessageDialog(null,newNode.term.getItem().trim()+" "+newNode.term.getStatement().trim()+" (Confidence score: "+Double.toString(newNode.term.getConfidence())+")");
       }

       else if (input.equals("4")){
       String term=JOptionPane.showInputDialog(null,"Enter the term to search: ")+"\t";
       String statement=JOptionPane.showInputDialog(null,"Enter the statement to search for: ")+"\t";
       Term newNode=node.find(term);
       if(newNode.term.getStatement().equals(statement) && newNode != null){
         JOptionPane.showMessageDialog(null, "The statement was found and has a confidence score of "+newNode.term.getConfidence());}
       else{
         JOptionPane.showMessageDialog(null,"Term and statement cannot be found:");}
       }
      else if (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5"))){
        JOptionPane.showMessageDialog(null,"choose one of the five options displayed to you");
        }
        
       else if(input==null){
        JOptionPane.showMessageDialog(null,"You neeed to choose option 5 to exit");}
        else{
        break;
       }
       }
       
        while(!input.equals("5"));
      }
}
