package be.rapho.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestGrid {

    @Test
    public void Equals_GivenNonEqualSimpleGrid_ReturnsFalse() {
      int[] myArr = { 1 };
      int[][] mySerializedGrid = { myArr };
      int[] myOtherArr = { 2 };
      int[][] myOtherSerializedGrid = { myOtherArr };
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      Grid someOtherGrid = GridFactory.deserialize(myOtherSerializedGrid);
  
      assertNotEquals(someGrid, someOtherGrid);
    }

    @Test
    public void Equals_GivenSomeObject_ReturnsFalse() {
      int[] myArr = { 1 };
      int[][] mySerializedGrid = { myArr };
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      Object someObject = new Object();

      assertNotEquals(someGrid, someObject);
    }


    @Test
    public void Equals_GivenSomeEqualMoreComplexGrid_ReturnsTrue() {
      int[] myArr = { 1 ,1 , 1};
      int[][] mySerializedGrid = { myArr , myArr, myArr};
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      int[][] myOtherSerializedGrid = { myArr , myArr, myArr};
      Grid someOtherGrid = GridFactory.deserialize(myOtherSerializedGrid);

      assertEquals(someGrid, someOtherGrid);
    }

    @Test
    public void Equals_GivenSomeNonEqualMoreComplexGridWithDifferentBottomRow_ReturnsFalse() {
      int[] myArr = { 1 ,1 , 1};
      int[] myOtherArr = { 0, 0, 0 };
      int[][] mySerializedGrid = { myArr , myArr, myArr};
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      int[][] myOtherSerializedGrid = { myArr , myArr, myOtherArr};
      Grid someOtherGrid = GridFactory.deserialize(myOtherSerializedGrid);

      assertNotEquals(someGrid, someOtherGrid);
    }

    @Test
    public void Equals_GivenSomeNonEqualMoreComplexGridWithDifferentLeftCol_ReturnsFalse() {
      int[] myArr = { 1 ,1 , 1};
      int[] myOtherArr = { 0, 1, 1 };
      int[][] mySerializedGrid = { myArr , myArr, myArr};
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      int[][] myOtherSerializedGrid = { myArr , myOtherArr, myArr};
      Grid someOtherGrid = GridFactory.deserialize(myOtherSerializedGrid);

      assertNotEquals(someGrid, someOtherGrid);
    }

    @Test
    public void Equals_GivenSomeNonEqualMoreComplexGridWithDifferentRightCol_ReturnsFalse() {
      int[] myArr = { 1 ,1 , 1};
      int[] myOtherArr = { 1, 1, 0};
      int[][] mySerializedGrid = { myArr , myArr, myArr};
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      int[][] myOtherSerializedGrid = { myArr , myOtherArr, myArr};
      Grid someOtherGrid = GridFactory.deserialize(myOtherSerializedGrid);

      assertNotEquals(someGrid, someOtherGrid);
    }

    @Test
    public void Equals_GivenSomeNonEqualMoreComplexGridWithDifferentInternals_ReturnsFalse() {
      int[] myArr = { 1 ,1 , 1};
      int[] myOtherArr = { 1, 0, 1};
      int[][] mySerializedGrid = { myArr , myArr, myArr};
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      int[][] myOtherSerializedGrid = { myArr , myOtherArr, myArr};
      Grid someOtherGrid = GridFactory.deserialize(myOtherSerializedGrid);

      assertNotEquals(someGrid, someOtherGrid);
    }


    @Test
    public void Rotate_GivenASimpleMatrix_ReturnsIdentity() {
      int[] myArr = { 1 };
      int[][] mySerializedGrid = { myArr};
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      someGrid.rotate();
      Grid someOtherGrid = GridFactory.deserialize(mySerializedGrid);

      assertEquals(someGrid, someOtherGrid);
    }

    @Test
    public void RotateCalledOnce_ShiftsTopRow() {
      int[] myArrRow = { 222 , 111};
      int[] myOtherArrRow = {111, 111};
      int[][] mySerializedGrid = { myArrRow, myOtherArrRow };
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      someGrid.rotate();

      int[] myExpectedFirstRow = {111, 222};
      int[] myExpectedSecondRow = {111, 111};
      int[][] myExpectedSerializedGrid = { myExpectedFirstRow, myExpectedSecondRow};
      Grid someOtherGrid = GridFactory.deserialize(myExpectedSerializedGrid);

      assertEquals(someGrid, someOtherGrid);
    }

    @Test
    public void RotateCalledOnce_ShiftsTopCol() {
      int[] myArrRow = { 222 , 111};
      int[] myOtherArrRow = {333, 111};
      int[][] mySerializedGrid = { myArrRow, myOtherArrRow };
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      someGrid.rotate();

      int[] myExpectedFirstRow = {333, 222};
      int[] myExpectedSecondRow = {111, 111};
      int[][] myExpectedSerializedGrid = { myExpectedFirstRow, myExpectedSecondRow};
      Grid someOtherGrid = GridFactory.deserialize(myExpectedSerializedGrid);

      assertEquals(someGrid, someOtherGrid);
    }

    @Test
    public void RotateCalledFourTimes_ReturnsIdentity() {
      int[] myArrRow = { 222 , 111};
      int[] myOtherArrRow = {333, 444};
      int[][] mySerializedGrid = { myArrRow, myOtherArrRow };
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      someGrid.rotate();
      someGrid.rotate();
      someGrid.rotate();
      someGrid.rotate();

      Grid someOtherGrid = GridFactory.deserialize(mySerializedGrid);

      assertEquals(someGrid, someOtherGrid);
    }

    @Test
    public void RotateCalledOnce_GivenAMultiComplexMatrix_ReturnsExpectedRotation() {
      int[] myArrRowOne = { 1, 2, 3};
      int[] myArrRowTwo = { 4, 5, 6};
      int[] myArrRowThree = { 7, 8, 9};

      int[][] mySerializedGrid = { myArrRowOne, myArrRowTwo, myArrRowThree };
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      someGrid.rotate();

      int[] myExpectedArrRowOne = { 7, 4, 1};
      int[] myExpectedArrRowTwo = { 8, 5, 2};
      int[] myExpectedArrRowThree = { 9, 6, 3};

      int[][] myExpectedSerializedGrid = { myExpectedArrRowOne, myExpectedArrRowTwo, myExpectedArrRowThree };
      Grid someOtherGrid = GridFactory.deserialize(myExpectedSerializedGrid);

      assertEquals(someGrid, someOtherGrid);
    }

    @Test
    public void RotateCalledOnce_GivenAMultiComplexMatrixWithMultipleShells_ReturnsExpectedRotation() {
      int[] myArrRowOne = { 1, 2, 3, 4};
      int[] myArrRowTwo = { 5, 6, 7, 8};
      int[] myArrRowThree = { 9, 10, 11, 12};
      int[] myArrRowFour = { 13, 14, 15, 16};

      int[][] mySerializedGrid = { myArrRowOne, myArrRowTwo, myArrRowThree, myArrRowFour };
      Grid someGrid = GridFactory.deserialize(mySerializedGrid);
      someGrid.rotate();

      int[] myExpectedArrRowOne = { 13, 9, 5, 1};
      int[] myExpectedArrRowTwo = { 14, 10, 6, 2};
      int[] myExpectedArrRowThree = { 15, 11, 7,3};
      int[] myExpectedArrRowFour = { 16, 12, 8, 4};

      int[][] myExpectedSerializedGrid = { myExpectedArrRowOne, 
        myExpectedArrRowTwo, myExpectedArrRowThree, myExpectedArrRowFour };
      Grid someOtherGrid = GridFactory.deserialize(myExpectedSerializedGrid);

      assertEquals(someGrid, someOtherGrid);
    }
}
