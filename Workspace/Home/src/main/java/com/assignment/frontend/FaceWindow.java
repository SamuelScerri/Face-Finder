package com.assignment.frontend;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.assignment.backend.FaceInformation;

/*The Face Window class creates the window and renders all the rectangles around the faces,
 * it stores a List with information for faces so that when it needs to paint the window
 * it can loop through the list and draw the rectangles.
 */
public class FaceWindow extends Canvas {
	private static final long serialVersionUID = 1392004622142452014L;
	private final Image image;
	private List<FaceInformation> faceInformationList;
	
	public FaceWindow(String fileName) throws IOException {
		if (fileName == null) throw new IllegalArgumentException("File Name Must Be Equal To String");
		
		//Store the image and automatically make the window as large as the image.
		image = ImageIO.read(new File(fileName));
		setSize(image.getWidth(null), image.getHeight(null));
		
		Frame window = new Frame();
		window.setSize(image.getWidth(null), image.getHeight(null));
		window.setTitle("Face Finder");
		
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.add(this);
		
		window.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e)
            {    
				 window.dispose();    
            }
		});
		
		faceInformationList = new ArrayList<FaceInformation>();
		
		window.setVisible(true);
	}
	
	public void AddFaceInformation(FaceInformation face) {
		if (face == null) throw new IllegalArgumentException("Face Must Be Of Type FaceInformation");
		
		faceInformationList.add(face);
	}
	
	@Override
	public void paint(Graphics g) {		
		g.drawImage(image, 0, 0, null);
		g.setColor(Color.GREEN);
		
		for (FaceInformation face: faceInformationList) {
			g.drawRect(
				face.getPositionX(),
				face.getPositionY(),
				face.getPositionW(),
				face.getPositionH()
			);
		}
	}
	
	public void Refresh() {
		this.repaint();
	}
}
