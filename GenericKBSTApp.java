import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.JFrame;
import java.awt.Color;

public class GenericKBSTApp{
   public static void main(String args[]){
      String input="";
      BST node=new BST();
      
      JFrame frame = new JFrame();
      frame.setVisible(true);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("GenericsKBSTApp");
      frame.getContentPane().setBackground(Color.black);
      do{
         do{
            input=JOptionPane.showInputDialog(frame,"Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit");
        
            if(input==null){
            JOptionPane.showMessageDialog(frame,"You neeed to choose option 5 to exit");}      
         }
         while (input == null);
      
       if(input.equals("1")){
       try{
        String file=JOptionPane.showInputDialog(frame,"Enter file name: ");
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
        JOptionPane.showMessageDialog(frame, "please enter a proper file name or enter proper location of the file");}       
      if(node != null){
        JOptionPane.showMessageDialog(frame,"Knowledge base loaded successfully.");}
         }
         
       else if(input.equals("2")){
       String term=JOptionPane.showInputDialog(frame,"Enter the term: ")+"\t";
       String statement=JOptionPane.showInputDialog(frame,"Enter the statement: ")+"\t";
       double confidence= Double.parseDouble(JOptionPane.showInputDialog(frame,"Enter the confidence score: "));
       Item item = new Item(term,statement,confidence);
       node.Replace(item,node.root);
       JOptionPane.showMessageDialog(frame,"Statement has been added to database.");
       
       }
       else if (input.equals("3")){
       String term=JOptionPane.showInputDialog(frame,"Enter the term to search: ")+"\t";
       Term newNode=node.find(term);
       JOptionPane.showMessageDialog(frame,newNode.term.getItem().trim()+" "+newNode.term.getStatement().trim()+" (Confidence score: "+Double.toString(newNode.term.getConfidence())+")");
       }

       else if (input.equals("4")){
       String term=JOptionPane.showInputDialog(frame,"Enter the term to search: ")+"\t";
       String statement=JOptionPane.showInputDialog(frame,"Enter the statement to search for: ")+"\t";
       Term newNode=node.find(term);
       if(newNode.term.getStatement().equals(statement) && newNode != null){
         JOptionPane.showMessageDialog(frame, "The statement was found and has a confidence score of "+newNode.term.getConfidence());}
       else{
         JOptionPane.showMessageDialog(frame,"Term and statement cannot be found:");}
       }
      else if (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5"))){
        JOptionPane.showMessageDialog(frame,"choose one of the five options displayed to you");
        }
   //   else{
//         break;
//        }
       }
       
        while(!input.equals("5"));
        frame.dispose();
      }
}
