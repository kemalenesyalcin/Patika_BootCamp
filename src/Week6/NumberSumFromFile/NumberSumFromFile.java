package Week6.NumberSumFromFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class NumberSumFromFile {
    public static void main(String[] args) {
        String fileName = "numbers.txt"; // Dosya adını değiştirebilirsiniz

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int sum = 0;

            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                sum += number;
            }

            System.out.println("Dosyadaki sayıların toplamı: " + sum);
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Geçersiz sayı formatı: " + e.getMessage());
        }
    }
}
