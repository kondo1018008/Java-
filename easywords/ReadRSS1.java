package easywords;
/*
 * @author b1018008 Shogo Kondo
 */
import java.io.*;
import java.net.*;

public class ReadRSS1 {
	private String address;
	public ReadRSS1(String address) {
		this.address = address;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadRSS1 r = new ReadRSS1("http://newsrss.bbc.co.uk/rss/newsonline_uk_edition/health/rss.xml");
		try {
			r.reader();
		} catch (IOException e) {
		    System.out.println("入出力エラー");
		}		
	}
	
	public void reader()throws IOException {
		URL url = new URL(this.address);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while((line = br.readLine())!=null) {
			line = line.trim().toLowerCase();
			if(line.startsWith("<description>")) {
				//line = line.trim().toLowerCase();
				line = line.replaceAll("<description><!\\[cdata\\[", "");
				line = line.replaceAll("\\]\\]></description>", "");
				String [] lines = line.split("[<> ,/\\?\\]\\[\\.\"]+");
				for(String i :lines) {
					System.out.print("("+i+")");
				}
				System.out.println();
			}
		}
		br.close();
	}

}
