import java.sql.*;
import java.util.Scanner;

public class PersonelEkleme extends DBHelper {
    Boolean test = false;

    public void personel_Ekle() throws SQLException {
        PersonelEkleme personelEkleme = new PersonelEkleme();
        PersonelEkleme Personelekle = new PersonelEkleme();
        personelEkleme.giris();
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        ResultSet resultSet;
        Scanner scan = new Scanner(System.in);
        //eğer kullanıcı doğru şifre ve kullanıcı adı ile giriş yaptıysa işlemler burada başlatılır..
        if (personelEkleme.getTest() == true) {
            try {

                connection = dbHelper.getConnection();
                String sql = "insert into personeller(kullaniciadi,sifre,ad,soyad) values(?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql);
                System.out.println("Eklemek istediğiniz kişinin kullanıcıadını giriniz..");
                String kullaniciadi = scan.next();
                preparedStatement.setString(1, kullaniciadi);
                System.out.println("Eklemek istediğiniz kişinin şifresini giriniz..");

                String sifre = scan.next();
                preparedStatement.setString(2, sifre);
                System.out.println("Eklemek istediğiniz kişinin adını  giriniz");
                String ad = scan.next();
                preparedStatement.setString(3, ad);
                System.out.println("Eklemek istediğiniz kişinin soyadını  giriniz");
                String soyad = scan.next();
                preparedStatement.setString(4, soyad);
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


    }
}