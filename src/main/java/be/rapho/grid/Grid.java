package be.rapho.grid;

class Grid {

    Square shell;
    Grid innerGrid;

    Grid(Square shell, Grid innerGrid)
    {
        this.shell = shell;
        this.innerGrid = innerGrid;
    }

    public void rotate()
    {
        shell.rotate();
        if(innerGrid != null)
        {
            innerGrid.rotate();
        }
        return;
    }

    public boolean equals(Object o)
    {
        if(o != null && o.getClass().equals(this.getClass())) {
            Grid other = (Grid) o;
            return shellsEqual(other) && innerGridsEqual(other);
        }
        return false;
    }
    
    private boolean shellsEqual(Grid other)
    {
        return this.shell.equals(other.shell);
    }

    private boolean innerGridsEqual(Grid other)
    {
        if (this.innerGrid == null)
        {
            return other.innerGrid == null;
        }
        return this.innerGrid.equals(other.innerGrid);
    }

    public int hashCode()
    {
        return 1;
    }
}
