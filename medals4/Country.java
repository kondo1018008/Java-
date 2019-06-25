package medals4;
/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Country {
    private String name;
    private int gold, silver, bronze;
    public Country (String countryName) {
        this.name = countryName;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void add(String medal) {
    	if("Gold".equals(medal) ) {
    		this.gold++;
    	}else if("Silver".equals(medal)) {
    		this.silver++;
    	}else if("Bronze".equals(medal)) {
    		this.bronze++;
    	}
    }
    
    public String toString() {
    	int sum = this.gold+ this.silver+ this.bronze;
    	return this.name+"("+this.gold+","+this.silver+","+this.bronze+")["+sum+"]";
    }
   
}