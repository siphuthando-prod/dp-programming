//Packaging
package service.roomservice;

//Import statements
import oop.service.Service;

public class RoomService extends Service{
    //Data member
    private int roomNumber;

    //Constructors
    public RoomService(int roomNumber){
        super(10.0);
        this.roomNumber = roomNumber;
    }

    public RoomService(int roomNumber, double serviceFee){
        super(serviceFee);
        this.roomNumber = roomNumber;
    }

    //Accessor
    public int getRoomNumber(){
        return this.roomNumber;
    }

    //Helper method
    @Override
    public String toString(){
        return "Room number: " + this.roomNumber + "\n" 
                + super.toString();
    }
}