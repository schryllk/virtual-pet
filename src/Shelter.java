import java.util.HashMap;
import java.util.Scanner;

public class Shelter {
   public HashMap<String, Dog> petMap;
   Scanner scanner = new Scanner(System.in);
  

   // Constructor
   public Shelter() {
      this.petMap = new HashMap<>();
   }

   String whichDog;
   String userInput;
   int userInputInt;

   // getter
   public int getShelterSize() {
      return petMap.size();
   }

   public HashMap<String, Dog> getPetMap() {
      return petMap;
   }

   /** @return method to get the dog by its name */
   public Dog getDog(String name) {
      return petMap.get(name);
   }

   /** @return this method allows me to admit a dog into the shelter */
   public void addDog(String name) {
      Dog newDog = new Dog(name);
      petMap.put(name, newDog);
   }

   /** @return method to remove dogs in the shelter / HashMap */
   public void adoptDog(String name) {
      petMap.remove(name);
   }

   /** @return method that displays all of the dog in the shelter/Hashmap */
   public void displayDogs() {
      for (String name : petMap.keySet()) {
         System.out.print("[" + name + "]");
      }
   }

   /**
    * @return this method will handle the prompt if there are no pets in the
    *         shelter
    */
   public void admitIfShelterIsZero() {
      String name = "";

      System.out.println("Would you like to admit a dog? (y/n)? ");
      userInput = scanner.nextLine();
      if (userInput.equalsIgnoreCase("y")) {
         System.out.println("Enter the name of the dog you'd like to admit: ");
         name = scanner.nextLine();
         addDog(name);
         do {
            System.out.println("Would you like to admit another one? (y/n)");
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("y")) {
               System.out.println("Enter the name of the dog you'd like to admit: ");
               name = scanner.nextLine();
               addDog(name);
            } else if (userInput.equalsIgnoreCase("n")) {
               System.out.println("Awesome!");
               System.out.println("There are now " + getShelterSize() + " dog(s) in the Shelter, Thank You!");
               break;
            } else {
               System.out.println("INVALID INPUT! Try Again (: ");
            }
         } while (!userInput.equalsIgnoreCase("y") || !userInput.equalsIgnoreCase("n"));
      } else if (userInput.equalsIgnoreCase(("n"))) {
         System.out.println("Thanks for visiting your local Virtual Dog Shelter, Have a blessed day! ");
         System.exit(0);
      } else {
         System.out.println("INVALID INPUT! Try again (: ");
      }
   }

   /**
    * @return this method will handle the prompt if user would like to admit more
    *         pet(s)
    */
   public void admitIfShelterIsNotZero() {
      String name = "";
      do {
         System.out.println("Would you like to admit another one? (y/n)");
         userInput = scanner.nextLine();
         if (userInput.equalsIgnoreCase("y")) {
            System.out.println("Enter the name of the dog you'd like to admit: ");
            name = scanner.nextLine();
            addDog(name);
         } else if (userInput.equalsIgnoreCase("n")) {
            System.out.println("Great! There are now " + getShelterSize() + " pet(s) in the Shelter, Thank You!");
            System.exit(0);
         } else {
            System.out.println("INVALID INPUT! Try Again (: ");
         
         }
      } while (!userInput.equalsIgnoreCase("y") || !userInput.equalsIgnoreCase("n"));
   }
}
