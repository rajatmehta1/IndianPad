package indianwall.helper;



import indianwall.vo.NewsVO;

import indianwall.vo.UserVO;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;



public class TechnologyHelper implements DBHelper{

    Connection conn;                                                //our connnection to the db - presist for life of program



    private static final String db_file_name_prefix = 

                                    "C:\\MSDE\\rajat\\dev\\MCS_RAJAT\\harpreetweb\\config\\db\\dbfile";

    

    public TechnologyHelper() {

        try {

        Class.forName("org.hsqldb.jdbcDriver");

        conn = DriverManager.getConnection("jdbc:hsqldb:"

                                           + db_file_name_prefix,    

                                           "sa",                     

                                           "");

        }catch(Exception e) {

            e.printStackTrace();

        }

    }

    

    

    public void insertLatestPost(String title,String text,String domain,String url,String userName,int contentType) {

        String insertSql = "insert into TECH_LATEST_POSTS(title, description, domain, date_posted, posted_by, url,content_type) values( ? , ? , ? , ?, ?, ?,?)";

        PreparedStatement pstmt = null;

        try {

             pstmt = conn.prepareStatement(insertSql);

             pstmt.setString(1, title);

             pstmt.setString(2, text);

             pstmt.setString(3, domain);

             pstmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));

             pstmt.setString(5, userName);

             pstmt.setString(6, url);

             pstmt.setInt(7, contentType);

