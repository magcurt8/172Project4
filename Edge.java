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
public class Edge implements Comparable<Edge>{
	String name;
	Vertex v, w;
	double weight;
	
	public Edge(Vertex v, Vertex w){
		this.v = new Vertex(v.vNum, v.name, v.latitude, v.longitude);
		this.w = new Vertex(w.vNum, w.name, w.latitude, w.longitude);
		this.weight = weight(v.latitude, v.longitude, w.latitude, w.longitude);
	}
	//haversine formula: http://andrew.hedges.name/experiments/haversine/
	private double weight(double vlat, double vlon, double wlat, double wlon){
		//displacement of longitude and latitude
		double displacementLatitude = Math.toRadians(wlat - vlat);
		double displacementLongitude = Math.toRadians(wlon - vlon);
		vlat = Math.toRadians(vlat);
		wlat = Math.toRadians(wlat);
		//the earths radius in miles
		double earthRadius = 3961;
		//haversine formula
		double a = Math.pow((Math.sin(displacementLatitude/2)),2) + Math.cos(vlat) * Math.cos(wlat) * Math.pow(Math.sin(displacementLongitude/2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		//distance in miles traveled
		double distance = earthRadius * c;
		
		return distance;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	//comparator for collections.sort implementation
	public int compareTo(Edge e) {
		
		if(this.weight == e.weight)
			return 0;
		else if(this.weight < e.weight)
			return -1;
		else if(this.weight > e.weight)
			return 1;
		return 0;
	}
	
}

