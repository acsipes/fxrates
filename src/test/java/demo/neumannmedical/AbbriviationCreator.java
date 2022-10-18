package demo.neumannmedical;

public class AbbriviationCreator {

    public String createAbbreviation(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("emtpty String");
        }

        String[] splitName = name.split(" ");

        String result = "";
        
        for (String namePart : splitName) {
            String text = namePart.substring(0, 1);
            text = text.toUpperCase();
            result += text;
        }
        return result;
    }
}
