import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class App {

		public static void main(String[] args) {
			/*
			 * Queue is a mechanism in which you can maintain a controlled and order list based on the 
			 * first in first out mechanism FIFO
			 * 
			 * attributes
			 * - you can define the maximum number of elements that can fit into a queue
			 * - you will always add to the end (referred to as a TAIL in queue)
			 * - when you remove it removes from the beginning (referred to as a HEAD in queue)
			 *  HEAD -> 000000000000 <- TAIL
			 */
			Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(3);
			/*
			 * Queue interface provides several methods to work with queues
			 */
			try{
				
			
			q1.add(10);
			q1.add(13);
			q1.add(2);
			q1.add(5);
			
			
			
			}catch(IllegalStateException e){
				System.out.println("Reached Max in Queue");
				
			}
			
			System.out.println("HEAD - "+q1.element());
			
			System.out.println("");
			System.out.println("Iterating through a queue");
			for(Integer val:q1){
				System.out.println(val);
			}
			
			System.out.println("");
			System.out.println("removing from a queue (FIFO)");
			
			try{
				
			
			int rem = q1.remove();
			System.out.println("removed - "+rem);
			System.out.println("HEAD after removing from Queue- "+q1.element());
			
			rem = q1.remove();
			System.out.println("HEAD after removing from Queue- "+q1.element());
			rem = q1.remove();
			System.out.println("HEAD after removing from Queue- "+q1.element());
			rem = q1.remove();
			System.out.println("HEAD after removing from Queue- "+q1.element());
			rem = q1.remove();			
			System.out.println("HEAD after removing from Queue- "+q1.element());
			}catch(NoSuchElementException e)
			{
				System.out.println("No Such elements in queue");
				
			}
			System.out.println("");
			///////////////////////////////////////////////
			/*
			 * adding and removing items through OFFER() and POLL()
			 * and also look at PEAK, which will show the HEAD of the QUEUE
			 * when we use the above exceptions are not thrown
			 */
			System.out.println("Que2");
			
			Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(4);
			System.out.println("Head of the queue - "+q2.peek());
			q2.offer(1);
			q2.offer(13);
			q2.offer(3);
			q2.offer(45);
			
			if(q2.offer(2)==false){
			System.out.println("Offer failed to add 5th item");	
			}
			System.out.println("Head of the queue - "+q2.peek());
			
			System.out.println("");
			System.out.println("Iterating through a queue 2");
			for (Integer val:q2){
				System.out.println(val);
			}
			
			System.out.println("");
			System.out.println("Removing items through POLL");
			
			System.out.println("Removing from Que - "+ q2.poll());
			System.out.println("Head of the queue - "+q2.peek());
			System.out.println("Removing from Que - "+ q2.poll());
			System.out.println("Head of the queue - "+q2.peek());
			System.out.println("Removing from Que - "+ q2.poll());
			System.out.println("Head of the queue - "+q2.peek());
			
		}
}
