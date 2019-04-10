package interview.leetcode.microsoft;

public class TicTacToe {

    int[] rows;
    int[] cols;

    int dg1 = 0;
    int dg2 = 0;
    int m = 0;

    public TicTacToe(int m){
        this.m = m;
        rows = new int[m];
        cols = new int[m];
    }

    public int move(int row, int col, int player){
        int moveInt = player == 1 ? 1 : -1;

        rows[row] += moveInt;
        cols[col] += moveInt;


        if(row == col){
            dg1 += moveInt;
        }

        if(row == (m - col - 1)){
            dg2 += moveInt;
        }

        if(Math.abs(rows[row]) == m ||
                Math.abs(cols[col]) == m ||
                Math.abs(dg1) == m ||
                Math.abs(dg2) == m){
            return player;
        }
        return 0;
    }

    public static void main(String[] args){
        TicTacToe ticTacToe = new TicTacToe(2);

        int result = ticTacToe.move(0, 1, 1);
        System.out.println("  "+result);
        result = ticTacToe.move(1, 1, 2);
        System.out.println("  "+result);
        result = ticTacToe.move(1, 0, 1);
        System.out.println("  "+result);
    }


}
