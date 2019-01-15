public class Main {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\PixelFox\\Desktop\\1.txt";
        FileManager filemanager = new FileManager();
        filemanager.changeLine(filePath);
        filemanager.changeWord(filePath);
    }
}