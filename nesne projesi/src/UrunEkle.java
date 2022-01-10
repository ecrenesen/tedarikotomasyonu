import java.sql.*;
import java.util.Scanner;

public class UrunEkle extends DBHelper implements ILogin {
    boolean test = false;

    public static void uruneklemefonksiyonu() throws SQLException {
        UrunEkle urunEkleEkleme = new UrunEkle();
        urunEkleEkleme.giris();
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        ResultSet resultSet;
        Scanner scan = new Scanner(System.in);
        //eğer kullanıcı doğru şifre ve kullanıcı adı ile giriş yaptıysa işlemler burada başlatılır..
        if (urunEkleEkleme.getTest() == true) {
            try {

                connection = dbHelper.getConnection();
                String sql = "insert into giyimbilgileri(barkodno, tur,fiyat,renk,stok) values(?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println("Eklemek istediğiniz ürünün barkod numarasını giriniz..");
                int barkod = scan.nextInt();
                preparedStatement.setInt(1, barkod);
                System.out.println("Eklemek istediğiniz ürünün türünü giriniz..");
                String tur = scan.next();
                preparedStatement.setString(2, tur);
                System.out.println("Eklemek istediğiniz ürünün fiyatını  giriniz");
                int fiyat = scan.nextInt();
                preparedStatement.setInt(3, fiyat);
                System.out.println("Eklemek istediğiniz ürünün rengini giriniz..");
                String renk = scan.next();
                preparedStatement.setString(4, renk);
                System.out.println("Eklemek istediğiniz ürünün stoğunu giriniz..");
                int stok = scan.nextInt();
                preparedStatement.setInt(5, stok);
                int result = preparedStatement.executeUpdate();
                System.out.println("Kayıt Eklendi");
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
                dbHelper.showErrorMessage(exception);

            } finally {
                connection.close();
                preparedStatement.close();
            }
        }
        else System.out.println(" ");
    }


    @Override
    public void sorumlular() {
        System.out.println("Ürün ekleme işinden sorumlu kişiler: " +
                "Ece Şahin, " +
                "Altay Donuk");
    }
}