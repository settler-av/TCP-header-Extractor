import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    /**
     * @param args CLI args
     * @author 20CE155 Adnan Vahora
     * @since v1.0 16/9/2021
     */
    public static void main(String[] args) throws IOException {
        System.out.println("This program is prepared by  20CE155 ADNAN VAHORA\n" +
                "Total line of code = <<value>>\n" +
                "Total lines for comment= <<value>>\n");

        System.out.println("Enter path of input file along with file name: ");
        Scanner userInput = new Scanner(System.in);
        String fileName = userInput.nextLine();
        try {
            Scanner inputFile = new Scanner(Path.of(fileName),
                    StandardCharsets.UTF_8);

        } catch (IOException e) {
            System.out.println("File does not exists");
        }
        String fileData = inputFile.nextLine();
        System.out.println(fileData);

    }
}
