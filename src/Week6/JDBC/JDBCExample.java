package Week6.JDBC;

import java.sql.*;

public class JDBCExample {
    // Veritabanı bağlantı bilgileri
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/deneme"; // Veritabanı URL'si (testdb yerine kendi veritabanı adınızı yazın)
    static final String USER = "root"; // Veritabanı kullanıcı adı
    static final String PASS = "mysql"; // Veritabanı şifresi

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Veritabanı sürücüsünü yükle
            Class.forName(JDBC_DRIVER);

            // Veritabanına bağlan
            System.out.println("Veritabanına bağlanılıyor...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Tablo oluşturma işlemi
            System.out.println("Tablo oluşturuluyor...");
            stmt = conn.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employees ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(50),"
                    + "position VARCHAR(50),"
                    + "salary DOUBLE"
                    + ")";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Tablo oluşturuldu.");

            // Veri ekleme işlemi
            System.out.println("Veri ekleniyor...");
            String insertSQL = "INSERT INTO employees (name, position, salary) VALUES "
                    + "('berk mustafa', 'Manager', 5000.0),"
                    + "('harry potter', 'wizard', 4000.0),"
                    + "('solo leveling ', 'ruh çağıran', 3500.0),"
                    + "('edward elric ', 'simyacı', 4500.0),"
                    + "('roy mustang', 'gomutan', 2500.0)";
            stmt.executeUpdate(insertSQL);
            System.out.println("Veri eklendi.");

            // Verileri ekrana yazdırma
            System.out.println("Veriler okunuyor...");
            String selectSQL = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Kaynakları temizle
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
