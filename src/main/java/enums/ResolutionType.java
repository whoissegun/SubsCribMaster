package enums;

public enum ResolutionType {
    P_1080("1080p"), 
    K_4_HDR("4K+HDR");

    private final String description;

    ResolutionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
