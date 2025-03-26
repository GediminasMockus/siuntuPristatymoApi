package lt.projectx.siuntupristatymoapi.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lt.projectx.siuntupristatymoapi.ParcelStatus;
import lt.projectx.siuntupristatymoapi.entity.Courier;
import lt.projectx.siuntupristatymoapi.entity.Parcel;
import lt.projectx.siuntupristatymoapi.repository.CourierRepository;
import lt.projectx.siuntupristatymoapi.repository.ParcelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ParcelService {
    private final ParcelRepository parcelRepository;
    private final CourierRepository courierRepository;

    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    public Optional<Parcel> getParcelById(Long id) {
        return parcelRepository.findById(id);
    }

    public Parcel saveParcel(Parcel parcel) {
        return parcelRepository.saveAndFlush(parcel);
    }

    public void deleteParcelById(Long id) {
        parcelRepository.deleteById(id);
    }

    public void addTestData() {
        if (parcelRepository.count() == 0) { // Kad testiniai duomenys nesikartotų
            List<Courier> couriers = new ArrayList<>();

            Courier courier1 = new Courier();
            courier1.setPersonalCode("39566468234");
            courier1.setFirstName("Jonas");
            courier1.setLastName("Jonaitis");
            courier1.setVehicleNumber("ABC345");
            couriers.add(courierRepository.saveAndFlush(courier1));

            Courier courier2 = new Courier();
            courier2.setPersonalCode("395468862311");
            courier2.setFirstName("Petras");
            courier2.setLastName("Petraitis");
            courier2.setVehicleNumber("ABC123");
            couriers.add(courierRepository.saveAndFlush(courier2));

            Courier courier3 = new Courier();
            courier3.setPersonalCode("39577777777");
            courier3.setFirstName("Andrius");
            courier3.setLastName("Kazlauskas");
            courier3.setVehicleNumber("XYZ789");
            couriers.add(courierRepository.saveAndFlush(courier3));

            Courier courier4 = new Courier();
            courier4.setPersonalCode("39599988877");
            courier4.setFirstName("Mantas");
            courier4.setLastName("Stankevicius");
            courier4.setVehicleNumber("LMN456");
            couriers.add(courierRepository.saveAndFlush(courier4));

            Courier courier5 = new Courier();
            courier5.setPersonalCode("39511122233");
            courier5.setFirstName("Lukas");
            courier5.setLastName("Brazinskas");
            courier5.setVehicleNumber("QWE852");
            couriers.add(courierRepository.saveAndFlush(courier5));

            List<Parcel> parcels = new ArrayList<>();

            parcels.add(createParcel("TR02648950434", 12.5, "Tilžės 34-8, Šiauliai", ParcelStatus.PENDING, courier1));
            parcels.add(createParcel("TR87654321012", 5.0, "Gedimino pr. 1, Vilnius", ParcelStatus.DELIVERED, courier2));
            parcels.add(createParcel("TR12345678901", 8.2, "Kauno g. 45, Kaunas", ParcelStatus.IN_TRANSIT, courier3));
            parcels.add(createParcel("TR98765432101", 3.5, "Klaipėdos g. 8, Klaipėda", ParcelStatus.PENDING, courier4));
            parcels.add(createParcel("TR74185296302", 10.0, "Šiaulių g. 22, Panevėžys", ParcelStatus.DELIVERED, courier5));
            parcels.add(createParcel("TR96325874103", 2.1, "Vilniaus g. 7, Vilnius", ParcelStatus.IN_TRANSIT, courier1));
            parcels.add(createParcel("TR35715985204", 15.7, "Tilžės g. 11, Šiauliai", ParcelStatus.PENDING, courier2));
            parcels.add(createParcel("TR15935785205", 6.9, "Ukmergės g. 3, Vilnius", ParcelStatus.DELIVERED, courier3));
            parcels.add(createParcel("TR25874196306", 4.0, "Savanorių pr. 18, Kaunas", ParcelStatus.IN_TRANSIT, courier4));
            parcels.add(createParcel("TR65498732107", 9.5, "P. Cvirkos g. 5, Alytus", ParcelStatus.PENDING, courier5));

            parcelRepository.saveAll(parcels);
        }
    }

    private Parcel createParcel(String trackingNumber, double weight, String address, ParcelStatus status, Courier courier) {
        Parcel parcel = new Parcel();
        parcel.setTrackingNumber(trackingNumber);
        parcel.setWeightKg(weight);
        parcel.setDestinationAddress(address);
        parcel.setStatus(status);
        parcel.setCourier(courier);
        return parcel;
    }

}
