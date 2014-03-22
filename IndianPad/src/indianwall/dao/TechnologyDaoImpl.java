package indianwall.dao;
 
import indianwall.helper.DBHelper;
import indianwall.helper.HSqlHelper;
import indianwall.vo.NewsVO;
import indianwall.vo.UserVO;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
public class TechnologyDaoImpl implements WallDao {
 
    @Override
    public void addPost(String title, String desc, String userName) {
       
    }
 
    @Override
    public void addPost(String postType, String title, String desc, String userName) {
       
    }
 
    @Override
    public List<NewsVO> getLatestPosts() {
//        List<NewsVO> nlist = new ArrayList<NewsVO>();
//        NewsVO n = new NewsVO();
//               n.setTitle("Title of news 1");
//               n.setDesc("Desc DescDescDescDescDescDescDescDescDescDescDescDescDesc  of news 1");
//               n.setUpCount(20);
//               n.setDownCount(2);
//               n.setId(1);
//               n.setShowEdit(true);
//               n.setScore(5);
//               n.setUserName("rajat");
//               n.setDomain("www.indianwall.com");
//               n.setWhen(new Date());
//               nlist.add(n);
//          
//               n = new NewsVO();
//               n.setTitle("Title of news 2");
//               n.setDesc("Desc DescDescDescDescDescDescDescDescDescDescDescDescDesc  of news 1");
//               n.setUpCount(20);
//               n.setDownCount(2);
//               n.setId(2);
//               n.setShowEdit(true);
//               n.setScore(5);
//               n.setUserName("rajat");
//               n.setDomain("www.indianwall.com");
//               n.setWhen(new Date());
//               nlist.add(n);
        DBHelper dbhelper = new HSqlHelper();
        List<NewsVO> nlist = dbhelper.selectLatestPosts();
               return nlist;
    }
 
    @Override
    public List<NewsVO> getLatestPosts(int min, int max) {
        return null;
    }
 
    @Override
    public UserVO getLoggedInUser() {
        UserVO user = new UserVO();
          user.setEmail("test@rest.com");
          user.setUserName("rajat");
           return user;
    }
 
    @Override
    public void addPost(String postType, String title, String desc, String url, String userName) {
        // TODO Auto-generated method stub
       
    }
 
}
 