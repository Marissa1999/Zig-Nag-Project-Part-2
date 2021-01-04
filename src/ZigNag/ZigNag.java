package ZigNag;
import java.util.Random;

/**
 * @author Marissa Gonçalves
 * Date: January 22, 2018
 * Purpose: To categorize ZigNag objects based on their age, gender, mood and symbol.
 */

public class ZigNag
       
{  
   /**
   * Allows the ZigNags to produce randomly.
   */
   private static final int SEED = 47;
   private static Random rand = new Random(SEED);
   
   /**
    * Allows the age to be an integer, from 1 and beyond.
    */
   private int age;
   
   /**
    * Allows the gender to be a boolean result, either male or female.
    */
   private boolean gender;
   
   /**
    * Allows the mood to be a boolean result, either happy or unhappy.
    */
   private boolean mood;
   
   /**
    * Allows the symbol to be character, based on what character is called.
    */
   private char symbol;
   
   /**
    * Allows the ZigNag to be happy, when true.
    */
   private static final boolean HAPPY = true;
   
   /**
    * Allows the ZigNag to be unhappy, when false.
    */
   private static final boolean UNHAPPY = false;
   
   /**
    * Allows the ZigNag to be male, when true.
    */
   private static final boolean MALE = true;
   
   /**
    * Allows the ZigNag to be female, when false.
    */
   private static final boolean FEMALE = false;
   
    /**
     * This default constructor initializes this object's age to 1, sets the symbol to '*', and takes the gender and mood randomly.
     */
    public ZigNag()
   {
       this.age = 1;
       this.symbol = '*';
       this.gender = rand.nextBoolean();
       this.mood = rand.nextBoolean();
   }
    
    /**
     * This normal constructor takes the initial parameters for gender, mood and symbol and initializes this object's age to 1.
     * @param gender The gender of this ZigNag.
     * @param mood   The mood of this ZigNag.
     * @param symbol The symbol of this ZigNag.
     */
    public ZigNag (boolean gender, boolean mood, char symbol)
    {
        this.age = 1;
        this.gender = gender;
        this.mood = mood;
        this.symbol = symbol;
    }
    
    /**
     * This copy constructor creates an other object, copying this instance fields as well.
     * @param other The other ZigNag object.
     */
    public ZigNag (ZigNag other)
    {
        this(other.gender, other.mood, other.symbol);
    }
    
    /**
     * This accessor method returns this object's age.
     * @return The age of this object.
     */
    public int getAge()
    {
       return this.age;
    }
    
    /**
     * This accessor method returns this object's symbol.
     * @return The symbol of this object.
     */
    public char getSymbol()
    {
       return this.symbol;
    }
    
    /**
     * This mutator method sets this object's age.
     * @param age The age of this object.
     */
    public void setAge (int age)
    {
        this.age = age;
    }
    
    /**
     * This mutator method sets this object's symbol.
     * @param symbol The symbol of this object.
     */
    public void setSymbol (char symbol)
    {
        this.symbol = symbol;
    }
    
    /**
     * This mutator method sets this object's gender.
     * @param gender The gender of this object.
     */
    public void setGender (boolean gender)
    {
        this.gender = gender; 
    }
    
    /**
     * This mutator method sets this object's mood.
     * @param mood The mood of this object.
     */
    public  void setMood (boolean mood) 
    {
        this.mood = mood; 
    }       
            
    /**
     * This method returns true, while this object is male.
     * @return The gender of this object, being male.
     */
    public boolean isMale()
     {
         return this.gender = MALE;
     }
            
    /**
     * This method returns true, while this object is female.
     * @return The gender of this object, being female.
     */
    public boolean isFemale()
     {
         return this.gender == FEMALE;
     }
     
    /**
     * This method returns true, while this object is happy.
     * @return The mood of the object, being happy.
     */
    public  boolean isHappy()
     {
         return this.mood = HAPPY;
     }
         
    /**
     * This method returns true, while this object is unhappy.
     * @return The mood of the object, being unhappy.
     */
    public boolean isUnhappy()
     {
        return this.mood = UNHAPPY;
     }
         
    /**
     * This method reverses this object's mood from happy to unhappy, etc.
     */
    public void reverseMood()
     {
         this.mood = this.mood == false;
     }
         
    /**
     * This method returns true when this object has an older age than the other object.
     * @param other The other ZigNag object.
     * @return The comparison between this and other objects, where this object must be older than other object.
     */
    public boolean isOlder(ZigNag other)
     {
       boolean result = true;
       
       if (this.age > other.age)
       {
           return result;
       }
     
       else
       {
           return false;
       }
  
     }
     
