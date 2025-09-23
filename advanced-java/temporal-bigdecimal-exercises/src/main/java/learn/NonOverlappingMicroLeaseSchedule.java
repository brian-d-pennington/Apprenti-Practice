package learn;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A schedule of MicroLeases where no lease can overlap another.
 */
public class NonOverlappingMicroLeaseSchedule {

    private ArrayList<MicroLease> leases = new ArrayList<>();

    public boolean add(MicroLease lease) {
        if (lease == null) {
            return false;
        }

        LocalDateTime start = lease.getStart();
        LocalDateTime end = lease.getEnd();

        if (start == null || end == null) {
            return false;
        }

        // Check if start is later than end
        if (start.isAfter(end)) {
            return false;
        }

        // Check for overlap with any existing lease
        for (MicroLease existingLease : leases) {
            LocalDateTime existingStart = existingLease.getStart();
            LocalDateTime existingEnd = existingLease.getEnd();
            if (start.isBefore(existingEnd) && end.isAfter(existingStart)) {
                return false;
            }
        }

        // Add lease to the list if all checks pass
        leases.add(lease);
        return true;
    }
}
