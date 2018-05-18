package application.TagsManager;

public class EventResolved {
    Event _event;
    String _resolution;
    public EventResolved (Event event, String resolution){
        _event = event;
        _resolution = resolution;
    }

    public Event get_event() {
        return _event;
    }

    public void set_event(Event _event) {
        this._event = _event;
    }

    public String get_resolution() {
        return _resolution;
    }

    public void set_resolution(String _resolution) {
        this._resolution = _resolution;
    }
}
