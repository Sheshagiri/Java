import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Sheshagiri
 *
 */
public class BlockingQueue<E> {
	Queue<E> queue;
	int elements;

	/**
	 * @param queue
	 *            The underlying "wrapped" queue.
	 */
	public BlockingQueue(Queue<E> q) {
		queue = q;
		elements = 2;
	}

	/**
	 * Inserts the specified element into the underlying queue, waiting if
	 * necessary for the underlying queue to be ready to accept new elements.
	 * 
	 * @param e
	 *            the element to insert.
	 * @throws InterruptedException
	 */
	public void push(E e) throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (queue.size() == elements) {
					try {
						wait();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
				System.out.println("Producer produced :: " + e);
				elements++;
				queue.add(e);
				notify();
				Thread.sleep(200);
			}
		}
	}

	/**
	 * Retrieves and removes the head of the underlying queue, waiting if
	 * necessary until it is capable of providing an element.
	 * 
	 * @return the retrieved element
	 * @throws InterruptedException
	 */
	public E pull() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (queue.size() == 0) {
					try {
						wait();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
				elements--;
				System.out.println("Consumer consumed:: " + queue.remove());
				notify();
				Thread.sleep(200);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Queue<String> queue = new LinkedList<String>();
		final BlockingQueue<String> blockingQueue = new BlockingQueue<String>(queue);
		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					blockingQueue.push(new Date().toString());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					blockingQueue.pull();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
	}
}