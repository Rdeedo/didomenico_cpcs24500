package a9;

public abstract class ExerciseCompareByCalories implements Comparable<Exercise>{
	public int compare(Exercise exercise1, Exercise exercise2) {
		if (exercise1.getCaloriesBurned() > exercise2.getCaloriesBurned()) {
			return 1;
		} else if (exercise1.getCaloriesBurned() < exercise2.getCaloriesBurned()) {
			return -1;
		} else {
			return 0;
		}
		
	}
}
