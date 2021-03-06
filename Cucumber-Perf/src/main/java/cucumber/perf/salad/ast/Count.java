package cucumber.perf.salad.ast;

import io.cucumber.core.internal.gherkin.ast.Location;
import io.cucumber.core.internal.gherkin.ast.Node;

public class Count extends Node {
    private final String contentType;
    private final String content;

    public Count(Location location, String contentType, String content) {
        super(location);
        this.contentType = contentType;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getContentType() {
        return contentType;
    }
}
