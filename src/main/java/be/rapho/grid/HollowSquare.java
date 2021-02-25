package be.rapho.grid;

class HollowSquare implements Square{

    GridLine topRow;
    GridLine botRow;
    GridLine topCol;
    GridLine botCol;

    public HollowSquare(GridLine topRow, GridLine botRow, GridLine topCol, GridLine botCol)
    {
        this.topRow = topRow;
        this.botRow = botRow;
        this.topCol = topCol;
        this.botCol = botCol;
    }

    public void rotate()
    {
        GridLine temp = this.topCol;
        this.topCol = this.botRow;
        this.botRow = this.botCol;
        this.botCol = this.topRow;
        this.topRow = temp;
        this.botRow.reverse();
        this.topRow.reverse();
        return;
    }

    public boolean equals(Object o)
    {
        if( o != null && o.getClass() == this.getClass())
        {
            HollowSquare other = (HollowSquare) o;

            return other.topRow.equals(this.topRow) &&
            other.botRow.equals(this.botRow) &&
            other.topCol.equals(this.topCol) &&
            other.botCol.equals(this.botCol);
        }
        return false;
    }

    public int hashCode()
    {
        return 1;
    }
}
