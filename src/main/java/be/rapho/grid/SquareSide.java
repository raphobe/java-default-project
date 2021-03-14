package be.rapho.grid;

import java.util.Iterator;

import be.rapho.collection.ReversableDeque;

final class SquareSide implements Iterable<Integer> {

    ReversableDeque<Integer> line;

    public SquareSide(ReversableDeque<Integer> line )
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
            SquareSide other = (SquareSide) o;
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
