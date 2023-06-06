package itemSrc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui implements ActionListener{
	private JFrame frame;
	private JPanel panelNorth, panelSouth,panelWest, panelEast;
	private JLabel lblFirstName, lblSurname;
	private JTextField txtFirstName, txtSurname;
	private JButton btnClose, btnCopy;
	private JTextArea textArea;
	private JScrollPane scrollPane; 
	private JTextArea textArea1;
	private JScrollPane scrollPane1; 
	private JTextArea textArea2;
	private JScrollPane scrollPane2; 
	private JTextArea textArea3;
	private JScrollPane scrollPane3; 
	
	private Manager m;
	
	
	public Gui(Manager m) {
		//frame
		frame = new JFrame();
		frame.setTitle("GUI");
		frame.setBounds(50, 50, 1000, 380);
		
		//panels
		panelNorth = new JPanel();
		panelNorth.setLayout(new GridLayout(0,2));
		panelSouth = new JPanel();
		panelWest = new JPanel();
		panelEast = new JPanel();
		
		//labels and txt field
		lblFirstName = new JLabel("First Name ");
		txtFirstName = new JTextField(20);
		lblSurname = new JLabel("Surname ");
		txtSurname = new JTextField(20);
		
		//buttons
		btnClose = new JButton("Close");
		btnClose.addActionListener(this);
		btnCopy = new JButton("Process Customer");
		btnCopy.addActionListener(this);
		
		//add labels and txt fields to Northpanel
		/*panelNorth.add(lblFirstName);
		panelNorth.add(txtFirstName);
		panelNorth.add(lblSurname);
		panelNorth.add(txtSurname);*/
		textArea = new JTextArea(12, 40);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea1 = new JTextArea(12, 40);
		scrollPane1 = new JScrollPane(textArea1);
		textArea2 = new JTextArea(4, 44);
		scrollPane2 = new JScrollPane(textArea2);
		textArea3 = new JTextArea(4, 44);
		scrollPane3 = new JScrollPane(textArea3);
		//textArea.setEditable(false);
		//add buttons to SouthPanel
		panelNorth.add(scrollPane);
		panelNorth.add(scrollPane1);
		panelWest.add(scrollPane2);
		panelEast.add(scrollPane3);
		panelSouth.add(btnClose);
		panelSouth.add(btnCopy);
		
		//add panels to frame
		frame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		frame.getContentPane().add(panelWest, BorderLayout.WEST);
		frame.getContentPane().add(panelEast, BorderLayout.EAST);
		frame.setVisible(true);
		this.m = m;
		//m.initialiseData();
	}

	public void actionPerformed(ActionEvent e) {
		//Manager m = new Manager();
		//m.initialiseData();
		if(e.getSource() == btnClose) {
			System.exit(0);
		}

		if(e.getSource() == btnCopy) {
			m.initialiseWorkers();
			m.findWorker(0).processOneCustomer();
			String string1 = "Customers in Queue\n"+m.getCustQ().getQueueString();
			String text = string1;
			textArea.setText(text);
			if(m.findWorker(0).getCurrentCust().isInQueue()) {
				//the quantity of the current customer being processed
				int custQuant = m.findWorker(0).getCurrentCust().getQuantity();
				//the pid of the current customer being processed
				String pid = m.findWorker(0).getCurrentCust().getpId();
				//gets the quantity of the parcel current customer wants
				int cpuQuant=m.getAllCPUs().findParcel(pid).getQuantity();
				int stockCalc = cpuQuant-custQuant;
				//there isnt enough stock in the warehouse of that CPU
				if(stockCalc < 0) {
					String string2 = "Warehouse\n"+m.getAllCPUs().listDetails();
					textArea1.setText(string2);
					String string3 = "Worker 1\nOrder "+m.findWorker(0).getCurrentCust().getqNum()+" Customer "+m.findWorker(0).getCurrentCust().getName();
					textArea2.setText(string3+"\n"+"Not enough in stock");
					m.writeFile("Worker 1: Order "+m.findWorker(0).getCurrentCust().getqNum()+" Customer "+m.findWorker(0).getCurrentCust().getName()+ " Not enough in stock\n");
				}
				//else the stockCalc isnt bellow zero (theres stock in the warehouse)
				else {
					//finds the cpu the customer wants and sets a new CPU quantity for that cpu after the customer orders a set amount
					m.getAllCPUs().findParcel(pid).setQuantity(stockCalc);
					String string2 = "Warehouse\n"+m.getAllCPUs().listDetails();
					textArea1.setText(string2);
					String string3 = "Worker 1\nOrder "+m.findWorker(0).getCurrentCust().getqNum()+" Customer "+m.findWorker(0).getCurrentCust().getName();
					String priceCalc = m.getAllCPUs().findParcel(pid).orderPrice(custQuant);
					String string4 = Integer.toString(custQuant)+" * CPU: "+pid+" = £"+priceCalc;
					textArea2.setText(string3+"\n"+string4);
					m.writeFile("Worker1: Order "+ m.findWorker(0).getCurrentCust().getqNum()+" Customer "+m.findWorker(0).getCurrentCust().getName()+" "+string4+"\n");
				}
			}

			m.initialiseWorkers();
			m.findWorker(1).processOneCustomer();
			String string12 = "Customers in Queue\n"+m.getCustQ().getQueueString();
			String text1 = string12;
			textArea.setText(text1);
			if(m.findWorker(1).getCurrentCust().isInQueue()) {
				//the quantity of the current customer being processed
				int custQuant = m.findWorker(1).getCurrentCust().getQuantity();
				//the pid of the current customer being processed
				String pid = m.findWorker(1).getCurrentCust().getpId();
				//gets the quantity of the parcel current customer wants
				int cpuQuant=m.getAllCPUs().findParcel(pid).getQuantity();
				int stockCalc = cpuQuant-custQuant;
				//there isnt enough stock in the warehouse of that CPU
				if(stockCalc < 0) {
					String string2 = "Warehouse\n"+m.getAllCPUs().listDetails();
					textArea1.setText(string2);
					String string3 = "Worker 1\nOrder "+m.findWorker(1).getCurrentCust().getqNum()+" Customer "+m.findWorker(1).getCurrentCust().getName();
					textArea3.setText(string3+"\n"+"Not enough in stock");
					m.writeFile("Worker 2: Order "+m.findWorker(1).getCurrentCust().getqNum()+" Customer "+m.findWorker(1).getCurrentCust().getName()+ " Not enough in stock\n");
				}
				//else the stockCalc isnt bellow zero (theres stock in the warehouse)
				else {
					//finds the cpu the customer wants and sets a new CPU quantity for that cpu after the customer orders a set amount
					m.getAllCPUs().findParcel(pid).setQuantity(stockCalc);
					String string2 = "Warehouse\n"+m.getAllCPUs().listDetails();
					textArea1.setText(string2);
					String string3 = "Worker 2\nOrder "+m.findWorker(1).getCurrentCust().getqNum()+" Customer "+m.findWorker(1).getCurrentCust().getName();
					String priceCalc = m.getAllCPUs().findParcel(pid).orderPrice(custQuant);
					String string4 = Integer.toString(custQuant)+" * CPU: "+pid+" = £"+priceCalc;
					textArea3.setText(string3+"\n"+string4);
					m.writeFile("Worker2: Order "+ m.findWorker(1).getCurrentCust().getqNum()+" Customer "+m.findWorker(1).getCurrentCust().getName()+" "+string4+"\n");
				}
			}
			
			

		}		
	}
}
