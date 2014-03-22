package littleindia.servlets;



import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.List;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import littleindia.rss.RssFeedParser;

import littleindia.rss.bean.Feed;



import com.google.gson.Gson;



/**

* Servlet implementation class ContactServlet

*/

public class ContactServlet extends HttpServlet {

                private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public ContactServlet() {

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

        List<Contact> clist = new ArrayList<Contact>();

           clist.add(new Contact(1,"rajat"));

           clist.add(new Contact(2,"harpreet"));  

        ContactList cl = new ContactList(clist);

        Gson gson = new Gson();

        String json = gson.toJson(cl);

        try {

                PrintWriter out = response.getWriter();

                    out.println(json);

                    out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }   

                }



}

