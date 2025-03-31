package lt.projectx.siuntupristatymoapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.projectx.siuntupristatymoapi.entity.Courier;
import lt.projectx.siuntupristatymoapi.repository.CourierRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Service
@RequiredArgsConstructor
public class CourierService {
    private final CourierRepository courierRepository;

    public List<Courier> getAllCouriers(){
        return courierRepository.findAll();
    }
    public Courier getCourierById(Long id){

        Optional<Courier> maybeCourier =  courierRepository.findById(id);
        if(maybeCourier.isEmpty()){
            throw new EntityNotFoundException("Courier with id " + id + " not found");
        }
        return maybeCourier.get();
    }
    public Courier saveCourier(Courier courier){
        return courierRepository.saveAndFlush(courier);
    }
    public Courier updateCourierById(Long id, Courier courierFromRequest){
        Courier courierFromDB = getCourierById(id);
        if (StringUtils.isNotBlank(courierFromRequest.getFirstName()) &&
                !courierFromRequest.getFirstName().equals(courierFromDB.getFirstName())) {
            courierFromDB.setFirstName(courierFromRequest.getFirstName());
        }
        if (StringUtils.isNotBlank(courierFromRequest.getLastName()) &&
                !courierFromRequest.getLastName().equals(courierFromDB.getLastName())) {
            courierFromDB.setLastName(courierFromRequest.getLastName());
        }
        if (StringUtils.isNotBlank(courierFromRequest.getPersonalCode()) &&
                !courierFromRequest.getPersonalCode().equals(courierFromDB.getPersonalCode())) {
            courierFromDB.setPersonalCode(courierFromRequest.getPersonalCode());
        }
        if (StringUtils.isNotBlank(courierFromRequest.getVehicleNumber()) &&
                !courierFromRequest.getVehicleNumber().equals(courierFromDB.getVehicleNumber())) {
            courierFromDB.setVehicleNumber(courierFromRequest.getVehicleNumber());
        }
        return saveCourier(courierFromDB);
    }

    public void deleteCourierById(Long id){
        courierRepository.deleteById(id);
    }

}
