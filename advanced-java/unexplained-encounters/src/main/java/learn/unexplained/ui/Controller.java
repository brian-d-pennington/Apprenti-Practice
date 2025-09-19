package learn.unexplained.ui;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.domain.EncounterResult;
import learn.unexplained.domain.EncounterService;
import learn.unexplained.models.Encounter;

import java.util.List;

public class Controller {

    private final EncounterService service;
    private final View view;

    public Controller(EncounterService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        view.printHeader("Welcome To Unexplained Encounters.");

        try {
            runMenuLoop();
        } catch (DataAccessException ex) {
            view.printHeader("CRITICAL ERROR:" + ex.getMessage());
        }

        view.printHeader("Goodbye");
    }

    private void runMenuLoop() throws DataAccessException {
        MenuOption option;
        do {
            option = view.displayMenuGetOption();
            switch (option) {
                case DISPLAY_ALL:
                    displayAllEncounters();
                    break;
                case ADD:
                    addEncounter();
                    break;
                case FIND_BY_TYPE:
                    String type = displayEncounterTypes();
                    findEncounterByType(type);
                    break;
                case UPDATE:
                    updateEncounter();
                    break;
                case DELETE:
                    deleteEncounter();
                    break;
            }
        } while (option != MenuOption.EXIT);
    }

    private void displayAllEncounters() throws DataAccessException {
        List<Encounter> encounters = service.findAll();
        view.printAllEncounters(encounters);
    }

    // added methods: displayEncounterTypes, findEncounterByType, update, and delete

    private String displayEncounterTypes() throws DataAccessException {
        return view.readType().toString();
    }

    private void findEncounterByType(String type) throws DataAccessException {
        List<Encounter> encounters = service.findByType(type);
        view.printAllEncounters(encounters);
    }

    private void updateEncounter() throws DataAccessException {
        List<Encounter> encounters = service.findAll();
        if (!encounters.isEmpty()) {
            Encounter encounter = chooseEncounter(encounters);
            service.update(encounter);
        } else {
            System.out.println("There are no Encounters to update.");
        }
    }

    private void deleteEncounter() throws DataAccessException {
        List<Encounter> encounters = service.findAll();
        if (!encounters.isEmpty()) {
            Encounter encounter = chooseEncounter(encounters);
            int id = encounter.getEncounterId();
            service.deleteById(encounter.getEncounterId());
            System.out.println("Encounter " +id+ " deleted.");
        } else {
            System.out.println("There are no Encounters to delete.");
        }
    }

    public Encounter chooseEncounter(List<Encounter> encounters){
        view.printAllEncounters(encounters);
        Encounter result = null;
        if(!encounters.isEmpty()) {
            int max = encounters.size()+1;
            int encounterId = view.readInt("Choose an Encounter to modify: ", 1, max);
            for (Encounter encounter : encounters){
                if(encounter.getEncounterId() == encounterId){
                    result = encounter;
                    break;
                }
            }
        }
        return result;
    }

    private void addEncounter() throws DataAccessException {
        Encounter encounter = view.makeEncounter();
        EncounterResult result = service.add(encounter);
        view.printResult(result);
    }
}
