package src.sangita;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    String name;
    int numberOfRooms;

    public Customer(String name, int numberOfRooms) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;
    }
}

class Hotel{
    List<String> customerName =  new ArrayList<>();
    int roomsBooked = 0;

    public Hotel(List<String> customerName, int roomsBooked) {
        this.customerName = customerName;
        this.roomsBooked = roomsBooked;
    }

    public Hotel() {
    }

    public String checkIn(Customer customer){
        if(roomsBooked<=10){
            customerName.add(customer.name);
            roomsBooked+=customer.numberOfRooms;
            return "Checked in";
        }else{
            return "No rooms available";
        }
    }
    public String checkRooms(Customer customer){
        if(customer.numberOfRooms<=roomsBooked){
            return "Yes";
        }else{
            return "No";
        }
    }

}

class Source1{
    public static void main(String[] args) {
        Customer customer = new Customer("Doselect",4);
        Hotel hotel = new Hotel();
        hotel.checkIn(customer);
    }
}



