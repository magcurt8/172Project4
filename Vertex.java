/*
 *Project 4
 *Version 1.0
 *Copyright Margaret M. Curtis
 *CSC 172 Spring 2015
 *MW 5-6:15PM
 *TA: Kate Zeng
 *Partner: Scott Onestak
 *Last Revised: May 4, 2015
 */
import java.util.LinkedList;

public class Vertex {
	
	public int vNum;
	public String name;
	public double latitude, longitude, distance;
	public boolean known;
	public Vertex path;
	public LinkedList<Adjacents> adjacencies;
	//construct vertex
	public Vertex(int vNum, String name, double latitude, double longitude){
		this.vNum = vNum;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		known = false;
		path = null;
		adjacencies = new LinkedList<Adjacents>();
		distance = Double.POSITIVE_INFINITY;
	}
	//add adjacents to adjacencies list
	public void insert(Adjacents a){
		adjacencies.add(a);
	}
	
}

