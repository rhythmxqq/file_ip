package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("введите айпи адресс");
            String ipishka = in.nextLine();
            ipProverka(
                    ipishka
            );
        }
        private static void ipProverka(String... Ipadress) {
            Pattern ip = Pattern.compile("(\\\\s|^)(([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}");
            String iip = null;
            for (String nip : Ipadress) {
               Matcher m = ip.matcher(nip);
                if (m.find()) {
                    iip = m.group();
                    System.out.print("найден ip адресс найден и записан в файл");
                }
                else {
                   iip = "корректного ip в веденной строке нет";
                   System.out.println("ответ в файлике");
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("FindIp.txt")))
            {
                String text = iip;
                String textt= " ip адресс ";
                bw.write(textt);
                bw.write(text);
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
}
