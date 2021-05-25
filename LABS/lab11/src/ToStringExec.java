import java.util.ArrayList;
import java.util.Formatter;

public class ToStringExec {
    public StringBuffer line = new StringBuffer();

    public void execute(String elem, ArrayList<Integer> lineNumbers) {
        Formatter formatter = new Formatter();
        formatter.format("%-15s", elem);
        line.append(formatter).append("  - ");
        for (Integer integer : lineNumbers) {
            line.append(integer).append(", ");
        }
        line.replace(line.length() - 2, line.length() - 1, "");
        line.append("\n");

    }

    public String getResult() {

        return line.toString();
    }

    public void clear() {
        line = new StringBuffer();
    }
}
