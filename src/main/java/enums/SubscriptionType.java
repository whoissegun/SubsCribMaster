package enums;

public enum SubscriptionType {
    STANDARD_WITH_ADS("Standard With Ads", 5.99, ResolutionType.P_1080,2),
    STANDARD("Standard", 16.49, ResolutionType.P_1080,2),
    PREMIUM("Premium", 20.99, ResolutionType.K_4_HDR,6);

    private final String description;
    private final double price;
    private final ResolutionType resolution;
    private final int numDevicesForDownload;

    private SubscriptionType(String description, double price, ResolutionType resolution, int numDevicesForDownload){
        this.description = description;
        this.price = price;
        this.resolution = resolution;
        this.numDevicesForDownload = numDevicesForDownload;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public ResolutionType getResolution() {
        return this.resolution;
    }

    public int getNumDevicesForDownload() {
        return this.numDevicesForDownload;
    }    

}
