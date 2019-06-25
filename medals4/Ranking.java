package medals4;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Ranking {

	final int NUM_OF_COUNTRIES = 1000;
	/*String[] country;
	int[] gold, silver, bronze;*/
	int next;
	Country[] countries;

	public Ranking() {
		/*country = new String[NUM_OF_COUNTRIES];
		gold = new int[country.length];
		silver = new int[country.length];
		bronze = new int[country.length];*/
		countries = new Country[NUM_OF_COUNTRIES];
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
			if (countries[i].getName().equals(countryName)) return i;
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
			countries[next] = new Country(countryName);
			index = next;
			next ++;
		}
		// 色に対応するメダルの数を増やす
		countries[index].add(medal);
		/*if ("Gold".equals(medal)) {
			countries[index].gold++;
		} else if ("Silver".equals(medal)) {
			countries[index].silver++;
		} else if ("Bronze".equals(medal)) {
			countries[index].bronze++;
		}*/
	}

	public void sortResults() {
		// TODO 並べ替えを実装したらどうなる?!
		/*for (int i = 1; i < countries.length && countries[i] != null; i++) {
		    int j = i - 1;
		    // i番目のデータを待避しておく
		    String c = countries[i].name;
		    int g = countries[i].gold;
		    int s = countries[i].silver;
		    int b = countries[i].bronze;
		    // i番目の国名がj番目の国名よりも前である間くり返す
		    while (j >= 0 && c.compareTo(countries[j].name) < 0) {
		        // j番目のデータをj+1番目にコピー
		        countries[j+1].name = countries[j].name;
		        countries[j+1].gold = countries[j].gold;
		        countries[j+1].silver = countries[j].silver;
		        countries[j+1].bronze = countries[j].bronze;
		        j--;
		    }
		    j++;
		    // 待避しておいたi番目のデータをj番目にコピー
		    countries[j].name = c;
		    countries[j].gold = g;
		    countries[j].silver = s;
		    countries[j].bronze = b;
		}*/
		/*for (int i = 1; i < countries.length && countries[i] != null; i++) {
		    int j = i - 1;
		    Country c = countries[i];
		    while (j >= 0 &&
		            (c.gold*1000000+c.silver*1000+c.bronze>countries[j].gold*1000000+countries[j].silver*1000+countries[j].bronze ||
		            (c.gold*1000000+c.silver*1000+c.bronze==countries[j].gold*1000000+countries[j].silver*1000+countries[j].bronze &&
		            c.name.compareTo(countries[j].name) < 0))) {
		        countries[j+1] = countries[j];
		        j--;
		    }
		    j++;
		    countries[j] = c;
		}*/
	}

	public void printResults() {
		// 集計結果を表示
		for (int i = 0; i < countries.length && countries[i] != null; i++) {
			/*
			System.out.print(countries[i].name);
			int sum = countries[i].gold;
			System.out.print("(" + countries[i].gold);
			sum += countries[i].silver;
			System.out.print("," + countries[i].silver);
			sum += countries[i].bronze;
			System.out.print("," + countries[i].bronze);
			System.out.println(")[" + sum + "]");
			*/
			System.out.println(countries[i].toString());
		}

	}

}