package easywords;
/*
 * @author b1018008 Shogo Kondo
 */
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map.Entry;

public class ReadRSS2 {
	private String address;
	public ReadRSS2(String address) {
		this.address = address;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> times;
		ReadRSS2 r = new ReadRSS2("http://newsrss.bbc.co.uk/rss/newsonline_uk_edition/health/rss.xml");
		try {
			times =r.reader();
			for(Entry<String, Integer> i: times.entrySet()) {
				System.out.println(i.getValue().toString()+":"
						+ i.getKey());
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

}
