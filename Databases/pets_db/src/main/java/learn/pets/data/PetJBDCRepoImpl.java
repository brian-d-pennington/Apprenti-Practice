package learn.pets.data;

import learn.pets.models.Pet;

import java.util.List;

public class PetJBDCRepoImpl implements PetRepository{
    @Override
    public List<Pet> findAll() {
        return null;
    }

    @Override
    public Pet findByName(String petName) {
        return null;
    }

    @Override
    public Pet findById(int pet_id) {
        return null;
    }

    @Override
    public Pet add(Pet pet) {
        return null;
    }

    @Override
    public boolean update(Pet pet) {
        return false;
    }

    @Override
    public boolean delete(int pet_id) {
        return false;
    }
}

