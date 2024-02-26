import java.util.Scanner;

public class GenericsKbArrayApp{
  public static void main(String args[]){
     Scanner keyword = new Scanner(System.in);
     ReadFile lines=null;
     String input="";
     do{
      System.out.println("Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit");
      System.out.print("Enter your choice: "); 
      input = keyword.nextLine();
      
      if(input.equals("1")){
        System.out.print("Enter file name: ");
        String file = keyword.nextLine();
        lines = new ReadFile(file);
        lines.setSentences(file);
        System.out.println("Knowledge base loaded successfully.");
         }
         
      else if(input.equals("2")){
       System.out.print("Enter the term: ");
       String item= keyword.nextLine();
       System.out.print("Enter the statement: ");
       String statement = keyword.nextLine();
       System.out.print("Enter the confidence score: ");
       double confidence= keyword.nextDouble();
       keyword.nextLine();
       System.out.println(lines.Update_database(item, statement, confidence));
       }
       
       else if (input.equals("3")){
       System.out.print("Enter the term to search: ");
       String item = keyword.nextLine();
       System.out.println(lines.search(item));
       }
       
       else if (input.equals("4")){
       System.out.print("Enter the term to search: ");
       String item = keyword.nextLine();
       System.out.print("Enter the statement to search for: ");
       String statement = keyword.nextLine();
       System.out.println(lines.search(item,statement));
       }
       else{
       break;}
       }
      while(!input.equals("5"));
      }
     }

       
        
      
      