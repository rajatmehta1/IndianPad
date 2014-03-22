package indianwall.servlets;



import indianwall.dao.WallDao;

import indianwall.dao.WallDaoImpl;

import indianwall.helper.DBHelper;

import indianwall.helper.HSqlHelper;

import indianwall.helper.HelperFactory;

import indianwall.utils.IWConstants;

import indianwall.vo.NewsVO;

import indianwall.vo.UserVO;



import java.io.IOException;

import java.net.URI;

import java.net.URISyntaxException;

import java.util.List;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



    /**

     * Servlet implementation class WallServlet

     */

    public class WallServlet extends HttpServlet {

                private static final long serialVersionUID = 1L;

           

        public WallServlet() {

            super();

        }

    

                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                                doPost(request,response);

                }

    

        /*

         *  L_P = latest post

         *  T_P = top post

         * 

         */

                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                                String action = request.getParameter("action");

                                String helperType = request.getParameter("helperType");

                                String nextJSP = "/indianwall";  

                                WallDao dao = new WallDaoImpl();

                                DBHelper dbHelper = HelperFactory.getHelper(helperType);



                                if(action == null || "L_P".equals(action)) {  

                                    List<NewsVO> nlist = dbHelper.selectLatestPosts();

                                    request.setAttribute(IWConstants.NEWS_LIST, nlist);

                                    request.setAttribute(IWConstants.USER_VO, dao.getLoggedInUser());

                                    nextJSP = "/indianwall/latest.jsp";

            } else if("T_P".equals(action)) { //top posts 

                int si = this.getStartIndex(request);

                int ei = this.getEndIndex(request);

                int postCount = dbHelper.getPostCount();                

                    List<NewsVO> nlist = dbHelper.selectTopPosts(si,ei);

                request.setAttribute(IWConstants.START_INDEX, "" + si);

                request.setAttribute(IWConstants.END_INDEX, "" + ei);

                request.setAttribute(IWConstants.NEWS_LIST, nlist);

                request.setAttribute(IWConstants.USER_VO, dao.getLoggedInUser());

                  if(ei >= postCount) {

                      request.setAttribute(IWConstants.NEXT, "N");

                  } else {

                      request.setAttribute(IWConstants.NEXT, "Y");

                  }

                nextJSP = "/indianwall/top.jsp";

            }else if("S_S".equals(action)) { 

                request.setAttribute(IWConstants.USER_VO, dao.getLoggedInUser());

                nextJSP = "/indianwall/submit.jsp";

            }else if("A_P".equals(action)) {

               String title = request.getParameter("title");

               String desc = request.getParameter("text");

               String url = request.getParameter("url");

               String type = request.getParameter("contentType"); //1 - link, 2 - video, 3-pic

               String domain = this.getDomainName(url);

                   try {

                         dbHelper.insertLatestPost(title, desc, domain, url, dao.getLoggedInUser().getUserName(),Integer.parseInt(type));

                   } catch (Exception e) {

                       throw new RuntimeException( e );

                   }

                   request.setAttribute(IWConstants.USER_VO, dao.getLoggedInUser());

                   nextJSP = "/indianwall/submit.jsp";

               

            }

            else if("G_C".equals(action)) {//get comments

                String postId = request.getParameter("postId"); 

                int postIdInt = Integer.parseInt(postId);

                NewsVO newsVO = null;

                    try {

                           newsVO = dbHelper.getPost(postIdInt);

                    } catch (Exception e) {

                        throw new RuntimeException( e );

                    }

                    request.setAttribute(IWConstants.USER_VO, dao.getLoggedInUser());

                    request.setAttribute(IWConstants.NEWS_VO, newsVO);

                    nextJSP = "/indianwall/comments.jsp";

                

             }                                 

            else if("login".equals(action)) {

                nextJSP = "/indianwall/login.jsp";

            }

            else if("loginsubmit".equals(action)) {

                String u = request.getParameter("username");

                String p = request.getParameter("password");

                UserVO userVO = dbHelper.login(u,p);

                if(userVO == null) {

                    request.setAttribute("loginResult", "Invalid UserName/Password. Please try again");

                    nextJSP = "/indianwall/login.jsp";

                } else {

                    HttpSession session = request.getSession(true);

                       session.setAttribute(IWConstants.LOGIN_SESSION, userVO);

                    List<NewsVO> nlist = dbHelper.selectLatestPosts();

                        request.setAttribute(IWConstants.NEWS_LIST, nlist);

                        request.setAttribute(IWConstants.USER_VO, dao.getLoggedInUser());

                    nextJSP = "/indianwall/latest.jsp";                    

                }

            }                                  

            else if("register".equals(action)) {

                String rusername = request.getParameter("rusername");

                String email = request.getParameter("email");

                String password = request.getParameter("regpassword");

                try {

                      dbHelper.registerNewUser(rusername, email, password);

                } catch (Exception e) {

                    throw new RuntimeException( e );

                }

                

                request.setAttribute("result", "New User - ( " + email + " ) added successfully." );

                nextJSP = "/indianwall/login.jsp";

            }

                                

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);

            dispatcher.forward(request,response);                                    

                }

    

                public String getDomainName(String url)  {

                    String domain = "";

                    try {

                URI uri = new URI(url);

                domain = uri.getHost();

                domain = domain.startsWith("www.") ? domain.substring(4) : domain;

            } catch (Exception e) {

                // TODO: handle exception

            }



                    return domain;

                }

                

                

                

                public String isUserValid(HttpServletRequest request) {

                    HttpSession session = request.getSession(false);

                    if(session == null) return "NO_SESSION";

                    else {

                        UserVO user = (UserVO)session.getAttribute(IWConstants.LOGIN_SESSION);

                        if(user != null) return "true";

                        else return "false";

                    }

                }

                

                

                public int getStartIndex(HttpServletRequest request) {

            String si = request.getParameter("si");

            if(si == null) return IWConstants.DEF_START_INDEX;

            else return Integer.parseInt(si);

                }

                

        public int getEndIndex(HttpServletRequest request) {

            String si = request.getParameter("ei");

            if(si == null) return IWConstants.DEF_END_INDEX;

            else return Integer.parseInt(si); 

        }      

    }

