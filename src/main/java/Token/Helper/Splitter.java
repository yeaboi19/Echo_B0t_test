package Token.Helper;

public class Splitter {

    public String Splitter(String msg, int queue) {

        String[] splitted = msg.split(" ");

        if (queue == 1) {
            return splitted[0];
        } else {
            if (splitted.length != 1) {
                String other = "";
                for (int i = 1; i < splitted.length; i++) {
                    other += splitted[i];
                    if (i + 1 < splitted.length) {
                        other += " ";
                    }
                }
                return other;
            }
            return "";
        }
    }
}
// echo nika

// nika