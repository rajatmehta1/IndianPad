package indianwall.vo;



public class FeedsInfo {

   

       private final String feedCount;

       private final String pageSizeCnt;

       

       public FeedsInfo(String feedCount,String pageSizeCnt) {       

              this.feedCount = feedCount;

              this.pageSizeCnt = pageSizeCnt;

       }



       public String getFeedCount() {

              return feedCount;

       }



       public String getPageSizeCnt() {

              return pageSizeCnt;

       }





       

       

}

