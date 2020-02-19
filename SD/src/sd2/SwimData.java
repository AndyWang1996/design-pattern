package sd2;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class SwimData implements Cloneable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<Swimmer> swimmers;
	
	public Object clone() {
		try{return super.clone();} 
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Object cloneMe() {
		try{return (SwimData)super.clone();} 
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean ForM(String G){
		if (getClass().equals("male")) {
			return true;
		}else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public SwimData() throws IOException{
		swimmers = new Vector<Swimmer>();
		File file = new File("swimmerdata.txt");
		InputStreamReader in = new InputStreamReader(new FileInputStream(file));
		BufferedReader br = new BufferedReader(in);
		while (br.readLine() != null){
			Swimmer tempswimmer = new Swimmer();
			tempswimmer.setName(br.readLine());
			tempswimmer.setAge(Integer.parseInt(br.readLine()));
			tempswimmer.setClub(br.readLine());
			tempswimmer.setTime(Float.parseFloat(br.readLine()));
			tempswimmer.setGender(ForM(br.readLine()));
			swimmers.add(tempswimmer);
		}
		br.close();
		System.out.print("The original  :");
		for(int i = 0;i<swimmers.size();i++){
			System.out.print(swimmers.get(i).getName() + "|");
		}
		
		System.out.println("");
		
		Vector<Swimmer> swimmers1 = new Vector<Swimmer>();
		swimmers1 = (Vector<Swimmer>) swimmers.clone();
		Vector<Swimmer> swimmers2 = new Vector<Swimmer>();
		swimmers2 = swimmers;
		
		System.out.print("The deep clone:");
		for(int i = 0;i<swimmers1.size();i++){
			System.out.print(swimmers1.get(i).getName() + "|");
		}
		
		System.out.println("");
		System.out.print("The      clone:");
		for(int i = 0;i<swimmers2.size();i++){
			System.out.print(swimmers2.get(i).getName() + "|");
		}
		
		swimmers.remove(0);
		System.out.println("");
		System.out.println("________________________________________");
		System.out.println("we remove the first element of swimmers:");
		System.out.println("");
		
		System.out.print("The original  :");
		for(int i = 0;i<swimmers.size();i++){
			System.out.print(swimmers.get(i).getName() + "|");
		}
		
		System.out.println("");
		System.out.print("The deep clone:");
		for(int i = 0;i<swimmers1.size();i++){
			System.out.print(swimmers1.get(i).getName() + "|");
		}
		
		System.out.println("");
		System.out.print("The      clone:");
		for(int i = 0;i<swimmers2.size();i++){
			System.out.print(swimmers2.get(i).getName() + "|");
		}
		
	}
	
	public static Vector<Swimmer> DeepClone(Vector<Swimmer> swimmer){
		Vector<Swimmer> aSwimmers = SwimData.DeepClone(swimmer);
		return aSwimmers;
	}
	
	public static void main(String args[]){
		try {
			new SwimData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