    /**
     * This method returns true when this object has a younger age than the other object, by using delegation from the isOlder(ZigNag other) method.
     * @param other The other ZigNag object.
     * @return The result between this and other objects, where this object must be younger than other object.
     */
    public boolean isYounger(ZigNag other)
     {
         return isOlder(other) == false;
     }
            
    /**
     * This method returns true, if this object's age is in the range between 4 and 6, inclusive.
     * @return The result between this object, where it can produce or not.
     */
    public boolean canProduce()
     {
         boolean result = true; 
         int high = 6;
         int low = 4;
         
         if (this.age >= low && this.age <= high)
         {
            return result;
         }
         
         else 
         {
            throw new IllegalArgumentException ("Error: ZigNag is too young to produce offspring.");
         }
         
     }
     
    /**
     * This method returns true if this ZigNag and the other ZigNag objects have the same age.
     * @param other The other ZigNag object.
     * @return The result between this and other objects, where this object and the other object must have the same age.
     */
    public boolean haveSameAge(ZigNag other)
     {
         return this.age == other.age;
     }
       
    /**
     * This method returns true if this ZigNag and the other ZigNag objects have the same gender.
     * @param other The other ZigNag object.
     * @return The result between this and other objects, where this object and the other object must have the same gender.
     */
    public boolean haveSameGender(ZigNag other)
     {
         return this.gender == other.gender;
     }
             
    /**
     * This method returns a new ZigNag object, based on this and other ZigNag parents. 
     * Reproduction can take place, according to their specific moods and recommended ages.
     * @param other The other ZigNag object.
     * @return A newly constructed ZigNag, based on the ZigNag parents attributes.
     */
    public ZigNag produceZigNag(ZigNag other)
     {
         
         ZigNag child = null;
        
        if (this.canProduce() && other.canProduce())
        {
            if (this.mood == other.mood)
            {
                boolean g = rand.nextBoolean();
                child = new ZigNag(g, this.mood, this.symbol);
                return child;
            }
            
           
            else
            {
                boolean g = rand.nextBoolean();
                boolean m = rand.nextBoolean();
                child = new ZigNag (g, m, this.symbol);
                return child;
            }
        }
        
        else
        {
           System.out.println ("Error: ZigNag is too young to produce offspring.");
        }
        
        return child;
        
     }
         
    /**
     * This method allows this object's age to be incremented an unknown amount of times.
     * If the number is non-positive, an error message must be thrown.
     * @param n The unknown amount of times to increase this object's age.
     * @return The calculated age, based on the incrementation for an unknown number of times.
     */
    public int growUp(int n)
     {
         if (n > 0)
         {
             this.age += n;
         }
         
         else
         {
             throw new IllegalArgumentException ("Invalid age:" + n);
         }
         
       return this.age;
     }

    /**
     * This method allows this object's age to be incremented one at a time, using delegation from the growUp(int n) method.
     * @return The calculated age, based on the incrementation one at a time.
     */
    public int growUp()
     {
         return growUp(1); 
     }
             
    /**
     * This method allows this object's age, gender and mood to be identified as a message.
     * @return The message, describing the specific attributes for each of the ZigNag objects.
     */
    @Override
     public String toString()
     {
         
         String result = "";
         
         
             if (isHappy())
             {
                if (isMale())   
                {
                   result += "This is a " + this.age + "-year old happy male ZigNag.";
                }
              
                else
                {
                   result += "This is a " + this.age + "-year old happy female ZigNag.";
                }
             }
             
             else
             {  
                 if (isMale())
                 {
                     result += "This is a " + this.age + "-year old unhappy male ZigNag.";
                 }
                 
                 else
                 {
                     result += "This is a " + this.age + "-year old unhappy female ZigNag.";
                 }
            
             }
                
         return result;   
     }          
  
    /**
     * This method returns true if this ZigNag is equal to the other ZigNag, based on gender, age, mood and symbol parameters.
     * @param other The other ZigNag object.
     * @return The boolean result, to determine whether all the attributes from this and other ZigNags are equal to one another.
     */
    public boolean equals(ZigNag other)
     {
       return this.age == other.age && this.gender == other.gender && this.mood == other.mood && this.symbol == other.symbol;
     }
     
