package PackageLesson3;

import java.util.Random;
import java.util.Scanner;

public class GameClass {

    public static char[][] field;
    public static int sizeFieldX;
    public static int sizeFieldY;

    public static final char personChar = 'X';
    public static final char aiChar = 'O';
    public static final char emptyChar = '_';
    public static final char seriesWin = 4;

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        createField();
        printField();

        while (true) {

            personTurn();
            printField();
            if (checkWin(personChar)) {
                System.out.println(personChar + "WIN!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
                break;
            }

            aiTurn();
            printField();
            if (checkWin(aiChar)) {
                System.out.println(aiChar + "WIN!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
                break;
            }
        }
    }

    public static void createField() {
        sizeFieldX = 5;
        sizeFieldY = 5;
        field = new char[sizeFieldY][sizeFieldX];

        for (int y = 0; y < sizeFieldY; y++) {
            for (int x = 0; x < sizeFieldX; x++) {
                field[y][x] = emptyChar;
            }
        }
    }

    public static void printField() {
        for (int y = 0; y < sizeFieldY; y++) {
            for (int x = 0; x < sizeFieldX; x++) {
                System.out.print("|" + field[y][x] + "");
            }
            System.out.println();
        }
        System.out.println("_______________");
    }

    public static void personTurn() {
        int x;
        int y;

        do {
            System.out.println("Your Turn");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellCorrect(y, x) || !isEmpty(y, x));
        field[y][x] = personChar;
    }

    public static void aiTurn() {
        int x;
        int y;

        do {
            x = random.nextInt(sizeFieldX);
            y = random.nextInt(sizeFieldY);
        } while (!isEmpty(y, x));

        field[y][x] = aiChar;
    }

    public static boolean isCellCorrect(int y, int x) {
        return x >= 0 && x < sizeFieldX && y >= 0 && y < sizeFieldY;
    }

    public static boolean isEmpty(int y, int x) {
        return field[y][x] == emptyChar;
    }

    public static boolean checkWin(char symbol) {
        for (int y = 0; y < sizeFieldY; y++) {
            int countHorizont = 0;
            int countVertical = 0;
            for (int x = 0; x < sizeFieldX; x++) {

                // horizont start
                if (field[y][x] == symbol) {
                    countHorizont = countHorizont + 1;
                    if (countHorizont == seriesWin) {
                        return true;
                    }
                } else {
                    countHorizont = 0;
                }
                // horizont end

                //vertical
                if (field[x][y] == symbol) {
                    countVertical = countVertical + 1;
                    if (countVertical == seriesWin) {
                        return true;
                    }
                } else {
                    countVertical = 0;
                }
                // vertical end

                //diag1
                if (field[y][x] == symbol) {
                    int countDiag1 = 0;
                    for (int i = 1; i < seriesWin; i++) {
                        if (x + i >= sizeFieldX || y + i >= sizeFieldY) {
                            break;
                        }
                        if (field[y + i][x + i] == symbol) {
                            countDiag1++;
                            if (countDiag1 == seriesWin - 1) {
                                return true;
                            }
                        }
                    }
                }

                //diag2
                if (field[y][x] == symbol) {
                    int countDiag2 = 0;
                    for (int i = 1; i < seriesWin; i++) {
                        if (x - i <0  || y + i < 0) {
                            break;
                        }
                        if (field[y + i][x - i] == symbol) {
                            countDiag2++;
                            if (countDiag2 == seriesWin - 1) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isFieldFull() {
        for (int y = 0; y < sizeFieldY; y++) {
            for (int x = 0; x < sizeFieldX; x++) {
                if (field[y][x] == emptyChar) {
                    return false;
                }
            }
        }
        return true;
    }


}


