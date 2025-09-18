package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterFileRepositoryTest {
    static final String SEED_FILE_PATH = "./data/encounters-seed.csv";
    static final String TEST_PATH = "./data/encounters-test.csv";

    Encounter[] testEncounters = new Encounter[3];

    EncounterRepository repository;

    @BeforeEach
    void setup() throws DataAccessException, IOException {
        // added seed file
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);

        repository = new EncounterFileRepository(TEST_PATH);
        testEncounters = new Encounter[]{
                new Encounter(1, EncounterType.UFO, "2020-01-01", "short test #1", 1),
                new Encounter(2, EncounterType.CREATURE, "2020-02-01", "short test #2", 1),
                new Encounter(3, EncounterType.SOUND, "2020-03-01", "short test #3", 1)
        };

        for (Encounter e : repository.findAll()) {
            repository.deleteById(e.getEncounterId());
        }

        for (Encounter e : testEncounters) {
            repository.add(e);
        }
    }
    // New Test for added methods
    @Test
    void testFindByType() throws DataAccessException {
        List<Encounter> expected = new ArrayList<>();
        expected.add(testEncounters[1]);
        List<Encounter> actual = repository.findByType("CREATURE");
        assertEquals(expected, actual);
    }

    @Test
    void testUpdateSuccessful() throws DataAccessException {
        // new Encounter has updated description text
        Encounter testUpdatedEncounter = new Encounter(1, EncounterType.UFO, "2020-01-01", "UPDATED DESCRIPTION TEST", 1);
        boolean expected = true;
        boolean actual = repository.update(testUpdatedEncounter);
        assertEquals(expected, actual);
    }

    @Test
    void testDeleteByIdSuccessful() throws DataAccessException {
        boolean expected = true;
        boolean actual = repository.deleteById(3);
        assertEquals(expected, actual);
    }

    @Test
    void testDeleteByIdUnsuccessful() throws DataAccessException {
        boolean expected = false;
        boolean actual = repository.deleteById(7); // id doesn't exist, should return false
        assertEquals(expected, actual);
    }

    @Test
    void testUpdateUnsuccessful() throws DataAccessException {
        // Encounter not included in the list will be passed, should return false
        Encounter testNonExistentEntryUpdate = new Encounter(5, EncounterType.UFO, "2020-01-01", "UPDATED DESCRIPTION TEST", 1);
        boolean expected = false;
        boolean actual = repository.update(testNonExistentEntryUpdate);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<Encounter> encounters = repository.findAll();
        Encounter[] actual = encounters.toArray(new Encounter[encounters.size()]);
        assertArrayEquals(testEncounters, actual);
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = new Encounter();
        encounter.setType(EncounterType.UFO);
        encounter.setWhen("Jan 15, 2005");
        encounter.setDescription("moving pinpoint of light." +
                "seemed to move with me along the highway. " +
                "then suddenly reversed direction without slowing down. it just reversed.");
        encounter.setOccurrences(1);

        Encounter actual = repository.add(encounter);

        assertNotNull(actual);
        assertEquals(4, actual.getEncounterId());
    }

}