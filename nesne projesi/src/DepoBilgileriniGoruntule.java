import java.sql.*;
import java.util.Scanner;

public class DepoBilgileriniGoruntule extends DBHelper implements ILogin {
    boolean test = false;


    Scanner scan = new Scanner(System.in);

    public static void depoBilgileriniGoruntule() throws SQLException {
        DepoBilgileriniGoruntule depoBilgileriniGoruntule = new DepoBilgileriniGoruntule();

        depoBilgileriniGoruntule.giris();
        if (depoBilgileriniGoruntule.getTest()==true){

        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        ResultSet resultSet = null;
        Scanner scan = new Scanner(System.in);
        try {
            connection = dbHelper.getConnection();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery("select*from giyim.giyimbilgileri;");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            try {
                System.out.print("barkod numarası: ");System.out.print(resultSet.getInt("barkodno"));
                System.out.print("     ");System.out.print("kategorisi: ");System.out.print(resultSet.getString("tur"));
                System.out.print("     ");System.out.print("fiyatı: ");System.out.print(resultSet.getString("fiyat"));
                System.out.print("     ");System.out.print("rengi: ");System.out.print(resultSet.getString("renk"));
                System.out.print("     ");System.out.print("stok adeti: ");System.out.print(resultSet.getString("stok"));
                System.out.print("     "); System.out.println("\n");
              } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }}
        else System.out.println("  ");
    }

    @Override
    public void sorumlular() {
        System.out.println("Depo bilgilerini düzenlemekten sorumlu kişiler: " +
                "Çağla Aksoy, " +
                "İlayda Özbekoğlu");
    }
}