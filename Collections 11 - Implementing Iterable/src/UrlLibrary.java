import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Iterable interface has one method
 * 
 * --> the Iterator method
 * by default collections has Iterable wrapped around 
 * which allows you to iterate through the collection
 * 
 * but if you want to customize then, the Iterator interface needs to be implemented
 * and the methods within the same interface needs to be overridden
 * 
 * 
 */
public class UrlLibrary implements Iterable<String> {

	private LinkedList<String> urls = new LinkedList<String>();

	/*
	 * Two constructors
	 * 1. Constructor that takes in an argument --> a linked List
	 * 2. No param constructor in which we add some items to the list
	 * 
	 */
	public UrlLibrary(LinkedList<String> url) {

		this.urls = url;
	}

	public UrlLibrary() {
		this.urls.add("http://www.cnn.com");
		this.urls.add("http://www.xhamster.com");
		this.urls.add("http://www.google.com");

	}

	/*
	 * 
	 * Using a toString to print out the elements of the list
	 */
	@Override
	public String toString() {
		return "UrlLibrary [url=" + urls + "]";
	}

	/*
	 * Getters and setters since ArrayList is  defined as private PRIVATE
	 * but please note that we can only pass in ArrayList not 
	 * elements to be added into the ArrayList
	 * 
	 * to do this we have created a custom Method --> addURL
	 * with this u can pass in a string and it will be appended to the existing ArrayList
	 */
	public LinkedList<String> getUrl() {
		return urls;
	}

	public void setUrl(LinkedList<String> url) {
		this.urls = url;
	}

	public void addURL(String url) {
		this.urls.add(url);
	}

	// Implementing Basic Iterator//
	/*
	 * We can use the default iterator that is implemented in all collections.
	 * which will go through each element of a List or Collection
	 * 
	 * you will see a custom iterator towards the later part of the code
	 */
	
	
	/*
	 * @Override 
	 * public Iterator<String> iterator() 
	 * { 
	 * return this.urls.iterator(); 
	 * }
	 */

	////////// Implementing Custom Iterator //////////////
	/**/
	@Override
	public Iterator<String> iterator() {

		/*
		 * Using your custom iterator to iterate as defined by you
		 * remove comments and execute
		 */
		return new UrlIterator();
	}

	////// Using an Inner class to define how to iterate and what to return//////
	/*
	 * Key notes on inner class
	 */
	private class UrlIterator implements Iterator<String> {
		
		private int index = 0;
		
		
		
		@Override
		public boolean hasNext() {
			return index < urls.size();
			
		}

		@Override
		public String next() {
		
		/*
		 * Simple custom iteration pattern
		 * iterate every other element
		 * 
		 * remove comment and execute
		 */
		/*
		String val =  urls.get(index); 
		index = index +2;
		return val;
		*/
			
		/*
		 * Advance iterating pattern with  customized return
		 */
			StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urls.get(index));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			
			String line = null;
			
			while ((line = br.readLine()) != null){
				sb.append(line);
				sb.append("\n");
			}
			br.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
			index++;
			return sb.toString();
		}
		
		@Override
		public void remove(){
			urls.remove(index);
		}
		
		

	}

}
