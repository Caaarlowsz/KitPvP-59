package fr.moderncraft.utils;

import java.util.ArrayList;

import org.bukkit.Location;

public class MapLocation {
	private Cuboid cuboid;
	private ArrayList<Location> teleportPoints;
	
	public MapLocation(Location l1,Location l2){
		cuboid = new Cuboid(l1, l2);
		teleportPoints = new ArrayList<Location>();
	}
	
}
