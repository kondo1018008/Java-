package themes0;
/*
 * @author b1018008 Shogo Kondo
 * */
import java.io.*;

public class Document1 {
	public Document1(String path) throws IOException {
		// ここを実装
		FileReader is = new FileReader(path);
		BufferedReader br = new BufferedReader(is);
		String line = null;
		while((line = br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}

	// 動作確認用
	public static void main(String[] args) {
		try {
			Document1 doc = new Document1("wakati/10.txt");
		} catch (IOException e) {
			System.out.println("入出力エラー: " + e.getMessage());
		}
	}
}
