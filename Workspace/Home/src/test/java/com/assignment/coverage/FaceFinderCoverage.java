package com.assignment.coverage;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import com.assignment.backend.FaceDetection;
import com.assignment.backend.FaceInformation;
import com.assignment.backend.ImageFinder;


public class FaceFinderCoverage {
	public String jsonError = "";
	public String jsonCorrect = "{\"_type\":\"images\",\"totalCount\":1080,\"value\":[{\"url\":\"https://image.freepik.com/free-vector/crowd-speech-bubble-sign-isometric-concept_98292-108.jpg?1\",\"height\":626,\"width\":626,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=6632060576885327311\",\"thumbnailHeight\":156,\"thumbnailWidth\":156,\"base64Encoding\":null,\"name\":\"\",\"title\":\"Crowd | Free Vectors, Stock Photos & PSD\",\"provider\":{\"name\":\"freepik\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://www.freepik.com/free-photos-vectors/crowd\"},{\"url\":\"https://dentistry.co.uk/wp-content/uploads/2021/03/Crowd.png\",\"height\":300,\"width\":300,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=1537013100431868267\",\"thumbnailHeight\":300,\"thumbnailWidth\":300,\"base64Encoding\":null,\"name\":\"\",\"title\":\"Crowd - Dentistry.co.uk\",\"provider\":{\"name\":\"dentistry\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://dentistry.co.uk/shows/online-cpd-dentistry-show/ecpd-show-event-apply/crowd/\"},{\"url\":\"https://pragativadi.com/wp-content/uploads/2022/03/BCCI-To-Allow-25-Percent-Capacity-Of-Crowd-In-Stadiums.jpg\",\"height\":563,\"width\":750,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=1901124182263597815\",\"thumbnailHeight\":157,\"thumbnailWidth\":209,\"base64Encoding\":null,\"name\":\"\",\"title\":\"IPL 2022: BCCI To Allow 25 % Capacity Of Crowd In Stadiums - Pragativadi\",\"provider\":{\"name\":\"pragativadi\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://pragativadi.com/ipl-2022-bcci-to-allow-25-capacity-of-crowd-in-stadiums/\"},{\"url\":\"https://outsider.com/wp-content/uploads/2022/03/nascar-william-byron-gets-crowd-going-atlanta-motor-speedway-after-second-win-two-days.jpg\",\"height\":780,\"width\":1300,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=3369228625833774266\",\"thumbnailHeight\":48,\"thumbnailWidth\":80,\"base64Encoding\":null,\"name\":\"\",\"title\":\"NASCAR: William Byron Gets Crowd Going After Second Win in Two Days\",\"provider\":{\"name\":\"outsider\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://outsider.com/sports/nascar/nascar-william-byron-gets-crowd-going-atlanta-motor-speedway-after-second-win-two-days/\"},{\"url\":\"https://cdnph.upi.com/ph/st/th/6751647780454/2022/upi_com/8771527cbf7c203fb64c2985f17ac580/v1.5/Six-killed-after-car-drives-into-crowd-preparing-for-parade-in-Belgium.jpg?lg=5\",\"height\":800,\"width\":1200,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=5254876090744899447\",\"thumbnailHeight\":130,\"thumbnailWidth\":196,\"base64Encoding\":null,\"name\":\"\",\"title\":\"Six killed after car drives into crowd preparing for parade in Belgium - UPI.com\",\"provider\":{\"name\":\"upi\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://www.upi.com/Top_News/World-News/2022/03/20/Six-killed-after-car-drives-into-crowd-preparing-for-parade-in-Belgium/6751647780454/\"},{\"url\":\"https://ca-times.brightspotcdn.com/dims4/default/87bdd9a/2147483647/strip/true/crop/5472x2873+0+388/resize/1200x630!/quality/90/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F01%2F54%2F5e54f2194b82bc1f024ccbadaf1d%2Ftn-dpt-soc-the-crowd-20220319-1.jpg\",\"height\":630,\"width\":1200,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=8186109158943718491\",\"thumbnailHeight\":117,\"thumbnailWidth\":222,\"base64Encoding\":null,\"name\":\"\",\"title\":\"The Crowd: Culinary arts scholarships focus of Table for 10 held in Laguna Beach - Los Angeles Times\",\"provider\":{\"name\":\"brightspotcdn\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://www.latimes.com/socal/daily-pilot/opinion/story/2022-03-18/the-crowd-culinary-arts-scholarships-focus-of-table-for-10-held-recently-in-laguna-beach\"},{\"url\":\"https://media2.bollywoodhungama.in/wp-content/uploads/2022/03/Ranveer-Singh-takes-a-penalty-in-socks-during-Premier-League-in-London-leaves-the-crowd-in-splits-1.jpg\",\"height\":450,\"width\":620,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=7960196235876625825\",\"thumbnailHeight\":168,\"thumbnailWidth\":231,\"base64Encoding\":null,\"name\":\"\",\"title\":\"Ranveer Singh takes a penalty in socks during Premier League in London, leaves the crowd in splits : Bollywood News - Bollywood Hungama\",\"provider\":{\"name\":\"bollywoodhungama\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://www.bollywoodhungama.com/news/features/ranveer-singh-takes-penalty-socks-premier-league-london-leaves-crowd-splits/\"},{\"url\":\"https://images.thestar.com/Dbky3tJYtnFZYzQMFWSv9yuXV7o=/1200x776/smart/filters:cb(1647225971317)/https://www.thestar.com/content/dam/thestar/sports/leafs/2022/03/13/cold-what-cold-pro-leafs-crowd-soaks-up-outdoor-game-experience/leafs_crowd.jpg\",\"height\":776,\"width\":1200,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=90289061411760249\",\"thumbnailHeight\":108,\"thumbnailWidth\":167,\"base64Encoding\":null,\"name\":\"\",\"title\":\"Cold? What cold? Pro-Leafs crowd soaks up outdoor experience | The Star\",\"provider\":{\"name\":\"thestar\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://www.thestar.com/sports/leafs/2022/03/13/cold-what-cold-pro-leafs-crowd-soaks-up-outdoor-game-experience.html\"},{\"url\":\"https://www.indy100.com/media-library/nascar-reporter-makes-smooth-save-as-crowd-chant-joe-biden-abuse.jpg?id=29498132&width=1200&coordinates=0%2C54%2C0%2C66&height=600\",\"height\":600,\"width\":1200,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=7471043499439880790\",\"thumbnailHeight\":131,\"thumbnailWidth\":262,\"base64Encoding\":null,\"name\":\"\",\"title\":\"NASCAR reporter makes smooth save as crowd chant Joe Biden abuse on live TV | indy100\",\"provider\":{\"name\":\"indy100\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://www.indy100.com/politics/lets-go-brandon-nascar-biden\"},{\"url\":\"https://npr.brightspotcdn.com/dims4/default/f1f5e27/2147483647/strip/true/crop/2048x1075+0+121/resize/1200x630!/quality/90/?url=http%3A%2F%2Fnpr-brightspot.s3.amazonaws.com%2F89%2F6b%2Fbf98a42b4b16aaaa188f29150ac1%2Fclt-crowd-charlotte-fc-twitter-opener-1.jpg\",\"height\":630,\"width\":1200,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=3118932169607247595\",\"thumbnailHeight\":137,\"thumbnailWidth\":260,\"base64Encoding\":null,\"name\":\"\",\"title\":\"Charlotte FC lost a record-crowd-size home game, but its defense shined, sportswriter says | WFAE 90.7 - Charlotte's NPR News Source\",\"provider\":{\"name\":\"brightspotcdn\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/Crowd/images\",\"webpageUrl\":\"https://www.wfae.org/sports/2022-03-07/charlotte-fc-lost-a-record-crowd-size-home-game-but-its-defense-shined-sportswriter-says\"}]}\n";
	public String jsonPNG = "{\"_type\":\"images\",\"totalCount\":768,\"value\":[{\"url\":\"https://www.perl.com/images/site/perl-onion.png\",\"height\":482,\"width\":482,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=600835269630818155\",\"thumbnailHeight\":241,\"thumbnailWidth\":241,\"base64Encoding\":null,\"name\":\"\",\"title\":\"Png\",\"provider\":{\"name\":\"perl\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/PNG/images\",\"webpageUrl\":\"https://www.perl.com/tags/png/\"},{\"url\":\"https://algorithmia.com/static/images/algo-share-image.1df84db.png\",\"height\":630,\"width\":1200,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=663609871850639167\",\"thumbnailHeight\":472,\"thumbnailWidth\":899,\"base64Encoding\":null,\"name\":\"\",\"title\":\"png Algorithms - Algorithmia\",\"provider\":{\"name\":\"algorithmia\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/PNG/images\",\"webpageUrl\":\"https://algorithmia.com/tags/png\"},{\"url\":\"https://crowd360.org/wp-content/uploads/2016/09/crowd360_image_OG.png\",\"height\":1200,\"width\":1200,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=4903141213202723605\",\"thumbnailHeight\":450,\"thumbnailWidth\":450,\"base64Encoding\":null,\"name\":\"\",\"title\":\"PNG Archives - Crowd 360Crowd 360\",\"provider\":{\"name\":\"crowd360\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/PNG/images\",\"webpageUrl\":\"https://crowd360.org/tag/png/\"},{\"url\":\"http://thelinuxexperiment.com/blog/wp-content/uploads/2009/10/the-linux-experiment-mascot.png\",\"height\":300,\"width\":300,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=624202941595839898\",\"thumbnailHeight\":225,\"thumbnailWidth\":225,\"base64Encoding\":null,\"name\":\"\",\"title\":\"PNG  The Linux Experiment\",\"provider\":{\"name\":\"thelinuxexperiment\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/PNG/images\",\"webpageUrl\":\"https://thelinuxexperiment.com/tag/png/\"},{\"url\":\"https://www.oneindia.com/img/1200x80/2022/03/png-1648093951.jpg\",\"height\":676,\"width\":1200,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=4011556607889373588\",\"thumbnailHeight\":126,\"thumbnailWidth\":223,\"base64Encoding\":null,\"name\":\"\",\"title\":\"PNG Price Hike: Check latest rates across NCR - Oneindia News\",\"provider\":{\"name\":\"oneindia\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/PNG/images\",\"webpageUrl\":\"https://www.oneindia.com/india/png-price-hike-check-latest-rates-across-ncr-3387051.html\"},{\"url\":\"https://static.india.com/wp-content/uploads/2021/10/CNG-PNG-Price.jpg\",\"height\":800,\"width\":1200,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=7314751791021879426\",\"thumbnailHeight\":200,\"thumbnailWidth\":300,\"base64Encoding\":null,\"name\":\"\",\"title\":\"Domestic PNG Price Hike Check Latest Rates In Delhi  Noida Ghaziabad Meerut Karnal Muzaffarnagar Gurugram Ajmer Rajsamand\",\"provider\":{\"name\":\"india\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/PNG/images\",\"webpageUrl\":\"https://www.india.com/business/png-price-hike-check-latest-rates-for-delhi-noida-ghaziabad-meerut-karnal-muzaffarnagar-gurugram-ajmer-rajsamand-5300294/\"},{\"url\":\"https://www.panews.com/wp-content/uploads/sites/35/2021/02/PNG-SoccerWEB.jpg\",\"height\":450,\"width\":800,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=2651891558050280867\",\"thumbnailHeight\":42,\"thumbnailWidth\":74,\"base64Encoding\":null,\"name\":\"\",\"title\":\"Check out playoff details for both PNG soccer teams - Port Arthur News | Port Arthur News\",\"provider\":{\"name\":\"panews\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/PNG/images\",\"webpageUrl\":\"https://www.panews.com/2022/03/21/check-out-playoff-details-for-both-png-soccer-teams/\"},{\"url\":\"https://cdn.mos.cms.futurecdn.net/4knj8f2Ctghk6SgASc6FsL.png\",\"height\":500,\"width\":1000,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=1507870142979619147\",\"thumbnailHeight\":250,\"thumbnailWidth\":500,\"base64Encoding\":null,\"name\":\"\",\"title\":\"How to Convert a PNG to PDF on Windows 11 | Laptop Mag\",\"provider\":{\"name\":\"futurecdn\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/PNG/images\",\"webpageUrl\":\"https://www.laptopmag.com/how-to/how-to-convert-a-png-to-pdf-on-windows-11\"},{\"url\":\"https://static.businessworld.in/article/article_extra_large_image/1645190203_dLCGxt_Saurabh.png\",\"height\":470,\"width\":870,\"thumbnail\":\"https://rapidapi.usearch.com/api/thumbnail/get?value=5730902709971009620\",\"thumbnailHeight\":235,\"thumbnailWidth\":435,\"base64Encoding\":null,\"name\":\"\",\"title\":\"png jewellers a jewellery behemoth in making - BW Businessworld\",\"provider\":{\"name\":\"businessworld\",\"favIcon\":\"\",\"favIconBase64Encoding\":\"\"},\"imageWebSearchUrl\":\"https://usearch.com/search/PNG/images\",\"webpageUrl\":\"https://www.businessworld.in/article/png-jewellers-a-jewellery-behemoth-in-making/18-02-2022-420959\"}]}\n";
	
