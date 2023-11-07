import java.util.Scanner;

public abstract class VirtualPet {

    Scanner scanner = new Scanner(System.in);

    // Attributes
    private String name;

    // Constructor
    public VirtualPet(String name) {
        this.name = name;
    }

    // setter method for name attribute
    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

}
