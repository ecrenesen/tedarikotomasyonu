import java.io.FileNotFoundException;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            if (i == 100) {
                break;
            }
            System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////");
            System.out.println("SEÇİM EKRANINA YÖNLENDİRİLİYORSUNUZ");
            System.out.println("Ürün eklemek istiyorsanız 1'e tıklayın.. \n" +
                    "Stok güncellemek istiyorsanız 2'ye tıklayın..\n" +
                    "Ürün silmek istiyorsanız 3'e tıklayın..\n" +
                    "Depo bilgilerini görmek istiyorsanız 4'e tıklayın..\n" +
                    "Ayrı sınıfların çalışan bilgilerini görmek istiyorsanız 5'e tıklayın..\n" +
                    "Personel eklemek istiyorsanız 6'ya tıklayın..\n" +
                    "Yetkinizi sorgulamak istiyorsanız 7'ye tıklayın..\n" +
                    "Programdan çıkış yapmak için 8'e tıklayın..");
//Kullanıcı yapmak istediği işlemleri burada seçer
            String secim = scan.next();
            if (secim.equalsIgnoreCase("1")) {
                UrunEkle ürünEkleme = new UrunEkle();
                ürünEkleme.uruneklemefonksiyonu();

            } else if (secim.equalsIgnoreCase("2")) {
                UrunStokGuncelle urunStokGuncelle = new UrunStokGuncelle();
                urunStokGuncelle.urunstokgüncelleme();

            } else if (secim.equalsIgnoreCase("3")) {
                UrunSilme urunSilme = new UrunSilme();
                urunSilme.urunSilmeFonksiyonu();
            } else if (secim.equalsIgnoreCase("4")) {
                DepoBilgileriniGoruntule.depoBilgileriniGoruntule();

            } else if (secim.equalsIgnoreCase("5")) {
                UrunStokGuncelle urunStokGuncelle= new UrunStokGuncelle();
                UrunEkle urunEkle = new UrunEkle();
                DepoBilgileriniGoruntule depoBilgileriniGoruntule = new DepoBilgileriniGoruntule();
                UrunSilme urunSilme = new UrunSilme();
                urunStokGuncelle.sorumlular();
                urunEkle.sorumlular();
                depoBilgileriniGoruntule.sorumlular();
                urunSilme.sorumlular();
            } else if (secim.equalsIgnoreCase("6")) {
                PersonelEkleme personelEkleme = new PersonelEkleme();
                personelEkleme.personel_Ekle();
            } else if (secim.equalsIgnoreCase("7")) {
                System.out.println("ID'inizi GİRİNİZ");
                String name = scan.next();
                YetkiSorgulama fileSearch = new YetkiSorgulama();
                fileSearch.parseFile("C:\\Users\\EYLÜL UÇAR\\Desktop\\test.txt", name);
                //aradığımız ID yöneticinin bilgisayarında var mı diye kontrol ediyoruz..
            }
            else if (secim.equalsIgnoreCase("8")) {
                System.out.println("Programdan çıkılıyor...");
                break;
            }
        }
    }


}