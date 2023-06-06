package itemSrc;

public class CustInQueue 
{
	private static int sequence = 0;
	private String name;
	private String pId;
	private int quantity;
	private int qNum;
	private boolean inQueue = false;

    public CustInQueue(String name, String pId, int quantity) {
    	this.name = name;
    	
    	try {
    		//splits each character of pId
			String parts [] = pId.split("");
			//if there was more then 4 characters in pId 
			if (parts.length > 4) {
				//then create an ArithmeticException error to not allow the id to be passed
				int catching = 100 / 0 ;
			}
			//creates a String to hold the first character from pId
			String first =  parts[0].trim();
				String firstint = parts[0];
				//if firstint is not a letter
				if(!Character.isLetter(firstint.charAt(0))) {
					//then create an ArithmeticException error to not allow the id to be passed
					int catching = 100 / 0 ;
				}
				
			//creates a String to hold the second character from pId	
			String second = parts[1].trim();
				//tries to convert second to an Integer, if it can't then it is a NumberFormatException error and the pId has not passed
				int secondint = Integer.parseInt(second);
			//creates a String to hold the third character from pId	
			String third = parts[2].trim();
				//tries to convert third to an Integer, if it can't then it is a NumberFormatException error and the pId has not passed
				int thirdint = Integer.parseInt(third);
			//creates a String to hold the forth character from pId
			String forth = parts[3].trim();
				//tries to convert forth to an Integer, if it can't then it is a NumberFormatException error and the pId has not passed
				int forthint = Integer.parseInt(forth);
			
			//if the pId was valid it sets the pId instant variable to pId
			this.pId = pId;
    	}
    	//this catches trying to convert a String to an integer
    	catch(NumberFormatException e ) {
    		System.out.print("\nThe customer's id should be a letter followed by 3 integers\n");
    	}
    	
    	//this catches trying to divide a number by 0
    	catch(ArithmeticException e ) {
    		System.out.print("\nThe customer's id should be a letter followed by 3 integers\n");
    	}
    	
    	//sets the quantity instant variable to quantity
    	this.quantity = quantity;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; 
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getqNum() {
		return qNum;
	}
	public void setqNum(int qNum) {
		this.qNum = qNum;
	}
	

	public boolean isInQueue() {
		return inQueue;
	}

	public void setInQueue(boolean inQueue) {
		this.inQueue = inQueue;
	}

	@Override 
	public String toString() {
		return "Customer in queue is [name is: " + name + ", pId is: " + pId + ", quantity is: "+quantity+ ", qNum is " + qNum+ ")";
	}
    
}
