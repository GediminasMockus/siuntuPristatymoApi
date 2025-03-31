package lt.projectx.siuntupristatymoapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.projectx.siuntupristatymoapi.ParcelStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackingNumber;
    private double weightKg;
    private String destinationAddress;

    @Enumerated(EnumType.STRING)
    private ParcelStatus status;

    @ManyToOne
    private Courier courier;

    public static Parcel createParcel(String trackingNumber, double weight, String address, ParcelStatus status, Courier courier) {
        Parcel parcel = new Parcel();
        parcel.setTrackingNumber(trackingNumber);
        parcel.setWeightKg(weight);
        parcel.setDestinationAddress(address);
        parcel.setStatus(status);
        parcel.setCourier(courier);
        return parcel;
    }

}
