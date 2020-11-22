import java.util.ArrayList;
import java.util.List;

public class WordSearch{

    //class variables telling the direction vectors
    /*
     N: (0, -1)
     NE: (+1, -1)
     E: (+1, 0)
     SE: (+1, +1)
     S: (0, +1)
     SW: (-1, +1)
     W: (-1, 0)
     NW: (-1, -1)

     */
    //Vectors go from north to northwest
    public static int[] xVector = {0,  1,  1, 1, 0, -1, -1, -1}; //traversing the columns
    public static int[] yVector = {-1, -1, 0, 1, 1,  1,  0, -1}; //traversing the rows

    //switch statement taking in the directions and printing out north east and south
    public static String coordinateConverter(int direction){
        switch(direction){
            case 0:
                return "N";
            case 1 :
                return "NE";
            case 2:
                return "E";
            case 3:
                return "SE";
            case 4:
                return "S";
            case 5:
                return  "SW";
            case 6:
                return  "W";
            case 7:
                return "NW";

            default:
                return "null";
        }
    }

    //returns the directions of the word from a specific coordinate point
    public static String solveIn8Dir(String word, char[][] grid, int row, int col){
        //check the first character to see if it matches the first letter in the word...if not
        //return the empty string
        if(grid[row][col] != word.charAt(0)) return "";

        String dir = "";

        int wordLen = word.length();
        // 0 = N to 8 = NW
        for(int direction = 0; direction < 8; direction ++){
            int rowDir = row + yVector[direction];  // up or down y
            int colDir = col+ xVector[direction];   //left or right x
            int i; //pointer in the matrix

            //iterate the length of the word in the direction
            //if characters don't match break
            for(i = 1; i < wordLen; i++){
                //checking if direction is out of bounds
                if(!isValidDir(grid, rowDir, colDir) )break ;
                //if not matching character to the word then leave
                if(grid[rowDir][colDir] != word.charAt(i)) break;

                //otherwise increase the colDir and rowDir by the direction vectors
                rowDir += yVector[direction]; //row => y
                colDir += xVector[direction]; //col => x
            }

            //check if i == the wordLen (that means we matched in this direction)
            if(i == wordLen){
                dir += coordinateConverter(direction) + " ";
                //System.out.println("Direction: " + direction + " is " + dir);
            }
        }

        //System.out.println("Dir is " + dir);
        return dir.trim();
    }

    public static boolean isValidDir(char[][] grid, int rowDir, int colDir){
        if(rowDir >= grid.length || rowDir < 0 || colDir >= grid[0].length || colDir < 0){
            return false;
        }
        return true;
    }

    public static String printLocations(char[][] grid, String word){
        List<String> locations = new ArrayList<String>();
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                String dir = solveIn8Dir(word, grid, row, col);
                if(dir != ""){
                    String[] list = dir.split(" ");
                    String coordinate = "(" + row + " , " + col + ")";
                    for(String direction : list){
                        locations.add(coordinate + direction );
                    }
                }
            }
        }
        if(locations.isEmpty()) return "Not Found";
        return locations.toString();
    }



    public static void main( String[] args )
    {
        char[][] grid = {
                {'o', 'k', 'k', 'y', 'e', 'k'},
                {'p', 'e', 'e', 't', 'e', 'v'},
                {'y', 'j', 'y', 'y', 'r', 'k'}
        };
        String word = "key";
        System.out.println( WordSearch.printLocations(grid, word) );
    }

}

