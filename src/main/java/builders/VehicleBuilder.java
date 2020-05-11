package builders;

import entities.Vehicle;

public class VehicleBuilder {
    private Vehicle vehicle;

    public VehicleBuilder() {
    }

    public VehicleBuilder withLocation(String location){
        vehicle.setLocation(location);
        return this;
    }

    public Vehicle build(){
        return this.vehicle;
    }
}