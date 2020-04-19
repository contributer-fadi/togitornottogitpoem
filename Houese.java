import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class House {
	private int beds;
	private int rooms;
	private double area;
	private String address;
	private double pricePerYear;
	private boolean petsAllowed;
	private HouseType type;
	private HouseStatus status;
	private ArrayList<Facility> facilities;
	private Customer renter;

	public House(int beds, int rooms, double area, String address, double price, boolean pets, HouseType type, ArrayList<Facility> facilities) {
		this.beds = beds;
		this.rooms = rooms;
		this.area = area;
		this.address = address;
		this.pricePerYear = price;
		this.petsAllowed = pets;
		this.type = type;
		this.facilities = facilities;
		this.renter = null;
		this.status = HouseStatus.rented;
	}
	
	public void changePrice(double newPrice) {
		this.pricePerYear = newPrice;
	}
	
	public void addFacility (Facility newFacility) {
		this.facilities.add(newFacility);
	}
	
	public void removeFacility (Facility aFacility) {
		Iterator<Facility> itr = this.facilities.iterator(); 
        while (itr.hasNext()) { 
        	Facility f = (Facility)itr.next(); 
            if (f.equals(aFacility)) 
                itr.remove(); 
        } 
	}
	
	public boolean checkAvailability() {
		return (status==HouseStatus.free);
	}
	
	public HouseStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(HouseStatus newStatus) {
		this.status = newStatus;
	}
	
	public boolean rent(Customer c) {
		if (checkAvailability()) {
			renter=c;
			status = HouseStatus.rented;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean endRent(Customer c) {
		if ((renter!=null) && (renter.equals(c))) {
            renter = null;
            status = HouseStatus.rented;
            return true;        
        }
		else
			return false;
	}
}
