import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Use: java WordCount <path to CSV file> <word to search for>");
            System.exit(1);
        }

        String filePath = args[0];
        String searchWord = args[1];
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    if (value.contains(searchWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("The word '" + searchWord + "' was found " + count + " times.");
    }
}
