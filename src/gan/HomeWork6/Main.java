package gan.HomeWork6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        createConcatFile("text1.txt","text2.txt");
    }

    public static void createConcatFile(String nameFile1, String nameFile2){
        try {
            FileOutputStream fos = new FileOutputStream(nameFile1 + " + " + nameFile2, true);
            String readSrt1 = readFile(nameFile1);
            String readSrt2 = readFile(nameFile2);
            byte[] str1 = readSrt1.getBytes();
            byte[] str2 = readSrt2.getBytes();
            fos.write(str1);
            fos.write(str2);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String nameFile){
        StringBuilder text = new StringBuilder(nameFile);
        try {
            FileInputStream fis = new FileInputStream(nameFile);
            int outbox;
            while ((outbox = fis.read()) != -1){
                text.append((char)outbox);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
