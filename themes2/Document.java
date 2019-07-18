package themes2;
/*
 * @author b1018008 Shogo Kondo
 * */
import java.util.*;
import java.io.*;
public class Document  {
	private String path;
	private HashMap<String, Integer> wordCount;
	public Document(String path)throws IOException {
		this.path = path;
		this.wordCount = new HashMap<>();
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line = br.readLine())!=null) {
			String [] lines = line.split(" ");
			for(String s:lines) {
				if(s.length()>1) {
					if(this.wordCount.containsKey(s)) {
						this.wordCount.put(s, this.wordCount.get(s)+1);
					}else {
						this.wordCount.put(s, 1);
					}
				}
			}
			
		}
		br.close();
	}
	
	public String getPath() {
		return this.path;
	}
	public Set<String> getWords() {
		return this.wordCount.keySet();
	}
	
	// 動作確認用
	public static void main(String[] args) {
		try {
			Document doc = new Document("wakati/10.txt");
			String[] words = new String[] {
					"情報",
					"システム",
					"コンピュータ",
					"デザイン",
			};
			for (String w: words) {
				System.out.println(w + ":" + doc.calcTF(w));
			}
		} catch (IOException e) {
			System.out.println("入出力エラー: " + e.getMessage());
		}
	}
	
	public double calcTF(String st) {
		double sum=0;
		for(Map.Entry<String, Integer> e: this.wordCount.entrySet()) {
			sum+=e.getValue();
		}
		
		if(this.wordCount.containsKey(st)) {
			return this.wordCount.get(st)/sum;
		}else {
			return 0.0;
		}
	}
	
}
