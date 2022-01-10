import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBHelper {
    private String userName = "root";
    private String password = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306/giyim";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void showErrorMessage(SQLException exception) {
        System.out.println("Error:" + exception.getMessage());
        System.out.println("Error code:" + exception.getErrorCode());
    }
    private boolean test;
//her class için çağırdığımız sorgu ekranı..
    public void giris() {
        Scanner scan = new Scanner(System.in);
        System.out.println("SİSTEMİN SİZE VERMİŞ OLDUĞU KULLANICI ADINI VE ŞİFREYİ GİRMENİZ GEREKMEKTEDİR  \n" +
                "EĞER BU VERİLERE SAHİP DEĞİLSENİZ YETKİ SORGULAMA EKRANINA DÖNMELİSİNİZ \n" +
                "Kullanıcı adını giriniz:..");
        String kullanıcıadı = scan.next();
        System.out.println("şifre giriniz..");
        String sifre = scan.next();
        if (kullanıcıadı.equals("admin") && sifre.equals("bilgisayar")) {
            System.out.println("İşlemleri yapabilirsiniz..");
            setTest(true);
        } else {
            System.out.println("Şifre veya kullanıcı adı hatalı.. Seçim ekranına yönlendiriliyorsunuz.. ");
            setTest(false);
        }

    }
    public boolean getTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
}