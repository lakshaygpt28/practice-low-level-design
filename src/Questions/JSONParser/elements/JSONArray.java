package Questions.JSONParser.elements;

import java.util.ArrayList;
import java.util.List;

public class JSONArray implements JSONElement {
    List<JSONElement> elements;

    public JSONArray(List<JSONElement> elements) {
        this.elements = elements;
    }

    @Override
    public Object getValue() {
        List<Object> result = new ArrayList<>();
        elements.forEach(value -> result.add(value.getValue()));
        return result;
    }
}
