package com.assignment.backend;
import com.google.cloud.vision.v1.BoundingPoly;
import com.google.cloud.vision.v1.Likelihood;

/*The Face Information class holds all the information for the position of the faces,
 * the angry, happy and surprised variables aren't used for now, but extra features could be easily implemented
 * later on.
 */
public class FaceInformation {
	private final BoundingPoly position;
	
	/*private final Likelihood angry;
	private final Likelihood happy;
	private final Likelihood surprised;*/

	public FaceInformation(BoundingPoly position, Likelihood angry, Likelihood happy, Likelihood surprised) {
		if (position == null) throw new IllegalArgumentException("Position Must Be Of Type BoundingPoly");
		
		this.position = position;
		/*this.angry = angry;
		this.happy = happy;
		this.surprised = surprised;*/
	}

	private BoundingPoly getPosition() {
		return position;
	}
	
	public int getPositionX() { return this.getPosition().getVertices(0).getX(); }
	public int getPositionY() { return this.getPosition().getVertices(1).getY(); }
	
	//The width of the bounding box is returned by subtracting the bottom points with the top points
	public int getPositionW() { return this.getPosition().getVertices(2).getX() - this.getPositionX(); }
	public int getPositionH() { return this.getPosition().getVertices(3).getY() - this.getPositionY(); }
	
	public boolean getAngerState() {
		return true;
	}
	
	public boolean getHappyState() {
		return true;
	}
	
	public boolean getSurprisedState() {
		return true;
	}
}