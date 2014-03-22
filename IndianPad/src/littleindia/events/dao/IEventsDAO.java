package littleindia.events.dao;



import java.util.List;



import littleindia.events.vo.EventVO;



public interface IEventsDAO {

    public void addEvent(EventVO event);

    public List<EventVO> getEvents(String place);

    public EventVO getEvent(int eventId); 

}

