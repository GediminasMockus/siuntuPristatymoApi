package lt.projectx.siuntupristatymoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourierRequest {
    @NotNull(message = "Firstname is required")
    private String firstName;

    @NotNull(message = "Lastname is required")
    private String lastName;

    @Size(min = 11, max = 11, message = "Personal code must be 11 characters")
    private String personalCode;

    @NotBlank(message = "Vehicle number is required")
    private String vehicleNumber;
}