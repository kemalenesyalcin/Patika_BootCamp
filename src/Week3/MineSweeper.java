package Week3;

import java.util.Random;
import java.util.Scanner;
public class MineSweeper //(Temel Fonksiyonlar 5. Madde.)
{
    Scanner input = new Scanner(System.in);
    int rowCount;
    int columnCount;
    int mineCount = 0;
    int time = 0;
    int selectedArea = 0;
    int rowNumber;
    int columnNumber;
    // Oyun Haritası, Mayın Haritası ve önceden kullanıcı tarafından girilmiş alanların haritası (SelectedAreaMap) tanımlandı.
    public String[][] gameMap;
    public String[][] mineMap;
    public String [][] selectedAreaMap;
    boolean isLose = true;
    boolean isWin = false;

    //Bu metod, oyun alanındaki mayın sayısını hesaplar.Satır ve sütun sayıları çarpılır ve dörde bölünür, böylece mayın sayısı belirlenir.
    public int mineCountCalculator (int rowCount, int columnCount)
    {
        this.mineCount = (rowCount * columnCount) / 4;
        return this.mineCount;
    }

    //Bu metod, bir oyun haritası oluşturur.Parametre olarak bir String dizisi alır.
    public String[][] crateMap(String[][] array)
    {
        for (int i = 0; i < this.rowCount; i++)
        {
            for (int j = 0; j < this.columnCount; j++)
            {
                array[i][j] = "-";
            }
        }
        return array;
    }
    //Bu metod,mayın haritasını görerek hareket etmek ve test amaçlı kullanılmak için bırakılmıştır.(98. yorum satırı kaldırılması gerekmektedir.)
    /*public void printMineMap() {
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                System.out.print(" " + this.mineMap[i][j]);
            }
            System.out.println("");
        }
        System.out.println("===========================");
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");
    }*/
    //Bu metod, oyun haritasını ekrana yazdırır.Her satır ve sütun için oyun haritasındaki değerler yazdırılır.
    public void printGameMap()
    {
        for (int i = 0; i < this.rowCount; i++)
        {
            for (int j = 0; j < this.columnCount; j++)
            {
                System.out.print(" " + this.gameMap[i][j]);
            }
            System.out.println("");
        }
    }
    //Bu metod, belirtilen koordinatlarda bir mayın olup olmadığını kontrol eder.Parametre olarak oyun haritası ve koordinat değerleri alır.
    public boolean isMine(String[][] arr, String value)
    {
        if (arr[this.rowNumber][this.columnNumber] == "*")
        {
            return true;
        }
        return false;
    }
    //Bu metod, oyun haritasına mayın yerleştirmek için rastgele bir koordinat belirler.Rastgele bir satır ve sütun numarası seçilir.
    public void randomSayi()
    {
        Random rdn = new Random();
        this.rowNumber = rdn.nextInt(this.rowCount);
        Random rdn2 = new Random();
        this.columnNumber = rdn2.nextInt(this.columnCount);
    }
    //Bu metod, oyunun ana işleyişini başlatır.Belirli bir mayın sayısına kadar rastgele mayınlar yerleştirilir.Oyun haritası oluşturulur ve ekrana yazdırılır. //(Temel Fonksiyonlar 8. Madde.)
    public void run()
    {
        for (int j = 0; j < this.rowCount; j++)
        {
            for (int k = 0; k < this.columnCount; k++)
            {
                if (time < this.mineCount)
                {
                    randomSayi();
                    time++;
                    if (!isMine(this.gameMap, "*"))
                    {
                        this.mineMap[rowNumber][columnNumber] = "*";
                        this.gameMap[rowNumber][columnNumber] = "*";
                    } else time--;
                }
            }
        }
        //printMineMap(); //test amaçlı burada bırakılmıştır.
        crateMap(this.gameMap);
        printGameMap();
        playMineSweeper();
    }
    //Bu metod, oyunun gerçek zamanlı oynanmasını sağlar.Kullanıcıdan satır ve sütun girişi alır, bu girişler geçerli mi kontrol eder.Kullanıcının girişine göre oyun haritası güncellenir ve ekrana yazdırılır.
    public void playMineSweeper()
    {
        while (this.isLose)
        {
            int nearBomb = 0;
            this.selectedArea++;
            //Girilen kordinatlar kontrol ediliyor ve hatalı ise kullanıcıdan yeniden girilmesi isteniyor
            boolean checkForWrongData = true;
            int row = 0;
            int column = 0;
            while (checkForWrongData)
            {
                System.out.println("Satır Giriniz : ");   //(Temel Fonksiyonlar 9. Madde.)
                if (input.hasNextInt())
                {
                    row = input.nextInt();
                    System.out.println("Sütun Giriniz : ");
                    if (input.hasNextInt())
                    {
                        column = input.nextInt();
                        if ((row >= 0 && row < this.rowCount) && (column >= 0 && column < this.columnCount))
                        {
                            checkForWrongData = false;
                        } else
                        {
                            System.out.println("Hatalı koordinat girdiniz. Lütfen geçerli bir koordinat giriniz !");        //(Temel Fonksiyonlar 10. Madde.)
                        }
                    } else
                    {
                        System.out.println("Lütfen sütun için geçerli bir tam sayı giriniz.");
                        input.next();
                    }
                } else
                {
                    System.out.println("Lütfen satır için geçerli bir tam sayı giriniz.");
                    input.next();
                }
            }
            //Girilen kordinatların daha önceden girilip girilmediği kontrol ediliyor.
            if(this.selectedAreaMap[row][column].equals("x"))
            {
                System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin !");
                this.selectedArea--;
            }
            System.out.println("===========================");
            if (this.mineMap[row][column].equals("*"))
            {
                System.out.println("Kaybettin ! ");
                for (int i = 0; i < this.rowCount; i++)
                {
                    for (int j = 0; j < this.columnCount; j++)
                    {
                        if (this.mineMap[i][j] =="*")
                        {
                            this.gameMap[i][j] = "*";
                        }
                    }
                }
                this.isLose=true;
                printGameMap();
                break;
            }

            //Bu dizinin her hücresi, oyun alanındaki kullanıcının seçtiği koordinatları izlemek için kullanılıyor. "x" değeri, kullanıcının daha önce zaten seçtiği bir hücreyi temsil eder.
            this.selectedAreaMap[row][column]=("x");
            for (int i = -1; i < 2; i++)
            {
                for (int j = -1; j < 2; j++)
                {
                    if ((row + i >= 0 && (row + i) <= (this.rowCount - 1)) && (column + j >= 0 && (column + j) <= (this.columnCount - 1)))
                    {
                        if (this.mineMap[row + i][column + j].equals("*"))
                        {
                            nearBomb++;
                            this.gameMap[row][column] = String.valueOf(nearBomb);
                        }
                        if (nearBomb == 0)
                        {
                            this.gameMap[row][column] = "0";
                        }
                    }
                }
            }
            if (this.selectedArea == this.rowCount * this.columnCount - this.mineCount)
            {
                this.isWin = true;
            }
            if (this.isWin == true)
            {
                this.isLose = false;
                System.out.println("KAZANDINIZ !!!");
            }
            printGameMap();
        }
    }
    //Bu metod, oyunun başlatılması için gerekli kullanıcı girişlerini alır.Satır ve sütun sayılarını kullanıcıdan alır.Girişlerin geçerliliğini kontrol eder ve oyun haritalarını oluşturur.
    public void enterGameArea()
    {
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");
        boolean isCheckArea = true;
        while(isCheckArea)
        {
            System.out.print("Satır Giriniz: ");   //(Temel Fonksiyonlar 7. Madde.)
            if (input.hasNextInt())
            {
                this.rowCount = input.nextInt();
                System.out.print("Sütun Giriniz : ");
                if (input.hasNextInt())
                {
                    this.columnCount = input.nextInt();
                    if (this.rowCount < 2 || this.columnCount < 2)
                    {
                        System.out.println("Lütfen en az 2x2 bir alan veya daha büyük bir alan belirleyin !");
                    } else
                    {
                        isCheckArea = false;
                    }
                } else
                {
                    System.out.println("Lütfen sütun için geçerli bir tam sayı giriniz !");
                    input.next();
                }
            } else
            {
                System.out.println("Lütfen satır için geçerli bir tam sayı giriniz !");
                input.next();
            }
        }
        this.mineMap = new String[this.rowCount][this.columnCount];
        this.gameMap = new String[this.rowCount][this.columnCount];
        this.selectedAreaMap = new String[this.rowCount][this.columnCount];
        mineCountCalculator(this.rowCount,this.columnCount);
        crateMap(this.mineMap);
        crateMap(this.gameMap);
        crateMap(this.selectedAreaMap);
        run();
    }
}