package be.rapho.grid;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestGridFactory {
    
  @Test
  public void Deserialize_Given2DArray_CreatesAGridObject() {
    int[] myArr = { 1, 2, 3 };
    int[][] mySerializedGrid = { myArr, myArr, myArr };

    Grid actual = GridFactory.deserialize(mySerializedGrid);
    assertNotEquals(actual, null);
  }

  // @Test
  // public void Equals_GivenSameGrid_ReturnsTrue() {
  //   int[] myArr = { 1, 2, 3 };
  //   int[][] mySerializedGrid = { myArr, myArr, myArr };
  //   Grid someGrid = GridFactory.deserialize(mySerializedGrid);
  //   // int[][] actualContents = GridFactory.serialize(someGrid);


  //   assertEquals(someGrid, actualContents);
  // }
}
