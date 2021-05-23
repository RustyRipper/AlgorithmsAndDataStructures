public class ToStringExec implements IExecutor {
    public StringBuffer line = new StringBuffer();


    public void nawias(boolean t) {
        if (t) {
            line.append("(");
        } else
            line.append(")");
    }

    @Override
    public void execute(String elem) {


        line.append(" " + elem + " ");


    }

    @Override
    public String getResult() {

        return line.toString();
    }
}

