/**
 * Cereal.java  
 *
 * @author – Boone
 * @author – 10:00
 * 
 */
public class Cereal
{
   private String name; 
   private int calories; 
   private double fiber, carbs, cups; 

   public Cereal(String initName, int initCal, double initFiber, 
                 double initCarbs,  double initCups)
   {
      name = initName; 
      calories = initCal; 
      fiber = initFiber; 
      carbs = initCarbs;
      cups = initCups; 
   }
   /* Accessor method returns the value stored in the instance variable name. */
   public String getName()
   {
      return name;
   }

   /* Accessor method returns the value stored in the instance variable carbs. */      
   public double getCarbs()
   {
      return carbs;
   }

   /* Accessor method returns the value stored in the instance variable cups. */       
   public double getCups()
   { 
      return cups;
   }

   /* Accessor method returns the value stored in the instance variable fiber. */
   public double getFiber() 
   { 
      return fiber;
   }

   /* Accessor method returns the value stored in the instance variable calories.  
    */
   public int getCalories()
   {
      return calories;
   }


   /* toString method returns the values stored in the instance variables   
      concatenated in a sentence. */
   public String toString()
   {
      return "Cereal: " + name + " has: " + calories 
              + "calories, in a " + cups + " cup serving, with "
              + fiber + "grams of fiber and "
              + carbs +"grams of carbohydrates";
   }
}