    /**
     * This method draws a pattern, based on the age, gender, mood, symbol being called from the ZigNagDriver class.
     */
    public void draw()
     {
        switch (this.age)
        {
            case 1: System.out.println (this.symbol); break; 
            case 2: for (int r = 1; r <= this.age; r++)
                     {
                        System.out.print(this.symbol);
                     }
             
                    System.out.println();
                    
                    for (int r = 1; r <= this.age; r++)
                    {
                        System.out.print(this.symbol);
                    }  
                    
                    System.out.println();
                    
                    break;
        
        default:
        
        if (isHappy() && isMale())
        {
            drawN(); 
        }
        
        
        
        else if (isHappy() && isFemale())
        {
            drawZ();
        }
        
        
        
        else if (isUnhappy() && isMale())
        {
            drawInvertedN();
        }
        
        
        else
        {
           drawInvertedZ(); 
        }
        
        break;

        }
     }

     /**
      * This private method is being called from draw(), when the mood and gender are both true.
      */
     private void drawN()
     {
       
        //first row
        System.out.print (this.symbol + " ");
      
        for (int ls = 1; ls <= this.age - 2; ls++)
        { 
           System.out.print("  ");
        }
      
        System.out.println(this.symbol + " ");
         
         
         
         
        
         //middle rows
         for (int r = this.age - 2; r >= 1; r--)
            {
                
                System.out.print (this.symbol + " ");
                
                
               for (int ls = 1; ls <= (this.age - 3) - (r - 1); ls++)
                {
                    System.out.print("  ");
                }
      
            
                System.out.print(this.symbol + " ");
                
                
               for (int ls = 1; ls <= r - 1; ls++)
                {
                     System.out.print("  ");
                }
               
               
                System.out.println(this.symbol + " ");
               
            } 
         
         
         
        //last row
        System.out.print (this.symbol + " ");
              
        for (int ls = 1; ls <= this.age - 2; ls++)
        { 
           System.out.print("  ");
        }
      
        System.out.println(this.symbol + " ");
         
     }
     
     
     /**
      * This private method is being called from draw(), when the mood is false and the gender is true.
      */
     private void drawInvertedN()
     {
      
      //first row
      System.out.print (this.symbol + " ");
      
      for (int ls = 1; ls <= this.age - 2; ls++)
      { 
          System.out.print("  ");
      }
      
      System.out.println(this.symbol + " ");
         
      
      
            //middle rows
            for (int r = this.age - 2; r >= 1; r--)
            {
         
                System.out.print (this.symbol + " ");
                
                for (int ls = 1; ls <= r - 1; ls++)
                {
                     System.out.print("  ");
                }
            
            
                System.out.print(this.symbol + " ");
                
               
                for (int ls = 1; ls <= (this.age - 3) - (r - 1); ls++)
                {
                    System.out.print("  ");
                }
                
                System.out.println(this.symbol + " ");
            }
      
         
            
            
         
      //last row     
      System.out.print (this.symbol + " ");
      
      for (int ls = 1; ls <= this.age - 2; ls++)
      { 
          System.out.print("  ");
      }
      
      System.out.println (this.symbol + " "); 
      
     }
     
     /**
      * This private method is being called from draw(), when the mood is true and the gender is false.
      */
     private void drawZ()
     {
        
        //first row
        for (int r = 1; r <= this.age; r++)
        {
             System.out.print(this.symbol + " ");
        }
        
       
        System.out.println();
        
        
    
        
            //middle rows
            for (int r = 1; r <= this.age - 2; r++)
            {
         
                
                for (int ls = 1; ls <= (this.age - 1) - r ; ls++)
                {
                     System.out.print("  ");
                }
            
            
                System.out.println(this.symbol + " ");

            }
            
            
            
            
          //last row
          for (int r = 1; r <= this.age; r++)
          {
                System.out.print(this.symbol + " ");
          }
        
        
         System.out.println();
         
     }

     /**
      * This private method is being called from draw(), when the mood and gender are both false.
      */
     private void drawInvertedZ()
     {

        //first row
        for (int r = 1; r <= this.age; r++)
        {
             System.out.print(this.symbol + " ");
        }
        
       
        System.out.println();
        
        
        
        
            //middle rows
            for (int r = this.age - 2; r >= 1; r--)
            {
         
                
                for (int ls = 1; ls <= (this.age - 1) - r; ls++)
                {
                     System.out.print("  ");
                }
            
            
                System.out.println(this.symbol + " ");

            }
            
         
            
            
          //last row 
          for (int r = 1; r <= this.age; r++)
          {
                System.out.print(this.symbol + " ");
          }
        
        
         System.out.println();   
         
     }
      
}