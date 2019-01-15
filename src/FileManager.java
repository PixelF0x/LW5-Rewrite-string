import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class FileManager {

    Vector<String> fileContentLine = new Vector<String>();

    boolean readFile(String filePath){
        InputStream in = null;

        try {
            in = new FileInputStream(filePath);
        } catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        try {
            while ((line = br.readLine()) != null){
                fileContentLine.add(line);
            }
            in.close();
        } catch (IOException e){
            System.out.println("Input Error");
        }

        return true;
    }

    boolean writeFile(String filePath){
        OutputStream out;
        try{
            out = new FileOutputStream(filePath,false);
        } catch(FileNotFoundException e){
            return false;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));


        try {
            for (String s:fileContentLine) {
                bw.write(s+"\r\n");
            }
            bw.flush();
        }catch (IOException e){
            return false;
        }

        fileContentLine.clear();

        return true;
    }

    boolean changeLine(String filePath){
        System.out.println("String replacement function\n");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the line number you want to replace");
        int stringNum=scan.nextInt();
        System.out.println("Enter the string you want to insert");
        scan.nextLine();
        String newString = scan.nextLine();

        readFile(filePath);
        fileContentLine.set(stringNum,newString);
        writeFile(filePath);

        System.out.println("Successfully\n");
        return true;
    }

    boolean changeWord(String filePath){
        System.out.println("Word replacement function\n");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the line number, the word in which you want to replace");
        int stringNum = scan.nextInt();
        System.out.println("Enter the number of the word you want to replace");
        int wordNum = (scan.nextInt()) + 1;
        System.out.println("Enter the word you want to insert");
        String newWord = scan.next();

        readFile(filePath);
//F!?
        String[] words = fileContentLine.elementAt(stringNum).split(" ");
        words[wordNum] = " "+newWord+" ";
        StringBuilder builder = new StringBuilder();
        for(String w:words){
            builder.append(w);
        }
        fileContentLine.set(stringNum,builder.toString());

        writeFile(filePath);
        System.out.println("Successfully\n");
        return true;
    }
}
