package itemSrc;


import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.*;
import java.text.DecimalFormat;

public class Manager
{
	private Worker workers[];
	private int numWorkers = 2;
	private QueueOfCusts custQ;
    private CPUMap allCPUs;
   
   private int wSpeed [];
   
    public Manager()
    {
    	custQ = new  QueueOfCusts();
    	allCPUs = new CPUMap();
    }
    

    public QueueOfCusts getCusts() {
    return custQ;
    }
    
    public void initialiseData() {
    	readCustFile();

    	readCPUFile();
    	
    	int number = 0;
    	for (int i = 0; i < 10; i++ ) {
    		number = i;
    		CustInQueue c = custQ.get(i);
    		c.setInQueue(true);
    		c.setqNum(number);
    	}

    	System.out.println("\nCPU details\n"+allCPUs.listDetails());
    	System.out.println("queueing customers\n"+custQ.getQueueString());
    	
    	
    }

    public void readCustFile() {
    	try {
    		Scanner scanner = new Scanner (new File("Custs.csv"));
    		System.out.println("Scanning");
        	while(scanner.hasNext()){  
            	String inputLine = scanner.nextLine();
            	System.out.println(inputLine);
        		processCustLine(inputLine);

        	}
    	}
    	catch (Exception e) {
    		
    	}
    }

    private void processCustLine (String inputLine) {
		try {
			String parts [] = inputLine.split(",");
			
			//first, the number
			String id =  parts[0].trim();
			
			//then the days
			String pid = parts[1].trim();
			
			String quant = parts[2].trim();
			int quantity = Integer.parseInt(quant);
			
			//create  object and add to the list
			CustInQueue c= new CustInQueue (id, pid, quantity);
    		//add to list
			if(c.getpId() != null){
				 custQ.addDetails(c);
			}
			else {
				System.out.println("id ["+pid+"] is incorrect and won't be added to queue\n");
			}
           
		}
			
			//this catches trying to convert a String to an integer
			catch (NumberFormatException nfe) {
				String error = "Number conversion error in '"
	                   + inputLine + "'  - " + nfe.getMessage();
				System.out.println(error);
			}
			//this catches missing items if only one or two items
			catch (ArrayIndexOutOfBoundsException air) {
				String error = "Not enough items in  : '" + inputLine
				            + "' index position : " + air.getMessage();
				System.out.println(error);
			}
		}
    
    public void readCPUFile() {
    	try {
    		Scanner scanner = new Scanner (new File("CPU.csv"));
    		System.out.println("\nScanning");
        	while(scanner.hasNext()){  
            	String inputLine = scanner.nextLine();
            	System.out.println(inputLine);
        		processCPULine(inputLine);

        	}
    	}
    	catch (Exception e) {
    		
    	}
    }
    
    private void processCPULine (String inputLine) {

				 
    	try {
			String parts [] = inputLine.split(",");
			String id = parts[0].trim();
			
			//then the days
			String dayString = parts[1].trim();
			int days = Integer.parseInt(dayString);
	

		    //then the dim
			String lenString = parts[2].trim();
			int cores = Integer.parseInt(lenString);
			
			String widString = parts[3].trim();
			int clockSpeed = Integer.parseInt(widString);
			
			String heightString = parts[4].trim();
			int quantity = Integer.parseInt(heightString);
			
			String weightString = parts[5].trim();
			int price = Integer.parseInt(weightString);
			
			//create  object and add to the list
			CPU p = new CPU (id, days, cores,clockSpeed,quantity, price);
    		//add to list
			allCPUs.addDetails(p);
           
		}
			
			//this catches trying to convert a String to an integer
			catch (NumberFormatException nfe) {
				String error = "Number conversion error in '"
	                   + inputLine + "'  - " + nfe.getMessage();
				System.out.println(error);
			}
			//this catches missing items if only one or two items
			catch (ArrayIndexOutOfBoundsException air) {
				String error = "Not enough items in  : '" + inputLine
				            + "' index position : " + air.getMessage();
				System.out.println(error);
			}
		}

    public void print() {
    	FileWriter fw = null;
    	try {
        	fw = new FileWriter("ItemDetails.txt");
        	CustInQueue next = custQ.getNext();
        	fw.write(next.getName() +", " +next.getpId().toString());
        	//fw.write(custQ.getNext().getName() +", " +custQ.getNext().getpId().toString());
        	fw.close();
    	}
    	catch (FileNotFoundException e) {
    		System.out.println(e.getMessage());
    		System.exit(1);
    	}
    	
    	catch (IOException ioe){
    		System.exit(1);
    	}

    }
    
    public void writeFile(String inputs) {
    	FileWriter fw = null;
    	//tries to write inputs to a file
    	try {
        	fw = new FileWriter("customersProcessed.txt",true);
        	fw.write(inputs);
        	fw.close();
    	}
    	//catches if the file is not found
    	catch (FileNotFoundException e) {
    		System.out.println(e.getMessage());
    		System.exit(1);
    	}
    	//catches for an input output error
    	catch (IOException ioe){
    		System.exit(1);
    	}    	
    }
    
    public void initialiseWorkers() {

    	workers = new Worker[numWorkers];
    	wSpeed = new int [numWorkers];
    	for (int tind = 0; tind <numWorkers; tind ++)
    	{
    		wSpeed[tind] = 1000 * (tind+1) * 2 ;
    		workers[tind] = new Worker(custQ, allCPUs, wSpeed[tind], tind + 1);

    	}
    }  
    
    public QueueOfCusts getCustQ(){
    	return custQ;
    }
    
    public CPUMap getAllCPUs() {
    	return allCPUs;
    }
    
    
    public Worker[] getWorkers() {
    	return workers;
    }
    
    public Worker findWorker(int i) {
    	return workers[i];
    }
    
    
    public static void main(String[] args) {    	
		Manager m = new Manager();
		m.initialiseData();
		new Gui(m);	
	}      
}

