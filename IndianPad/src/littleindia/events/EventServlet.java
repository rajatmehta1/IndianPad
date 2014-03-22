package littleindia.events;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.util.List;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import com.google.gson.Gson;



import littleindia.events.dao.EventsDAO;

import littleindia.events.dao.IEventsDAO;

import littleindia.events.vo.EventVO;



/**

* Servlet implementation class EventServlet

*/

public class EventServlet extends HttpServlet {

                private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public EventServlet() {

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

                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 

                {

                    

                                String action = request.getParameter("action");

                                String output = "";

                                if("G_E".equals(action)) {

                                     output = getEventsOutput();

                                }

                                else if("F_E".equals(action)) { //filter event

                                    String category = request.getParameter("category");

                                    String sorting = request.getParameter("sortBY");

        }

        else if("F_L".equals(action)) { //filter event

            String location = request.getParameter("loc");

            String category = request.getParameter("cat");

            String sortOrder = request.getParameter("so");

            System.out.println(" location : " + location);

            output = getEventsOutput();

        }                      

                                else if("A_E".equals(action)) {

                                    IEventsDAO dao = new EventsDAO();

                                    String formData = request.getParameter("eventDetails");

                                    Gson gson = new Gson();

                                    EventVO evo = gson.fromJson(formData, EventVO.class);

                                        dao.addEvent(evo);

                                        output = getEventsOutput();

        }

        else if("E_D".equals(action)) {

            String eventId = request.getParameter("eventID");

            IEventsDAO dao = new EventsDAO();

            output = getEventDetailOutput(dao.getEvents("test").get(Integer.parseInt(eventId)));

        }                      

                                

        try {               

            PrintWriter out = response.getWriter();

               out.println(output);

               out.close();

         } catch (IOException e) {

             e.printStackTrace();

         }  

                }

                

                public String getEventsOutput() {

                    IEventsDAO dao = new EventsDAO();

        String output = "<ul id=\"eventsList\" class=\"thumbnails pagination\">";

        List<EventVO> events = dao.getEvents("new jersey"); 

        for (EventVO eventVO : events) {

            output += "<li class=\"span7\">"  +

                    "  <div id=\"" + eventVO.getEventId() + "\" class=\"thumbnail height-full\">" +

                    "       <img src=\"http://placehold.it/200x100\" class=\"float-left\">" + 

                    "        <h3>" + eventVO.getName() + "</h3>" +

                    "      <p> " + eventVO.getDescription() + "</p>" +

                    "  </div> </li>";

        }

       return output;

                }



    public String getEventDetailOutput(EventVO eventVO) {



        String output = "";

            output += "<h2>" +

                            eventVO.getName() +

                      "</h2>";

            if(eventVO.getImgURL() != null || !"".equals(eventVO.getImgURL())) {

                output += "<img src=\"" + eventVO.getImgURL() + "\" class=\"width-100-percent height-240-px\">";

            } else {

                output += "<img src=\"http://placehold.it/300x300\" class=\"width-100-percent height-240-px\">";

            }

                      

            output += "<table class=\"table width-100-percent\">";

            output += "<tr>" +

                      "<td><h4>Where :</h4></td>" +

                      "<td>" + eventVO.getWhere() + "</td>" +

                      "</tr>" +

                      "<tr>" +

                      "<td><h4>When :</h4></td>" +

                      "<td>" + eventVO.getWhen() + "</td>" +

                      "</tr>" +

                      "<tr>" +

                      "<td><h4>Venua :</h4></td>" +

                      "<td>" + eventVO.getVenue() + "</td>" +

                      "</tr>" +            

                      "<tr>" +

                      "<td><h4>Venue :</h4></td>" +

                      "<td></td>" +

                      "</tr></table>";                      

         

       return output;

    }



}

