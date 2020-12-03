package uk.co.robson.adventofcode2020.day3.util;

public class Slide {

    /**
     * slide down the course and count the trees found
     * @return
     */
    public int treesHit(int[][] course, int rightMove, int downMove) {

        int tree = 1;
        int x = 0;
        int y = 0;

        int numOfTrees = 0;

        while(y < course.length) {
            int numOfColumns = course[y].length - 1;

            if(x > numOfColumns) {
                x -= (numOfColumns + 1); //end of the col but the +1 is to reset x back to starting at 0
            }

            int value = course[y][x];

            if(value == tree) {
                numOfTrees += 1;
            }

            x += rightMove;
            y += downMove;
        }

        System.out.printf("output %s%n", numOfTrees);
        return numOfTrees;

    }
}
