public class PetNeeds {

    // Attributes
    private int hunger;
    private int thirst;
    private int boredom;

    // Constructors
    public PetNeeds() {
        this.hunger = 50;
        this.thirst = 100;
        this.boredom = 50;
    }

    // Getters
    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    // Methods
    /** @return decreases hunger level to 10 */
    public void feed() {
        this.hunger = Math.max(0, this.hunger - 10); // Math.max()method ensures that the value will not go below zero
    }

    /** @return decreases thirst level to 10 */
    public void drink() {
        this.thirst = Math.max(0, this.thirst - 10);
    }

    /** @return decreases boredom level to 10 */
    public void play() {
        this.boredom = Math.max(0, this.boredom - 10);
    }

    /** @return tick() increases hunger, thirst, boredom, levels to 2 */
    public void tick() {
        hunger += 2;
        thirst += 2;
        boredom += 2;
    }

}
