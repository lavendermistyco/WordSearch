

import org.junit.*;

/**
 * Unit test for WordSearch.
 */
public class WordSearchTest 
{
    WordSearch ws = new WordSearch();
    char[][] grid = {
        {'o', 'k', 'k', 'y', 'e', 'k'},
        {'p', 'e', 'e', 't', 'u', 'v'},
        {'y', 'j', 'y', 'y', 'r', 's'}
                    };
    char[][] grid2 = {
        {'o', 'k', 'k', 'y', 'e', 'k'},
        {'p', 'e', 'e', 't', 'e', 'v'},
        {'y', 'j', 'y', 'y', 'r', 'k'}
                     };
    @Test
    public void coordinateConvTest(){
        String ex1 = "N";
        String ex2 = "NE";
        String ex3 = "E";
        String ex4 = "SE";
        String ex5 = "S";
        String ex8 = "NW";

        int dir1 = 0;
        int dir2 = 1;
        int dir3 = 2; 
        int dir4 = 3;
        int dir5 = 4;
        int dir8 = 7;

        String act1 = WordSearch.coordinateConverter(dir1);
        String act2 = WordSearch.coordinateConverter(dir2);
        String act3 = WordSearch.coordinateConverter(dir3);
        String act4 = WordSearch.coordinateConverter(dir4);
        String act5 = WordSearch.coordinateConverter(dir5);
        String act8 = WordSearch.coordinateConverter(dir8);

        Assert.assertEquals(ex1, act1);
        Assert.assertEquals(ex2, act2);
        Assert.assertEquals(ex3, act3);
        Assert.assertEquals(ex4, act4);
        Assert.assertEquals(ex5, act5);
        Assert.assertEquals(ex8, act8);
    }

    @Test
    public void solveIn8DirTest1(){
        //Given 
        String word = "eu";
        int row = 0; //y 
        int col = 4;  //x
        String expected = "S";

        String actual = WordSearch.solveIn8Dir(word, grid, row, col);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void solveIn8DirTest2(){
        //Given 
        String word = "key";
        int row = 0; //y 
        int col = 2;  //x
        String expected = "S SW";

        String actual = WordSearch.solveIn8Dir(word, grid, row, col);

        Assert.assertEquals(expected, actual);
    }

    @Test 
    public void isValidDirTest(){
        int rowDir = 4;
        int colDir = 5;
        Assert.assertFalse(WordSearch.isValidDir(grid, rowDir, colDir));

    }

    @Test 
    public void isValidDirTest2(){
        int rowDir = -1;
        int colDir = -1;
        Assert.assertFalse(WordSearch.isValidDir(grid, rowDir, colDir));

    }

    @Test 
    public void isValidDirTest3(){
        int rowDir = 2;
        int colDir = 1;
        Assert.assertTrue(WordSearch.isValidDir(grid, rowDir, colDir));

    }

    @Test
    public void printLocationsTest(){
        String word = "key";

        String expected = "[(0 , 1)SE, (0 , 2)S, (0 , 2)SW, (0 , 5)SW, (0 , 5)W, (2 , 5)NW]";

        String actual = WordSearch.printLocations(grid2, word);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printLocationsTest2(){
        String word = "et";

        String expected = "[(0 , 4)SW, (1 , 2)E]";

        String actual = WordSearch.printLocations(grid, word);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printLocationsTest3(){
        String word = "key";

        String expected = "[(0 , 1)SE, (0 , 2)S, (0 , 2)SW, (0 , 5)W]";

        String actual = WordSearch.printLocations(grid, word);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printLocationsTest4(){
        String word = "beep";

        String expected = "Not Found";

        String actual = WordSearch.printLocations(grid2, word);

        Assert.assertEquals(expected, actual);
    }


}
