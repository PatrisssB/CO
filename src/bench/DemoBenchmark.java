package bench;
import java.util.Random;


public class DemoBenchmark implements IBenchmark
{
    private int n;
    private int aux;
    private int[] array;
    @Override
    public void run()
    {
        for( int i = 0; i < n; i++ )
        {
            for( int j = 0; j < n; j++ )
            {
                aux = array[j];
                array[j] = array[i];
                array[i] = aux;
            }
        }
    }

    @Override
    public void run(Object ... params)
    {

    }

    @Override
    public void initialize() {

    }

    @Override
    public void initialize(Object ... params)
    {
        Random rand = new Random();
        this.n = (Integer) params[0];
        this.array = new int[n];

        for( int i = 0; i < n; i++ )
        {
            array[i] = rand.nextInt(1000);
        }
    }

    @Override
    public void clean()
    {
        array = null;
    }

    @Override
    public void warmUp() {

    }

    @Override
    public void cancel()
    {

    }
}