package application;

public class NQueen {
    private final boolean[][] board;
    private final boolean isQueenPlaced;

    public NQueen(int n) {
        board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = new boolean[n];
        }
        isQueenPlaced = isQueenPlaced(0);
    }

    private boolean isQueenPlaced(int x) {
        if (x == board.length) return true;
        for (int i = 0; i < board.length; i++) {
            if (isSafeSquare(x, i)) {
                board[x][i] = true;
                if(isQueenPlaced(x+1)){
                    return true;
                }
                board[x][i] = false;
            }
        }
        return false;
    }

    private boolean isSafeSquare(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (board[i][y]) return false;
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) return false;
        }
        return true;
    }

    public void printBoard() {
        if (!isQueenPlaced) {
            System.out.println(board.length + " queens cannot be accurately placed.");
            return;
        }
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "Q " : "_ ");
            }
            System.out.println();
        }
    }
}
