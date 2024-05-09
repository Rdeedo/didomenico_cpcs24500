package a9;

import java.util.Date;

public abstract class RunWalk extends Exercise{
	private double dist;
	
	public RunWalk() {
		super();
		dist = 0;
	}
	
	public RunWalk(Date date, double duration, String comment, double dist) {
		super("Run / Walk", date, duration, comment);
		this.dist = dist;
	}
	
	public RunWalk(String date, double duration, String comment, double dist) {
		super("Run / Walk", date, duration, comment);
		this.dist = dist;
	}
	
	public void setDistance(double dist) {
		this.dist = dist;
	}
	
	public double getDistance() {
		return dist;
	}
	
	@Override
	public String getName() {
		return "Run / Walk";
	}
	
	@Override
	public double getCaloriesBurned() {
		return dist / super.getDuration() * 9000;
	}
}
