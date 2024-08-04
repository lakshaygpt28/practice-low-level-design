package Questions.JSONParser.elements;

import java.util.HashMap;
import java.util.Map;

public class JSONObject implements JSONElement{
    private Map<String, JSONElement> properties;

    public JSONObject(Map<String, JSONElement> properties) {
        this.properties = properties;
    }

    @Override
    public Object getValue() {
        Map<String, Object> result = new HashMap<>();
        properties.forEach((key, value) -> result.put(key, value.getValue()));
        return result;
    }
}
