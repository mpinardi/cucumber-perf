package cucumber.perf.api.formatter;

import cucumber.perf.api.event.EventBus;

public interface EventWriter {
	
    /**
     * Set the event bus. The plugin can send events.
     * @param eventBus the event bus
     */
    void setEventBus(EventBus eventBus);
}