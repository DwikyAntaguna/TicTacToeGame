package game;

public class ExtendedTicTacToeBoard extends TicTacToeBoard{
    public ExtendedTicTacToeBoard (int size){
        super(size);
    }
    @Override
    public boolean checkWin(char symbol){
        // Dalam Versi Ini, Kita Dapat Menambahkan Logika Tambahan Untuk Kemenangan Jika Diperlukan
        return super.checkWin(symbol);
    }
}
