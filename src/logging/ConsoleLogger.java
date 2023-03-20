package logging;

public class ConsoleLogger implements ILog
{

    public void write (String string)
    {
        System.out.println(string);
    }

    public void write(long value)
    {
        System.out.println(String.valueOf(value));
    }

    public void write( Object ... values)
    {
        for (Object o : values)
            System.out.print(o.toString() + " ");
        System.out.println();
    }

    @Override
    public void writeTime(String string, long value, TimeUnit unit) {
        System.out.println(string + " " + TimeUnit.toTimeUnit(value,unit) + TimeUnit.generateString(unit));
    }

    @Override
    public void close()
    {
    }
}
