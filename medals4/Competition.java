package medals4;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Competition {

	/**
	 * 動作確認用のmainメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// Rankingインスタンスを作成
		Ranking rank = new Ranking();
		// サンプルデータを登録
		rank.addMedal("ITA","Bronze");
		rank.addMedal("NOR","Bronze");
		rank.addMedal("CAN","Silver");
		rank.addMedal("CZE","Silver");
		rank.addMedal("RUS","Silver");
		rank.addMedal("RUS","Gold");
		rank.addMedal("AUT","Silver");
		rank.addMedal("CAN","Gold");
		rank.addMedal("KOR","Silver");
		rank.addMedal("NED","Bronze");
		rank.addMedal("NOR","Bronze");
		rank.addMedal("NOR","Gold");
		rank.addMedal("USA","Gold");
		rank.addMedal("NED","Bronze");
		rank.addMedal("KOR","Gold");
		rank.addMedal("RUS","Bronze");
		rank.addMedal("NOR","Gold");
		rank.addMedal("NED","Gold");
		rank.addMedal("RUS","Silver");
		rank.addMedal("NOR","Silver");
		rank.addMedal("USA","Bronze");
		rank.addMedal("CAN","Gold");
		rank.addMedal("GER","Gold");
		rank.addMedal("CAN","Bronze");
		rank.addMedal("USA","Silver");
		rank.addMedal("CAN","Silver");
		rank.addMedal("USA","Bronze");
		rank.addMedal("GER","Gold");
		rank.addMedal("SUI","Silver");
		rank.addMedal("GER","Silver");
		rank.addMedal("GER","Bronze");
		rank.addMedal("AUT","Gold");
		rank.addMedal("RUS","Bronze");
		rank.addMedal("AUT","Silver");
		rank.addMedal("AUT","Bronze");
		rank.addMedal("FRA","Gold");
		rank.addMedal("NED","Silver");
		rank.addMedal("FRA","Bronze");
		rank.addMedal("CHN","Gold");
		rank.addMedal("CHN","Silver");
		rank.addMedal("BLR","Gold");
		rank.addMedal("FRA","Silver");
		rank.addMedal("SUI","Gold");
		rank.addMedal("USA","Gold");
		rank.addMedal("RUS","Gold");
		rank.addMedal("POL","Gold");
		rank.addMedal("JPN","Silver");
		rank.addMedal("JPN","Bronze");
		rank.addMedal("SWE","Silver");
		rank.addMedal("SWE","Bronze");
		rank.addMedal("NED","Gold");
		rank.addMedal("FIN","Silver");
		rank.addMedal("RUS","Gold");
		rank.addMedal("SLO","Bronze");

		// ランキングで並び替えて
		rank.sortResults();

		// 結果出力
		rank.printResults();
	}

}