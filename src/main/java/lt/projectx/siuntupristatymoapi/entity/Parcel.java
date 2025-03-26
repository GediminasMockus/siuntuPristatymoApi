package lt.projectx.siuntupristatymoapi.entity;

public class Parcel {
    private int id;
    private String trackingNumber;
    private double weightKg;
    private String destinationAddress;
    private String status;

    @ManytoOne
    private Courier courier;

}
