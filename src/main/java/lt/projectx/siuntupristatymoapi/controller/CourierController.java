package lt.projectx.siuntupristatymoapi.controller;

import lombok.RequiredArgsConstructor;
import lt.projectx.siuntupristatymoapi.entity.Courier;
import lt.projectx.siuntupristatymoapi.entity.Parcel;
import lt.projectx.siuntupristatymoapi.repository.CourierRepository;
import lt.projectx.siuntupristatymoapi.repository.ParcelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/couriers")
public class CourierController {
    private final CourierRepository courierRepository;
    private final ParcelRepository parcelRepository;

    @PostMapping
    public Courier createCourier(@RequestBody Courier courier) {
        return courierRepository.saveAndFlush(courier);
    }

    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    @GetMapping("/{id}")
    public Courier getCourierById(@PathVariable Long id) {
        return courierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Courier not found with id: " + id));
    }

    @GetMapping("/{id}/parcels")
    public List<Parcel> getAllCourierParcels(@PathVariable Long id) {
        return parcelRepository.findByCourierId(id);
    }

    @PutMapping("/{id}")
    public Courier updateCourierInfo(@PathVariable Long id, @RequestBody Courier updatedCourier) {
        return courierRepository.findById(id)
                .map(courier -> {
                    courier.setPersonalCode(updatedCourier.getPersonalCode());
                    courier.setFirstName(updatedCourier.getFirstName());
                    courier.setLastName(updatedCourier.getLastName());
                    courier.setVehicleNumber(updatedCourier.getVehicleNumber());
                    return courierRepository.saveAndFlush(courier);
                })
                .orElseThrow(() -> new RuntimeException("Courier not found with id: " + id));
    }
}
