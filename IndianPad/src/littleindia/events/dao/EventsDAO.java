package littleindia.events.dao;

import java.util.List;
import littleindia.events.TestEvent;
import littleindia.events.vo.EventVO;

public class EventsDAO implements IEventsDAO {



    @Override

    public void addEvent(EventVO event) {

        TestEvent.getInstance().addEvent(event);

    }



    @Override

    public List<EventVO> getEvents(String place) {

        return TestEvent.getInstance().getEvents();

    }

    

    @Override

    public EventVO getEvent(int eventId) {

        return null;

    }

    

}

