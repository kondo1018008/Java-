package easywords;
/*
 * @author b1018008 Shogo Kondo
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ReadRSS3 {
	private String address;
	public ReadRSS3(String address) {
		this.address = address;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ReadRSS3 rss = new ReadRSS3("http://newsrss.bbc.co.uk/rss/newsonline_uk_edition/health/rss.xml");
			for (Map.Entry<String, Integer> entry: rss.sort(rss.reader(), false)) {
				System.out.println(entry.getValue() + ":" + entry.getKey());
			}
		} catch (IOException e) {
			System.out.println("入出力エラー");
		}

	}
	
	public HashMap<String,Integer> reader()throws IOException {
		URL url = new URL(this.address);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		HashMap<String, Integer> a = new HashMap<>();
		while((line = br.readLine())!=null) {
			line = line.trim().toLowerCase();
			if(line.startsWith("<description>")) {
				//line = line.trim().toLowerCase();
				line = line.replaceAll("<description><!\\[cdata\\[", "");
				line = line.replaceAll("\\]\\]></description>", "");
				String [] lines = line.split("[<> ,/\\?\\]\\[\\.\"]+");
				for(String i :lines) {
					if(i.length()>=1) {
						if(!a.containsKey(i)) {
							a.put(i, 1);
						}else {
							a.put(i, a.get(i)+1);
						}
					}
					//System.out.print("("+i+")");
				}
				//System.out.println();
			}
		}
		br.close();
		return a;
	}
	
	public ArrayList<Map.Entry<String, Integer>> sort(HashMap<String, Integer> map, boolean asc) {
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet()); // HashMapに格納されているデータをArrayListに変換
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
				//return 0; // エラー回避のためのダミー実装
				if(!asc) {
					if(entry1.getValue().intValue()>entry2.getValue().intValue()) {
						return -1;
					}else if(entry1.getValue().intValue()<entry2.getValue().intValue()){
						return 1;
					}else {
						return entry2.getKey().compareTo(entry1.getKey());
					}
				}else {
					if(entry1.getValue().intValue()>entry2.getValue().intValue()) {
						return 1;
					}else if(entry1.getValue().intValue()<entry2.getValue().intValue()){
						return -1;
					}else {
						return entry2.getKey().compareTo(entry1.getKey());
					}
				}
			}
		});
		return list;
	}

}
