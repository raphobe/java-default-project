package be.rapho.grid;

class SimpleSquare implements Square {

    Integer val;

    public SimpleSquare(Integer val)
    {
        this.val = val;
    }

    public void rotate()
    {
        return;
    }

    public boolean equals(Object o)
    {
        if( o != null && o.getClass() == this.getClass())
        {
            SimpleSquare other = (SimpleSquare) o;

            return this.val.equals(other.val);
        }
        return false;
    }

    public int hashCode()
    {
        return 1;
    }
}
