package Week6.NotePadUygulamasi;
import java.io.*;
import java.util.Scanner;

public class NotepadUygulamasi {
    public static void main(String[] args) {
        // Kullanıcıdan metin girişi almak için Scanner kullanılmıştır.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir metin girin: ");
        String metin = scanner.nextLine();

        // Metni dosyaya kaydetmek için bir metod çağırılmıştır.
        kaydet(metin);

        // Kaydedilen metni okumak için bir metod çağırılmıştır.
        String okunanMetin = oku();
        if (okunanMetin != null) {
            System.out.println("En son kaydedilen metin:");
            System.out.println(okunanMetin);
        } else {
            System.out.println("Kaydedilen bir metin bulunamadı.");
        }
    }

    public static void kaydet(String metin) {
        try {
            FileWriter fileWriter = new FileWriter("notlar.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(metin);
            printWriter.close();
            System.out.println("Metin başarıyla dosyaya kaydedildi.");
        } catch (IOException e) {
            System.out.println("Dosya kaydedilirken bir hata oluştu: " + e.getMessage());
        }
    }

    public static String oku() {
        try {
            FileReader fileReader = new FileReader("notlar.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String okunanMetin = bufferedReader.readLine();
            bufferedReader.close();
            return okunanMetin;
        } catch (IOException e) {
            System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
            return null;
        }
    }
}