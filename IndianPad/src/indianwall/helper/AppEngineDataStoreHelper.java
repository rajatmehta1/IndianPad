package indianwall.helper;
 
import indianwall.utils.IWConstants;
import indianwall.vo.NewsVO;
import indianwall.vo.UserVO;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
////app engine
//import com.google.appengine.api.datastore.DatastoreService;
//import com.google.appengine.api.datastore.DatastoreServiceFactory;
//import com.google.appengine.api.datastore.Entity;
//import com.google.appengine.api.datastore.PreparedQuery;
 
public class AppEngineDataStoreHelper implements DataStoreHelperI {
 
//    @Override
//    public void insertLatestPost(String title, String text, String domain, String url, String userName, int contentType) {
//        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//       
//        Entity post = new Entity("WallPost");
//  
//                post.setProperty("title", title);
//                post.setProperty("text", text); //see for text you can use something other then string
//                post.setProperty("domain", domain);
//                post.setProperty("url", url);
//                post.setProperty("postedBy", userName);
//                post.setProperty("datePosted", new Date());
//                post.setProperty("contentType", contentType);
//                post.setProperty("likeCount", 0);
//                post.setProperty("unlikeCount", 0);
//                post.setProperty("postCategory", postCategory);
//               
//                datastore.put(post);
//       
//    }
//
//    @Override
//    public List<NewsVO> selectLatestPosts(String category) {
//        //build query
//            return null;
//    }
//
//    @Override
//    public int upVote(Key newsId) {
//        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//        Entity post = datastore.get(newsId);
//        int likeCount = (Integer)post.getProperty("likeCount");
//            likeCount = likeCount + 1;
//           
//            post.setProperty("likeCount", likeCount);
//           
//            datastore.put(post);
//    }
//
//    @Override
//    public List<NewsVO> selectTopPosts() { //top news post
//        List<NewsVO> newsList = new ArrayList<NewsVO>();
//        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//
//        Filter newsFilter =
//          new FilterPredicate("postCategory",
//                              FilterOperator.EQUAL,
//                              IWConstants.CAT_NEWS);
//       
//        Filter likeCountFilter =
//                new FilterPredicate("likeCount",
//                                    FilterOperator.EQUAL,
//                                    IWConstants.CAT_NEWS);
//       
//        Query q = new Query("WallPost").setFilter(newsFilter);
//       
//        PreparedQuery pq = datastore.prepare(q);
//
//
//        for (Entity result : pq.asIterable()) {
//            NewsVO nvo = new NewsVO();
//                nvo.setTitle((String) result.getProperty("title"));
//                nvo.setDesc((String) result.getProperty("text"));
//                nvo.setDomain((String) result.getProperty("domain"));
//                nvo.setUrl((String) result.getProperty("url"));
//                nvo.setKey(result.getKey().toString());
//                nvo.setDownCount((String) result.getProperty("unlikeCount"));
//                nvo.setUpCount((String) result.getProperty("likeCount"));
//                nvo.setContentType((Integer) result.getProperty("contentType"));
//                nvo.setWhen((Date) result.getProperty("datePosted"));
//                nvo.setPostCategory((String) result.getProperty("postCategory"));
//                newsList.add(nvo);
//        } 
//        return newList;
//    }
//
//   
//
//   
//    @Override
//    public void registerNewUser(String username, String email, String password) {
//       
//        //validate if same or different user is registered twice here
//       
//        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//        Entity post = new Entity("WallUser");
//       
//            post.setProperty("username", username);
//            post.setProperty("email", email); //see for text you can use something other then string
//            post.setProperty("password", password);
//       
//            datastore.put(post);       
//    }
//
//    @Override
//    public UserVO login(String email, String password) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public List<NewsVO> selectLatestPosts(int startIndex, int endIndex) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//
//    @Override
//    public int getPostCount() {
//        // TODO Auto-generated method stub
//        return 0;
//    }
 
}
 