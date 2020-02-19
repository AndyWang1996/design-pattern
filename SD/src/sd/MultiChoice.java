package sd;

import java.util.Vector;

import javax.swing.JPanel;

public abstract class MultiChoice {
	Vector<?> choices;
	public MultiChoice(Vector<?> choiceList){
		choices = choiceList;
	}
	
	//to be implemented in derived classes
	abstract public JPanel getUI();
	//return a Panel of components
	abstract public String[] getSelected();
	//get list of items
	abstract public void clearAll();
	//clear selections

}
