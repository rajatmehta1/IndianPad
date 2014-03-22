package littleindia.rss;



import java.io.IOException;

import java.io.InputStream;

import java.net.InetSocketAddress;

import java.net.MalformedURLException;

import java.net.Proxy;

import java.net.URL;

import java.net.URLConnection;



import javax.xml.stream.XMLEventReader;

import javax.xml.stream.XMLInputFactory;

import javax.xml.stream.XMLStreamException;

import javax.xml.stream.events.Characters;

import javax.xml.stream.events.XMLEvent;



import littleindia.rss.bean.Feed;

import littleindia.rss.bean.FeedMessage;





public class RssFeedParser {

  static final String TITLE = "title";

  static final String DESCRIPTION = "description";

  static final String CHANNEL = "channel";

  static final String LANGUAGE = "language";

  static final String COPYRIGHT = "copyright";

  static final String LINK = "link";

  static final String AUTHOR = "author";

  static final String ITEM = "item";

  static final String PUB_DATE = "pubDate";

  static final String GUID = "guid";

  static final String IMAGE = "image";



  final URL url;



  public RssFeedParser(String feedUrl) {

    try {

      this.url = new URL(feedUrl);

    } catch (MalformedURLException e) {

      throw new RuntimeException(e);

    }

  }



  public Feed readFeed() {

    Feed feed = null;

    try {

      boolean isFeedHeader = true;

      // Set header values intial to the empty string

      String description = "";

      String title = "";

      String link = "";

      String language = "";

      String copyright = "";

      String author = "";

      String pubdate = "";

      String guid = "";

      String image = "";



      // First create a new XMLInputFactory

      XMLInputFactory inputFactory = XMLInputFactory.newInstance();

      // Setup a new eventReader

      InputStream in = read();

      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

      // Read the XML document

      while (eventReader.hasNext()) {

        XMLEvent event = eventReader.nextEvent();

        if (event.isStartElement()) {

          String localPart = event.asStartElement().getName()

              .getLocalPart();

          if(ITEM.equals(localPart)){ 

            if (isFeedHeader) {

              isFeedHeader = false;

              feed = new Feed(title, link, description, language,

                  copyright, pubdate);

            }

            event = eventReader.nextEvent();

          }

          else if(TITLE.equals(localPart)) {

            title = getCharacterData(event, eventReader);

          }

          else if(DESCRIPTION.equals(localPart)) {

            description = getCharacterData(event, eventReader);

            if(description.indexOf("img src") > 0) {

                int imgIndex = description.indexOf("img src");

                String firstString = description.substring(0,imgIndex - 1);

                String remStr = description.substring(imgIndex + 8);

                int lastImgIndex = remStr.indexOf(".jpg");

                String imgStr = remStr.substring(0,lastImgIndex + 4);

                image = imgStr;

                description = firstString + " " + remStr.substring(lastImgIndex + 8);

            }

          }

          else if(LINK.equals(localPart)) {

              link = getCharacterData(event, eventReader);

            }          

          else if(GUID.equals(localPart)) {

              guid = getCharacterData(event, eventReader);

            }          

          else if(LANGUAGE.equals(localPart)) {

              language = getCharacterData(event, eventReader);

            }          

          else if(AUTHOR.equals(localPart)) {

              author = getCharacterData(event, eventReader);

            }          

          else if(PUB_DATE.equals(localPart)) {

              pubdate = getCharacterData(event, eventReader);

          }          

          else if(COPYRIGHT.equals(localPart)) {

              copyright = getCharacterData(event, eventReader);

          }    

          else if(IMAGE.equals(localPart)) {

              String test = getCharacterData(event, eventReader);

              if(test == null || test.equals("")) {

                  //do nothing

              }

              else image = test;

          }           





        } else if (event.isEndElement()) {

          if (event.asEndElement().getName().getLocalPart() == (ITEM)) {

            FeedMessage message = new FeedMessage();

                message.setAuthor(author);

                message.setDescription(description);

                message.setGuid(guid);

                message.setLink(link);

                message.setTitle(title);

                message.setImage(image);

                    feed.getMessages().add(message);

                    event = eventReader.nextEvent();

            continue;

          }

        }

      }

    } catch (XMLStreamException e) {

      throw new RuntimeException(e);

    }

    return feed;

  }



  private String getCharacterData(XMLEvent event, XMLEventReader eventReader)

      throws XMLStreamException {

    String result = "";

    event = eventReader.nextEvent();

    if (event instanceof Characters) {

      result = event.asCharacters().getData();

    }

    return result;

  }



  private InputStream read() {
	    try {
	      return url.openStream();
//	        String proxyUser = "rajat";
//	        String proxyPassword = "Admin551";
//	        String proxyAddress = "wwwproxy.ms.com";
//	        int proxyPort = 8080;
//	        InetSocketAddress sa = new InetSocketAddress(proxyAddress, proxyPort);
//	        Proxy proxy = new Proxy(Proxy.Type.HTTP, sa);
//	        URLConnection conn = url.openConnection(proxy);
//	        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
//	        String encodedUserPwd = encoder.encode((proxyUser + ":" + proxyPassword).getBytes());
//	        conn.setRequestProperty("Accept-Charset", "UTF-8");
//	        conn.setRequestProperty("Proxy-Authorization", "Basic " + encodedUserPwd);
//	           return  conn.getInputStream();
	    } catch (IOException e) {
	      throw new RuntimeException(e);
	    }
	  }
}



