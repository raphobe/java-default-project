package be.rapho.grid;

import java.util.Deque;
import java.util.Iterator;

class GridLine implements Iterable<Integer> {

    Deque<Integer> line;
    boolean isMarkedReversed;

    public GridLine(Deque<Integer> line )
    {
        this.line = line;
        this.isMarkedReversed = false;
    }

    public boolean contains(Integer inte)
    {
        return line.contains(inte);
    }
    public void reverse()
    {
        this.isMarkedReversed = !this.isMarkedReversed;
    }



    public boolean equals(Object o)
    {
        if( o != null && o.getClass() == this.getClass())
        {
            GridLine other = (GridLine) o;
            Deque<Integer> theirLine = other.line;
            Deque<Integer> myLine = line;
            if(myLine.size() != theirLine.size())
            {
                return false;
            }
            return areDequesEqual(this.iterator(), other.iterator());
        }
        return false;
    }

    private boolean areDequesEqual(Iterator<Integer> aDequeItr, Iterator<Integer> anotherDequeItr)
    {
        while( aDequeItr.hasNext() && anotherDequeItr.hasNext())
        {
            if(!aDequeItr.next().equals(anotherDequeItr.next()))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return line.hashCode();
    }

    public Iterator<Integer> iterator() {
        if(this.isMarkedReversed)
        {
            return line.descendingIterator();
        }
        return line.iterator();
    }
}
