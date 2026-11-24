package com.equalrowcolumns;

/**
 * Hello world!
 *
 */
public class EqualRowsColumns 
{
    public static void main( String[] args )
    {
        int inputGrid[][] = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println("Row Grid: ");
        printArray(inputGrid);
        System.out.println(equalPairs(inputGrid));
    }

    public static void printArray(int inputArray[][])
    {
        for (int innerArray[] : inputArray)
        {
            System.out.print("{ ");
            for (int i : innerArray)
            {
                System.out.print(i+" ");
            }
            System.out.println("}");
        }
    }

    public static int equalPairs(int grid[][])
    {
        int numOfPairs = 0;

        //create Column grid
        int gridLength = grid.length;
        int columnGrid [][] = new int[gridLength][gridLength];
        for (int i = 0; i <= gridLength-1; i++)
        {
            for (int j = 0; j <= gridLength-1; j++)
            {
                columnGrid[i][j] = grid[j][i];
            }
        }

        //Comment out on Submission
        System.out.println("Column Grid: ");
        printArray(columnGrid);

        //Loop through both arrays
            // Within this loop, loop through each element in each sub array. 
            //Check if the elements are the same. If yes, keep checking until the whole row/column match, then increment numOfPairs. If no, break out of the current iteration.
        for (int i = 0; i <= gridLength-1; i++)
        {
            for (int j = 0; j <= gridLength-1; j++)
            {
                if(columnGrid[i][j] != grid[i][j])
                    break;
            }
            numOfPairs++;
        }

        return numOfPairs;
    }
}
