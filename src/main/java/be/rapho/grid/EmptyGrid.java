package be.rapho.grid;

final class EmptyGrid implements Grid {

    @Override
    public void rotate() {
    }
    
    public boolean equals(Object o)
    {
        return o != null && o.getClass().equals(this.getClass());
    }

    public int hashCode()
    {
        return 1;
    }
}
