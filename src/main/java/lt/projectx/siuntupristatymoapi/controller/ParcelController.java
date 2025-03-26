package lt.projectx.siuntupristatymoapi.controller;

import lombok.RequiredArgsConstructor;
import lt.projectx.siuntupristatymoapi.entity.Parcel;
import lt.projectx.siuntupristatymoapi.repository.ParcelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parcel")
public class ParcelController {
    private final ParcelRepository parcelRepository;

    @PostMapping
    public void addParcel(@RequestBody Parcel parcel) {
        parcelRepository.saveAndFlush(parcel);
    }

    @GetMapping
    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Parcel getParcelById(@PathVariable Long id) {
        return parcelRepository.findById(id).get();
    }

    @PatchMapping("/{id}")
    public void updateParcel(@PathVariable Long id, @RequestBody Parcel parcel) {
        parcelRepository.saveAndFlush(parcel);
    }

    @DeleteMapping("/{id}")
    public void deleteParcelById(@PathVariable Long id) {
        parcelRepository.deleteById(id);
    }
}
