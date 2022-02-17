package Physics;

public class Physics {

	private static double univGravConst = 6.67408e-11;

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

	public static double[] newVel(double ux, double uy, double[] force, double mass, double t) {
		/* v = u+at */
		double ax = force[0]/mass;
		double ay = force[1]/mass;
		double vx = ux + ax*t;
		double vy = uy + ay*t;
		double[] vel = {vx,vy};
		return vel;
	}

	public static double[] newPos(double ux, double uy, double vx, double vy, double[] force, double mass) {
		/* v2 - u2 = 2as */
		double ax = force[0]/mass;
		double ay = force[1]/mass;
		double sx = (Math.pow(vx, 2) - Math.pow(ux, 2))/(2*ax);
		double sy = (Math.pow(vy, 2) - Math.pow(uy, 2))/(2*ay);
		double s[] = {sx,sy};
		return s;
	}

	public static double getSphereMass(double radius, double density) {
		return (4/3)*Math.PI*Math.pow(radius,3)*density;
	}

	public static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
	}

	public static double getAngle(double x1, double y1, double x2, double y2) {
		return Math.atan((y2-y1)/(x2-x1));
	}
}
