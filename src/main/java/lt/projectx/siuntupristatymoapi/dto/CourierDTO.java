package lt.projectx.siuntupristatymoapi.dto;

public record CourierDTO(

        Long id,
        String personalCode,
        String firstName,
        String lastName,
        String vehicleNumber) {
}
