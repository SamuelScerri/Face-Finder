package com.assignment.backend;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.protobuf.ByteString;

//The Face Detection class returns the information of all the face positions found by the Google Vision API
public class FaceDetection {
	
	//This will return all the faces given from the requested image using the Google Vision API
	//Reference: https://cloud.google.com/vision/docs/detecting-faces
	public static List<FaceInformation> buildFaceInformation(String fileName) throws Exception {
		
		if (fileName == null) throw new IllegalArgumentException("File Name Must Be Of Type String");
		
		//Load the image information
		List<AnnotateImageRequest> imageRequestList = new ArrayList<AnnotateImageRequest>();
		ByteString imageInformation = ByteString.readFrom(new FileInputStream(fileName));

		//Build image and enable Face Detection
		Image image = Image.newBuilder().setContent(imageInformation).build();
		Feature feature = Feature.newBuilder().setType(Feature.Type.FACE_DETECTION).build();
		AnnotateImageRequest imageRequest = AnnotateImageRequest.newBuilder().addFeatures(feature).setImage(image).build();

		imageRequestList.add(imageRequest);

		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(imageRequestList);
			List<AnnotateImageResponse> responseList = response.getResponsesList();

			for (AnnotateImageResponse imageResponse : responseList) {
				if (imageResponse.hasError())
				{
					System.err.println("Image Annotation Error: " + imageResponse.getError().getMessage());
					throw new Exception("Image Annotation Error, Please Try Again");
				}
					

				//Initialize the Face Information list
				List<FaceInformation> faceInformationList = new ArrayList<FaceInformation>();

				//Add the detected faces in the image requested to the List
				for (FaceAnnotation annotation : imageResponse.getFaceAnnotationsList()) {
					FaceInformation face = new FaceInformation(annotation.getBoundingPoly(),
							annotation.getAngerLikelihood(), annotation.getJoyLikelihood(),
							annotation.getSurpriseLikelihood());
					faceInformationList.add(face);
				}

				return faceInformationList;
			}
		}
		return null;
	}
}