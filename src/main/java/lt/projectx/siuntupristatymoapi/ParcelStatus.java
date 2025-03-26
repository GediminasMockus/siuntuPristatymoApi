package lt.projectx.siuntupristatymoapi;

import lombok.Getter;

@Getter
public enum ParcelStatus {
    PENDING(1),
    IN_TRANSIT(2),
    DELIVERED(3);

    private final int value;

    ParcelStatus(int value) {
        this.value = value;
    }

    public static ParcelStatus fromValue(int value) {
        for (ParcelStatus status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
