package be.rapho.grid;

class ComplexGrid implements Grid {

    Square shell;
    Grid innerGrid;

    ComplexGrid(Square shell, Grid innerGrid)
    {
        this.shell = shell;
        this.innerGrid = innerGrid;
    }

    public void rotate()
    {
        shell.rotate();
        innerGrid.rotate();

        return;
    }

    public boolean equals(Object o)
    {
        if(o != null && o.getClass().equals(this.getClass())) {
            ComplexGrid other = (ComplexGrid) o;
            return shellsEqual(other) && innerGridsEqual(other);
        }
        return false;
    }

    private boolean shellsEqual(ComplexGrid other)
    {
        return this.shell.equals(other.shell);
    }

    private boolean innerGridsEqual(ComplexGrid other)
    {
        return this.innerGrid.equals(other.innerGrid);
    }

    public int hashCode()
    {
        return 1;
    }
}
