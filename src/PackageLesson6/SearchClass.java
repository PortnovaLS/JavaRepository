package PackageLesson6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SearchClass {
    public static void main(String[] args) {
        findWord("File1","software");

    }

    public static void findWord(String fileName, String word) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            int symbol = 0;
            int index = 0;
            byte[] wordBytes = word.getBytes();
            while ((symbol = fileInputStream.read()) != -1) {
                if (wordBytes[index] == symbol) {
                    index++;
                    if (index == wordBytes.length) {
                        System.out.println("Word find");
                        break;

                    }
                }else {
                    index = 0;
                }
            }
            fileInputStream.close();

        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
