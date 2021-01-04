package ZigNag;

/*
   Be sure you enable assertions (ea) in Netbeans as follows:
    1) Right click on the project in the Project Explorer
    2) Select Properties
    3) Select Run
    4) Set the VM Options field to include -ea
    5) Click OK
*/

public class ZigNagTestDriver
{
   private final static char STAR = '*';
   public static void main(String[] args)
   {
      // Using ZigNag's default constructor, create an object referenced by the variable z1.
      ZigNag z1 = new ZigNag();
      assert(z1.getAge() == 1);
      assert(z1.getSymbol() == STAR);

      System.out.println("z1: " + z1); // print z1

      // Create z2 whose mood and gender are the opposite of those in z1
      ZigNag z2 = new ZigNag(!z1.isMale(), !z1.isHappy(), 'x'); // test normal constructor;
      if (z1.isMale()) // Test getGender()
      {
         assert(z2.isFemale()); // test isFemale
         if (z1.isHappy()) // Test isHappy()
         {
            assert(z2.isUnhappy()); // Test isUnhappy()
         }
         else
         {
            assert(z2.isHappy());
         }
         
      }
      else if (z1.isFemale())
      {
         assert(z2.isMale()); // test isMale
         if (z1.isHappy())
         {
            assert(z2.isUnhappy()); 
         }
         else
         {
            assert(z2.isHappy());
         }
      }

      System.out.println("z2: " + z2);
      System.out.println("It is " + z1.equals(z2) + " that z1 = z2");

      z1.setSymbol('c'); // test setSymbol()
      z2.setSymbol('s');

      
      ZigNag z3 = new ZigNag(z1); // clone z1
      System.out.println("z3: " + z3);
      System.out.println("It is " + z1.equals(z3) + " that z1 = z3");
      System.out.println("It is " + z1.haveSameAge(z3) + " that z1 and z3 have the same age");
      
      z3.reverseMood(); // test reverseMood()
      System.out.println("z3: " + z3);

      
      ZigNag z4 = null;
     
      try
      {
          z4 = z1.produceZigNag(z2); // let, z1 and z2 reproduce
      }
      catch(IllegalArgumentException e)
      {
         System.out.println(e.getMessage());
      } 
      
      
      z1.growUp();
      System.out.println("z1: " + z1);
      z2.growUp(3);
      System.out.println("z2: " + z2);
 
      
      try
      {
          z4 = z1.produceZigNag(z2); // let, z1 and z2 reproduce
      }
      catch(IllegalArgumentException e)
      {
         System.out.println(e.getMessage());
      }
      
      
      System.out.println("z4: " + z4);
      
      z1.growUp(4);
      System.out.println("z1: " + z1);
 
      
      try
      {
          z4 = z1.produceZigNag(z2); // let, z1 and z2 reproduce
          System.out.println("z1 and z2 produced offspring");
      }
      catch(IllegalArgumentException e)
      {
         System.out.println(e.getMessage()); 
      }
      
       
      z4.reverseMood(); // test reverseMood()
      System.out.println("z4: " + z4);
      System.out.println("It is " + z2.equals(z4) + " that z2 = z4");
      System.out.println("It is " + z2.isYounger(z4) + " that z2 is younger than z4");
      System.out.println("It is " + z2.isOlder(z4) + " that z2 is older than z4");
      System.out.println("It is " + z2.haveSameAge(z4) + " that z2 and z4 have the same age");

      // let z1, z2, z2, and z4 grow up one year at a time for 5 years.
      // draw and print each z for each year.
      for (int year = 1; year <= 5; ++year)
      {
         z1.growUp(1);
         System.out.println("z1: " + z1);
         z1.draw();

         z3.growUp(1);
         System.out.println("z3: " + z3);
         z3.draw();

         z2.growUp(1);
         System.out.println("z2: " + z2);
         z2.draw();

         z4.growUp(1);
         System.out.println("z4: " + z4);
         z4.draw();
      }

      System.out.println("Done");
      return;
           
   }
              
}
