package lt.projectx.siuntupristatymoapi.repository;

import lt.projectx.siuntupristatymoapi.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    List<Parcel> findByCourierId(Long id);
}
