
import static org.junit.Assert.*;
import org.junit.Test;

public class VirtualPetShelterTest {
    private Shelter shelter = new Shelter();

    @Test
    public void testAdoptDog() {
        // Initial number of dogs in the shelter
        int initialSize = shelter.getShelterSize();

        // Adopt a dog
        String dogName = "Dog1";
        shelter.adoptDog(dogName);

        // Verify that the dog has been removed from the shelter
        assertNull(shelter.getDog(dogName));

        // Verify that the size of the shelter has decreased by 1
        assertEquals(initialSize, shelter.getShelterSize());
    }

    @Test
    public void testGetShelterSizeWithEmptyShelter() {
        assertEquals(0, shelter.getShelterSize());
    }

    @Test
    public void testGetDogWhenDogDoesNotExist() {
        assertNull(shelter.getDog("NonExistentDog"));
    }

    

    

    

    
    
    
    
    

    
    
    

    
    

    
    
    
    

}
