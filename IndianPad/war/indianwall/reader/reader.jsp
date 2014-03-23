

<%

  String feedTitleElement = "<" + "%" + "=title" + "%" + ">";

  String feedIdElement = "<" + "%" + "=fid" + "%" + ">";

  

  //item

  String feedItemTitleElement = "<" + "%" + "=title" + "%" + ">";

  String feedDescriptionElement = "<" + "%" + "=description" + "%" + ">";

  String feedUrlElement = "<" + "%" + "=link" + "%" + ">";

  String feedItemImageElement = "<" + "%" + "=image" + "%" + ">";

%>

<!DOCTYPE html>

<html lang="en">

  <head>

    <meta charset="utf-8">

    <title>Bootstrap, from Twitter</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content="">

    <meta name="author" content="">



    <!-- Le styles -->

    <link href="indianwall/css_orig/bootstrap.css" rel="stylesheet">

    <style type="text/css">

      body {

        padding-top: 60px;

        padding-bottom: 40px;

        width: 100%;

        height: 100%;

        background-color : #eef4f4;

      }

      .float-left {

        float: left;

      }

      .float-right {

        float: right;

      }      

      .height-full {

        overflow: auto;

      }

      .margin-left-5 {

        padding-left: 5px;

      }

      .margin-top {

        margin-top : 0;

      }

      .content-center {

        text-align: center;

      }

      .height-100 {

       height : 100%;

      }

      .width-full {

        width: 100%;

      }

      .border-right {

        border-right : 1px solid #c4cecd;

      }



      .border {

          border : 1px solid #c4cecd;

      }

      .smalltext {

        font-size: 11px;        

      }

      .black-color {

        color : #2d2d2d;

      }

      .padding-5 {

         padding-left : 5px;

         padding-right : 5px;

      }

      .padding-10 {

         padding-left : 10px;

         padding-right : 10px;

      }      

      .bgwhite {

        background-color : #FFFFFF;

      }

      

      #eventsList li {

         margin-top : 0px;

      }

      

      .carousel-inner>.item>img {

            height: 320px;

            width: 224px;

            float: left; 

            padding : 5px; 

            -moz-border-radius: 15px;

            border-radius: 15px;

            overflow: hidden;

      }

      

      .carousel-thumbnail {

            height: 340px;

            width: 212px;

            float: left; 

            padding : 5px; 

            overflow: hidden;

            margin : 5px;

      }

      .carousel-thumbnail>img {

            height: 160px;

            width: 205px;

            float: left; 

            padding : 1px; 

            overflow: hidden;

      }    

      



      #progressbarCnt {

         width: 100%;

         height: 100%;

      }

      #progressbar {

         position:absolute; 

         top:50%;

         left:30%;

         width: 41%; 

         height:1.5em; 

         margin-top:-5em;

      }

      #progessMesg {

         position:absolute; 

         top:50%;

         left:25%;

         height:1em; 

         margin-top:-5em;      

      }              

      #progressbar > .ui-progressbar-value {

        background:#356AA0;

      }

    </style>

    <link href="indianwall/css_orig/bootstrap-responsive.css" rel="stylesheet">

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />



  </head>



  <body>

  

     <div class="container height-100" >

        <div class="navbar navbar-inverse navbar-fixed-top">

          <div class="navbar-inner">

            <div class="container-fluid">

              <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

              </button>

              <a class="brand" href="#">Little India</a>

              <div class="nav-collapse collapse">

                <p class="navbar-text pull-right">

                  Logged in as <a href="#" class="navbar-link">Username</a>

                </p>

                <ul class="nav">

                  <li class="active"><a href="#">iReader</a></li>

                  <li><a href="#about">iVideos</a></li>
                  
                  <li><a href="#about">iMusic</a></li>

                  <li><a href="#contact">iWall</a></li>

                </ul>

              </div>

            </div>

          </div>

        </div>

     </div>  



    <div id="mainContainer" class="container">

             
              	<div class="span11 well">
              	    <button type="button" class="close" data-dismiss="alert">&times;</button>
  					<H3> Indian Reader - read all your favorite news, blogs, articles and stories at one place.</H3>
			  	</div>

              <div class="masthead span12">

			  
                 <div id="categoryDiv" class="pull-left">

                    <h4>Category: </h4>

                    <select id="category">

                        <option>News</option>

                        <option>Entertainment</option>

                        <option>Technology</option>

                        <option>Business</option>

                        <option>Sports</option>

                    </select>

                 </div>    

                 

                 <div id="emptyDiv" class="pull-left">

                    <p> &nbsp;&nbsp; </p>

                 </div>

                 

                 <div id="languageDiv" class="pull-left">

                    <h4>Language: </h4>

                    <select id="language">

                                                                                                <option>Hindi</option>                    

                        <option>English</option>                        

                        <option>Telugu</option>

                        <option>Tamil</option>

                        <option>Marathi</option>

                        <option>Bengali</option>

                    </select>

                 </div>   

                 

                 <div id="contentDiv" class="pull-right">

                    <h4> &nbsp; </h4>

                    <button id="addContentBtnId" type="button" value="Add Content" name="AddContent" class="btn btn-success">Add More Content</button>

                    &nbsp;&nbsp;

                 </div>                                             

              </div>

                

        

        <div id="readerContainer" class="span12">



        </div>

        

        <div id="paginationDiv" class='span12 hide'>

            <div class="span8">

            </div>

                        <div class="pagination span4">

                                                                <ul id='paginationItemsDiv'>

                                                                </ul>

                                                </div>          

        </div> 

    </div>



    

    <footer>

       <p>&copy; Company 2013</p>

    </footer>



    <script type="text/template" id="progressbar-template">

        <div id="progressbarCnt">

             <span id="progessMesg">Loading... </span><div id="progressbar"></div>

        </div>

    </script>

            

    <script type="text/template" id="feed-item-template">

        <a href="<%= feedUrlElement %>">

            <div class="thumbnail carousel-thumbnail bgwhite">

                <img src="<%= feedItemImageElement%>"/>                

                <div class="caption">

                    &nbsp;

                    <h4><%= feedItemTitleElement %></h4>

                    <p><%= feedDescriptionElement %></p>

                </div>

            </div> 

        </a>

    </script>  

    

    <script type="text/template" id="feed-template">             

        <div> 

           <h4 class="muted"><%=feedTitleElement%></h4>

        </div>

        <div id="myCarousel<%=feedIdElement%>" class="carousel" data-interval="false">

            <div class="carousel-inner">

                <div id="feedItemsParentDiv<%=feedIdElement%>-0" class="item active">

                    <div id="feedItemsDiv<%=feedIdElement%>-0">

                    </div>

                </div>

                <div id="feedItemsParentDiv<%=feedIdElement%>-1" class="item">

                     <div id="feedItemsDiv<%=feedIdElement%>-1">

                     </div>

                </div>

                <div id="feedItemsParentDiv<%=feedIdElement%>-2" class="item">

                     <div id="feedItemsDiv<%=feedIdElement%>-2">

                     </div>

                </div>

            </div>

            <a class="left carousel-control" href="#myCarousel<%=feedIdElement%>" data-slide="prev">&lsaquo;</a>

            <a class="right carousel-control" href="#myCarousel<%=feedIdElement%>" data-slide="next">&rsaquo;</a>

       </div>

    </script>

               

     <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
     <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
     <script src="indianwall/reader/js/lib/bootstrap.min.js"></script>
     <script src="indianwall/reader/js/lib/underscore-min.js"></script>
     <script src="indianwall/reader/js/lib/backbone-min.js"></script>
     <script src="indianwall/reader/js/model/feed.js"></script>          
     <script src="indianwall/reader/js/collections/feedcoll.js"></script>
     <script src="indianwall/reader/js/model/feedsinfo.js"></script> 
     <script src="indianwall/reader/js/views/appview.js"></script>
     <script src="indianwall/reader/js/views/feedview.js"></script>
     <script charset="utf-8" src="indianwall/reader/js/app.js"></script>

  </body>

</html>
