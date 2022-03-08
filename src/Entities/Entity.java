package Entities;

import java.util.LinkedList;

import Physics.Physics;

public abstract class Entity {
	/*
		Class Entity defines any object in space that has a mass and some velocity.
	*/

	public double mass; // Mass in kg
	  public double[] velocity; // Velocity in km/sec
	  public double[] position; // Position in AU
	  public int[] size;
	  public String name;
	  public LinkedList<double[]> pathTravelled = new LinkedList<double[]>();
	  long lenOfTrail = 100000000;

	 
	public void setLenOfTrail(int l) {
		this.lenOfTrail = l;
	}
	  
	public void setPos(double x, double y) {
		/* set pos array values */
		this.position[0] = x*Physics.AstronomicalUnit;
		this.position[1] = y*Physics.AstronomicalUnit;
	}

	public void setVel(double x, double y) {
		/* set velocity array values */
		this.velocity[0] = x;
		this.velocity[1] = y;
	}

	public static int[] getScaledPos(double[] posArray) {
		/* Given pos in Astronomical Units, get pos in pixels */
		int len = posArray.length;
		int[] newPos = new int[len];
		for(int i = 0; i < len; i++) {
			newPos[i] = (int) (posArray[i]*Physics.scale);
		}
		return newPos;
	}
	
	public void addPathTravelled(double[] point) {
		// if length of trail > max trail length
		if( this.pathTravelled.size() >= this.lenOfTrail ) {
			this.pathTravelled.poll();
		}
		// add the current point to queue
		double[] tmp_point = new double[2];
		tmp_point[0] = point[0]; tmp_point[1] = point[1];
		this.pathTravelled.offer(point);
		System.out.println("ENTITY: "+this.pathTravelled.size());
	}

}
