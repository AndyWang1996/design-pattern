package sd2;

public class Swimmer {
	String name;
	int age;
	String club;
	float time;
	boolean gender;
	
	public Swimmer(){
		this.name = null;
		this.age = 0;
		this.club = null;
		this.time = 0;
		this.gender = true;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public String getClub(){
		return club;
	}
	
	public void setClub(String club){
		this.club = club;
	}
	
	public float getTime(){
		return time;
	}
	
	public void setTime(float time){
		this.time = time;
	}
	
	public boolean getGender(){
		return gender;
	}
	
	public void setGender(boolean gender){
		this.gender = gender;
	}

	public Swimmer DeepClone(){
		Swimmer clone = new Swimmer();
		clone.setAge(age);
		clone.setClub(club);
		clone.setGender(gender);
		clone.setName(name);
		clone.setTime(time);
		return clone;
	}
}
