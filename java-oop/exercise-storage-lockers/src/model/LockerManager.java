package model;

import java.util.ArrayList;

public class LockerManager {
    public ArrayList<Locker> lockers;

    // constructor
    public LockerManager() {
        this.lockers = new ArrayList<>();
    }

    // methods
    public void addLocker(String lockerId) {
        lockers.add(new Locker(lockerId));
    }

    public Locker getLocker(String lockerId) {
        for (int i = 0; i < lockers.size(); i++) {
            if (lockerId.equals(lockers.get(i).getLockerId())) {
                return lockers.get(i);
            }
        }
        return null;
    }

    public void removeLocker(String lockerId) {
        for (int i = 0; i < lockers.size(); i++) {
            if (lockerId.equals(lockers.get(i).getLockerId())) {
                lockers.remove(i);
                System.out.println("Locker removed");
                break;
            } else {
                System.out.println("Locker by id " + lockerId + " could not be found to be deleted");
            }
        }
    }
}