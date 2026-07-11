
//Packaging
package oop.companycar;

//Import statements
import java.util.ArrayList;
import oop.driver.Driver;
import oop.trip.Trip;
import oop.trip.worktrip.WorkTrip;

public class CompanyCar {
    //data members
    private String regNumber;
    private Driver driver;
    private int speedoReading;
    private ArrayList<Trip> tripsTaken;
    
    //Constructors
    public CompanyCar(String regNumber, String surname, String staffNumber, String licenseNumber){
        this.regNumber = regNumber;
        driver = new Driver(surname, staffNumber, licenseNumber);
        speedoReading = lastTripEndReading();     
        tripsTaken = new ArrayList<>();
    }

    public CompanyCar(String regNumber, Driver driver){
        this.regNumber = regNumber;
        this.driver = driver;
        speedoReading = lastTripEndReading();
        tripsTaken = new ArrayList<>();
    }
    
    //Mutator methods
    public void setSpeedoReading(int speedoReading){
        this.speedoReading = speedoReading;
    }
    
    public void setDriver(Driver driver){
        this.driver = driver;
    }
    
    //Accessor m ethods
    public int getSpeedoReading(){
        return this.speedoReading;
    }
    
    public Driver getDriver(){
        return this.driver;
    }
    
    //Helper/Fascillitator methods
    public int lastTripEndReading() {
        return tripsTaken.get(tripsTaken.size() - 1).getEndKM();
    }
    
    private void newTrip(Trip trip){
        tripsTaken.add(trip);
    }
    
    public double claimAmountWorkTrips(){
        double totalClaim = 0.0;
        for (Trip trip : tripsTaken) {
            if(trip instanceof WorkTrip worktrip){
                totalClaim += worktrip.tripDistance() * 3.24;
            }
        }
        return totalClaim;
    }
}
