/**************************
* CerealRunner.java Starter Code
* Note: You will need to complete all questions 
* before you can run this class. If you wish to test one part at a time,
* please comment out the unfinished methods and the related tests 
************/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CerealRunner
{
/* Question 1: Write filterCarbsPerCup
   * This static method will return an ArrayList of cereal 
   * objects with carbs per cup between min and max inclusive
   * @param: min - the minimum integer value of the range
   * @param: max - the maximum integer value of the range
   * Precondition: min < max
   */
   public static  ArrayList<Cereal> filterCarbsPerCup(int min, int max)
   {
      ArrayList<Cereal> result = new ArrayList<Cereal>();

      for (Cereal c : cereals)
      {
         double servingsPerCup = 1 / c.getCups();
         double carbsPerCup = c.getCarbs() * servingsPerCup;

         if (carbsPerCup >= min && carbsPerCup <= max)
         {
            result.add(c);
         }
      }

      return result;
   }
   
   /* Question 2: Write highestPercentFiber
   * This static method will return the cereal with the highest 
   * percentage of Fiber per calorie
   * Precondition: cereals.size() > 0
   */
    
   public static Cereal highestPercentFiber()
   {
      Cereal best = cereals.get(0);

      for (Cereal c : cereals)
      {
         double current = c.getFiber() / c.getCalories();
         double bestVal = best.getFiber() / best.getCalories();

         if (current > bestVal)
         {
            best = c;
         }
      }

      return best;
   }
  
   
   /* Questino 3: Write findNetCarbs
   *  This static method will take in a cereal object and returns 
   *  difference of carbs and fiber for that cereal
   *  @param: c - Cereal object
   */
    
   public static double findNetCarbsPerCup(Cereal c)
   {
      double servingsPerCup = 1 / c.getCups();

      double carbsPerCup = c.getCarbs() * servingsPerCup;
      double fiberPerCup = c.getFiber() * servingsPerCup;

      return carbsPerCup - fiberPerCup;
   }
  

   /*****************************************************************
    * The code below does not need to be edited.
    ****************************************************************/
   
   //ArrayList of Cereal objects from cerealSubset.csv
   private static ArrayList<Cereal> cereals = new ArrayList<Cereal>(); 
  
   public CerealRunner(String fileName)
   {
      try 
      {
         FileReader fileRdr = new FileReader(fileName);
         Scanner scan = new Scanner(fileRdr);
         while(scan.hasNext())
         {
            String myStr = scan.nextLine();
            String[] myArray = myStr.split(",");  
            String name = myArray[0];
            int calories = Integer.parseInt(myArray[1]);
            double fiber = Double.parseDouble(myArray[2]); 
            double carbs = Double.parseDouble(myArray[3]); 
            double cups = Double.parseDouble(myArray[4]); 
            cereals.add(new Cereal(name, calories, fiber, carbs, cups));   
         } //close while
         scan.close();
       } catch (FileNotFoundException e) 
         {
            System.out.println("An error occurred.");
            e.printStackTrace();
         }
      int numCereals = cereals.size();
      System.out.println( numCereals + " records created.");   
   }

   public static void main(String [] args)
   {
      for(Cereal c: cereals) { 
         if(c.getName().equals("All-Bran with Extra Fiber") ||   
            c.getName().equals("Apple Jacks") ||  
            c.getName().equals("Cocoa Puffs")) 
         { 
            System.out.println("\nCereal: " + c.getName() + ", NetCarbs: "    
                                 + findNetCarbs(c)); 
         } 
      }
      
   }
}