	@Test
	public void ImageFinderWriteImageToProjectException()
	{
		assertThrows(IllegalArgumentException.class, ()-> ImageFinder.writeImageToProject(null));
	}
	
	@Test
	public void ImageFinderGetImageException()
	{
		assertThrows(IllegalArgumentException.class, ()-> ImageFinder.getImage(null));
	}
	
	@Test
	public void ImageFinderGetImageTest() throws IOException, InterruptedException
	{
		assertTrue(ImageFinder.getImage("Crowd") instanceof String);
	}
	
	@Test
	public void FaceDetectionException()
	{
		assertThrows(IllegalArgumentException.class, ()-> FaceDetection.buildFaceInformation(null));
	}
	
	@Test
	public void ImageFinderParseJsonException()
	{
		assertThrows(IllegalArgumentException.class, ()-> ImageFinder.ParseImageJSON(null));
	}
	
	@Test
	public void ImageFinderParseJsonEmpty() throws MalformedURLException, JSONException, IOException
	{
		assertThrows(org.json.JSONException.class, ()-> ImageFinder.ParseImageJSON(jsonError));
	}
	
	@Test
	public void ImageFinderParseJsonCorrect() throws MalformedURLException, JSONException, IOException
	{
		assertTrue(ImageFinder.ParseImageJSON(jsonCorrect) instanceof BufferedImage);
	}
	
	@Test
	public void FaceDetectionTest() throws Exception
	{
		ImageFinder.writeImageToProject(ImageFinder.ParseImageJSON(ImageFinder.getImage("Crowd")));
		assertTrue(FaceDetection.buildFaceInformation("./TemporaryImage.jpg") instanceof List<?>);
	}
	
	@Test
	public void FaceInformationException()
	{
		assertThrows(IllegalArgumentException.class, ()-> new FaceInformation(null, null, null, null));
	}
	
	@Test
	public void ConnectionFailedScenario()
	{
		assertThrows(ConnectException.class, ()-> ImageFinder.getImage("Crowd"));
	}
}
