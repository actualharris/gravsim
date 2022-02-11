package Physics;


public class Physics {
	
	public static double univGravConst = 6.67408e-11;
	
	public static double gravForce(double m1, double m2, double dist) {
		double force = (univGravConst*m1*m2)/Math.pow(dist, 2);
		return force;
	}
	
	public static double updateVel() {
		return 0.0;
	}
	
	public static double updatePos() {
		return 0.0;
	}
	
	public static double getSphereMass(double radius, double density) {
		return (4/3)*Math.PI*Math.pow(radius,3)*density;
	}
	
}
