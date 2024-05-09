package a9;

import java.util.Date;

public abstract class WeightLifting extends Exercise{
	private double amtLifted;
	
	public WeightLifting() {
		super();
		amtLifted = 0;
	}
	
	public WeightLifting(Date date, double duration, String comment, double dist) {
		super("Weight Lifting", date, duration, comment);
		this.amtLifted = dist;
	}
	
	public WeightLifting(String date, double duration, String comment, double dist) {
		super("Weight Lifting", date, duration, comment);
		this.amtLifted = dist;
	}
	
	public void setDistance(double dist) {
		this.amtLifted = dist;
	}
	
	public double getDistance() {
		return amtLifted;
	}
	
	@Override
	public String getName() {
		return "Weight Lifting";
	}
	
	@Override
	public double getCaloriesBurned() {
		return amtLifted / super.getDuration() * 50;
	}
}
