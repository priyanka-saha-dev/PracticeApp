package orderprocessingsystem.model;

import java.util.Arrays;

public enum Status {
    NEW, PROCESSING, COMPLETED, CANCELLED;

    public static Status mapStatus(String status) {
        return Arrays.stream(Status.values())
                .filter(s -> s.name().equals(status))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
