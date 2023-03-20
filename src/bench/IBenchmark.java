package bench;

public interface IBenchmark 
{

    public void run();
    
    public void run(Object ... params); //– is the method which will contain the core of the code used to actually benchmark a hardware component.

    abstract void initialize();

    public void initialize(Object ... params); //– here we place all code needed to prepare the data for the run method to execute.
   //We can pass any number and type of arguments to this method, like, file path, array size etc. 

   public void clean(); //– here we might need to clean up after the run method.

    public void warmUp();
    // call calculatePi from here and also verify if you can make it smaller
   public void cancel(); //– useful mainly when exposing a UI (user interface) to a client

    Object getResult();
}
