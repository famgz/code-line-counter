import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class App {

    // private static String pathTest = "  C:\\Users\\GOOZ\\Desktop\\LineCounter   ";
    private static String pathTest = "    \n\n \t   ";

    private static String path;
    private static int lines;
    private static int files;
    
    public void countLines(File file) throws FileNotFoundException, IOException {
        // https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line

        try {
			Scanner scanner = new Scanner(file);
            String line;

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
                if (line.trim().length() == 0) {
                    continue;
                }
                lines ++;
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        
        // System.out.println("Enter the path to project folder");
        // Scanner scanner = new Scanner(System.in);
        // String path = scanner.nextLine();

        String path = pathTest;

        System.out.println(path);

        System.exit(0);

        File dir = new File(path);
        
        if (!dir.exists()) {
            System.out.println("The given path does not exists.\nexiting");
            System.exit(1);
        }
        
        if (!dir.isDirectory()) {    
            System.out.println("The given path is not a folder.\nexiting");
            System.exit(1);
        }

        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                files ++;
            }
        }

    }
}