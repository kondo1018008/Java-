package medals5;
/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Country implements Comparable {
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Country oo = (Country) o;
			if (oo.gold*1000000+oo.silver*1000+oo.bronze>this.gold*1000000+this.silver*1000+this.bronze) {
				 return 1;
			}else if(this.gold*1000000+this.silver*1000+this.bronze>oo.gold*1000000+oo.silver*1000+oo.bronze) {
				return -1;
			}else if(this.name.compareTo(oo.name)>0) {
				return 1;
			}else if(this.name.compareTo(oo.name)<0) {
				return -1;
			}
			
		return 0;
	}
   
}