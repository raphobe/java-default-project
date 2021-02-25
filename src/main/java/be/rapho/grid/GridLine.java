package be.rapho.grid;

import java.util.Iterator;

import be.rapho.collection.ReversableDeque;

class GridLine implements Iterable<Integer> {

    ReversableDeque<Integer> line;
    boolean isMarkedReversed;

    public GridLine(ReversableDeque<Integer> line )
    {
        this.line = line;
    }

    public void reverse()
    {
        line.reverse();
    }

    public boolean equals(Object o)
    {
        if( o != null && o.getClass() == this.getClass())
        {
            GridLine other = (GridLine) o;
            return this.line.equals(other.line);
        }
        return false;
    }

    public int hashCode() {
        return line.hashCode();
    }

    public Iterator<Integer> iterator() {
        return line.iterator();
    }
}
