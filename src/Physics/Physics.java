package Physics;

public class Physics {
	/*
		Class to handle all physics of the world.
		Contains methods to find force, distance and velocity updates
	*/

	/* Universal Gravitation Constant */
	private static double univGravConst = 6.67408e-11;
	public static double AstronomicalUnit = 149.6e6 * 1000;
	private static double timestep = 3600 * 24; // 1 day
	public static double scale = 250/AstronomicalUnit;

	/*
		Method to calculate the gravitational force
		exerted by object of mass m1 (pos x1,y1)
		on object of mass m2 (pos x2,y2)

		Returns array of doubles: [x component of force, y component of force]
	*/
	public static double[] gravForce(double m1, double m2, double[] pos1, double[] pos2) {
		/* F = Gmm/r^2 */
		/* Returns x and y components of effectivve force between objects */
		double dist = getDistance(pos1,pos2);
  	double force = (univGravConst*m1*m2)/Math.pow(dist, 2);
  	double theta = getAngle(pos1,pos2);
  	double force_x = Math.cos(theta)*force;
  	double force_y = Math.sin(theta)*force;
    double[] ret_array = new double[] {force_x,force_y};
    return ret_array;
	}

	public static double newVel(double force, double mass) {
		/* Calculate velocity from force and mass */
		return force / mass * timestep;
	}

	public static double newPos(double v) {
		/* Calculates position given velocity */
		return v * timestep;
	}

	public static double getDistance(double[] pos1, double[] pos2) {
		/*
			Given two points in a 2D plane, returns distance between them
			Returns: double
		*/
		return Math.sqrt(Math.pow(pos2[0]-pos1[0],2)+Math.pow(pos2[1]-pos1[1],2));
	}

	public static double getAngle(double[] pos1, double[] pos2) {
		/*
			Given two points in a 2D plane, get angle between line passing through the two points
			and the x axis in RADIANS
			Returns: double
		*/
		return Math.atan2((pos2[1] - pos1[1]),(pos2[0] - pos1[0]));
	}

	public static double getAngle(double v1, double v2) {
		if (v1 == 0) {
			return Math.PI/2;
		}
		return Math.atan2(v2,v1);
	}

	public static double[] getComponents(double val, double angle) {
		/*
		 	Given a vector and the angle it makes with x axis,
			Returns the x and y components of the vector
		*/
		double[] components = new double[2];
    components[0] = Math.cos(angle)*val;
    components[1] = Math.sin(angle)*val;
    return components;
	}
	
}
