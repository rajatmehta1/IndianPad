package littleindia.dao.rss;



import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;







public class FeedsData {

   

    public Map<String, List<String>> feedsMap;

    

    private static volatile FeedsData feedsDataObj;

    

    private FeedsData() {

        feedsMap = new HashMap<String, List<String>>();

        populateMap();

    }

    

    public static FeedsData getInstance() {

        if(null == feedsDataObj) {

               feedsDataObj = new FeedsData();

        }

        

        return feedsDataObj;

    }

    

    public Map<String,List<String>> getMap() {

        return feedsMap;

    }

    



    private void populateMap() {      

        //News        

            //English

            List<String> englishNews = new ArrayList<String>();

                 englishNews.add("http://www.firstpost.com/india/feed");//first post

                 englishNews.add("http://www.tehelka.com/?feed=custom_feed");//tehelka english

                 englishNews.add("http://feeds.hindustantimes.com/HT-HomePage-TopStories");//hindustan times

                 englishNews.add("http://timesofindia.feedsportal.com/c/33039/f/533916/index.rss");//times of india

                 englishNews.add("http://feeds.feedburner.com/NdtvNews-TopStories?format=xml");//ndtv

                 englishNews.add("http://economictimes.indiatimes.com/rssfeedstopstories.cms");//economic times

                 englishNews.add("http://www.moneycontrol.com/rss/MCtopnews.xml");//Money Control Top News                 

                 

                 feedsMap.put("News.English", englishNews);

                 //English

             

             List<String> hindiNews = new ArrayList<String>();

                                         hindiNews.add("http://rss.jagran.com/rss/news/national.xml");//jagran

                                         hindiNews.add("http://feeds.feedburner.com/thepunjabkesari/MKUo");//bhaskar

                                         hindiNews.add("http://www.amarujala.com/rss/editors-pick.xml");//amar ujala

                                         hindiNews.add("http://feeds.feedburner.com/thepunjabkesari/MKUo");//punjab kesari

                                         hindiNews.add("http://rss.jagran.com/rss/news/national.xml");//jagran

                                         hindiNews.add("http://rss.jagran.com/rss/news/national.xml");//jagran

                                         hindiNews.add("http://rss.jagran.com/rss/news/national.xml");//jagran

//                         hindiNews.add("http://xmls.lokmat.com/xml/Main_Main.xml");//LokMat

                        

                         feedsMap.put("News.Hindi", hindiNews);

    }

    

    

}

