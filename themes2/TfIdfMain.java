package themes2;
/*
 * @author b1018008 Shogo Kondo
 * */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class TfIdfMain {
	private ArrayList<Document> docs;
	
	public TfIdfMain(String[] st) {
		docs = new ArrayList<>();
		for(String s : st) {
			try {
				docs.add(new Document(s));
			}catch(IOException e) {}
		}
	}
	
	public double calcIDF(String st) {
		double num=0.0;
		
		for(Document d:this.docs) {
			if(d.getWords().contains(st)) {
				num ++;
			}
		}
		return Math.log(this.docs.size()/num);
	}
	
	public ArrayList<String> getFeatureWords(String sss){
		HashMap<String,Double> comp= new HashMap<>();
		ArrayList<String> top5 = new ArrayList<>(5) ;
		for(Document d:this.docs) {
			if(d.getPath().equals(sss)) {
				for(String s:d.getWords()) {
					comp.put(s,d.calcTF(s)*this.calcIDF(s));
				}
				
				ArrayList<Map.Entry<String,Double>> entries = new ArrayList<Map.Entry<String,Double>>(comp.entrySet());
			        Collections.sort(entries, new Comparator<Map.Entry<String,Double>>() {
			 
			            @Override
			            public int compare(
			                  Map.Entry<String,Double> entry1, Map.Entry<String,Double> entry2) {
			                return ((Double)entry2.getValue()).compareTo((Double)entry1.getValue());
			            }
			        });
			        int i=0;
			        for(Map.Entry<String,Double> s : entries) {
			        	if(i>4)
			        		return top5;
			        	top5.add(s.getKey());
			        	i++;
			        }
			}

		}
		return null;
	}
	
	// 動作確認用
		public static void main(String[] args) {
			ArrayList<String> files = new ArrayList<>();
			for (String s: new java.io.File("wakati").list()) {
				if (!s.startsWith(".")) files.add("wakati/" + s);
			}
			TfIdfMain tfidf = new TfIdfMain(files.toArray(new String[0]));
			for (String doc: files) {
				System.out.print(doc);
				System.out.print(" ");
				System.out.println(tfidf.getFeatureWords(doc).toString());
			}
		}
}
