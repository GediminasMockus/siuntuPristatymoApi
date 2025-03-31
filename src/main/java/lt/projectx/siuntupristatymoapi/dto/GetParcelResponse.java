package lt.projectx.siuntupristatymoapi.dto;

import lombok.Data;
import lt.projectx.siuntupristatymoapi.ParcelStatus;

@Data
public class GetParcelResponse {
    private Long id;
    private String trackingNumber;
    private double weightKg;
    private String destinationAddress;
    private ParcelStatus status;
    private GetCourierResponse courier;
}