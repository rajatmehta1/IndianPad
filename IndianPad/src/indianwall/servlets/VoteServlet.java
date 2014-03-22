package indianwall.servlets;



import indianwall.helper.DBHelper;

import indianwall.helper.HSqlHelper;



import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



/**

* Servlet implementation class VoteServlet

*/

public class VoteServlet extends HttpServlet {

                private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public VoteServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



                /**

                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

                */

                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                                doPost(request,response);

                }



                /**

                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

                */

                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                    String action = request.getParameter("action");

                    String output = "";

        if("U_V".equals(action)) {

            String newsId = request.getParameter("newsId");

            int newsIdINT = Integer.parseInt(newsId);

            try {

                  DBHelper dbHelper = new HSqlHelper();

                  int cnt = dbHelper.upVote(newsIdINT);

                  output = "" + cnt;

            } catch (Exception e) {

                throw new RuntimeException( e );

            }

        }

        

        try {               

            PrintWriter out = response.getWriter();

               out.println(output);

               out.close();

         } catch (IOException e) {

             e.printStackTrace();

         }  

                }



}

