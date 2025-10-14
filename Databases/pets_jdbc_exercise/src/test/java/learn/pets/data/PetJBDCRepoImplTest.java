package learn.pets.data;

import learn.pets.models.Pet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PetJBDCRepoImplTest {
    PetJBDCRepoImpl repository = new PetJBDCRepoImpl();

    @Test
    void testFindAll() {
        List<Pet> pets = repository.findAll();
        assertNotNull(pets);
        System.out.println("Find all pets: " + pets);
        assertTrue(!pets.isEmpty());
    }

    @Test
    void testFindByName() {
        Pet pet = repository.findAll().getFirst();
        String petName = pet.getName();
        Pet actual = repository.findByName(petName);
        System.out.println("Find pet by name: " + actual);
        assertEquals(petName, actual.getName());
    }

    @Test
    void testFindByName_NullName() {
        Pet actual = repository.findByName(null);
        System.out.println("Find pet by null name: " + actual);
        assertNull(actual, "Should return null when searching with null name");
    }

    @Test
    void testFindByID() {
        int id = repository.findAll().getFirst().getPetId();
        Pet pet = repository.findById(id);
        System.out.println("Find Pet by ID: " + pet);
        assertNotNull(pet);
        assertEquals("Buddy", pet.getName());
        assertEquals("Dog", pet.getType());
    }

    @Test
    void testFindByID_InvalidID() {
        int invalidId = 0;
        Pet pet = repository.findById(invalidId);
        System.out.println("Find Pet by invalid ID: " + pet);
        assertNull(pet, "Should return null for invalid ID");
    }

    @Test
    void shouldAddPet() {
        Pet pet = new Pet();
        pet.setName("Charlie");
        pet.setType("Parrot");
        Pet actual = repository.add(pet);
        int ped_id = pet.getPetId();
        System.out.println("Added pet: " + actual);
        assertNotNull(actual);
        assertTrue(actual.getPetId() > 0);
        repository.delete(ped_id); // delete test generated data
    }

    @Test
    void shouldNotAddPet_WhenPetIsNull() {
        assertThrows(Exception.class, () -> {
            repository.add(null);
        }, "Should throw exception when adding null pet");
    }

    @Test
    void shouldUpdatePet() {
        Pet pet = repository.findAll().getFirst();
        String originalName = pet.getName(); // to reset after test
        pet.setName("Updated Name");
        assertTrue(repository.update(pet));
        System.out.println("Updated pet: " + pet);
        assertEquals("Updated Name", repository.findAll().getFirst().getName());
        pet.setName(originalName); // reset memory
        repository.update(pet); // reset db
    }

    @Test
    void shouldNotUpdatePet_WhenPetIsNull() {
        assertThrows(Exception.class, () -> {
            repository.update(null);
        }, "Should throw exception when updating null pet");
    }

    @Test
    void shouldDeletePet() {
        Pet pet = new Pet();
        pet.setName("Temp Pet");
        pet.setType("Lizard");
        repository.add(pet);
        System.out.println("Pet to Delete: " + pet);
        assertTrue(repository.delete(pet.getPetId()));
    }

    @Test
    void shouldNotDeletePet_WithInvalidID() {
        int invalidId = 0;
        boolean result = repository.delete(invalidId);
        System.out.println("Delete pet with invalid ID result: " + result);
        assertFalse(result, "Should return false when deleting with invalid ID");
    }
}