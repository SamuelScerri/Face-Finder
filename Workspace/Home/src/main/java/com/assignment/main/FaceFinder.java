package com.assignment.main;
import java.util.List;

import com.assignment.backend.FaceDetection;
import com.assignment.backend.FaceInformation;
import com.assignment.backend.ImageFinder;
import com.assignment.frontend.FaceWindow;

public class FaceFinder
{
	public static void main(String[] a) throws Exception {
		if (a[0] == null)
			System.err.println("Argument Is Empty! Please Input An Argument Such As: Face, Family Photo, Large Crowd ETC...");
		
		//Find an image and store it as TemporaryImage.jpg
		ImageFinder.writeImageToProject(ImageFinder.ParseImageJSON(ImageFinder.getImage(a[0])));
		
		//Create a List filled with all the face positions found by the Google Vision API
		List<FaceInformation> faceInformationList = FaceDetection.buildFaceInformation("./TemporaryImage.jpg");
		
		//Create a window and add all the faces
		FaceWindow window = new FaceWindow("./TemporaryImage.jpg");
		for (FaceInformation face : faceInformationList) {
			window.AddFaceInformation(face);
		}
		
		//Finally render the window
		window.Refresh();
	}
}