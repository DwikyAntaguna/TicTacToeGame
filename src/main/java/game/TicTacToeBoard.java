package game;

public class TicTacToeBoard {
    protected char [][] board;
    protected int size;

    public TicTacToeBoard(int size){
        this.size = size;
        board = new char[size][size];

        // Mengisi papan dengan Tanda Kosong 
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                board [i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(" " + board [i][j] + " ");
                if (j < size - 1)System.out.print("|");
            }
            System.out.println();
            if(i < size - 1){
                for (int k = 0; k < size; k++){
                    System.out.print("---");
                    if (k < size - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
    }

    public boolean isCellEmpty (int row, int col){
        return board [row][col] == ' ';
    }

    public void placeSymbol (int row, int col, char symbol){
        board [row][col] = symbol;
    }
    public boolean checkWin (char symbol){
        // Periksa baris dan kolom 
        for (int i = 0; i < size; i++){
            if (checkRow (i, symbol) || checkColumn(i, symbol)) return true;
        }
        
        // Periksa Diagonal 
        return checkMainDiagonal(symbol) || checkSecondaryDiagonal(symbol);

    }
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (board [i][j] == ' ') return false;
            }
        }
        return true;
    }
    private boolean checkRow (int row, char symbol){
        for (int col = 0; col < size; col++){
            if (board[row] [col] != symbol) return false;
        }
        return true;
    }
    private boolean checkColumn (int col, char symbol){
        for (int row = 0; row < size; row++){
            if (board[row][col] != symbol) return false;
        }
        return true;
    }
    private boolean checkMainDiagonal (char symbol){
        for (int i = 0; i < size; i++){
            if (board[i][i] != symbol) return false;
        }
        return true;
    }
    private boolean checkSecondaryDiagonal (char symbol){
        for (int i = 0; i < size; i++){
            if (board[i][size - i - 1] !=symbol) return false;
        }
        return true;
    }
}
