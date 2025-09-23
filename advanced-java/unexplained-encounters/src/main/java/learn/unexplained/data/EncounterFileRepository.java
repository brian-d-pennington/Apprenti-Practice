package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EncounterFileRepository implements EncounterRepository {

    private static final String DELIMITER = ",";
    private static final String DELIMITER_REPLACEMENT = "@@@";
    private static final String HEADER = "encounter_id,type,when,description,occurrences";
    private final String filePath;

    public EncounterFileRepository(@Value("${dataFilePath}") String filePath) {
        this.filePath = filePath;
    }

    // ADDED METHODS: findByType and update
    @Override
    public List<Encounter> findByType(String type) throws DataAccessException{
        List<Encounter> encounters = findAll();
        List<Encounter> encountersByType = new ArrayList<>();
        for(Encounter encounter: encounters){
            if(encounter.getType().toString().equals(type)){
                encountersByType.add(encounter);
            }
        }
        if (encountersByType.isEmpty()) {
            return null;
        } else {
            return encountersByType;
        }
    }

    @Override
    public boolean update(Encounter encounter) throws DataAccessException {
        List<Encounter> all = findAll();
        boolean found = false;

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getEncounterId() == encounter.getEncounterId()) {
                int updateOccurrences = all.get(i).getOccurrences();
                updateOccurrences+=1;
                all.get(i).setOccurrences(updateOccurrences); // Update increments Occurrences by 1
                System.out.println("Occurrences of " +all.get(i).getDescription() + " " +all.get(i).getType() + " encounter incremented by 1.");
                all.set(i, encounter);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Could not find Encounter to update.");
            return false;
        }

        try (PrintWriter writer = new PrintWriter(filePath)) {
            // rebuild CSV file
            writer.println("encounter_id,type,when,description,occurrences");
            for (Encounter e : all) {
                writer.println(serialize(e));
            }
            return true;
        } catch (IOException e) {
            throw new DataAccessException("Could not update file", e);
        }
    }

    @Override
    public List<Encounter> findAll() throws DataAccessException {

        ArrayList<Encounter> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // skip header
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                Encounter encounter = deserialize(line);
                if (encounter != null) {
                    result.add(encounter);
                }
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }

        return result;
    }

    @Override
    public Encounter add(Encounter encounter) throws DataAccessException {
        List<Encounter> all = findAll();
        encounter.setEncounterId(getNextId(all));
        all.add(encounter);
        writeAll(all);
        return encounter;
    }

    @Override
    public boolean deleteById(int encounterId) throws DataAccessException {
        List<Encounter> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getEncounterId() == encounterId) {
                all.remove(i);
                writeAll(all);
                return true;
            }
        }
        return false;
    }

    private int getNextId(List<Encounter> allEncounters) {
        int nextId = 0;
        for (Encounter e : allEncounters) {
            nextId = Math.max(nextId, e.getEncounterId());
        }
        return nextId + 1;
    }

    private void writeAll(List<Encounter> encounters) throws DataAccessException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println(HEADER);
            for (Encounter e : encounters) {
                writer.println(serialize(e));
            }
        } catch (IOException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }
    }

    private String serialize(Encounter encounter) {
        return String.format("%s,%s,%s,%s,%s",
                encounter.getEncounterId(),
                encounter.getType(),
                clean(encounter.getWhen()),
                clean(encounter.getDescription()),
                encounter.getOccurrences());
    }

    private Encounter deserialize(String line) {
        String[] fields = line.split(DELIMITER, -1);
        if (fields.length == 5) {
            Encounter encounter = new Encounter();
            encounter.setEncounterId(Integer.parseInt(fields[0]));
            encounter.setType(EncounterType.valueOf(fields[1]));
            encounter.setWhen(restore(fields[2]));
            encounter.setDescription(restore(fields[3]));
            encounter.setOccurrences(Integer.parseInt(fields[4]));
            return encounter;
        }
        return null;
    }

    private String clean(String value) {
        return value.replace(DELIMITER, DELIMITER_REPLACEMENT);
    }

    private String restore(String value) {
        return value.replace(DELIMITER_REPLACEMENT, DELIMITER);
    }

}
