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

  * Servlet implementation class VideoServlet

  * 

  * 

  */

public class VideoServlet extends HttpServlet {

                private static final long serialVersionUID = 1L;

           

        public VideoServlet() {

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

             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indianwall/video/videos.jsp");

             dispatcher.forward(request,response);                                   

                }

    

                

}



