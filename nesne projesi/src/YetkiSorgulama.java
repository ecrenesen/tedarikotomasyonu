import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class YetkiSorgulama extends DBHelper{
//bu ekranda kullanıcı yönetici bilgisayarındaki dosyadan yetkisi olup olmadığını sorgular..
    public void parseFile(String fileName, String arananID) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        while (scan.hasNext()) {
            String line = scan.nextLine().toLowerCase().toString();
            if (line.contains(arananID)) {
                System.out.println("Yetkiniz var giriş yapabilirsiniz\n" +
                        "Kullanıcı adı: admin\n" +
                        "Şifre: bilgisayar");
                return;
            } else if (line.contains(arananID) == false) {
                System.out.println("Yetkiniz yok giriş ekranına yönlendiriliyorsunuz...");
                return;
            }

        }


    }
}