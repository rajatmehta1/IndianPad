package indianwall.dao;
 
import indianwall.vo.NewsVO;
import indianwall.vo.UserVO;
 
import java.util.List;
 
public interface WallDao{
   
    public void addPost(String title,String desc,String userName);
   
    public void addPost(String title,String desc,String url,String userName);
   
    public void addPost(String postType,String title,String desc,String url,String userName);
   
    public List<NewsVO> getLatestPosts();
   
    public List<NewsVO> getLatestPosts(int min,int max);
   
    public UserVO getLoggedInUser();
   
}
 