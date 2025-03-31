package lt.projectx.siuntupristatymoapi.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.projectx.siuntupristatymoapi.converter.CourierConverter;
import lt.projectx.siuntupristatymoapi.converter.ParcelConverter;
import lt.projectx.siuntupristatymoapi.dto.CreateParcelRequest;
import lt.projectx.siuntupristatymoapi.dto.GetParcelResponse;
import lt.projectx.siuntupristatymoapi.entity.Courier;
import lt.projectx.siuntupristatymoapi.entity.Parcel;
import lt.projectx.siuntupristatymoapi.exception.EntityNotFoundException;
import lt.projectx.siuntupristatymoapi.service.CourierService;
import lt.projectx.siuntupristatymoapi.service.ParcelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parcels")
public class ParcelController {
    private final ParcelService parcelService;
    private final CourierService courierService;
    private final ParcelConverter parcelConverter;
    private final CourierConverter courierConverter;

    @PostMapping
    public ResponseEntity<Parcel> addParcel(@Valid @RequestBody CreateParcelRequest request) {
        if (request == null) {
            return ResponseEntity.badRequest().build();
        }

        Courier courier = null;
        if (request.getCourierId() != null) {
            try {
                courier = courierService.getCourierById(request.getCourierId());
            } catch (EntityNotFoundException ex) {
                return ResponseEntity.notFound().build();
            }
        }

        Parcel parcel = parcelConverter.toEntity(request);
        parcel.setCourier(courier);
        return ResponseEntity.ok(parcelService.saveParcel(parcel));
    }


    @GetMapping
    public ResponseEntity<List<GetParcelResponse>> getAllParcels() {
        List<Parcel> parcels = parcelService.getAllParcels();
        List<GetParcelResponse> parcelResponses = parcelConverter.entityListToDto(parcels);
        return ResponseEntity.ok(parcelResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parcel> getParcelById(@PathVariable Long id) {
        try {
            Parcel parcel = parcelService.getParcelById(id);
            return ResponseEntity.ok(parcel);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Parcel> updateParcelStatus(@PathVariable Long id, @RequestBody Parcel updatedParcel) {
        Parcel parcel = parcelService.getParcelById(id);
        parcel.setStatus(updatedParcel.getStatus());
        return ResponseEntity.ok(parcelService.saveParcel(parcel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParcelById(@PathVariable Long id) {
        if (!parcelService.existsParcelById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        parcelService.deleteParcelById(id);
        return ResponseEntity.noContent().build();
    }
}
