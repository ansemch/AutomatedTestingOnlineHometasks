package JavaInputOutputFundamentals;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Scanner;

public class JavaInputOutputMain {

    static int countCalls=0;

    public static void main(String args[]) throws IOException {
        FileWriter writer = new FileWriter("data/dirStructure.txt");
        writeDirStructure (args [0], writer);
        readDirStructure ("data/dirStructure.txt");
    }

    static void writeDirStructure (String root, FileWriter writer) throws IOException {
        File f = new File(root);
        if(!f.exists()) {
            System.out.println("\nNot found: " + root);
            return;
        }
        if(f.isDirectory()) {
            String[] listFilesDirs = f.list();
            if (listFilesDirs.length == 0)
                if (countCalls==0) return;
                else {
                    System.out.println(root + File.separator);
                    return;
            }
            countCalls++;
            for(int i = 0; i < listFilesDirs.length; i++) {
                File f1 = new File(root + File.separator + listFilesDirs[i]);
                if(f1.isFile()) {
                    writer.write(root + File.separator + listFilesDirs[i] + "\n");
                    writer.flush();
                }
                else writeDirStructure (root + File.separator + listFilesDirs[i], writer);
            }
        }
    }

    static void readDirStructure (String fileName) throws FileNotFoundException {
        int numDirs=0;
        int numFiles=0;
        int lengthFileName=0;
        Scanner sc = new Scanner(new File(fileName));
        String line;
        while(sc.hasNext()) {
            line = sc.nextLine();
            if (line.endsWith("\\")) numDirs++;
            else numFiles++;
            line = line.replace('\\','/');
            String [] substrs = line.split("/");
            lengthFileName += substrs[substrs.length-1].length();
        }
        System.out.println("Количество папок");
        System.out.println(numDirs);
        System.out.println("Количество файлов");
        System.out.println(numFiles);
        if (numDirs>0) {
            System.out.println("Среднее количество файлов в папке");
            System.out.println((float) numFiles / (float) numDirs);
        }
        if (numFiles>0) {
            System.out.println("Средняя длина названия файла");
            System.out.println((float) lengthFileName / (float) numFiles);
        }
    }
}