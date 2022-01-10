import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UrunSilme extends DBHelper implements ILogin {
    Scanner scan = new Scanner(System.in);
    boolean test = false;

    public ArrayList<String> urunSilmeFonksiyonu() throws SQLException {
        UrunSilme urunSilme = new UrunSilme();
        urunSilme.giris();
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        ResultSet resultSet;
        Scanner scan = new Scanner(System.in);
        ArrayList<String> giyimtur = new ArrayList<>();
        //eğer kullanıcı doğru şifre ve kullanıcı adı ile giriş yaptıysa işlemler burada başlatılır..
        if (urunSilme.getTest() == true) {
            try {
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select*from giyim.giyimbilgileri");
                System.out.println("Hangi türdeki ürünü silmek istiyorsunuz? ");
                String tur = scan.next();

                while (resultSet.next()) {
                    giyimtur.add(resultSet.getString("tur"));
                }

                if (giyimtur.contains(tur)) {

                    preparedStatement = connection.prepareStatement("delete from giyimbilgileri where tur=?");
                    preparedStatement.setString(1, tur);
                    int result = preparedStatement.executeUpdate();
                    System.out.println("Silmek istediğiniz ürün veritabanından silinmiştir! ");
                } else {
                    System.out.println("Silmek istediğiniz ürün veritabanında bulunamamıştır! ");
                }

            } catch (SQLException exception) {
                dbHelper.showErrorMessage(exception);

            } finally {
                connection.close();
            }
        }
        return giyimtur;
    }

    @Override
    public void sorumlular() {
        System.out.println("Ürün silme işinden sorumlu kişiler: " +
                "Ecren Nur Esen, " +
                "Eylül Uçar");
    }


}