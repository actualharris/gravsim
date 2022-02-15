package Assets;

public abstract class object {
	private double mass;     			// one double - mass of rocket
	private double volume;   			// one double - volume of rocket
	private double velocity; 			// array of 3 doubles - vx,vy,vz
	private double pos;      			// array of 3 doubles - sx,sy,sz
	private double max_acceleration; 	// one double - maximum acceleration of a rocket
	
	public void set_pos(double x, double y, double z) {
		/* set pos array values */
	}
	
	public void set_vel(double x, double y, double z) {
		/* set velocity array values */
	}
	
	public void update_vel(double x, double y, double z) {
		/* update velocity values using equations of motion */
		/* call set_vel in the end to update values of instance */
	}
}
