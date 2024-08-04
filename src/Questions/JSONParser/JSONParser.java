package Questions.JSONParser;

import Questions.JSONParser.elements.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONParser {
    private String json;
    private int index;

    // Constants
    private static final char OPEN_CURLY_BRACE = '{';
    private static final char CLOSE_CURLY_BRACE = '}';
    private static final char OPEN_SQUARE_BRACKET = '[';
    private static final char CLOSE_SQUARE_BRACKET = ']';
    private static final char DOUBLE_QUOTE = '"';
    private static final char COLON = ':';
    private static final char COMMA = ',';

    public JSONElement parse(String jsonString) {
        this.index = 0;
        this.json = jsonString;
        skipWhitespace();
        return parseValue();
    }

    private JSONElement parseValue() {
        char currentChar = json.charAt(index);

        return switch (currentChar) {
            case OPEN_CURLY_BRACE -> parseObject();
            case OPEN_SQUARE_BRACKET -> parseArray();
            case DOUBLE_QUOTE -> parseString();
            case 't', 'f' -> parseBoolean();
            case 'n' -> parseNull();
            default -> {
                if (Character.isDigit(currentChar) || currentChar == '-') {
                    yield parseNumber();
                }
                throw new RuntimeException("Invalid JSON.");
            }
        };
    }

    private JSONObject parseObject() {
        Map<String, JSONElement> properties = new HashMap<>();

        consume(OPEN_CURLY_BRACE);
        skipWhitespace();

        while (json.charAt(index) != CLOSE_CURLY_BRACE) {
            // parse property name
            String propertyName = parseString().getValue().toString();
            skipWhitespace();

            consume(COLON);
            skipWhitespace();

            JSONElement propertyValue = parseValue();
            properties.put(propertyName, propertyValue);

            skipWhitespace();

            if (json.charAt(index) == COMMA) {
                consume(COMMA);
                skipWhitespace();
            }
        }

        consume(CLOSE_CURLY_BRACE);
        return new JSONObject(properties);
    }

    private JSONArray parseArray() {
        List<JSONElement> elements = new ArrayList<>();

        consume(OPEN_SQUARE_BRACKET);
        skipWhitespace();

        while (json.charAt(index) != CLOSE_SQUARE_BRACKET) {
            JSONElement element = parseValue();
            elements.add(element);

            skipWhitespace();

            if (json.charAt(index) == COMMA) {
                consume(COMMA);
                skipWhitespace();
            }
        }

        consume(CLOSE_SQUARE_BRACKET);
        return new JSONArray(elements);
    }

    private JSONNumber parseNumber() {
        int startIndex = index;

        while (Character.isDigit(json.charAt(index)) || json.charAt(index) == '.') {
            ++index;
        }
        String numberStr = json.substring(startIndex, index);
        if (numberStr.contains(".")) {
            return new JSONNumber(Double.parseDouble(numberStr));
        } else {
            return new JSONNumber(Long.parseLong(numberStr));
        }
    }

    private JSONBoolean parseBoolean() {
        String boolStr = consumeWord();
        if (boolStr.equals("true")) {
            return new JSONBoolean(true);
        } else if (boolStr.equals("false")) {
            return new JSONBoolean(false);
        }
        throw new RuntimeException("Invalid boolean value.");
    }

    private JSONString parseString() {
        consume(DOUBLE_QUOTE);

        StringBuilder sb = new StringBuilder();
        while (json.charAt(index) != DOUBLE_QUOTE) {
            sb.append(json.charAt(index));
            ++index;
        }

        consume(DOUBLE_QUOTE);

        return new JSONString(sb.toString());
    }

    private JSONNull parseNull() {
        String nullStr = consumeWord();
        if (nullStr.equals("null")) {
            return new JSONNull();
        }
        throw new RuntimeException("Invalid null string");
    }

    private String consumeWord() {
        StringBuilder sb = new StringBuilder();
        while (Character.isLetter(json.charAt(index))) {
            sb.append(json.charAt(index));
            ++index;
        }
        return sb.toString();
    }

    private void consume(char expected) {
        if (json.charAt(index) == expected) {
            ++index;
        } else {
            throw new RuntimeException("Expected: " + expected);
        }
    }

    private void skipWhitespace() {
        while (index < json.length() && Character.isWhitespace(json.charAt(index))) {
            ++index;
        }
    }
}
