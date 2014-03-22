package littleindia.dao.rss;



import java.util.List;



//fetch feeds

public interface FeedsDAO {

     public List<String> getFeeds(String userId,String category,String language);

     public List<String> getDefaultFeeds(String category,String language);

}
