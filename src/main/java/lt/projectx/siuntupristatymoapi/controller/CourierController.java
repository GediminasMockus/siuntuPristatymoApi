package lt.projectx.siuntupristatymoapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.projectx.siuntupristatymoapi.entity.Courier;
import lt.projectx.siuntupristatymoapi.entity.Parcel;
import lt.projectx.siuntupristatymoapi.service.CourierService;
import lt.projectx.siuntupristatymoapi.service.ParcelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/couriers")
public class CourierController {
    private final CourierService courierService;
    private final ParcelService parcelService;

    @PostMapping
    public Courier createCourier(@Valid @RequestBody Courier courier) {
        return courierService.saveCourier(courier);
    }

    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }

    @GetMapping("/{id}")
    public Courier getCourierById(@PathVariable Long id) {
        return courierService.getCourierById(id);

    }

    @GetMapping("/{id}/parcels")
    public List<Parcel> getAllCourierParcels(@PathVariable Long id) {
        return parcelService.getParcelRepository().findByCourierId(id);
    }

    @PutMapping("/{id}")
    public Courier updateCourierInfo(@PathVariable Long id, @RequestBody Courier updatedCourier) {
        return courierService.updateCourierById(id, updatedCourier);

    }
}