package itemSrc;

public class Worker   {
	private QueueOfCusts allCusts;
	private CPUMap allCPUs;
	private int speed;
	private int numWorker;
	private CustInQueue currentCust;
	private boolean open = true;
	private boolean finished = false;
	
	
	
    public Worker( QueueOfCusts allCusts, CPUMap allParcels, int speed,
			int numWorker) {
    	this.allCusts = allCusts;
    	this.allCPUs = allParcels;
    	this.speed = speed;
    	this.numWorker = numWorker;
	}
	
    public CustInQueue getCurrentCust() {
    	return currentCust;
    }
    
    public int getNum() {
    	 return numWorker;
    }

	public boolean getClosed() {
		return open;
	}
	
	public void setClosed() {
		open = false;
		
	}
	
	public boolean getFinished() { return finished; }

	public  CustInQueue getNext() {
		
		CustInQueue c = allCusts.getNext();

		Log log = Log.getInstance();
		if (c!= null){
			log.addEntry("W" + numWorker + " :C" + c.getqNum());
			
		}
		return c;
	}
	
	public  void processOneCustomer() {
		currentCust = this.getNext() ;
		if ((currentCust != null) && currentCust.isInQueue()) {

			
			String pid = currentCust.getpId();
			CPU p = allCPUs.findParcel(pid);
			allCPUs.setCollected(p);
			System.out.println (pid +" "+ p);
		    if (allCPUs.allGone() ) {
				finished = true;
			}
			
		}
		else   
		{
			finished = true;
		}
			
	}

}
