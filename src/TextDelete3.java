import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TextDelete3 {

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // ファイル入出力（MS932からUTF8へ変換）
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("C:\\Users\\CHO YEONGHYEON\\Desktop\\TextFileSystem\\sample.txt"), "UTF8"));
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("C:\\Users\\CHO YEONGHYEON\\Desktop\\TextFileSystem\\sample2.txt"), "UTF8"));

            String line;

            for (int i = 0; i >= 0; i++) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(line);
                if (sb.substring(0, 2).endsWith("KK")) { // 名前がEEならその行を削除する。

                } else {
                    bw.write(line);
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ie) {
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ie) {
                }
            }
        }

        try {
            // ファイル入出力（MS932からUTF8へ変換）
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("C:\\Users\\CHO YEONGHYEON\\Desktop\\TextFileSystem\\sample2.txt"), "MS932"));
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("C:\\Users\\CHO YEONGHYEON\\Desktop\\TextFileSystem\\sample.txt"), "UTF8"));

            String line;
            while ((line = br.readLine()) != null) {

                // ファイルへ書き込み
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ie) {
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ie) {
                }
            }
        }
    }
}