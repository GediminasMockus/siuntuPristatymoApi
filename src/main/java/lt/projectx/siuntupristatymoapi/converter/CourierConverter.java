package lt.projectx.siuntupristatymoapi.converter;

import lt.projectx.siuntupristatymoapi.dto.CreateCourierRequest;
import lt.projectx.siuntupristatymoapi.dto.GetCourierResponse;
import lt.projectx.siuntupristatymoapi.entity.Courier;
import org.springframework.stereotype.Component;

@Component
public class CourierConverter {
    public GetCourierResponse entityToDto(Courier courier) {
        GetCourierResponse response = new GetCourierResponse();
        response.setId(courier.getId());
        response.setFirstName(courier.getFirstName());
        response.setLastName(courier.getLastName());
        response.setPersonalCode(courier.getPersonalCode());
        response.setVehicleNumber(courier.getVehicleNumber());
        return response;
    }

    public Courier dtoToEntity(CreateCourierRequest request) {
        Courier courier = new Courier();
        courier.setFirstName(request.getFirstName());
        courier.setLastName(request.getLastName());
        courier.setPersonalCode(request.getPersonalCode());
        courier.setVehicleNumber(request.getVehicleNumber());
        return courier;
    }

}