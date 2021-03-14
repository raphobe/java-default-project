package be.rapho.grid;

final class Square{

    SquareSide topRow;
    SquareSide botRow;
    SquareSide topCol;
    SquareSide botCol;

    public Square(SquareSide topRow, SquareSide botRow, SquareSide topCol, SquareSide botCol)
    {
        this.topRow = topRow;
        this.botRow = botRow;
        this.topCol = topCol;
        this.botCol = botCol;
    }

    public void rotate()
    {
        SquareSide temp = this.topCol;
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
            Square other = (Square) o;

            return other.topRow.equals(this.topRow) &&
            other.botRow.equals(this.botRow) &&
            other.topCol.equals(this.topCol) &&
            other.botCol.equals(this.botCol);
        }
        return false;
    }

    public int hashCode()
    {
        int prime = 31;
        int result = 1;

        result = prime * result + topRow.hashCode();
        result = prime * result + botRow.hashCode();

        result = prime * result + botCol.hashCode();
        result = prime * result + topCol.hashCode();

        return result;
    }
}
