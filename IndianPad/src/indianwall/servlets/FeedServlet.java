package indianwall.servlets;



import indianwall.dao.WallDao;

import indianwall.dao.WallDaoImpl;

import indianwall.helper.DBHelper;

import indianwall.helper.HSqlHelper;

import indianwall.helper.HelperFactory;

import indianwall.utils.IWConstants;

import indianwall.vo.FeedsInfo;

import indianwall.vo.NewsVO;

import indianwall.vo.UserVO;



import java.io.IOException;

import java.io.PrintWriter;

import java.net.URI;

import java.net.URISyntaxException;

import java.util.List;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import com.google.gson.Gson;



/**

  * Servlet implementation class VideoServlet

  * 

  * 

  */

public class FeedServlet extends HttpServlet {

                private static final long serialVersionUID = 1L;

           

        

                public FeedServlet() {

            super();

        }

    

                

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                                doPost(request,response);

                }

    

                

                protected void doPost(HttpServletRequest request, HttpServletResponse response) 

                                                throws ServletException, IOException {

                                System.out.println("Fetch the feedinfo");

                                FeedsInfo fvo = new FeedsInfo("7", "5");

                                Gson gson = new Gson();

                                                String jsobObj = gson.toJson(fvo);

                                    try {

                            PrintWriter out = response.getWriter();

                                out.println(jsobObj);

                                out.close();

                                    } catch (IOException e) {

                                                e.printStackTrace();

                                    }                                                          

                }



                

                

}


