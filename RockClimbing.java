package a9;

import java.util.Date;

public abstract class RockClimbing extends Exercise{
	private double wallHeight;
	private int timesScaled;
	private String name;
	
	public RockClimbing() {
		super();
		wallHeight = 0;
		timesScaled = 0;
	}
	
	public RockClimbing(Date date, double duration, String comment, double dist, int scaled) {
		super("Rock Climbing", date, duration, comment);
		this.wallHeight = dist;
		timesScaled = scaled;
	}
	
	public RockClimbing(String date, double duration, String comment, double dist, int scaled) {
		super("Rock Climbing", date, duration, comment);
		this.wallHeight = dist;
		timesScaled = scaled;
	}
	
	public void setDistance(double dist) {
		this.wallHeight = dist;
	}
	
	public double getDistance() {
		return wallHeight;
	}
	
	@Override
	public String getName() {
		return "Rock Climbing";
	}
	
	@Override
	public double getCaloriesBurned() {
		return wallHeight * timesScaled / super.getDuration() * 100;
	}

}
