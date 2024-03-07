/*DBXKAG003
  Dube Kagiso
  28 February 2024
  This application is the main class it deals with the front end of the program. 
  */

import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import javax.swing.UIManager;

public class GenericsKbArrayApp{
  public static void main(String args[]){
	  Scanner keyword = new Scanner(System.in);
	  //Stores the facts in the file in an array
	  ReadFile lines=null;
	  
	  //Accepts the users input.
	  String input="";
     
     
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
		
		//Give users brief instrutions on what they should not do.
	  JOptionPane.showMessageDialog(frame,"Please be aware that program won't work unless you enter the source file or the location of the source file first or chose exit option.");
		
	  do{
	  
		 do{
				input=JOptionPane.showInputDialog(frame,"Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit");
            
		  //When user enters anything but the options provided to them.  
				if(input==null){
				JOptionPane.showMessageDialog(frame,"You neeed to choose option 5 to exit");}      
			}
		while (input == null);
         
		//Chose first option
		if(input.equals("1")){
      
		//Accepting the file name
		String file;
			 do{
				file=JOptionPane.showInputDialog(frame,"Enter file name: ");
				
			  //When user enters anthing but the proper file name or location.
				if(file == null||file.trim().length()==0){
				JOptionPane.showMessageDialog(frame,"Enter file name");}      
			   }
			while (file == null||file.trim().length()==0);

				  lines = new ReadFile(file);
              
				  //Inserting the facts in a list.
              
				  lines.setSentences(file);
				  JOptionPane.showMessageDialog(frame,"Knowledge base loaded successfully.");}
		  
      //User enters the new fact or generic truth               
		else if(input.equals("2") && lines !=null){
		String term;
   		  do{
   				term=JOptionPane.showInputDialog(frame,"Enter the term: ");
               
   		      // When user enters anything but a proper string/existing term.
   				if(term == null||term.equals("")||term.trim().length()==0){
   				  JOptionPane.showMessageDialog(frame,"Enter proper term");}      
   			}
   			while (term == null||term.equals("")||term.trim().length()==0);
   
		 
	  String statement;
   		  do{
   				statement=JOptionPane.showInputDialog(frame,"Enter the statement: ");
   		  
   				if(statement == null||statement.equals("")||statement.trim().length()==0){
               //When user enters anything but the actual statement
   				JOptionPane.showMessageDialog(frame,"Enter proper statement!!!!");}      
   			}
   		 while (statement == null||statement.equals("")||statement.trim().length()==0);
   
		String confidence_level;
   		 do{
   			  confidence_level= JOptionPane.showInputDialog(frame,"Enter the confidence score: ");
              if (isDouble(confidence_level)==false||confidence_level==null||Double.parseDouble(confidence_level)<0||confidence_level.equals("")||confidence_level.trim().length()==0||Double.parseDouble(confidence_level)>1){
                    JOptionPane.showMessageDialog(frame,"Enter a proper number/number between 0 and 1.");}

   		   }
            //Check if input is a number
   			while(isDouble(confidence_level)==false||confidence_level==null||Double.parseDouble(confidence_level)<0||confidence_level.equals("")||confidence_level.trim().length()==0||Double.parseDouble(confidence_level)>1);
   		
			 
			 double confidence = Double.parseDouble(confidence_level);
							 
		 JOptionPane.showMessageDialog(frame,lines.Update_database(term, statement, confidence));
		 }
       
      //This allows the user to search for a generic tree using it's term	 
		 else if (input.equals("3") && lines !=null){
   		 String term;
   			do{
   				term=JOptionPane.showInputDialog(frame,"Enter the term: ");
   		  
      				if(term == null||term.equals("")||term.trim().length()==0){
      				JOptionPane.showMessageDialog(frame,"Enter proper term");}      
   			  }
              //accounts for when the user enters anything but the term
   			while (term == null||term.equals("")||term.trim().length()==0);
   
      		 JOptionPane.showMessageDialog(frame,lines.search(term.trim()));
      		 }
   		//Allows user to check if a certain generic truth exists using their term and statement. 
		 else if (input.equals("4") && lines !=null){
   		 String term;
   			do{
   				term=JOptionPane.showInputDialog(frame,"Enter the term: ");
   		  
   				if(term == null||term.equals("")||term.trim().length()==0){
   				JOptionPane.showMessageDialog(frame,"Enter proper term");}      
   			}
            //When the user enters anything but a term
   			while (term == null||term.equals("")||term.trim().length()==0);
   
   		 String statement;
   		  do{
   				statement=JOptionPane.showInputDialog(frame,"Enter the statement: ");
   		  
   				if(statement == null||term.equals("")||statement.trim().length()==0){
   				JOptionPane.showMessageDialog(frame,"Enter proper statement!!!!");}      
   			}
            //when user enters anything but a statement
   			 while (statement == null||statement.equals("")||statement.trim().length()==0);
   
   		 JOptionPane.showMessageDialog(frame,lines.search(term,statement));
   		 }
        //user has to enter one of these five option in order for the program to work  
		else if (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5"))){
   		  JOptionPane.showMessageDialog(frame,"choose one of the five options displayed to you");
   		    }
   
   		 }
    //Cancel program
	while(!input.equals("5"));
   //close screen
	frame.dispose();
	 }
//checks if confidence is a number		
public static boolean isDouble(String str) {
	 try {
		  Double.parseDouble(str);
		  return true;}
	  catch (NumberFormatException e) {
		  return false;
	 }

	  }
	 }

		 
		  
		
		