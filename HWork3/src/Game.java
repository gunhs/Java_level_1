import java.util.Random;
import java.util.Scanner;

public class Game {
    private static char map[][];
    private static int size = 3;

    private static final char empty =' ';
    private static final char x = 'X';
    private static final char o = 'O';

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();

        while (true){
            humanTurn();
            if(gameOver(x)) {
                break;
            }
            computerTurn();
            if(gameOver(o)) {
                break;
           }
         }
        System.out.println("Игра окончена.");
    }
    private static void initMap(){
        map = new char[size][size];
        for (int i = 0; i<size; i++ ){
            for (int j =0; j<size; j++){
                map[i][j]= empty;
            }
        }
    }

    private static void printMap(){
        for (int i=0; i<=size; i++){
            System.out.print(i +" ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < size; j++) {
                System.out.print (map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {
        int z,y;
        do {
            System.out.println("Введите координаты ячейки");
            y = scanner.nextInt() - 1;
            z = scanner.nextInt() - 1;
        } while (!isCellValid(z, y));
            map[y][z]=x;
    }

    private static void computerTurn(){
        int z = -1;
        int y = -1;

        do {
            z = random.nextInt(size);
            y = random.nextInt(size);
        } while (!isCellValid(z,y));
        System.out.println("Компьютер выбрал ячейку " + (y+1)+ " "+(z+1));
        map[y][z]=o;

    }
    private static boolean isCellValid(int z, int y){
        boolean result = true;
        if(z<0 || z>=size || y<0 || y>=size){
            result = false;
        }
        if (map[y][z] != empty){
            result = false;
        }
        return result;
    }

    private static boolean gameOver(char playerSymbol){
        boolean result = false;
        printMap();
        if (checkWIn(playerSymbol)){
            System.out.println("Победил " + playerSymbol);
            result=true;
        }
        if(isMapFull()){
            System.out.println("Ничья");
            result=true;
        }
        return result;
    }
    private static boolean isMapFull(){
        boolean result = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == empty)
                    result=false;
            }
        }
        return result;
    }

    private static boolean checkWIn(char playerSymbol){
        boolean result=false;
        if(
                map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol ||
                map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol ||
                map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol ||
                map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol ||
                map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol ||
                map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol ||
                map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol ||
                map[0][2] == playerSymbol && map[1][1] == playerSymbol && map[2][0] == playerSymbol
        ) {result=true;}
        return result;
    }
}
