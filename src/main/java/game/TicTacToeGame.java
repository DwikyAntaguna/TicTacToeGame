package game;

import java.util.Scanner;

import player.Player;

public class TicTacToeGame {
    public void startGame(){
        Scanner scanner = new Scanner(System.in);

        // Pilih Ukuran papan
        System.out.println("Pilih Ukuran Board (3 for 3x3, 4 for 4x4) :");
        int size = scanner.nextInt();
        scanner.nextLine();

        // Membuat papan berdasarkan ukuran
        TicTacToeBoard board = (size == 4) ? new ExtendedTicTacToeBoard(size) : new TicTacToeBoard(size);

        // Input Pemain
        System.out.println("Masukkan nama player 1 (X): ");
        Player player1 = new Player(scanner.nextLine(), 'X');

        System.out.println("Masukkan nama player 2 (O): ");
        Player player2 = new Player(scanner.nextLine(), 'O');

        Player currentPlayer = player1;

        // Mulai Permainan
        while (true) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "(" + currentPlayer.getSymbol() + "), Giliranmu!");

            // Input koordinat
            int row, col;
            while (true) {
                System.out.println("Masukkan row (1-" + size + "): ");
                row = scanner.nextInt() -1;

                System.out.println("Masukkan column (1-" + size + "): ");
                col = scanner.nextInt() -1;

                if (row >= 0 && row < size && col >= 0 && col < size && board.isCellEmpty(row, col)){
                    break;
                }
                System.out.println("Langkah Tidak Benar!, Coba lagi");
            }

            // Tempatkan simbol
            board.placeSymbol(row, col, currentPlayer.getSymbol());

            // Periksa Kemenangan
            if (board.checkWin(currentPlayer.getSymbol())){
                board.displayBoard();
                System.out.println(" Selamat, " + currentPlayer.getName() + "! kamu Menang");
                break;
            }

            // Perikasa apakah papan penuh
            if (board.isBoardFull()){
                board.displayBoard();
                System.out.println("Permainan Seri");
                break;
            }

            // ganti nama pemain
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        scanner.close();
    }

}
