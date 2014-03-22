package littleindia.servlets;



import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import littleindia.dao.rss.FeedsDAO;

import littleindia.dao.rss.FeedsData;

import littleindia.rss.RssFeedParser;

import littleindia.rss.bean.Feed;



import com.google.gson.Gson;



/**

* Servlet implementation class TestServlet

*/

public class TestServlet extends HttpServlet {

                private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public TestServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



                /**

                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

                */

                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                                doPost(request, response);

                }



                /**

                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

                */

                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                    //DataObject obj = new DataObject();

                    //Gson gson = new Gson();

                

                    // convert java object to JSON format,

                    // and returned as JSON formatted string

                    //String json = gson.toJson(obj);

                

//                try {

//                    PrintWriter out = response.getWriter();

//                    out.println(json);

//                    out.close();

//            

//                } catch (IOException e) {

//                    e.printStackTrace();

//                }

                    response.setContentType("text/html");

                    response.setCharacterEncoding("utf-8");

                    

                    String category = request.getParameter("category");

                    String language = request.getParameter("language");

                    String pagenum = request.getParameter("pagenum");

                    Feed[] feeds = null;

                    if(category == null) { //default

                String rssLink = request.getParameter("rssLink");

                if(rssLink.equals("ttn")) {

                    rssLink = "http://rss.jagran.com/rss/news/national.xml";

                }

                    RssFeedParser parser = new RssFeedParser(rssLink);

        

                    Feed feed = parser.readFeed();

                     feed.setFid("0");

                

                    RssFeedParser parser1 = new RssFeedParser("http://rss.jagran.com/rss/entertainment/bollywood.xml");

        

                Feed feed1 = parser1.readFeed();

                     feed1.setFid("1");

                

                RssFeedParser parser2 = new RssFeedParser("http://rss.jagran.com/rss/news/sports.xml");

        

                Feed feed2 = parser2.readFeed();

                     feed2.setFid("2");

                

                    feeds = new Feed[3];

                    feeds[0] = feed; 

                    feeds[1] = feed1;

                    feeds[2] = feed2;

                    } else {

                                

                        FeedsData feedData = FeedsData.getInstance();

                        Map<String,List<String>> map = feedData.getMap();

                        List<String> feedLinks = map.get(category + "." + language);

                        int fid = 0;

                        //feeds = new Feed[feedLinks.size()];

                        int maxs = 5;

                        feeds = new Feed[maxs];           

                        if(pagenum != null) {

                                maxs = 5 * Integer.parseInt(pagenum);

                        }

                        int j = maxs - 5;

//                    for (String feedLink : feedLinks) {                      

                        while(j < maxs) {        

                                if(j >= feedLinks.size()) break;

                            String feedLink = feedLinks.get(j);

                            RssFeedParser feedParser = new RssFeedParser(feedLink);

                            Feed rFeed = feedParser.readFeed();

                                 rFeed.setFid("" + fid);

                                 feeds[fid] = rFeed;

                                 fid = fid + 1;

                                 j = j + 1;

            }



                        

                    }

            

                    Gson gson = new Gson();

                    String json = gson.toJson(feeds);

                    try {

                            PrintWriter out = response.getWriter();

                                out.println(json);

                                out.close();

                    } catch (IOException e) {

                        e.printStackTrace();

                    }              

                }



}



