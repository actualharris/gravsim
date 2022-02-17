package Physics;

public class Physics {

	private static double univGravConst = 6.67408e-11;

	public static double[] gravForce(double m1, double m2, double x1, double y1, double x2, double y2) {
		/* F = Gmm/r^2 */ 
		double force = (univGravConst*m1*m2)/Math.pow(getDistance(x1,y1,x2,y2), 2);
		double angle = getAngle(x1,y1,x2,y2);
		double[] ret_array = {force,angle};
		return ret_array;
	}

	public static double[] newVel(double ux, double uy, double theta, double force, double mass, double t) {
		/* v = u+at */
		double a = force/mass;
		double vx = ux + a*Math.cos(theta)*t;
		double vy = uy + a*Math.sin(theta)*t;
		double[] vel = {vx,vy};
		return vel;
	}

	public static double[] newPos(double ux, double uy, double theta, double force, double mass, double t) {
		/* s = ut + 0.5 at^2 */
		double a = force/mass;
		double sx = ux*t + 0.5 * (a*Math.cos(theta)) * Math.pow(t, 2);
		double sy = uy*t + 0.5 * (a*Math.sin(theta)) * Math.pow(t, 2);
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
