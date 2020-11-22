# WordSearch
Need to solve a word search puzzle?

Given a 2D grid of characters and a word, find all occurrences of given word in grid.
 * A word can be matched in all 8 directions at any point.
 * Word is said be found in a direction if all characters match in this direction (not in zig-zag form).
 * The solution should print the starting coordinate and the direction (north, east, south, west, etc..)
 * The 8 directions are North, South, East, West,...
 
 ![Word Search Puzzle Demo](search.gif)

 
 
 ```
 Example:
  input:
    String = "et";
    char[][] grid = {
        {'o', 'k', 'k', 'y', 'e', 'k'},
        {'p', 'e', 'e', 't', 'u', 'v'},
        {'y', 'j', 'y', 'y', 'r', 's'}
                    };
                    
    output: "[(0 , 4)SW, (1 , 2)E]"
```
Note: The function will return "Not Found" if the word is not in the matrix!

Please enjoy my solution and feel free to add suggestions. 
