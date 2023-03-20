package bench.cpu;
import bench.IBenchmark;

public class CPUFixedPoint implements IBenchmark
{

    @Override
    public void run() {
    }
    @Override
    public void run(Object... params)
    {
        int Option = (Integer) params[0];

        switch (Option)
        {
            case 0 -> arithmeticTest((Integer) params[1]);
            case 1 -> branchingTest();
            default -> throw new IllegalArgumentException("Option invalid! Must choose between 0 and 1!");
        }
    }

    public void arithmeticTest(int size)
    {
        int[] num = {0, 1, 2, 3};
        int j = 0;
        int k = 0;
        int l = 0;
        for( int i = 0; i<size; i++ )
        {
            j = num[1] * (k - j) * (l - k);
            k = num[3] * k - (l - j) * k;
            l = (l - k) * (num[2] + j);
        }
    }

    public void branchingTest()
    {
        int [] num = { 0, 1, 2, 3 };
        int j = 0;
        int k = 5;
        int l = 2;
        if (j == 1)
        {
            j = num[2];
        }
        else
        {
            j = num[3];
        }
        if (j > 2)
        {
            j = num[0];
        }
        else
        {
            j = num[1];
        }
        if (j < 1)
        {
            j = num[1];
        }
        else
        {
            j = num[0];
        }
    }

    @Override
    public void initialize() {

    }

    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void warmUp() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public Object getResult() {
        return null;
    }
}
