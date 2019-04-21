package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC51NQueens {

    boolean[] cols = null;
    boolean[] rows = null;
    boolean[] diagonal1 = null;
    boolean[] diagonal2 = null;
    int num = 0;

    public List<List<String>> solveNQueens(int n) {


        num = n;
        cols = new boolean[n];
        rows = new boolean[n];
        diagonal1 = new boolean[2 * num];
        diagonal2 = new boolean[2 * num];
        List<List<String>> res = new ArrayList<List<String>>();

        //init board
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';



        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(i, colIndex)) {
                updateBoard(board, i, colIndex, true);
                dfs(board, colIndex + 1, res);
                updateBoard(board, i, colIndex, false);
            }
        }
    }

    public void updateBoard(char[][] board, int x, int y, boolean occupay) {
        cols[y] = occupay;
        rows[x] = occupay;
        diagonal1[x + y] = occupay;
        diagonal2[x-y+num-1] = occupay;
        board[x][y] = occupay ? 'Q' : '.';
    }

    public boolean validate(int x, int y) {
        System.out.println(x);
        System.out.println(y);
        System.out.println();
        return !cols[y] && !diagonal1[x+y] && !diagonal2[x-y+num-1] && !rows[x];
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        LC51NQueens lc51NQueens = new LC51NQueens();
        List<List<String>> lists = lc51NQueens.solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println("");
        }
    }
}
