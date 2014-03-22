package indianwall.helper;
 
public class HelperFactory {
 
    public HelperFactory() {
        
    }
    
    
    public static DBHelper getHelper(String helperType) {
        
        if(helperType == null || "".equals(helperType.trim())) {
            return new HSqlHelper();
        } else if("TECH".equals(helperType.trim())) {
            return new TechnologyHelper();
        } else {
            return new HSqlHelper();
        }
    }
    
    
}