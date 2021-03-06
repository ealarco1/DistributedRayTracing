package math;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Vector implements Serializable {
	
	public double x, y, z;
	
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	public double magnitudeSquared(){
		return (x * x + y * y + z * z);
	}
	
	public void normalize() {
		double length = magnitude();
		x /= length;
		y /= length;
		z /= length;
	}
	
	public Vector normalized() {
		double length = magnitude();
		return new Vector(x / length, y / length, z / length);
	}
	
	public Vector add(Vector v) {
		return new Vector(x + v.x, y + v.y, z + v.z);
	}
	
	public Vector multiply(double scalar) {
		return new Vector(scalar * x, scalar * y, scalar * z);
	}
	
	public Vector substract(Vector v) {
		return new Vector(x - v.x, y - v.y, z - v.z);
	}
	
	public double dot(Vector v) {
		return x * v.x + y * v.y + z * v.z;
	}
	
	public Vector cross(Vector v) {
		double newX = (y * v.z) - (z * v.y);
		double newY = (x * v.z) - (z * v.x);
		double newZ = (x * v.y) - (y * v.x);
		return new Vector(newX, -newY, newZ);
	}
	
	public boolean equals(Vector v){
		boolean eq = true;
		for (int i = 0; i < 3; i++) if (this.getComponents()[i] != v.getComponents()[i]) eq = false;
		return eq;
	}
	
	public boolean geq(Vector v){
		boolean geq = true;
		for (int i = 0; i < 3; i++) if (this.getComponents()[i] < v.getComponents()[i]) geq = false;
		return geq;
	}
	
	public boolean leq(Vector v){
		boolean leq = true;
		for (int i = 0; i < 3; i++) if (this.getComponents()[i] > v.getComponents()[i]) leq = false;
		return leq;
	}
	
	public double[] getComponents() {
		double components[] = {x, y, z};
		return components;
	}
	
	public String toString() {
		return "Vector(" + x + ", " + y + ", " + z + ")";
	}

}
