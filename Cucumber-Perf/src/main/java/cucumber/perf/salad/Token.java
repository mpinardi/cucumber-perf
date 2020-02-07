package cucumber.perf.salad;

import java.util.List;

import io.cucumber.core.internal.gherkin.GherkinLineSpan;
import io.cucumber.core.internal.gherkin.IGherkinLine;
import io.cucumber.core.internal.gherkin.ast.Location;

public class Token {
    public final IGherkinLine line;
    public Parser.TokenType matchedType;
    public String matchedKeyword;
    public String matchedText;
    public List<GherkinLineSpan> mathcedItems;
    public int matchedIndent;
    public SaladDialect matchedSaladDialect;
    public Location location;

    public Token(IGherkinLine line, Location location) {
        this.line = line;
        this.location = location;
    }

    public boolean isEOF() {
        return line == null;
    }

    public void detach() {
        if (line != null)
            line.detach();
    }

    public String getTokenValue() {
        return isEOF() ? "EOF" : line.getLineText(-1);
    }

    @Override
    public String toString() {
        return String.format("%s: %s/%s", matchedType, matchedKeyword, matchedText);
    }
}
