public class PetManager {
    private PetNeeds needs;
    private Dog pet;
    boolean alive = true;

    //constructors
    public PetManager(PetNeeds needs, Dog pet) {
        this.needs = needs;
        this.pet = pet;
    }

    /**
     * @return this will display Pet status and handle different
     *         scenarios based on pet's need
     */
    public void displaySummary() {
        // Display Pet's Status
        System.out.println(pet.getName() + "'s Status: " + "Hunger: " + needs.getHunger() + " Thirst: "
                + needs.getThirst() + " Boredom: " + needs.getBoredom());

        // Checks if pet's needs are all met
        if (needs.getHunger() == 0 && needs.getThirst() == 0 && needs.getBoredom() == 0) {
            System.out.println("Congratulations! Your Pet is Satisfied Thanks for playing!");
            System.exit(0);
        }else{
            isUnsatisfied();
        }
    }

    /** @return checks if pet dies or ran away */
    public boolean isUnsatisfied() {
        if (needs.getHunger() > 100 || needs.getThirst() > 100 || needs.getThirst() > 100) {
            alive = false;
            if (needs.getBoredom() > 100) {
                System.out.println("I'm super bored, I'm going to find a new owner...");
            }
            if (needs.getThirst() > 100) {
                System.out.println("Game Over " + pet.getName() + " Died of Thirst...");
            }
            if (needs.getHunger() > 100) {
                System.out.println("Game Over " + pet.getName() + " Died of hunger...");
            }
            System.exit(0); // Exits terminal
        }
        return true;
    }
}
