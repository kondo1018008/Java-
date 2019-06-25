package medals0;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Ranking {

	final int NUM_OF_COUNTRIES = 1000;
	String[] country;
	int[] gold, silver, bronze;
	int next;

	public Ranking() {
		country = new String[NUM_OF_COUNTRIES];
		gold = new int[country.length];
		silver = new int[country.length];
		bronze = new int[country.length];
		next = 0;
	}

	/**
	 * 指定された国が配列の何番に登録されているか探し、その添え字を返す
	 * @param countryName 国(3文字のIOCコード)
	 * @return countryNameがcountryの何番に格納されているか、なければ-1
	 */
	public int indexOfCountry(String countryName) {
		for (int i = next - 1; i >= 0; i--) {
			// i番目の国名がcountryNameと同じ文字列ならば i を返す
			if (country[i].equals(countryName)) return i;
		}
		return -1; // 見つからなければ -1 を返す
	}

	/**
	 * IOCコードで指定された国に指定された色のメダルを1つ追加
	 * @param countryName 国(3文字のIOCコード)
	 * @param medal メダルの色("Gold", "Silver" または "Bronze")
	 */
	public void addMedal(String countryName, String medal) {
		// countryNameが配列の何番目に格納されているか探す
		int index = indexOfCountry(countryName);
		if (index < 0) { // 見つからなかった場合は新たに格納し、nextを増やす
			country[next] = countryName;
			index = next;
			next ++;
		}
		// 色に対応するメダルの数を増やす
		if ("Gold".equals(medal)) {
			gold[index]++;
		} else if ("Silver".equals(medal)) {
			silver[index]++;
		} else if ("Bronze".equals(medal)) {
			bronze[index]++;
		}
	}

	public void sortResults() {
		// TODO 並べ替えを実装したらどうなる?!
		for (int i = 1; i < country.length && country[i] != null; i++) {
		    int j = i - 1;
		    // i番目のデータを待避しておく
		    String c = country[i];
		    int g = gold[i];
		    int s = silver[i];
		    int b = bronze[i];
		    // i番目の国名がj番目の国名よりも前である間くり返す
		    while (j >= 0 && c.compareTo(country[j]) < 0) {
		        // j番目のデータをj+1番目にコピー
		        country[j+1] = country[j];
		        gold[j+1] = gold[j];
		        silver[j+1] = silver[j];
		        bronze[j+1] = bronze[j];
		        j--;
		    }
		    j++;
		    // 待避しておいたi番目のデータをj番目にコピー
		    country[j] = c;
		    gold[j] = g;
		    silver[j] = s;
		    bronze[j] = b;
		}
	}

	public void printResults() {
		// 集計結果を表示
		for (int i = 0; i < country.length && country[i] != null; i++) {
			System.out.print(country[i]);
			int sum = gold[i];
			System.out.print("(" + gold[i]);
			sum += silver[i];
			System.out.print("," + silver[i]);
			sum += bronze[i];
			System.out.print("," + bronze[i]);
			System.out.println(")[" + sum + "]");
		}

	}

}