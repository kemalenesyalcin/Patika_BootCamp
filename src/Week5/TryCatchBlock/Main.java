package Week5.TryCatchBlock;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen dizideki bir indeks girin (0-9): ");
        int index = scanner.nextInt();

        try {
            int element = getElementAtIndex(array, index);
            System.out.println("Dizideki " + index + ". indeksteki eleman: " + element);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Hata: Belirtilen indeks dizi boyutunun dışında!");
        }
    }
    public static int getElementAtIndex(int[] array, int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // Belirtilen indeksteki elemanı döndür
        return array[index];
    }
}

