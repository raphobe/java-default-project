package be.rapho.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ReversableDeque<T> implements Iterable<T> {

    Deque<T> aDeque;
    Boolean isReversed;

    public ReversableDeque() {
        aDeque = new ArrayDeque<T>();
        isReversed = false;
    }

    public ReversableDeque(Deque<T> anotherDeque) {
        this();
        defensiveCopy(anotherDeque);
    }

    private void defensiveCopy(Deque<T> anotherDeque) {
        for(T t: anotherDeque)
        {
            aDeque.add(t);
        }
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object o)
    {
        if( o != null && o.getClass() == this.getClass())
        {
            ReversableDeque<T> other = (ReversableDeque<T>) o;
            if(this.aDeque.size() != other.aDeque.size())
            {
                return false;
            }
            return areDequesContentsEqual(this.iterator(),other.iterator());
        }
        return false; 
    }

    private boolean areDequesContentsEqual(Iterator<T> anItr, Iterator<T> anotherItr)
    {
        while(anItr.hasNext() && anotherItr.hasNext())
        {
            if(!anItr.next().equals(anotherItr.next()))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        if(isReversed)
        {
            return aDeque.descendingIterator();
        }
        return aDeque.iterator();
    }

	public ReversableDeque<T> reverse() {
        this.isReversed = !this.isReversed;
        return this;
	}

    public int hashCode()
    {
        return aDeque.hashCode();
    }
}
