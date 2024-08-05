package Questions.JSONParser;

import Questions.JSONParser.elements.JSONElement;

public class JSONParserDemo {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"John\", \"age\": 30, \"city\": \"New York\", \"isAdmin\": true, \"scores\": [10, 20, 30] }";
        JSONParser jsonParser = new JSONParser();
        JSONElement jsonElement = jsonParser.parse(jsonString);
        System.out.println(jsonElement.getValue());

        String jsonString2 = "{\"zabc\":{\"zbcde\":null,\"xml\":\"asd\"}}";
        System.out.println(jsonParser.parse(jsonString2).getValue());

        String jsonString3 = "{\n" +
                "  \"employee\": {\n" +
                "    \"id\": 12345,\n" +
                "    \"name\": \"Jane Smith\",\n" +
                "    \"position\": \"Software Engineer\",\n" +
                "    \"details\": {\n" +
                "      \"hobbies\": [\"reading\", \"hiking\"],\n" +
                "      \"experience\": 5\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Object object = jsonParser.parse(jsonString3).getValue();
        System.out.println(object);
    }
}
