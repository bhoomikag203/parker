package entities;

public class Vehicle {

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    String location;

    public Vehicle() {
    }

    public boolean isParked(){
        boolean isParked = false;

        if(park() == getLocation()){
            isParked = true;
        }
        return isParked;
    }

    public String park(){
        System.out.println("Vehicle Parked at location" + getLocation());
        return location;
    }

    public void unPark(){
        if(isParked() == true) {
            System.out.println("Vehicle UnParked from location" + getLocation());
        } else {
            System.out.println("Vehicle not found");;
        }
    }


}