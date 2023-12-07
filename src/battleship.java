import java.util.Scanner;

public class battleship {
    static Scanner lector = new Scanner(System.in);

    public static int randInt() {
        int min = 0;
        int max = 9;
        int randomInt = (int) Math.floor(Math.random()*(max-min+1)+min);
        return randomInt;
    }
    public static void main(String[] args) {
        // Creamos el Tablero (10x10), y medimos sus dimensiones:
        int [][] board = new int[10][10];
        int boardRows = (board.length-1);
        int boardCollumns = (board[0].length-1);

        // Rellenamos el tablero, los 0 representan agua:

        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j<boardCollumns; j++) {
                board[i][j] = 0;
            }
        }

        // Prueba Imprimir Board (Borrar luego)

        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j<boardCollumns; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println(" ");
        }

        // Creamos los barcos.


        //Colocamos los barcos.


        boolean positioned;
        do {



        } while (positioned = false);



    }
}
