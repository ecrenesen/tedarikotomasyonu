
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UrunStokGuncelle extends DBHelper implements ILogin {
    Boolean test = false;
    public ArrayList<String> urunstokgüncelleme() throws SQLException {
        UrunStokGuncelle urunStokGuncelle = new UrunStokGuncelle();
        urunStokGuncelle.giris();
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        ResultSet resultSet;
        Scanner scan = new Scanner(System.in);
        ArrayList<String> giyimtür = new ArrayList<>();
        ArrayList<String> giyimbarkod = new ArrayList<>();
        ArrayList<String> giyimfiyat = new ArrayList<>();
        ArrayList<String> giyimrenk = new ArrayList<>();
        ArrayList<String> giyimstok = new ArrayList<>();
        //eğer kullanıcı doğru şifre ve kullanıcı adı ile giriş yaptıysa işlemler burada başlatılır..
        if (urunStokGuncelle.getTest() == true) {
            try {
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select*from giyim.giyimbilgileri");
                System.out.println("Aramak istediğiniz ürünün türünü giriniz:");
                String urunTur = scan.next();

                while (resultSet.next()) {
                    giyimbarkod.add(resultSet.getString("barkodno"));
                    giyimtür.add(resultSet.getString("tur"));
                    giyimfiyat.add(resultSet.getString("fiyat"));
                    giyimrenk.add(resultSet.getString("renk"));
                    giyimstok.add(resultSet.getString("stok"));
                }
                if (giyimtür.contains(urunTur)) {
                    System.out.println("yeni stok kaç olsun:");
                    Integer stok = scan.nextInt();
                    preparedStatement = connection.prepareStatement("update giyim.giyimbilgileri set stok=? where tur='" + urunTur + "'");
                    preparedStatement.setInt(1, stok);
                    int result = preparedStatement.executeUpdate();
                    System.out.println("Aradığınız ürün veritabanına kaydedilmiştir..\n Yeni " + urunTur + " : Yeni Stok:" + stok + "..");
                } else {
                    System.out.println("Aradığınız ürün veritabanında bulunamamıştır!");
                }
            } catch (SQLException exception) {
                dbHelper.showErrorMessage(exception);
            } finally {
                connection.close();
            }
        }
        else
        {
            System.out.println("");
        }
        return giyimbarkod;

    }
    @Override
    public void sorumlular() {
        System.out.println("Stok güncelleme işinden sorumlu kişiler: " +
                "Berfin Dalar, " +
                "Meltem Savaş");
    }
}