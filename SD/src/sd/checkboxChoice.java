package sd;

import java.awt.Checkbox;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

public class checkboxChoice extends MultiChoice{
	
	JPanel panel;
	int count;
	
	public checkboxChoice(Vector<?> choiceList) {
		super(choiceList);
		// TODO Auto-generated constructor stub
		count = 0;
		panel = new JPanel();
	}

	@Override
	public JPanel getUI() {
		// TODO Auto-generated method stub
		String s;
		//create a grid layout 1 column by n rows
		panel.setLayout(new GridLayout(choices.size(), 1));
		//and add labeled check boxes to it
		for (int i=0; i< choices.size(); i++) {
		s =(String)choices.elementAt(i);
		panel.add(new Checkbox(s));
		count++; }
		return panel;
	}

	@Override
	public String[] getSelected() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearAll() {
		// TODO Auto-generated method stub
		
	}

}
