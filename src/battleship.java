import java.util.Scanner;

public class battleship {
    static Scanner lector = new Scanner(System.in);

    public static int[][] board = new int[10][10];

    public static int randInt() {
        int min = 0;
        int max = 9;
        int randomInt = (int) Math.floor(Math.random()*(max-min+1)+min);
        return randomInt;
    }

    public static int checkPosition(int x, int y, int boatSize) {
        int position = 0;
        if ((x)>=boatSize) {
            for (int i = x; i > (x-boatSize); i--) {
                if (board[i][y] != 0) {
                    position = 1;
                }
            }
        } else if (((y)+boatSize)<=9) {
            for (int j = y; j < (y+boatSize); j++) {
                if (board[x][j] != 0) {
                    position = 2;
                }
            }
        } else if (((x) + boatSize)<=9) {
            for (int k = x; k < (x+boatSize); k++) {
                if (board[k][y] != 0) {
                    position = 3;
                }
            }
        } else if (y>boatSize) {
            for (int l = y; l > (y-boatSize); l--) {
                if (board[x][l] != 0) {
                    position = 4;
                }
            }
        }
        return position;
    }





    public static void main(String[] args) {

        int boardRows = (board.length-1);
        int boardCollumns = (board[0].length-1);

        // Rellenamos el tablero, los 0 representan agua:

        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j<boardCollumns; j++) {
                board[i][j] = 0;
            }
        }

        // Creamos los barcos.

        int[] patrol = new int[]{1, 1};
        int[] submarine = new int[]{1, 1, 1};
        int[] destroyer = new int[]{1, 1, 1};
        int[] battleship = new int[]{1, 1, 1, 1};
        int[] carrier = new int[]{1, 1, 1, 1, 1};

        int [][] ships = {patrol,submarine,destroyer,battleship,carrier};

        //Colocamos los barcos.


        int positioned;
        int shipCounter = ships.length-1;
        do {
            // Generamos una posicion random.
            int x = randInt();
            int y = randInt();
            
            // Comprobamos el tamaño de la nave para pasarla a la funcion
            int z = ships[shipCounter].length;
            
            // Comprobamos la posicion con la funcion
            positioned = checkPosition(x,y,z);
            // Sustituimos en la posicion
            if (positioned != 0) {
                switch (positioned) {
                    case 1: {
                        for (int i = x; i > (x-z); i--) {
                            board[i][y] = 1;
                        }
                        shipCounter--;
                        break;
                    }
                    case 2: {
                        for (int j = y; j < (y+z); j++) {
                            board[x][j] = 1;
                        }
                        shipCounter--;
                        break;

                    }
                    case 3: {
                        for (int k = x; k < (x+z); k++) {
                            board[k][y]= 1;
                        }
                        shipCounter--;
                        break;
                    }
                    case 4: {
                        for (int l = y; l > (y-z); l--) {
                            board[x][l]= 1;
                        }
                        shipCounter--;
                        break;
                    } default: {

                    }
                }
            }
        } while (positioned == 0 && shipCounter >= 0);

        // Prueba Imprimir Board (Borrar luego)

        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j<boardCollumns; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println(" ");
        }



    }
}
