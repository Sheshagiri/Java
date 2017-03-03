import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * "Flattens" nested sub-iterators into an iterator in a depth-first manner.
 *
 * @author Sheshagiri
 *
 * Example: an iterator {{1,2},{3},{4,5}} which has three sub-iterators with
 * 2, 1 and 2 elements correspondingly, presents values in this order:
 * {1, 2, 3, 4, 5}
 */
public class IteratorFlattener<E> implements Iterator<E> {
	private Iterator<Iterator<E>> itr1;
    private Iterator<E> itr2;
    
    public IteratorFlattener(Iterator<Iterator<E>> root) {
       if(null == root){
    	   throw new NullPointerException();
       }
       this.itr1 = root;
       itr2 = null;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     *
     * @return {@code true} if the iteration has more elements
     */
    public boolean hasNext() {
    	if (itr2 == null) {
    		if (itr1.hasNext()) {
    			itr2 = itr1.next();
    		} else {
    			return false;
    		}
    	}

    	while (!itr2.hasNext() && itr1.hasNext()) {
    		itr2 = itr1.next();
    	}

    	return itr2.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    public E next() {
        return itr2.next();
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation). This method can be called
     * only once per call to {@link #next}.
     *
     * @throws IllegalStateException if the {@code next} method has not
     *         yet been called, or the {@code remove} method has already
     *         been called after the last call to the {@code next}
     *         method
     */
    public void remove() {
        // impement code here ...
    }
}

