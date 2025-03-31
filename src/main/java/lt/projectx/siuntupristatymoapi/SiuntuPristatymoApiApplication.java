package lt.projectx.siuntupristatymoapi;

import lombok.RequiredArgsConstructor;
import lt.projectx.siuntupristatymoapi.service.ParcelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class SiuntuPristatymoApiApplication {

    private final ParcelService parcelService;

    public static void main(String[] args) {
        SpringApplication.run(SiuntuPristatymoApiApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void insertTestData() {
        parcelService.addTestData();
        System.out.println(parcelService.getAllParcels());
    }

}
