package sd;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class wealthBuilder extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] string = {"Stocks","Bonds","Mutual Funds"}; 
	JList<String> stockList = new JList<>(string);
	Button Plot;
    JPanel choicePanel;
    MultiChoice mchoice;
    choiceFactory cfact;
    
    public wealthBuilder() {
		// TODO Auto-generated constructor stub
    	super("Wealth Builder"); //frame title bar 
//		buildStockLists(); //create stock lists 
		this.setSize(400, 300);
        this.setLocation(200, 200);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setGUI(); //set up display
		
		cfact=new choiceFactory(); //the factory
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Vector<Object> GetPackedVector(String key){
		Vector<Object> vector;
		if (key.equals("Stocks")) {
			vector = new Vector<>();
			vector.addElement("Cisco");
			vector.addElement("Coca Cola");
			vector.addElement("General Electric");
			vector.addElement("Harley Davidson");
			vector.addElement("IBM");
			vector.addElement("Harley Davidson");
			return vector;
		}else if(key.equals("Bonds")){
			vector = new Vector<>();
			vector.addElement("CT State GO 2012");
			vector.addElement("NEW YORK GO 2005");
			vector.addElement("GE corp bonds");
			return vector;
		}else if(key.equals("Mutual Funds")){
			vector = new Vector<>();
			vector.addElement("RNG");
			vector.addElement("EDG");
			vector.addElement("都是菜鸡");
			vector.addElement("至于IG");
			vector.addElement("大哥说了：莽夫才有未来");
			return vector;
		}else {
			vector = new Vector<>();
			vector.addElement("DEFAULT");
			vector.addElement("DEFAULT");
			vector.addElement("DEFAULT");
			return vector;
		}
	}
	
	private void setGUI() {
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		add("Center", p);
		//center contains left and right panels
		p.setLayout(new GridLayout(1,2));
		//left is list of stocks
		//Plot button along bottom of display
		JPanel p1 = new JPanel();
		p1.setBackground(Color.lightGray);
		add("South", p1);
		Plot = new Button("Plot");
		Plot.setEnabled(false);
		//disabled until stock picked
		Plot.addActionListener(this);
		p1.add(Plot);
		//right is empty at first
		choicePanel = new JPanel();
		choicePanel.setBackground(Color.lightGray);
		p.add(stockList);
		p.add(choicePanel);
		p.updateUI();
		stockList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(stockList.getSelectedValue().toString());
				Vector<Object> vector = GetPackedVector(stockList.getSelectedValue().toString());
				mchoice = cfact.getChoiceUI(vector);
				choicePanel.removeAll();
				choicePanel.repaint();
				choicePanel.add(mchoice.getUI());
				choicePanel.validate();
				Plot.setEnabled(true);
				
			}
		});

	}
	
	public static void main(String args[]){
		new wealthBuilder();
	}
}
