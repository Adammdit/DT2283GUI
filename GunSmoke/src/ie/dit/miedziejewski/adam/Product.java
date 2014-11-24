package ie.dit.miedziejewski.adam;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable
{
	private String name = "";
	private String description = "";
	private Double price = 0.00;
	private int quantity = 0;
	private Double ext = 0.00;
	
	public Product (String name, String description, Double price)
	{
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getExt() {
		return (double) Math.round(price*quantity*100)/100;
	}
	public void setExt(Double ext) {
		this.ext = ext;
	}
	
	
	@Override
	public int describeContents() {return 0;}

	// Parcel part
	// http://stackoverflow.com/questions/7181526/how-can-i-make-my-custom-objects-be-parcelable
    public Product(Parcel in)
    {
    	readFromParcel(in);
    }
	
	@Override
	public void writeToParcel(Parcel dest, int flags) 
	{
		dest.writeString(name);
	    dest.writeDouble(price);
	    dest.writeInt(quantity);
	}
	
	private void readFromParcel(Parcel in) 
	{   
		// We just need to read back each 
		// field in the order that it was 
		// written to the parcel 
		name = in.readString(); 
		price = in.readDouble(); 
		quantity = in.readInt(); 
	} 
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Product createFromParcel(Parcel in) {
            return new Product(in); 
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    }; 
}
