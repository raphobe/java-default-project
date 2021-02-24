package be.rapho.grid;

import java.util.Deque;

class SimpleSquare implements Square {

    Deque<Deque<Integer>> grid;

    public SimpleSquare(Deque<Deque<Integer>> grid)
    {
        this.grid = grid;
    }

    public void rotate()
    {
        return;
    }

    private boolean isEmpty()
    {
        return this.grid == null || this.grid.isEmpty();
    }

    private Integer getValue()
    {
        return this.grid.peekFirst().peekFirst();
    }

    public boolean equals(Object o)
    {
        if( o != null && o.getClass() == this.getClass())
        {
            SimpleSquare other = (SimpleSquare) o;
            if(this.isEmpty())
            {
                return other.isEmpty();
            }
            return this.getValue() == other.getValue();
        }
        return false;
    }

    public int hashCode()
    {
        return 1;
    }
}
