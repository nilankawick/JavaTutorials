
public class App {

	public static void main(String[] args) {
		
		// Using constructor that takes in no arguments
		UrlLibrary urlSet = new UrlLibrary();
		System.out.println(urlSet);
		urlSet.addURL("http://www.bbc.com");
		System.out.println(urlSet);
		System.out.println("");
		System.out.println("Iterating through URLs");
		
		for(String url:urlSet){
			System.out.println(url.length());
			//System.out.println(url);
			System.out.println("");
		}
	}
	
	
}
