package littleindia.events.vo;



import java.util.Date;



public class EventVO {

   private String name;

   private String city;

   private String address_line1;

   private String address_line2;

   private String country;

   private String description;// can be html

   private String datetime;

   private Date eventDate;

   private String eventTime;

   private String eventDetailUrl;

   private String where;

   private String venue;

   private String when;

   private String imgURL;

   private String eventDesc;

   public int eventId;

   

   public EventVO() {

       

   }



    public String getName() {

        return name;

    }

    

    public void setName(String name) {

        this.name = name;

    }

    

    public String getCity() {

        return city;

    }

    

    public void setCity(String city) {

        this.city = city;

    }

       

    public String getAddress_line1() {

        return address_line1;

    }

    

    public void setAddress_line1(String address_line1) {

        this.address_line1 = address_line1;

    }

    

    public String getAddress_line2() {

        return address_line2;

    }

    

    public void setAddress_line2(String address_line2) {

        this.address_line2 = address_line2;

    }

    

    public String getCountry() {

        return country;

    }

    

    public void setCountry(String country) {

        this.country = country;

    }

    

    public String getDescription() {

        return description;

    }

    

    public void setDescription(String description) {

        this.description = description;

    }



    public String getDatetime() {

        return datetime;

    }



    public void setDatetime(String datetime) {

        this.datetime = datetime;

    }

    

    public String getDate() {

        //10/22/2013 08:41

      String ldt = datetime.trim();

      int space = ldt.indexOf(" ");

      return ldt.substring(0,space);

    }

    

    public String getTime() {

      String ldt = datetime.trim();

      int space = ldt.indexOf(" ");

      return ldt.substring(space);

    }



    public Date getCalculateEventDate() {

        return eventDate;

    }



    public void setEventDate(Date eventDate) {

        this.eventDate = eventDate;

    }



    public String getEventTime() {

        return eventTime;

    }



    public void setEventTime(String eventTime) {

        this.eventTime = eventTime;

    }



    public String getEventDetailUrl() {

        return eventDetailUrl;

    }



    public void setEventDetailUrl(String eventDetailUrl) {

        this.eventDetailUrl = eventDetailUrl;

    }



    public Date getEventDate() {

        return eventDate;

    }



    public String getWhere() {

        return where;

    }



    public void setWhere(String where) {

        this.where = where;

    }



    public String getVenue() {

        return venue;

    }



    public void setVenue(String venue) {

        this.venue = venue;

    }



    public String getWhen() {

        return when;

    }



    public void setWhen(String when) {

        this.when = when;

    }



    public String getImgURL() {

        return imgURL;

    }



    public void setImgURL(String imgURL) {

        this.imgURL = imgURL;

    }



    public String getEventDesc() {

        return eventDesc;

    }



    public void setEventDesc(String eventDesc) {

        this.eventDesc = eventDesc;

    }

    

    public String toString() {

        String output =   "name: " + name +

                            "\ncity: " + city +                

                            "\naddress_line1: " + address_line1 + 

                            "\naddress_line2: " + address_line2 +

                            "\ncountry: " + country +

                            "\ndescription: " + description +

                            "\ndatetime: " + datetime + 

                            "\neventDate: " + eventDate +

                            "\neventTime: " + eventTime +

                            "\neventDetailUrl: " + eventDetailUrl +

                            "\nwhere: " + where +

                            "\nvenue: " + venue +

                            "\nwhen: " + when +

                            "\nimgURL: " + imgURL +

                            "\neventId: " + eventId +

                            "\neventDesc: " + eventDesc;

       return output;

    }



    public int getEventId() {

        return eventId;

    }



    public void setEventId(int eventId) {

        this.eventId = eventId;

    }

        

               

       

}

