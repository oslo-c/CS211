/*This is an example of a haunted Java code. In this case the haunting comes from 
the misunderstanding of using comparisons (== versus equal).
When == is used for objects, it means that we compare two memory addresses. It doesn't
compare the actual values. To compare the objects semantically, one needs to use equals().

This simple misunderstanding made this lovely Halloween trick or treat code quite spooky.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Costume{
}

class Batman extends Costume{
    public String toString()
    {
        return "Batman";
    }
}

class WonderWoman extends Costume
{
        public String toString()
    {
        return "WonderWoman";
    }
}

//This is a class that makes Houses in our neighbourhood. Every house has a name by the family 
//living in it (String familyName)
class Child
{
    Costume costume;
    
   public Child(Costume c)
   {
       this.costume = c;
   }
   //When we knock on the door the family inside        
   public void knockKnock(String choice) {
    if (choice.equals("trick")) {
        System.out.println("Here's a trick...");
    } else if (choice.equals("treat")) {
        System.out.println("Thank you for your treats.");
    }
    else{
        System.out.println("Ok. Something spooky happened. :o");
    }
    } 
    
    public String speak()
    {
        return "Trick or treat!";
    }
    
    Costume getCostume()
    {
        return this.costume;
    }
}

class Codechef
{

	public static void main (String[] args) throws java.lang.Exception
	{
	    List<Child> neighbourhood = new ArrayList();
	    neighbourhood.add(new Child(new Batman()));
	    neighbourhood.add(new Child(new WonderWoman()));
	    
	    //Time to do have some children around for trick or treat
	    Child firstChild = neighbourhood.get(0);
	    System.out.println("Child with " + firstChild.getCostume() + " costume says: " + firstChild.speak());
	    //We choose to give some treats
	    firstChild.knockKnock("treat");
	    System.out.println("..... Waiting.....");
	    //Ok here comes the second child knocking
	    Child secondChild = neighbourhood.get(1);
	    System.out.println("Child with " + secondChild.getCostume() + " costume says: " + secondChild.speak());
	    //Let us try a different approach
	    String choice = new String("treat");
	    secondChild.knockKnock(choice);
	    
	    /*
	    ###, ,##, ,##,
        #  # #  # #  #
        ###  #  # #  #
        #  # #  # #  #
        ###' '##' '##'
             .--,
            /  (
           /    \
          /      \ 
         /  0  0  \
 ((()   |    ()    |   ()))
 \  ()  (  .____.  )  ()  /
  |` \_/ \  `""`  / \_/ `|
  |       `.'--'.`       |
   \        `""`        /
    \                  /
     `.              .'    ,
      |`             |  _.'|
      |              `-'  /
      \                 .'
       `.____________.-'
  */
	}
}
