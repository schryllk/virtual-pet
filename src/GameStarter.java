import java.util.Scanner;

/**
 * This class will handle the startGame method
 */
public class GameStarter {
    Scanner scanner = new Scanner(System.in);

    private Dog myDog = new Dog("Tim");
    private Shelter myShelter = new Shelter();
    private PetNeeds petNeeds = new PetNeeds();
    private PetManager petManager = new PetManager(petNeeds, myDog);

    String userInput;
    int userInputInt;
    String whichDog;
    boolean valid = true;
    boolean alive = true;

    public GameStarter() {
    }

    /**
     * initiates the game and will continue to loop until the pet is either
     * dead or user exits
     */
    public void startGame() {
        myShelter.addDog("Fin");
        myShelter.addDog("Jim");
        myShelter.addDog("Drake");
        myShelter.addDog("Ryu");

        welcomeScreen();

        do {
            System.out.println("Would you like to adopt or admit a pet?(y/n) ");
            userInput = scanner.nextLine();

            if (userInput.isBlank()) {
                System.out.println("INVALID INPUT! Try Again.");

            } else if (userInput.equalsIgnoreCase("y")) {
                admitOrAdopt();
                myShelter.admitIfShelterIsNotZero();

            } else if (userInput.equalsIgnoreCase("n")) {
                myShelter.getShelterSize();

                if (myShelter.getShelterSize() == 0) {
                    System.out.println("Thanks for visiting your local Virtual Dog Shelter, Have a blessed day!");
                    System.exit(0);

                } else if (myShelter.getShelterSize() > 0) {
                    System.out.println("Would you like to play with the dog(s) in the shelter? (y/n)");
                    userInput = scanner.nextLine();

                    if (userInput.equalsIgnoreCase("y")) {
                        takeCareOfPet();

                    } else if (userInput.equalsIgnoreCase("n")) {
                        System.out.println("Thanks for visiting your local Virtual Dog Shelter, Have a blessed day!");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Thanks for visiting your local Virtual Dog Shelter, Have a blessed day!");
                    System.exit(0);
                }

            }
        } while (userInput.isEmpty() || !userInput.equalsIgnoreCase("y") || !userInput.equalsIgnoreCase("n"));

    }

    /** Welcome display */
    private void welcomeScreen() {
        System.out.printf("\n||WELCOME TO VIRTUAL PET DOG SHELTER||\n");
        System.out.println("You currently have: " + myShelter.getShelterSize() + " pet(s) in you shelter");
    }

    /** Option to admit or adopt */
    private void admitOrAdopt() {

        System.out.println("Press 1: ADOPT    Press 2: ADMIT");
        userInput = scanner.nextLine();
        userInputInt = Integer.parseInt(userInput);

        // Adopt a dog
        if (userInputInt == 1) {
            do {
                System.out.println("Which Dog would you like to adopt? ");
                myShelter.displayDogs();
                System.out.println();
                whichDog = scanner.nextLine();

                // this checks if the key(name)is in the HashMap
                if (myShelter.getPetMap().containsKey(whichDog)) {
                    myShelter.adoptDog(whichDog);
                    System.out.println("Congratulations " + whichDog + " is out of the Shelter!");
                    System.out.println(
                            "You now have: " + myShelter.getShelterSize() + " pet(s) in you shelter");
                    break;
                } else {
                    System.out.println("That name is not on the List! Try Again...");
                }
            } while (!myShelter.getPetMap().containsKey(whichDog));

            if (myShelter.getShelterSize() == 0) {
                System.out.println("You currently have: " + myShelter.getShelterSize() + " pet(s) in you shelter");
                myShelter.admitIfShelterIsZero();

            } else {
                System.out.println("Would you like to adopt/admit again? (y/n)");
                userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("y")) {
                    admitOrAdopt();
                } else {
                    System.out.println("Would you like to play with a dog?");
                    userInput = scanner.nextLine();

                    if (userInput.equalsIgnoreCase("y")) {
                        takeCareOfPet();
                    } else {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }

                }
            }

            // Admit a dog
        } else if (userInputInt == 2) {
            System.out.println("How many dogs would you like to add? (Choose from: 1-3)");
            userInput = scanner.nextLine();
            userInputInt = Integer.parseInt(userInput);
            String name = "";

            if (userInputInt == 1) {
                System.out.println("Enter the name of the dog you'd like to admit: ");
                name = scanner.nextLine();
                myShelter.addDog(name);

            } else if (userInputInt == 2) {
                System.out.println("Enter the name of the dog you'd like to admit: ");
                name = scanner.nextLine();
                myShelter.addDog(name);
                System.out.println("Enter the name of the dog you'd like to admit: ");
                name = scanner.nextLine();
                myShelter.addDog(name);

            } else if (userInputInt == 3) {
                System.out.println("Enter the name of the dog you'd like to admit: ");
                name = scanner.nextLine();
                myShelter.addDog(name);
                System.out.println("Enter the name of the dog you'd like to admit: ");
                name = scanner.nextLine();
                myShelter.addDog(name);
                System.out.println("Enter the name of the dog you'd like to admit: ");
                name = scanner.nextLine();
                myShelter.addDog(name);

            } else {
                System.out.println("INVALID INPUT! Try again...");
            }
        } else {
            System.out.println("INVALID INPUT! Try again (:");
        }
    }

    /** option if user choose to play with pet */
    public void takeCareOfPet() {
        if (userInput.equalsIgnoreCase("y")) {
            System.out.printf("Which pet would you like to play with?\n");
            myShelter.displayDogs();
            System.out.println();
            do {
                whichDog = scanner.nextLine();
                if (!myShelter.getPetMap().containsKey(whichDog)) {
                    System.out.println("There is no dog by that name in this Shelter! Try again...");
                } else {
                    myShelter.getDog(whichDog);
                    myDog.setDogName(whichDog);
                }
            } while (!myShelter.getPetMap().containsKey(whichDog));
            do {
                System.out.println("What would you like to do?");
                System.out.println("1. Feed " + whichDog);
                System.out.println("2. Give water to " + whichDog);
                System.out.println("3. Play with " + whichDog);
                System.out.println("4. Exit ");
                userInput = scanner.nextLine();
                userInputInt = Integer.parseInt(userInput);
                if (userInputInt == 1) {
                    petNeeds.feed();
                    petNeeds.tick();
                    petManager.displaySummary();
                } else if (userInputInt == 2) {
                    petNeeds.drink();
                    petNeeds.tick();
                    petManager.displaySummary();
                } else if (userInputInt == 3) {
                    petNeeds.play();
                    petNeeds.tick();
                    petManager.displaySummary();
                } else if (userInputInt == 4) {
                    myDog.dogFace1();

                    System.out.println(
                            "Thanks for visiting your local Virtual Dog Shelter, Have a blessed day!");
                    System.exit(0);
                } else {
                    // anything else other than 1-4 will exit
                    System.out.println("Invalid input!");
                }
            } while (alive);
        }
    }
}
