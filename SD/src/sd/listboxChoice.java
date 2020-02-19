package sd;

import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class listboxChoice extends MultiChoice{
	
	JPanel panel;
	@SuppressWarnings("rawtypes")
	JList list;
	
	public listboxChoice(Vector<?> choiceList) {
		super(choiceList);
		// TODO Auto-generated constructor stub
		panel = new JPanel();
		list = new JList<>();
	}

	@Override
	public JPanel getUI() {
		// TODO Auto-generated method stub
		String text[] = new String[choices.size()];
		for(int i = 0;i<choices.size();i++){
			text[i] = choices.get(i).toString();
		}
		list = new JList<>(text);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		panel.add(list);
		return panel;
	}

	@Override
	public String[] getSelected() {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 0;i<list.getModel().getSize();i++){
			if (list.isSelectedIndex(i)) {
				count++;
			}
		}
		String selectedlist[] = new String[count];
		int ctr = 0;
		for(int i = 0;i<list.getModel().getSize();i++){
			if (list.isSelectedIndex(i)) {
				selectedlist[ctr] = list.getModel().getElementAt(i).toString();
				ctr++;
			}
		}
		return selectedlist;
	}

	@Override
	public void clearAll() {
		// TODO Auto-generated method stub
		
	}

}
