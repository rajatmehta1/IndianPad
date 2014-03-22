package littleindia.events;



import java.util.ArrayList;

import java.util.List;



import littleindia.events.vo.EventVO;



public class TestEvent {

   private static final TestEvent obj = new TestEvent();

   private List<EventVO> events = null;

   

   private TestEvent() {

       events = new ArrayList<EventVO>();

       populate();

   }

   

   private void populate() {

       EventVO evo = new EventVO();

          evo.setEventId(0);

          evo.setName("Jagjit Singh Live");

          evo.setCity("New Jersey");

          evo.setAddress_line1("line 1");

          evo.setAddress_line1("line 2");

          evo.setDescription("first event goes here and second event goes here");          

              events.add(evo);

              

          evo = new EventVO();

          evo.setEventId(1);

          evo.setName("Jagjit Singh Live33434");

          evo.setCity("New Jersey");

          evo.setAddress_line1("line 1");

          evo.setAddress_line1("line 2");

          evo.setDescription("first event goes here and second event goes here");          

             events.add(evo);              

   }

   

   public static TestEvent getInstance() {

       return obj;

   }

   public void addEvent(EventVO e) {

       events.add(e);

   }

   

   public List<EventVO> getEvents() {

       return events;

   }

   

}

