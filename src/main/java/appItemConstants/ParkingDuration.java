package appItemConstants;

public enum ParkingDuration {
    Any("any"), One_Hour_Plus("1 hr +"), Two_Hour_Plus("2 hr +"), Three_Hour_Plus("3 hr +"), Four_Hour_Plus("4 hr +");

    private String hours;
    ParkingDuration(String hours) {
        this.hours = hours;
    }

    public String getHours() {
        System.out.println(hours);
        return hours;
    }
}
