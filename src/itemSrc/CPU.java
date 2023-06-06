package itemSrc;

import java.text.DecimalFormat;

public class CPU implements Comparable <CPU>
{
	private String id;
	private int days;
	private int cores;
	private int clockSpeed;
	private int quantity;
	private int price;
	private boolean collected = false;
	
    public CPU(String id, int days, int cores, int clockSpeed, int quantity,
			int price) {
    	
    	this.id = id;
		this.days = days;
		this.cores = cores;
		this.clockSpeed = clockSpeed;
		this.quantity = quantity;
		this.price = price;
	}
    
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getCores() {
		return cores;
	}
	public void setCores(int cores) {
		this.cores = cores;
	}
	public int getClockSpeed() {
		return clockSpeed;
	}
	public void setClockSpeed(int clockSpeed) {
		this.clockSpeed = clockSpeed;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setCache(int price) {
		this.price = price; 
	}
	


	public boolean isCollected() {
		return collected;
	}



	public void setCollected(boolean collected) {
		this.collected = collected;
	}
	
	public String orderPrice(int ordQuant) {
		double calc = 0;
		String priceCalc = "";
		DecimalFormat df = new DecimalFormat("0.00");
		//splits each character in id
		String parts [] = id.split("");
		//gets the first character from id
		String first =  parts[0].trim();
		//if the first character is X then give customer a 20% discount
		if(first.equals("X")) {
			calc = price * ordQuant * 0.8;
			//rounds calc to 2dp
			priceCalc = df.format(calc);
		}
		//else dont give a discount
		else {
			calc = price * ordQuant;
			//rounds calc to 2dp
			priceCalc = df.format(calc);
		}
		
		return priceCalc;
	}

    public boolean equals(Object other)
    {
    	if(other instanceof CPU) {
            CPU otherItem = (CPU) other;
            return id.equals(otherItem.getId());
        }
        else {
            return false;
        }
    }

    public int compareTo(CPU otherDetails)
    {
    	return id.compareTo(otherDetails.getId());
    }

	@Override
	public String toString() {
		return "CPU [id=" + id + ", days=" + days+ ", cores=" + cores
				+ ", clock speed=" + clockSpeed + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

}
