package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterFileRepositoryTest {

    static final String TEST_PATH = "./data/encounters-test.csv";
    final Encounter[] testEncounters = new Encounter[]{
            new Encounter(1, EncounterType.UFO, "2020-01-01", "short test #1", 1),
            new Encounter(2, EncounterType.CREATURE, "2020-02-01", "short test #2", 1),
            new Encounter(3, EncounterType.SOUND, "2020-03-01", "short test #3", 1)
    };

    EncounterRepository repository = new EncounterFileRepository(TEST_PATH);

//    ● Test the new methods:
//            ○ Test findByType and update. Ensure that update is tested for both
//    successful and unsuccessful scenarios.
//            ● Add missing tests:
//            ○ The deleteById method should be explicitly tested with both positive
//            (encounter found) and negative (encounter not found) cases.
//● Improve setup:
//            ○ Currently, the test setup method uses multiple repository methods to
//    establish a known good state. This can lead to unclear test results if
//    issues arise. Instead, use a data "seed" file containing all necessary test
//    data. Copy this seed data into a test data file before each test. This
//    ensures that the test data remains consistent and accurate, isolating
//    issues more effectively

    @BeforeEach
    void setup() throws DataAccessException {
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
        Encounter[] expected = Arrays.stream(testEncounters).sequential()
        List<Encounter> actual = repository.findByType("CREATURE");
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