             pstmt.executeUpdate();

        }catch(SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                pstmt.close();

            }catch(Exception e) {

                

            }

        }

        

    }



    

    public List<NewsVO> selectLatestPosts() {

        List<NewsVO> nlist = new ArrayList<NewsVO>();

        String sql = "select lp.content_type,lp.id,lp.title,lp.description,lp.domain,lp.date_posted,lp.posted_by,lp.url,lp_md.likes_count,lp_md.unlikes_count from tech_latest_posts lp LEFT OUTER JOIN tech_latest_posts_META_DATA lp_md on lp.id = lp_md.post_id ";

        Statement stmt = null;

        try {

             stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql);

             while(rs.next()) {

                 String t = rs.getString("title");

                 NewsVO n = new NewsVO();

                         n.setTitle(rs.getString("title"));

                         n.setDesc(rs.getString("description"));

                         n.setDomain(rs.getString("domain"));

                         n.setWhen(rs.getDate("date_posted"));

                         n.setUserName(rs.getString("posted_by"));

                         n.setUrl(rs.getString("url"));

                         n.setId(rs.getInt("id"));

                         if(rs.getString("likes_count") == null) {

                             n.setUpCount("0");

                         } else {

                             n.setUpCount(rs.getString("likes_count"));

                         }

                         

                         if(rs.getString("unlikes_count") == null) {

                             n.setDownCount("0");

                         } else {

                             n.setDownCount(rs.getString("unlikes_count"));

                         }

                         n.setContentType(rs.getInt("content_type"));

                         

                         nlist.add(n);

             }

             

        }catch(SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                stmt.close();

            }catch(Exception e) {

                

            }

        }

        return nlist;

    }





    @Override

    public int upVote(int newsId) {        

       int cnt = getCurrentVoteCount(newsId);

       String sql = "";

           if(cnt == -1) {

               cnt = 0;

               sql = "insert into tech_latest_posts_META_DATA(post_id, likes_count, unlikes_count) values( " + newsId + ", 0 , 0)";

           } else {

               cnt = cnt + 1;

               sql = "update tech_latest_posts_META_DATA set likes_count=" + cnt + " where post_id = " + newsId;

           }

       Statement stmt = null;

           try {

                stmt = conn.createStatement();

                stmt.executeUpdate(sql);

           }catch(SQLException e) {

               e.printStackTrace();

           }finally {

               try {

                   stmt.close();

               }catch(Exception e) {

                   

               }

           }    

        return cnt;   

    }

    

    public int getCurrentVoteCount(int newsId) {

        int likeCnt = -1;

        String sql = "select likes_count from tech_latest_posts_META_DATA where post_id = " + newsId;

        Statement stmt = null;

        try {

             stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql);

             while(rs.next()) {

                 likeCnt = rs.getInt("likes_count");

             }

        }catch(SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                stmt.close();

            }catch(Exception e) {

                

            }

        }

        

        return likeCnt;

    }

    

    

    public List<NewsVO> selectTopPosts() {

        List<NewsVO> nlist = new ArrayList<NewsVO>();

        

        String sql = "select lp.id,lp.title,lp.description,lp.domain,lp.date_posted,lp.posted_by,lp.url,lp_md.likes_count," +

                     "lp_md.unlikes_count from tech_latest_posts lp LEFT OUTER JOIN tech_latest_posts_META_DATA lp_md on " +

                     "lp.id = lp_md.post_id order by lp_md.likes_count desc NULLS LAST";

        

        Statement stmt = null;

        try {

             stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql);

             while(rs.next()) {

                 NewsVO n = new NewsVO();

                         n.setTitle(rs.getString("title"));

                         n.setDesc(rs.getString("description"));

                         n.setDomain(rs.getString("domain"));

                         n.setWhen(rs.getDate("date_posted"));

                         n.setUserName(rs.getString("posted_by"));

                         n.setUrl(rs.getString("url"));

                         n.setId(rs.getInt("id"));

                         if(rs.getString("likes_count") == null) {

                             n.setUpCount("0");

                         } else {

                             n.setUpCount(rs.getString("likes_count"));

                         }

                         

                         if(rs.getString("unlikes_count") == null) {

                             n.setDownCount("0");

                         } else {

                             n.setDownCount(rs.getString("unlikes_count"));

                         }

                         

                         

                         nlist.add(n);

             }

             

        }catch(SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                stmt.close();

            }catch(Exception e) {

                

            }

        }

        return nlist;

    }

    

    

    

    public void registerNewUser(String username,String email,String password) {

        String sql =  "insert into USERS(username,email, password) values(\'" + username + "\',\'" + email + "\',\'" + password + "\')";

        Statement stmt = null;

            try {

                 stmt = conn.createStatement();

                 stmt.executeUpdate(sql);

            }catch(SQLException e) {

                e.printStackTrace();

            }finally {

                try {

                    stmt.close();

                }catch(Exception e) {

                    

                }

            }     

    }



    

    public UserVO login(String email,String password) {

        String sql = "select * as cnt from USERS where email = \'" + email + "\' and password=\'" + password + "\'";

        Statement stmt = null;

        UserVO u = null;

        try {

             stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql);

             while(rs.next()) {

                 u = new UserVO();

                 u.setEmail(rs.getString("email"));

                 u.setUserKarma(rs.getInt("karma"));

                u.setUserScore(rs.getInt("score"));

             }

        }catch(SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                stmt.close();

            }catch(Exception e) {

                

            }

        }

        return u;

    }





    @Override

    public List<NewsVO> selectLatestPosts(int startIndex, int endIndex) {

        List<NewsVO> nlist = new ArrayList<NewsVO>();

        

        String sql = "select * from (select lp.id,lp.title,lp.description,lp.domain,lp.date_posted,lp.posted_by,lp.url,lp_md.likes_count,lp_md.unlikes_count from tech_latest_posts lp LEFT OUTER JOIN tech_latest_posts_META_DATA lp_md on lp.id = lp_md.post_id) where id >= " + startIndex + " and id <= " + endIndex + "";

        

        Statement stmt = null;

        try {

             stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql);

             while(rs.next()) {

                 NewsVO n = new NewsVO();

                         n.setTitle(rs.getString("title"));

                         n.setDesc(rs.getString("description"));

                         n.setDomain(rs.getString("domain"));

                         n.setWhen(rs.getDate("date_posted"));

                         n.setUserName(rs.getString("posted_by"));

                         n.setUrl(rs.getString("url"));

                         n.setId(rs.getInt("id"));

                         if(rs.getString("likes_count") == null) {

                             n.setUpCount("0");

                         } else {

                             n.setUpCount(rs.getString("likes_count"));

                         }

                         

                         if(rs.getString("unlikes_count") == null) {

                             n.setDownCount("0");

                         } else {

                             n.setDownCount(rs.getString("unlikes_count"));

                         }

                         

                         

                         nlist.add(n);

             }

             

        }catch(SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                stmt.close();

            }catch(Exception e) {

                

            }

        }

        return nlist;



    }

    



    @Override

    public List<NewsVO> selectTopPosts(int startIndex, int endIndex) {

        List<NewsVO> nlist = new ArrayList<NewsVO>();

        

        String sql = "select * from (select lp.content_type,lp.id,lp.title,lp.description,lp.domain,lp.date_posted,lp.posted_by,lp.url,lp_md.likes_count," +

                     "lp_md.unlikes_count from tech_latest_posts lp LEFT OUTER JOIN tech_latest_posts_META_DATA lp_md on " +

                     "lp.id = lp_md.post_id order by lp_md.likes_count desc NULLS LAST) where id >= " + startIndex + " and id <= " + endIndex + "";

        

        Statement stmt = null;

        try {

             stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql);

             while(rs.next()) {

                 NewsVO n = new NewsVO();

                         n.setTitle(rs.getString("title"));

                         n.setDesc(rs.getString("description"));

                         n.setDomain(rs.getString("domain"));

                         n.setWhen(rs.getDate("date_posted"));

                         n.setUserName(rs.getString("posted_by"));

                         n.setUrl(rs.getString("url"));

                         n.setId(rs.getInt("id"));

                         if(rs.getString("likes_count") == null) {

                             n.setUpCount("0");

                         } else {

                             n.setUpCount(rs.getString("likes_count"));

                         }

                         

                         if(rs.getString("unlikes_count") == null) {

                             n.setDownCount("0");

                         } else {

                             n.setDownCount(rs.getString("unlikes_count"));

                         }

                         

                         n.setContentType(rs.getInt("content_type"));

                         nlist.add(n);

             }

             

        }catch(SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                stmt.close();

            }catch(Exception e) {

                

            }

        }

        return nlist;

    }





    @Override 

    public int getPostCount() { //latest post count

        String sql = "select count(*) as cnt from tech_latest_posts";

        Statement stmt = null;

        UserVO u = null;

        int cnt = 0;

        try {

             stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql);

             while(rs.next()) {

                 cnt = rs.getInt("cnt");

             }

        }catch(SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                stmt.close();

            }catch(Exception e) {

                

            }

        }

        return cnt;

    }





    @Override

    public void transferLatestPostToLastWeek() {

        // TODO Auto-generated method stub

        

    }





    @Override

    public NewsVO getPost(int postId) {

        // TODO Auto-generated method stub

        return null;

    }





}




