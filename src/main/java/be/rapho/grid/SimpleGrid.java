package be.rapho.grid;

final class SimpleGrid implements Grid {

    Integer val;

    public SimpleGrid(Integer val)
    {
        this.val = val;
    }

    @Override
    public void rotate() {
        return;
    }

    public boolean equals(Object o)
    {
        if(o != null && o.getClass().equals(this.getClass())) {
            SimpleGrid other = (SimpleGrid) o;
            return this.val.equals(other.val);
        }
        return false;
    }

    public int hashCode()
    {
        return 1;
    }
}
