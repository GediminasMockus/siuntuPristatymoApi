package lt.projectx.siuntupristatymoapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateParcelRequest {
    @NotBlank(message = "Tracking number is required")
    private String trackingNumber;

    @Min(value = 0, message = "Weight must be at least 0.0kg")
    private double weightKg;

    @NotBlank(message = "Destination address is required")
    private String destinationAddress;

    @NotBlank(message = "Status is required")
    private String status;

    private Long courierId;
}