package sd;

import java.awt.List;
import java.awt.Panel;
import java.util.Vector;

import javax.swing.JFrame;

public class choiceFactory extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MultiChoice ui;
	List stockList= new List(10);
	Panel choicePanel = new Panel();
	
	public MultiChoice getChoiceUI(Vector<?> choices){
		if(choices.size() <=3)
		ui = new checkboxChoice(choices);
		else
		ui = new listboxChoice(choices);
		return ui;
		}
}
