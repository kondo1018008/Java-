package medals3;
/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Country {
    String name;
    int gold, silver, bronze;
    public Country (String countryName) {
        this.name = countryName;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void add(String medal) {
    	if(medal == "Gold" ) {
    		this.gold++;
    	}else if(medal == "Silver") {
    		this.silver++;
    	}else if(medal == "Bronze") {
    		this.bronze++;
    	}
    }
    
    public String toString() {
    	int sum = this.gold+ this.silver+ this.bronze;
    	return this.name+"("+this.gold+","+this.silver+","+this.bronze+")["+sum+"]";
    }
   
}