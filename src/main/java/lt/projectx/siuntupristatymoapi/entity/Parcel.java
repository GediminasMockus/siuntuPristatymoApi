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
    @JoinColumn(name = "courier_id", nullable = false)
    private Courier courier;

}
