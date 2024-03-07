/*DBXKAG003
Dube Kagiso
01 March 2024
*/


import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;


public class GenericKbBSTApp{
   public static void main(String args[]){
      String input="";
      BST node=new BST();
      /* create the frame
         the frame must fit the screen
         the frame must have a background color
         we add all the panels to the frame
         */
      JFrame frame = new JFrame();
      frame.setVisible(true);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("GenericsKBSTApp");
      frame.getContentPane().setBackground(Color.PINK);
      UIManager.put("OptionPane.minimumSize", new Dimension(500, 500));
      UIManager.put("OptionPane.background", Color.WHITE); 
      UIManager.getLookAndFeelDefaults().put("Panel.background", Color.CYAN);

      
      JOptionPane.showMessageDialog(frame,"Please be aware that program won't work unless you enter the source file or the location of the source file first or chose exit option.");
      do{
         do{
         //Accept user input
            input=JOptionPane.showInputDialog(frame,"Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit");
        
            if(input==null){
            JOptionPane.showMessageDialog(frame,"You neeed to choose option 5 to exit");}      
         }
         //User must enter something and must never leave input bar empty
         while (input == null);
      
       if(input.equals("1")){
       String file;
       try{
          do{
            file=JOptionPane.showInputDialog(frame,"Enter file name: ");
        
            if(file == null||file.trim().length()==0){
            JOptionPane.showMessageDialog(frame,"Enter file name please");}      
         }
         while (file == null||file.trim().length()==0);

        BufferedReader read = new BufferedReader(new FileReader(file));
      String fileLine ="";
      /*read the file and enter the facts in a binary search tree
        the parts of the fact are separeted by a tab so look for the tab in order to separate them
        */
      while((fileLine = read.readLine()) != null){
        String item = fileLine.substring(0, fileLine.indexOf("\t")+1);
        String no_item=fileLine.substring(fileLine.indexOf("\t")+1, fileLine.length());
        String statement = no_item.substring(0,no_item.indexOf("\t")+1);
        double confidence = Double.parseDouble(no_item.substring(no_item.indexOf("\t")+1,no_item.length()));
        
      
       Item fact = new Item(item,statement,confidence);
       node.insert(fact);
       }
       //close the file
       read.close();
       }
       catch(IOException e){
        JOptionPane.showMessageDialog(frame, "please enter a proper file name or enter proper location of the file");}       
      if(!(node.root == null)){
        JOptionPane.showMessageDialog(frame,"Knowledge base loaded successfully.");}
         }
         
       else if(input.equals("2") && node.root !=null){
       String term;
          do{
            term=JOptionPane.showInputDialog(frame,"Enter the term: ")+"\t";
        
            if(term == null||term.trim().length()==0){
            JOptionPane.showMessageDialog(frame,"Enter proper term");}      
         }
           // When user enters anything but a proper string/existing term.
         while (term == null||term.trim().length()==0);

       String statement;
          do{
            statement=JOptionPane.showInputDialog(frame,"Enter the statement: ")+"\t";
        
            if(statement == null||statement.trim().length()==0){
            JOptionPane.showMessageDialog(frame,"Enter proper statement!!!");}      
         }
           // When user enters anything but a proper string
         while (statement == null||statement.trim().length()==0);


       String confidence_level;
       do{
           confidence_level= JOptionPane.showInputDialog(frame,"Enter the confidence score: ");
           if (isDouble(confidence_level)==false||confidence_level==null||Double.parseDouble(confidence_level)<0||confidence_level.equals("")||confidence_level.trim().length()==0||Double.parseDouble(confidence_level)>1){
              JOptionPane.showMessageDialog(frame,"Enter a proper number/number between 0 and 1.");}

             }
               // When user enters anything but a proper number.
        while(isDouble(confidence_level)==false||confidence_level==null||Double.parseDouble(confidence_level)<0||confidence_level.equals("")||confidence_level.trim().length()==0||Double.parseDouble(confidence_level)>1);

          
          double confidence = Double.parseDouble(confidence_level);   
           
       Item item = new Item(term,statement,confidence);
       
       JOptionPane.showMessageDialog(frame,node.Replace(item));
       
       }
       else if (input.equals("3") && node.root !=null){
       String term;
          do{
            term=JOptionPane.showInputDialog(frame,"Enter the term: ")+"\t";
        
            if(term == null||term.trim().length()==0){
            JOptionPane.showMessageDialog(frame,"Enter proper term");}      
         }
         // When user enters anything but a proper string/existing term.
         while (term == null||term.trim().length()==0);


       JOptionPane.showMessageDialog(frame,node.find(term).term.getItem().trim()+" "+node.find(term).term.getStatement().trim()+" (Confidence score: "+Double.toString(node.find(term).term.getConfidence())+")");
       }

       else if (input.equals("4") && node.root !=null){
        String term;
          do{
            term=JOptionPane.showInputDialog(frame,"Enter the term: ")+"\t";
        
            if(term == null||term.trim().length()==0){
            JOptionPane.showMessageDialog(frame,"Enter proper term");}      
         }
         // When user enters anything but a proper string/existing term.
         while (term == null||term.trim().length()==0);
         
          String statement;
          do{
            statement=JOptionPane.showInputDialog(frame,"Enter the statement: ")+"\t";
        
            if(statement == null||statement.trim().length()==0){
            JOptionPane.showMessageDialog(frame,"Enter proper statement!!!");}      
         }
           // When user enters anything but a proper string/existing string.
         while (statement == null||statement.trim().length()==0);


       if(node.find(term) != null && node.find(term).term.getStatement().equals(statement)){
         JOptionPane.showMessageDialog(frame, "The statement was found and has a confidence score of "+node.find(term).term.getConfidence());}
       else{
         JOptionPane.showMessageDialog(frame,"Term and statement cannot be found:");}
       }
       //allow user to enter only one of the five options given to them and nothing else
      else if (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5"))){
        JOptionPane.showMessageDialog(frame,"choose one of the five options displayed to you");
        }
       }
       //Quit the program
        while(!input.equals("5"));
        //close the frame
        frame.dispose();
      }
      
    // check if confidence score is an actual number  
    public static boolean isDouble(String str) {
    try {
        Double.parseDouble(str);
        return true;}
     catch (NumberFormatException e) {
        return false;
    }
}
}
