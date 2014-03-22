package indianwall.vo;



import indianwall.utils.IWConstants;



import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

import java.util.regex.Matcher;

import java.util.regex.Pattern;



public class NewsVO {

    private String title;

    private String url;

    private String voted; //up or down

    private String domain;

    private String newsType; //link, youtube, vimeo etc whatever is supported

    private String upCount;

    private String downCount;

    private int score;

    private Date when;

    private int id; //news id needed for comments

    public String isDeleted;

    public boolean showEdit;

    public String userName; //submitted by

    public String desc;

    public int contentType;

    public String key;

    private String postCategory;

    

    public NewsVO() {

        

    }



    public String getTitle() {

        return title;

    }



    public void setTitle(String title) {

        this.title = title;

    }



    public String getUrl() {

        return url;

    }



    public void setUrl(String url) {

        this.url = url;

    }



    public String getVoted() {

        return voted;

    }



    public void setVoted(String voted) {

        this.voted = voted;

    }



    public String getDomain() {

        return domain;

    }



    public void setDomain(String domain) {

        this.domain = domain;

    }



    public String getNewsType() {

        return newsType;

    }



    public void setNewsType(String newsType) {

        this.newsType = newsType;

    }



    public String getUpCount() {

        return upCount;

    }



    public void setUpCount(String upCount) {

        this.upCount = upCount;

    }



    public String getDownCount() {

        return downCount;

    }



    public void setDownCount(String downCount) {

        this.downCount = downCount;

    }



    public String getTruncatedTitle() {

        if(title.length() > 200) {

            String updTitle = title.substring(0,IWConstants.TRUNCATED_TITLE_LIMIT);

            return updTitle;

        } else {

            return title;

        }

    }



    public int getScore() {

        return score;

    }



    public void setScore(int score) {

        this.score = score;

    }



    public Date getWhen() {

        return when;

    }



    public String getFormattedWhen() {

        if(when == null) {

            return "";

        }

//        Date currDate = new Date();

//        Calendar cc = Calendar.getInstance();

//          cc.setTime(currDate);

//        Calendar whenCal = Calendar.getInstance();

//           whenCal.setTime(when);

//           if( cc.get(Calendar.DATE) == whenCal.get(Calendar.DATE) &&

//                   cc.get(Calendar.MONTH) == whenCal.get(Calendar.MONTH) && 

//                           cc.get(Calendar.YEAR) == whenCal.get(Calendar.YEAR)) {

//               long diff = currDate.getTime() - when.getTime();

//               long diffHours = diff / (60 * 60 * 1000) % 24;

//               int dh = (int) diffHours;

//               return "" + dh;

//           } else {

               SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");    

               return sdf.format(when.getTime());

//           }

    }

    

    public void setWhen(Date when) {

        this.when = when;

    }



    public int getId() {

        return id;

    }



    public void setId(int id) {

        this.id = id;

    }



    public String getIsDeleted() {

        return isDeleted;

    }



    public void setIsDeleted(String isDeleted) {

        this.isDeleted = isDeleted;

    }



    public boolean isShowEdit() {

        return true; // DONT KNOW

    }



    public void setShowEdit(boolean showEdit) {

        this.showEdit = showEdit;

    }



    public String getUserName() {

        return userName;

    }



    public void setUserName(String userName) {

        this.userName = userName;

    }



    public String getDesc() {

        return desc;

    }



    public void setDesc(String desc) {

        this.desc = desc;

    }



    public int getContentType() {

        return contentType;

    }



    public void setContentType(int contentType) {

        this.contentType = contentType;

    }



    public String getKey() {

        return key;

    }



    public void setKey(String key) {

        this.key = key;

    }



    public String getPostCategory() {

        return postCategory;

    }



    public void setPostCategory(String postCategory) {

        this.postCategory = postCategory;

    }







    

}

