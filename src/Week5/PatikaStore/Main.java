package Week5.PatikaStore;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Brand> brands = new TreeMap<>();
    private static final Map<Integer, Product> products = new HashMap<>();
    private static int productIdCounter = 1;

    public static void main(String[] args) {
        initializeBrands();
        initializeProducts();

        int choice;
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    listNotebooks();
                    break;
                case 2:
                    listSmartphones();
                    break;
                case 3:
                    listBrands();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void initializeBrands() {
        brands.put(1, new Brand(1, "Samsung"));
        brands.put(2, new Brand(2, "Lenovo"));
        brands.put(3, new Brand(3, "Apple"));
        brands.put(4, new Brand(4, "Huawei"));
        brands.put(5, new Brand(5, "Casper"));
        brands.put(6, new Brand(6, "Asus"));
        brands.put(7, new Brand(7, "HP"));
        brands.put(8, new Brand(8, "Xiaomi"));
        brands.put(9, new Brand(9, "Monster"));
    }

    private static void initializeProducts() {
        products.put(productIdCounter++, new Notebook(productIdCounter, 7000.0, 0.0, 10, "HUAWEI Matebook 14", brands.get(4), 16, 512, 14.0));
        products.put(productIdCounter++, new Notebook(productIdCounter, 3699.0, 0.0, 20, "LENOVO V14 IGL", brands.get(2), 8, 1024, 14.0));
        products.put(productIdCounter++, new Notebook(productIdCounter, 8199.0, 0.0, 15, "ASUS Tuf Gaming", brands.get(6), 32, 2048, 15.6));

        products.put(productIdCounter++, new SmartPhone(productIdCounter, 3199.0, 0.0, 30, "SAMSUNG GALAXY A51", brands.get(1), 128, 6.5, 32, 4000.0, 6, "Siyah"));
        products.put(productIdCounter++, new SmartPhone(productIdCounter, 7379.0, 0.0, 25, "iPhone 11 64 GB", brands.get(3), 64, 6.1, 5, 3046.0, 6, "Mavi"));
        products.put(productIdCounter++, new SmartPhone(productIdCounter, 4012.0, 0.0, 35, "Redmi Note 10 Pro 8GB", brands.get(8), 128, 6.5, 35, 4000.0, 12, "Beyaz"));
    }

    private static void displayMainMenu() {
        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefonu İşlemleri");
        System.out.println("3 - Marka Listele");
        System.out.println("0 - Çıkış Yap");
        System.out.print("Tercihiniz : ");
    }

    private static void listBrands() {
        System.out.println("Markalarımız\n--------------");
        for (Brand brand : brands.values()) {
            System.out.println("- " + brand.getName());
        }
    }

    private static void listNotebooks() {
        System.out.println("\nNotebook Listesi\n");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Product product : products.values()) {
            if (product instanceof Notebook notebook) {
                System.out.printf("| %-2d | %-30s | %-9.2f | %-9s | %-8d | %-11.1f | %-3d |\n",
                        notebook.getId(), notebook.getProductName(), notebook.getUnitPrice(), notebook.getBrand().getName(),
                        notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    private static void listSmartphones() {
        System.out.println("\nCep Telefonu Listesi\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (Product product : products.values()) {
            if (product instanceof SmartPhone phone) {
                System.out.printf("| %-2d | %-30s | %-9.2f | %-9s | %-8d | %-11.1f | %-9d | %-9.1f | %-9d | %-9s |\n",
                        phone.getId(), phone.getProductName(), phone.getUnitPrice(), phone.getBrand().getName(),
                        phone.getStorage(), phone.getScreenSize(), phone.getCamera(), phone.getBatteryPower(),
                        phone.getRam(), phone.getColor());
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Diğer metotlar (ürün ekleme, güncelleme, silme vb.) buraya eklenebilir.

}