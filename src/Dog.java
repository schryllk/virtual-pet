import java.util.Scanner;

public class Dog extends VirtualPet { // this should extend to the class VirtualPet
    Scanner scanner = new Scanner(System.in);

    public Dog(String name) {
        super(name); // refers to the parent class VirtualPet
    }

    /** @return this will set the pet's name */
    public void setDogName(String name) {
        super.setName(name);
    }

    /** @return virtual representation of your pet */
    public void dogFace1() {
        String dogFace = "  /^ ^\\\n" +
                " / 0 0 \\\n" +
                " V\\ Y /V\n" +
                "  / - \\\n" +
                " /    |\n" +
                "V__) ||\n";

        System.out.print(dogFace);

    }

}
