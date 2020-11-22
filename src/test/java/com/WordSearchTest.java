package com;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class WordSearchTest 
{
    WordSearch ws = new WordSearch();
    char[][] grid = {
        {'o', 'k', 'k', 'y', 'e', 'k'},
        {'p', 'e', 'e', 't', 'u', 'v'},
        {'y', 'j', 'y', 'y', 'r', 's'}
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
        int row = 0;
        int col = 4;
        String expected = "S";

        String actual = WordSearch.solveIn8Dir(word, grid, row, col);

        Assert.assertEquals(expected, actual);
    }
}
