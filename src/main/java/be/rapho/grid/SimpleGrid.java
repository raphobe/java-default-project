package be.rapho.grid;

class SimpleGrid implements Grid {

    SimpleSquare square;
    public SimpleGrid(SimpleSquare square)
    {
        this.square = square;
    }

    @Override
    public void rotate() {
        square.rotate();
    }

    public boolean equals(Object o)
    {
        if(o != null && o.getClass().equals(this.getClass())) {
            SimpleGrid other = (SimpleGrid) o;
            return this.square.equals(other.square);
        }
        return false;
    }

    public int hashCode()
    {
        return 1;
    }
}
