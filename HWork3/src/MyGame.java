import java.util.Scanner;
import java.util.Random;

public class MyGame {
    private static char map[][];
    private static final int  SIZE=4;
    private static final char CHEST='X';
    private static final char NULL='0';
    private static final char EMPTY='-';
    private static final boolean EASYMODE = false;
    private static final boolean MIDDLEMODE = true;
    private static Random random= new Random();
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
                if (gameOver(CHEST))
                {break;}
            computerTurn();
                if (gameOver(NULL))
                {break;}
        }
        System.out.println("Игра окончена");
    }
    private static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j]=EMPTY;
            }
        }
    }
    private static void printMap(){
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
            System.out.println();
        for (int j = 0; j < SIZE; j++) {
            System.out.print((j +1)+ " ");
            for (int i = 0; i < SIZE; i++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты через пробел: ");
            y = scanner.nextInt()-1;
            x = scanner.nextInt()-1;
        } while (!isCellValid(x, y));
        map[y][x]=CHEST;
    }
    private static void computerTurn(){
    int x= -1;
    int y=-1;

    if (EASYMODE) {
        boolean moveOut = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY) {
                    if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] == NULL) {
                        x = i;
                        y = j;
                        moveOut = true;
                    } else if (i - 1 >= 0 && map[i - 1][j] == NULL) {
                        x = i;
                        y = j;
                        moveOut = true;
                    } else if (i - 1 >= 0 && j + 1 < SIZE && map[i - 1][j + 1] == NULL) {
                        x = i;
                        y = j;
                        moveOut = true;
                    } else if (j - 1 >= 0 && map[i][j - 1] == NULL) {
                        x = i;
                        y = j;
                        moveOut = true;
                    } else if (j + 1 < SIZE && map[i][j + 1] == NULL) {
                        x = i;
                        y = j;
                        moveOut = true;
                    } else if (i + 1 < SIZE && j - 1 >= 0 && map[i + 1][j - 1] == NULL) {
                        x = i;
                        y = j;
                        moveOut = true;
                    } else if (i + 1 < SIZE && j + 1 < SIZE && map[i + 1][j + 1] == NULL) {
                        x = i;
                        y = j;
                        moveOut = true;
                    } else if (i + 1 < SIZE && map[i + 1][j] == NULL) {
                        x = i;
                        y = j;
                        moveOut = true;
                    } else
                        do {
                            x = random.nextInt(SIZE);
                            y = random.nextInt(SIZE);
                        } while (!isCellValid(x, y));
                }
                if (moveOut) {
                    break;
                }
            }
            if (moveOut) {
                break;
            }
        }
    }

        if (MIDDLEMODE) {
            int maxScoreX=-1;
            int maxScoreY=-1;
            int maxScore=0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    int scoreFiled=0;
                    if (map[i][j] == EMPTY) {
                        if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] == NULL) {
                            scoreFiled++;
                        }
                        if (i - 1 >= 0 && map[i - 1][j] == NULL) {
                            scoreFiled++;
                        }
                        if (i - 1 >= 0 && j + 1 < SIZE && map[i - 1][j + 1] == NULL) {
                            scoreFiled++;
                        }
                        if (j - 1 >= 0 && map[i][j - 1] == NULL) {
                            scoreFiled++;
                        }
                        if (j + 1 < SIZE && map[i][j + 1] == NULL) {
                            scoreFiled++;
                        }
                        if (i + 1 < SIZE && j - 1 >= 0 && map[i + 1][j - 1] == NULL) {
                            scoreFiled++;
                        }
                        if (i + 1 < SIZE && j + 1 < SIZE && map[i + 1][j + 1] == NULL) {
                            scoreFiled++;
                        }
                        if (i + 1 < SIZE && map[i + 1][j] == NULL) {
                            scoreFiled++;
                        }
                    }
                    if (scoreFiled>maxScore){
                        maxScore=scoreFiled;
                        maxScoreX=i;
                        maxScoreY=j;
                    }
                }
            }
            x=maxScoreX;
            y=maxScoreY;
        }
        if (x==-1){
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));}
        System.out.println();
        System.out.println("Копмпьютер сделал ход: " + x + " " + y);
        System.out.println();
        map[x][y]=NULL;
   }
    private static boolean isCellValid(int x, int y){
        boolean result = true;
            if (x<0 || x>=SIZE || y<0 || y>=SIZE){
                result=false;
            }
            if (map[y][x] != EMPTY){
                result=false;
            }
        return result;
    }

    private static boolean gameOver(char playSymb){
        boolean result  = false;
        printMap();
        if (checkWinLines(playSymb)||checkWinDiagonals(playSymb)){
            System.out.println("Победили " + playSymb);
            result=true;
        }
        if (isMapFull()){
            System.out.println("Ничья");
            result = true;
        }
        return result;
    }
    private static boolean isMapFull() {
        boolean result = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==EMPTY){result=false; break;}
            }
            if (!result){break;}}
        return result;
    }

    private static boolean checkWinDiagonals(char playerSymbol){
        boolean leftRigth=true, rightLeft=true, result =false;
        for (int i = 0; i < SIZE; i++) {
            leftRigth &=(map[i][i]==playerSymbol);
            rightLeft &=(map[SIZE-i-1][i]==playerSymbol);
        }
        if (leftRigth||rightLeft){result=true;}
        return result;
    }
    private static boolean checkWinLines(char playerSymbol){
        boolean cols, rows, result=false;
        for (int col = 0; col < SIZE; col++) {
            cols=true;
            rows =true;

            for (int row = 0; row < SIZE; row++) {
                cols &= (map[col][row]==playerSymbol);
                rows &= (map[row][col]==playerSymbol);
            }
            if (cols||rows){
                result= true;
                break;
            }
            if(result){break;}
        }
        return result;
    }
}
