package Physics;

public class Physics {
	/*
		Class to handle all physics of the world.
		Contains methods to find force, distance and velocity updates
	*/

	/* Universal Gravitation Constant */
	private static double univGravConst = 6.67408e-11;

	/*
		Method to calculate the gravitational force
		exerted by object of mass m1 (pos x1,y1)
		on object of mass m2 (pos x2,y2)

		Returns array of doubles: [x component of force, y component of force]
	*/
	public static double[] gravForce(double m1, double m2, double x1, double y1, double x2, double y2) {
		/* F = Gmm/r^2 */
		/* Returns x and y components of effectivve force between objects */
		double force = (univGravConst*m1*m2)/Math.pow(getDistance(x1,y1,x2,y2), 2);
		double angle = getAngle(x1,y1,x2,y2);
		double force_x = force*Math.cos(angle);
		double force_y = force*Math.sin(angle);
		double[] ret_array = {force_x,force_y};
		return ret_array;
	}

	/*
		Given the force acting, mass of object (mass), initial x and y velocities (ux,uy) and the time passed (t)
		Calculates the updated velocity of the object (vx,vy)
		Returns a tuple of doubles [vx, vy]
	*/
	public static double[] newVel(double ux, double uy, double[] force, double mass, double t) {
		/* v = u+at */
		double ax = force[0]/mass;
		double ay = force[1]/mass;
		double vx = ux + ax*t;
		double vy = uy + ay*t;
		double[] vel = {vx,vy};
		return vel;
	}

	/*
		Given the force acting, mass of object (mass), initial x and y velocities (ux,uy) and final x and y velocities (vx, vy)
		Calculates the updated position of the object (sx,sy)
		Returns a tuple of doubles [sx, sy]
	*/
	public static double[] newPos(double ux, double uy, double vx, double vy, double[] force, double mass) {
		/* v2 - u2 = 2as */
		double ax = force[0]/mass;
		double ay = force[1]/mass;
		double sx = (Math.pow(vx, 2) - Math.pow(ux, 2))/(2*ax);
		double sy = (Math.pow(vy, 2) - Math.pow(uy, 2))/(2*ay);
		double s[] = {sx,sy};
		return s;
	}

	/*
		Given radius and density of a sphere, calculates mass.
		Returns a double
	*/
	public static double getSphereMass(double radius, double density) {
		return (4/3)*Math.PI*Math.pow(radius,3)*density;
	}

	/*
		Given two points in a 2D plane, returns distance between them
		Returns: double
	*/
	public static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
	}

	/*
		Given two points in a 2D plane, get angle between line passing through the two points
		and the x axis in RADIANS
		Returns: double
	*/
	public static double getAngle(double x1, double y1, double x2, double y2) {
		return Math.atan((y2-y1)/(x2-x1));
	}
	
	/*
	 	Given
	*/
	public static double[] getComponents(double a, double tan) {
		double[] components = new double[2];
		double angle = Math.atan(tan);
		components[0] = Math.cos(angle) * a;
		components[1] = Math.sin(angle) * a;
		return components;
	}
}
