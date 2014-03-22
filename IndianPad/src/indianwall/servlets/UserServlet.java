 package indianwall.servlets;



import java.io.IOException;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



/**

* Handles login/registeration

*/

public class UserServlet extends HttpServlet {

                private static final long serialVersionUID = 1L;

       



    public UserServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                                doPost(request,response);

                }



                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                    String action = request.getParameter("action");

                    String nextJSP = "";

                    

                    if(null == action || "login".equals(action)) {

                        nextJSP = "/indianwall/login.jsp";

                    }

                    else if("register".equals(action)) {

            nextJSP = "/indianwall/login.jsp";

        }

        else if("loginsubmit".equals(action)) {

            String u = request.getParameter("username");

            String p = request.getParameter("password");

            System.out.println(" -> " + u);

            nextJSP = "WallServlet";

        }          

                    

                    

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);

        dispatcher.forward(request,response);            

                }



}



