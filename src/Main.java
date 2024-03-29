import javax.print.attribute.standard.PDLOverrideSupported;
import javax.swing.*;
import java.io.*;
import java.io.BufferedWriter;
import java.lang.ref.SoftReference;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("Dosya İşlemleri\n1: Yazma \n2: Okuma\n3: Çıkış");
            int userVote = input.nextInt();
            input.nextLine();
            switch (userVote) {
                case 1:
                    System.out.println("Kayıt Dosya Adı Giriniz");
                    String fileName = input.nextLine();
                    File fileText = new File(fileName);
                    if (fileText.exists()) {
                        System.out.println("Kaydedilecek metni giriniz");
                        String text = input.nextLine();

                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileText, true));
                            bufferedWriter.write(text);
                            bufferedWriter.newLine();
                            System.out.println("Metin kaydedildi");
                            bufferedWriter.close();
                        } catch (IOException e) {
                            e.getMessage();
                        }
                    } else {
                        System.out.println("Dosya Mevcut Degil Oluşturulsunmu: E / H");
                        String userInp = input.nextLine();
                        if (userInp.equalsIgnoreCase("e")) {
                            System.out.println("Yeni Dosya Adını Giriniz");
                            fileName = input.nextLine();
                            fileText = new File(fileName);
                            try {
                                fileText.createNewFile();
                                System.out.println("Dosya Olusturuldu");

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }

                    }

                    break;
                case 2:
                    System.out.println("Okunacak Dosya Adını Giriniz");
                    fileName = input.nextLine();
                    //fileText = new File(fileName);
                    File readFile = new File(fileName);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(readFile));
                        String Line;
                        while ((Line = bufferedReader.readLine()) != null) {
                            System.out.println("Kayıtlı Metinleriniz\n" + Line);
                        }

                    } catch (FileNotFoundException e) {
                        System.err.println("Dosya bulunamadı: " + e.getMessage());
                    } catch (IOException e) {
                        System.err.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
                    }
                    break;

                case 3:
                    flag = false;
                    System.out.println("Çıkış yapıldı");
                    break;
            }


        }


    }
}
