package ZigNag;

/**
 * @author Marissa Gonçalves
 * Date: February 10, 2018
 * Purpose: To run the ClubZed program, which categorizes ZigNag objects based on their age, gender, mood and symbol by using the encapsulation of ClubZed.
 */

public class ClubZedTestDriver 
{
    
    
    public static void main (String[] args)
    {
        
        ClubZed clubZ = new ClubZed();
        clubZ.populate();
        clubZ.populate();
        clubZ.populate();
        clubZ.populate();
        clubZ.populate();
        clubZ.populate(5);   
     
    
        try
        {
            clubZ.join (new ZigNag(true, false, 'o')); //invalid age, valid symbol
        }
        
        catch (IllegalArgumentException e)
        {
           System.out.println(e.getMessage());     
        }
        
        ZigNag newMember = new ZigNag(true, false, '?');
        newMember.setAge(5);
        
        try
        {
            clubZ.join(newMember); //invalid symbol, valid age
        }
        
        catch (IllegalArgumentException e)
        {
            System.out.println (e.getMessage());
        }
        
        newMember.setSymbol ('=');
        clubZ.join(newMember); //valid symbol, valid age
        

        System.out.println(clubZ);
        System.out.println("Club total capacity: " + clubZ.capacity());
        System.out.println("Club membership size: " + clubZ.size());
        System.out.println("Happy members: " + clubZ.countHappyMembers());
        System.out.println("Unhappy members: " + clubZ.countUnhappyMembers());
        System.out.println("Male members: " + clubZ.countMaleMembers());
        System.out.println("Female memebrs: " + clubZ.countFemaleMembers());
        System.out.println();
        
        //check frequencies
        int[] ageFreq = clubZ.computeAgeFrequency();
        System.out.println("Club Members Age Frequency");
        System.out.println("   Age    Frequency");
        System.out.println("   ===    =========");
        
        for(int k = 0; k < ageFreq.length; ++k)
        {
             System.out.printf ("%6d%13d\n", k, ageFreq[k]);
        }
       
        clubZ.draw(0);
        clubZ.draw(clubZ.size()/2);
    }
        
   
    
}
