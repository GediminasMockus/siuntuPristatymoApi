package lt.projectx.siuntupristatymoapi.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.projectx.siuntupristatymoapi.entity.Courier;
import lt.projectx.siuntupristatymoapi.repository.CourierRepository;
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
    public Optional <Courier> getCourierById(Long id){
        return courierRepository.findById(id);
    }
    public Courier saveCourier(Courier courier){
        return courierRepository.saveAndFlush(courier);
    }
    public void updateCourierById(Long id, Courier courier){
        Optional<Courier> courierOptional = courierRepository.findById(id);
    }
    public void deleteCourierById(Long id){
        courierRepository.deleteById(id);
    }
}
