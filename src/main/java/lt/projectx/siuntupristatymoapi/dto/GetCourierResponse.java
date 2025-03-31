package lt.projectx.siuntupristatymoapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCourierResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String personalCode;
    private String vehicleNumber;
}