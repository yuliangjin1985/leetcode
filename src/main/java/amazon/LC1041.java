package amazon;

/**
 * On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degrees to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 */
public class LC1041 {

    public static void main(String[] args) {

    }

    public boolean isRobotBounded(String instructions) {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;
        int x = 0, y = 0;
        for(char c : instructions.toCharArray()) {
            if(c == 'L') {
                i = (i + 3) % 4;
            } else if(c == 'R') {
                i = (i + 1) % 4;
            } else {
                x += dir[i][0];
                y += dir[i][1];
            }
        }

        return (x == 0 && y == 0) || i != 0;
    }
}
