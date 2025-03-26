package lt.projectx.siuntupristatymoapi.dto;

public record ParcelDTO(

        Long id,
        String trackingNumber,
        Double weightKg,
        String destinationAddress) {}


