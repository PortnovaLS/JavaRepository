package PackageLesson2;

public class MySecondClass {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
//        printArray(arr);
        int[] arr2 = replaceArray(arr);
        printArray(arr2);
        int[] arrTask2 = new int[8];
        arrTask2[0] = 1;
        printArray(fillNumbers(arrTask2));
        int[] arrTask3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(multiplyNumbers(arrTask3));
        int[] arrTask4 = {-10, 8, 4, 0, 6, 3};
        System.out.println(minFind(arrTask4));
        System.out.println(maxFind(arrTask4));
        int[][] arrTask5 = new int[5][5];
        fillDiagonal(arrTask5);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }

    public static int[] replaceArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        return arr;
    }

    public static int[] fillNumbers(int[] arrTask2) {
        for (int i = 1; i < arrTask2.length; i++) {
            arrTask2[i] = arrTask2[i - 1] + 3;
        }
        return arrTask2;
    }

    public static int[] multiplyNumbers(int[] arrTask3) {
        for (int i = 0; i < arrTask3.length; i++) {
            if (arrTask3[i] < 6) {
                arrTask3[i] *= 2;
            }
        }
        return arrTask3;
    }

    public static int minFind(int[] arrTask4) {
        int min = arrTask4[0];
        for (int i = 1; i < arrTask4.length; i++) {
            if (arrTask4[i] < min)
                min = arrTask4[i];
        }
        return min;
    }

    public static int maxFind(int[] arrTask4) {
        int max = arrTask4[0];
        for (int i = 1; i < arrTask4.length; i++) {
            if (arrTask4[i] > max)
                max = arrTask4[i];
        }
        return max;
    }

    public static void fillDiagonal(int[][] arrTask5) {
        for (int i = 0; i < arrTask5.length; i++) {
            for (int j = 0; j < arrTask5.length; j++) {
                if (i == j)
                    arrTask5[i][j] = 1;
                if (i + j == arrTask5.length - 1)
                    arrTask5[i][j] = 1;
                System.out.print(arrTask5[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

