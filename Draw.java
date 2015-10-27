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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class Draw extends JPanel {
	//data structures to draw edges
	private Map<Integer,Edge> edges = new HashMap<Integer, Edge>();
	private ArrayList<Edge> dEdges = new ArrayList<Edge>();
	double latDistance, lonDistance, lonMax, latMin, wlat, wlon, vlat, vlon;
	Edge drawLine;
	Shape line;
	
	 //adds edges to graph, scaling properly according to latitude and longitude of values from file
	 public void implementEdges(Map<Integer,Edge> map, double maxLat, double minLat, double maxLon, double minLon) {
		
		latDistance = Math.abs(maxLat - minLat);
		lonDistance = Math.abs(maxLon - minLon);
		latMin = Math.abs(minLat);
		lonMax = Math.abs(maxLon);
		edges.putAll(map);
		
	    repaint();
	 }
	 //draws the values of dijkstra/kruskal on top of map
	 public void drawtheD(Map<Integer,Edge> map,ArrayList<Edge> e, double maxLat, double minLat, double maxLon, double minLon){
		    
		 latDistance = Math.abs(maxLat - minLat);
		 lonDistance = Math.abs(maxLon - minLon);
		 latMin = Math.abs(minLat);
		 lonMax = Math.abs(maxLon);
		 edges.putAll(map);
		 dEdges.addAll(e);
		 repaint();
	 }
	 public void paintComponent(Graphics graphics) {
		 	Graphics2D g2 = (Graphics2D) graphics;
	        super.paintComponent(graphics);

	        //width and height of screen
	         int width = getHeight();
	         int height = getWidth();
	       
	        
	        //set background to black
	        this.setBackground(Color.BLACK);
	        //draws the map
	        for(int i = 0; i < edges.size(); i++){
	        	graphics.setColor(Color.WHITE);
	            line = new Line2D.Double(height -(1-(((edges.get(i).v.longitude + lonMax) * (height / lonDistance)))),
	            		(width-((edges.get(i).v.latitude - latMin) * (width / latDistance))), 
	            		(height-(1-((edges.get(i).w.longitude + lonMax) * (height / lonDistance)))),
	            		(width-((edges.get(i).w.latitude - latMin) * (width / latDistance))));
	            g2.draw(line);
	        }
	        //draws the edges for kruskals/dijkstra
	        if(dEdges.size()!=0){
	        	g2.setColor(Color.RED);
	        	for(int j=0;j<dEdges.size();j++){
	        		line = new Line2D.Double(height -(1-(((dEdges.get(j).v.longitude + lonMax) * (height / lonDistance)))),
            		(width-((dEdges.get(j).v.latitude - latMin) * (width / latDistance))), 
            		(height-(1-((dEdges.get(j).w.longitude + lonMax) * (height / lonDistance)))),
            		(width-((dEdges.get(j).w.latitude - latMin) * (width / latDistance))));
	        	g2.draw(line);
	        		}
	        }
	 }
}