package indianwall.utils;



import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VideoUtils {

    public static String getEmbedVideoString(String videoUrl) {

        String embed = "";

        String videoId = "<SOME VIDEO ID>";

        if(videoUrl.indexOf("youtube") > 0) {

            videoId = getYoutubeVideoId(videoUrl);

            embed = getYoutubeEmbedString(videoId);

        }

        else if(videoUrl.indexOf("dailymotion") > 0) {

            videoId = getDailyMotionId(videoUrl);

            embed = getDailyMotionEmbedString(videoId);

        }

        

        return embed;

    }

    

    // Youtube

    public static String getYoutubeVideoId(String youtubeUrl)

    {

            String video_id="";

                if (youtubeUrl != null && youtubeUrl.trim().length() > 0 && youtubeUrl.startsWith("http"))

                {    

                        String expression = "^.*((youtu.be"+ "\\/)" + "|(v\\/)|(\\/u\\/w\\/)|(embed\\/)|(watch\\?))\\??v?=?([^#\\&\\?]*).*"; // var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/;

                        CharSequence input = youtubeUrl;

                        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);

                        Matcher matcher = pattern.matcher(input);

                        if (matcher.matches())

                        {

                                String groupIndex1 = matcher.group(7);

                                if(groupIndex1!=null && groupIndex1.length()==11)

                                    video_id = groupIndex1;

                                }

                        }

                return video_id;

    }



    

    public static String getYoutubeEmbedString(String videoId) {

        String eStr = "<iframe width=\"100%\" height=\"315\" src=\"//www.youtube.com/embed/"  + 

                        videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";

        return eStr;

    }
    
    //Daily Motion

    public static String getDailyMotionId(String dUrl)

    {

       int i = dUrl.indexOf("/video/");

       String remStr = dUrl.substring(i + 7);

       int underscoreIndex = remStr.indexOf("_");

       String videoId = remStr.substring(0,underscoreIndex);

           System.out.println("daily motion videoId --> " + videoId);

           return videoId;

    }



    

    public static String getDailyMotionEmbedString(String videoId) {

        String eStr = "<iframe frameborder=\"0\" width=\"100%\" height=\"300\" " +

                                 "src=\"http://www.dailymotion.com/embed/video/" + videoId +"\"></iframe>";

        return eStr;

    }            





}


