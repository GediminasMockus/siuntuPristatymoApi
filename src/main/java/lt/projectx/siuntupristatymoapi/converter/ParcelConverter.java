package lt.projectx.siuntupristatymoapi.converter;

import lombok.RequiredArgsConstructor;
import lt.projectx.siuntupristatymoapi.ParcelStatus;
import lt.projectx.siuntupristatymoapi.dto.CreateParcelRequest;
import lt.projectx.siuntupristatymoapi.dto.GetParcelResponse;
import lt.projectx.siuntupristatymoapi.entity.Parcel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ParcelConverter {

    private final CourierConverter courierConverter;

    public GetParcelResponse entityToDto(Parcel parcel) {
        GetParcelResponse response = new GetParcelResponse();
        response.setId(parcel.getId());
        response.setTrackingNumber(parcel.getTrackingNumber());
        response.setWeightKg(parcel.getWeightKg());
        response.setDestinationAddress(parcel.getDestinationAddress());
        response.setStatus(parcel.getStatus());
        response.setCourier(courierConverter.entityToDto(parcel.getCourier()));
        return response;
    }

    public List<GetParcelResponse> entityListToDto(List<Parcel> parcels) {
        List<GetParcelResponse> responses = new ArrayList<>();
        for (Parcel parcel : parcels) {
            responses.add(entityToDto(parcel));
        }
        return responses;
    }

    public Parcel toEntity(CreateParcelRequest request) {
        Parcel parcel = new Parcel();
        parcel.setTrackingNumber(request.getTrackingNumber());
        parcel.setWeightKg(request.getWeightKg());
        parcel.setDestinationAddress(request.getDestinationAddress());
        parcel.setStatus(ParcelStatus.valueOf(request.getStatus()));
        return parcel;
    }
}