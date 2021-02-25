package be.rapho.grid;

import java.util.Deque;

import be.rapho.collection.ReversableDeque;

import java.util.ArrayDeque;

public class GridFactory {

    public static Grid deserialize(int[][] grid)
    {
        Deque<Deque<Integer>> dequeGrid = new ArrayDeque<>();

        for(int[] gridRow: grid)
        {
            Deque<Integer> dequeGridRow = new ArrayDeque<>();
            for(int gridCell: gridRow)
            {
                dequeGridRow.addLast(Integer.valueOf(gridCell));
            }
            dequeGrid.addLast(dequeGridRow);
        }
        return deserialize(dequeGrid);
    }

    private static Grid deserialize(Deque<Deque<Integer>> myGrid)
    {
        if(myGrid.size() > 1)
        {

            GridLine topRow = getTopRow(myGrid);
            GridLine botRow = getBotRow(myGrid);
            GridLine topCol = getLeftCol(myGrid);
            GridLine botCol = getRightCol(myGrid);

            Square sq = new HollowSquare(topRow, botRow, topCol, botCol);

            removeTopRow(myGrid);
            removeBotRow(myGrid);
            removeTopCol(myGrid);
            getAndRenameRightCol(myGrid);

            Grid innerGrid = deserialize(myGrid);
            return new ComplexGrid(sq, innerGrid);
        }
        else if(myGrid.size() == 1)
        {
            Integer val = myGrid.peekFirst().peekFirst();
            SimpleSquare ssq = new SimpleSquare(val);
            return new SimpleGrid(ssq);
        }
        else
        {
            return new EmptyGrid();
        }
    }

    private static GridLine getTopRow(Deque<Deque<Integer>> myGrid) {
        ReversableDeque<Integer> aDeque = new ReversableDeque<>(myGrid.peekFirst());
        return new GridLine(aDeque);
    }

    private static GridLine getBotRow(Deque<Deque<Integer>> myGrid) {
        ReversableDeque<Integer> aDeque = new ReversableDeque<>(myGrid.peekLast());
        return new GridLine(aDeque);
    }

    private static void removeTopRow(Deque<Deque<Integer>> myGrid) {
        myGrid.removeFirst();
    }


    private static void removeBotRow(Deque<Deque<Integer>> myGrid) {
        myGrid.removeLast();
    }

    private static void removeTopCol(Deque<Deque<Integer>> myGrid) {
        for(Deque<Integer> row: myGrid)
        {
            row.removeFirst();
        }
    }

    private static void getAndRenameRightCol(Deque<Deque<Integer>> myGrid) {
        for(Deque<Integer> row: myGrid)
        {
            row.removeLast();
        }
    }

    private static GridLine getLeftCol(Deque<Deque<Integer>> myGrid)
    {
        Deque<Integer> leftCol = new ArrayDeque<>();

        for(Deque<Integer> row: myGrid)
        {
            leftCol.addLast(row.peekFirst());
        }

        return new GridLine(new ReversableDeque<Integer>(leftCol));
    }

    private static GridLine getRightCol(Deque<Deque<Integer>> myGrid)
    {
        Deque<Integer> rightCol = new ArrayDeque<>();

        for(Deque<Integer> row: myGrid)
        {
            rightCol.addLast(row.peekLast());
        }

        return new GridLine(new ReversableDeque<Integer>(rightCol));
    }
}
