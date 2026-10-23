import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] matriz = new char[10][10];
        char robot = 'R';
        char meta = 'F';
        char muro = 'X';
        char bateria = 'B';
        int filaM;
        int filaB;
        int colM;
        int colB;
        Random dice = new Random();
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = '*';
            }
        }
        matriz[0][0] = robot;
        matriz[9][9] = meta;
        for (int i = 0; i < 5; i++) {
            do {
                filaM = dice.nextInt(10);
                colM = dice.nextInt(10);
            } while (matriz[filaM][colM] != '*');
            matriz[filaM][colM] = muro;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        do {
            filaB = dice.nextInt(10);
            colB = dice.nextInt(10);
        } while (matriz[filaB][colB] != '*');
        matriz[filaB][colB] = bateria;
        int vidas = 10;
        int filaR = 0;
        int colR = 0;
        char movimiento;
        int fin = 0;
        do {
            matriz[filaR][colR] = '*';
            do{
            movimiento = scan.next().toUpperCase().charAt(0);
            if (movimiento != 'D' & movimiento != 'S' & movimiento != 'A' & movimiento != 'W') {
                System.out.println("No puedes ir en esa dirección");
                System.out.println("Dime una letra: ");
            }
        } while (movimiento != 'D' & movimiento != 'S' & movimiento != 'A' & movimiento != 'W');
            if (movimiento == 'D') {
                colR++;
                if (colR >= 10) {
                    colR--;
                    matriz[filaR][colR] = robot;
                    System.out.println("No puedes salirte de la matriz");
                } else if (matriz[filaR][colR] == muro) {
                    colR--;
                    matriz[filaR][colR] = robot;
                    System.out.println("Movimiento bloqueado");
                } else if (matriz[filaR][colR] == bateria) {
                    vidas += 2;
                    matriz[filaR][colR] = robot;
                    System.out.println("Has encontrado una bateria");
                } else if (matriz[filaR][colR] == meta) {
                    matriz[filaR][colR] = robot;
                    System.out.println("Rescate completado");
                    fin = 1;
                } else {
                    matriz[filaR][colR] = robot;
                }
            }
            if (movimiento == 'A') {
                colR--;
                if (colR <= 0) {
                    colR++;
                    matriz[filaR][colR] = robot;
                    System.out.println("No puedes salirte de la matriz");
                } else if (matriz[filaR][colR] == muro) {
                    colR++;
                    matriz[filaR][colR] = robot;
                    System.out.println("Movimiento bloqueado");
                } else if (matriz[filaR][colR] == bateria) {
                    vidas += 2;
                    matriz[filaR][colR] = robot;
                    System.out.println("Has encontrado una bateria");
                } else if (matriz[filaR][colR] == meta) {
                    matriz[filaR][colR] = robot;
                    System.out.println("Rescate completado");
                    fin = 1;
                } else {
                    matriz[filaR][colR] = robot;
                }
            }
            if (movimiento == 'W') {
                filaR--;
                if (colR == 0) {
                    filaR++;
                    matriz[filaR][colR] = robot;
                    System.out.println("No puedes salirte de la matriz");
                } else if (matriz[filaR][colR] == muro) {
                    filaR++;
                    matriz[filaR][colR] = robot;
                    System.out.println("Movimiento bloqueado");
                } else if (matriz[filaR][colR] == bateria) {
                    vidas += 2;
                    matriz[filaR][colR] = robot;
                    System.out.println("Has encontrado una bateria");
                } else if (matriz[filaR][colR] == meta) {
                    matriz[filaR][colR] = robot;
                    System.out.println("Rescate completado");
                    fin = 1;
                } else {
                    matriz[filaR][colR] = robot;
                }
            }
            if (movimiento == 'S') {
                filaR++;
                if (filaR >= 10) {
                    filaR--;
                    matriz[filaR][colR] = robot;
                    System.out.println("No puedes salirte de la matriz");
                } else if (matriz[filaR][colR] == muro) {
                    filaR--;
                    matriz[filaR][colR] = robot;
                    System.out.println("Movimiento bloqueado");
                } else if (matriz[filaR][colR] == bateria) {
                    vidas += 2;
                    matriz[filaR][colR] = robot;
                    System.out.println("Has encontrado una bateria");
                } else if (matriz[filaR][colR] == meta) {
                    matriz[filaR][colR] = robot;
                    System.out.println("Rescate completado");
                    fin = 1;
                } else {
                    matriz[filaR][colR] = robot;
                }
            }
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Vidas restantes: " + vidas);
      } while (vidas > 0 & fin != 1);
    }
}