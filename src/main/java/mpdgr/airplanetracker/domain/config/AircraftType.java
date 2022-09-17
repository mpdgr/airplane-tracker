package mpdgr.airplanetracker.domain.config;

public enum AircraftType {
    BOEING_747 ("747");

    private final String type;

    AircraftType(String type){
        this.type = type;}

    public String getType() {
        return type;
    }
}
