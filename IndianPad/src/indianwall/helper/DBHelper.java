package indianwall.helper;
 
import indianwall.vo.NewsVO;
import indianwall.vo.UserVO;
 
import java.util.List;
 
//helper for database operations
public interface DBHelper {
 
    public void insertLatestPost(String title,String text,String domain,String url,String userName,int contentType);    
    
    public List<NewsVO> selectLatestPosts();
    
    public int upVote(int newsId);
    
    public List<NewsVO> selectTopPosts();
    
    public void registerNewUser(String username,String email,String password);
    
    public UserVO login(String email,String password);
    
    public List<NewsVO> selectLatestPosts(int startIndex,int endIndex);
    
    public List<NewsVO> selectTopPosts(int startIndex,int endIndex);
    
    public int getPostCount();
    
    
    public void transferLatestPostToLastWeek();
    
    public NewsVO getPost(int postId);
    
}
