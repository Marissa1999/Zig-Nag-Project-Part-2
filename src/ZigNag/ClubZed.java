package ZigNag;
import java.util.Arrays;
import java.util.Random;


/**
 * @author Marissa Gonçalves
 * Date: February 10, 2018
 * Purpose: To categorize ZigNag objects based on their age, gender, mood and symbol by using the encapsulation of ClubZed.
 */

public class ClubZed 
{
    /**
     * Allows the ZigNag objects to produce randomly, with initial value.
     */
    private static final int SEED = 47;
    
    /**
     * Allows the ZigNag objects to produce randomly.
     */
    private static final Random rand = new Random(SEED);
    
    /**
     * Allows an array of references to the ZigNag members of this ClubZed.
     */
    private ZigNag[] members;

    /**
     * Determines the current size of the ClubZed membership, as well as the index for this members.
     */
    private int currentSize;

    /**
     * Initializes the ZigNag members to 1 and sets this currentSize to 0.
     */
    public ClubZed()
  {
      this.members = new ZigNag[1];
      this.currentSize = 0;
  }
  
    /**
     * Returns whether the container is empty, which contains the value of 0.
     * @return The currentSize of the container.
     */
    public boolean isEmpty()
    {
        return this.currentSize == 0;
    }
    
    /**
     * Returns whether the container is full and if the number of ZigNag members is equal to the currentSize.
     * @return The currentSize of the container and the number of ZigNag members.
     */
    public boolean isFull()
    {
        return this.currentSize == this.members.length;
    }
    
    /**
     * Returns the number of ZigNag members.
     * @return The number of ZigNag members.
     */
    public int capacity()
    {
        return this.members.length;
    }
    
    /**
     * Returns the currentSize of the container.
     * @return The currentSize of the container.
     */
    public int size()
    {
        return this.currentSize;
    }
    
    /**
     * Returns the string representation of all the ClubZed members.
     * @return The string representation of all members from ZigNag.
     */
    @Override
    public String toString()
    {
        
        String result = "";
        
        for (int k = 0; k < this.currentSize; k++)
        {
            result += this.members[k] + "\n";
        }
        
        return result;
        
    }

    /**
     * Returns true if the other and this currentSizes and members to be equal to one another.
     * If it's not the case, then the method returns false.
     * @param other The other ClubZed object.
     * @return The boolean value whether this and other objects equal.
     */
    public boolean equals(ClubZed other)
    {  
        
        if (this.currentSize != other.currentSize)
        {
            return false;
        }
        
        for (int k = 0; k < this.currentSize; k++)
        {  
            if (Arrays.equals(this.members, other.members))
            {
                return false;
            }   
        }
        
        return true;
    }
    
    /**
     * Counts the total number of ZigNag members that are happy.
     * @return The numerical value of happy ZigNag members.
     */
    public int countHappyMembers()
    {
     
       int happyMembers = 0;
      
        
       for (int k = 0; k < this.currentSize; k++) 
       {  
           if (this.members[k].isHappy())
           {
              ++happyMembers;  
           }
       }
       
       return happyMembers; 
        
    }
    
    /**
     * Counts the total number of ZigNag members that are unhappy.
     * @return The numerical value of unhappy ZigNag members.
     */
    public int countUnhappyMembers()
    { 
       int unhappyMembers = 0;
      
        
       for (int k = 0; k < this.currentSize; k++) 
       {  
           if (this.members[k].isUnhappy())
           {
              ++unhappyMembers;  
           }
       }
       
       return unhappyMembers; 
        
    }
    
    /**
     * Counts the total number of ZigNag members that are male.
     * @return The numerical value of male ZigNag members.
     */
    public int countMaleMembers()
    {
        
       int maleMembers = 0;
      
        
       for (int k = 0; k < this.currentSize; k++) 
       {  
           if (this.members[k].isMale())
           {
              ++maleMembers;  
           }
       }
       
       return maleMembers; 
        
    }
    
    /**
     * Counts the total number of ZigNag members that are female.
     * @return The numerical value of female ZigNag members.
     */
    public int countFemaleMembers()
    {
        
       int femaleMembers = 0;
      
        
       for (int k = 0; k < this.currentSize; k++) 
       {  
           if (this.members[k].isFemale())
           {
              ++femaleMembers;  
           }
       }
       
       return femaleMembers; 
        
    }
    
    /**
     * Draws the ZigNag object if the index is considered to be valid.
     * If not, an error message is being stated.
     * @param index The implementation of the members array. 
     */
    public void draw(int index)
    {
        if (index >= 0 && index < this.currentSize)
        { 
           this.members[index].draw();
           System.out.println();
        }
        
        else
        {
            throw new IndexOutOfBoundsException ("Error: invalid index.");
        }
        
    }
    
    /**
     * Doubles the capacity of the members array.
     */
    public void resize()
    {
      
        ZigNag[] temp = new ZigNag [2 * this.members.length];
        
       System.arraycopy(this.members, 0, temp, 0, this.currentSize);
        
        this.members = temp;
    }
    
    /**
     * Creates and adds one ZigNag member, with certain characteristic verfications.
     */
    public void populate()
    {
        
        ZigNag child = new ZigNag();
        
        
        if (isFull())
        {
            resize();
        }
           
      
            //child.setMood(rand.nextBoolean());
            //child.setGender(rand.nextBoolean());
            child.setAge(rand.nextInt(8) + 3);
            
            
            String symbols = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm!@$%.&*+-/=";
            char selectedSymbol = symbols.charAt(rand.nextInt(symbols.length()));
            child.setSymbol(selectedSymbol);
          

            
          this.members[this.currentSize] = child;
          ++this.currentSize;
     
        
    }
    
    /**
     * Delegates to the populate() method, repeating a certain amount of times, due to a specific call statement.
     * @param n The called amount of times that the method populate() will re-populate itself.
     */
    public void populate(int n)
    {
        for (int k = 0; k < n; k++)
        {
           populate();
        }
    }
    
    /**
     * Accepts a ZigNag object and determines the validation of the age and symbol.
     * @param child The newly constructed ZigNag object.
     */
    public void join (ZigNag child)
    {
        
        
        if (child.getAge() < 3 || child.getAge() > 10)
        {
            throw new IllegalArgumentException ("Error: invalid age.");
        }
        
        
        
        String symbols = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm!@$%.&*+-/=";
        if (symbols.indexOf (child.getSymbol()) == -1)
        {
            throw new IllegalArgumentException ("Error: invalid symbol.");
        }
        
 
        
        if (isFull())
        {
            resize();
        }
          
          
          
        this.members[this.currentSize] = child;
        ++this.currentSize;
        
        
    }   
        
    /**
     * Returns an array of integers with a length of 11 and counts the frequency for each age of the selected members.
     * @return The age frequency for each of the selected ZigNag members.
     */
    public int[] computeAgeFrequency()
     {
     
             int[] ageFreq = new int[11];
             
             
              for (int k = 0; k < this.currentSize; k++)
              {
                 int age = this.members[k].getAge();
                 {
                    ++ageFreq[age];
                 }   
              }
             
             return ageFreq;

     }
}