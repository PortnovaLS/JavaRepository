package PackageLesson6;

import java.io.*;

public class MySixthClass {

    public static void main (String [] args) {


        try {
            FileInputStream fileInputStream = new FileInputStream("File1");
            FileInputStream fileInputStream2 = new FileInputStream("File2");
            FileOutputStream fileOutputStream = new FileOutputStream("File3.txt");
            PrintStream ps = new PrintStream(fileOutputStream);
            int inputByte;
            while ((inputByte = fileInputStream.read()) != -1) {
                ps.print((char) inputByte);
            }
            while ((inputByte = fileInputStream2.read()) != -1){
                ps.print((char) inputByte);
            }
            fileInputStream.close();
            fileInputStream2.close();
            fileOutputStream.close();
            ps.close();
            fileOutputStream.flush();


        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            ;
        }
    }




    }



