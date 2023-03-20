package testbench;

import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;
import bench.IBenchmark;
import bench.cpu.CPUFixedPoint;
//import bench.cpu.CPUNumberRepresentation;
//import bench.cpu.NumberRepresentation;

public class TestCPUFixedPoint
{

    public static void main(String[] args)
    {
        ITimer timer = new Timer();
        ILog log = /* new FileLogger("bench.log"); */new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Milli;
        int size = 100;
        IBenchmark bench = new CPUFixedPoint();
        bench.initialize(100);
        bench.warmUp();

        timer.start();
//      bench.run(NumberRepresentation.FIXED);
//		bench.run(NumberRepresentation.FLOATING);

        bench.run(0,size);
        //bench.run(1);
        long time = timer.stop();

        log.writeTime("Finished in", time, timeUnit);
        double timer2 = time/1000000000.0;
        double MOPS = (19.0*size)/(timer2*1e6);
        log.write("MOPS VALUE", MOPS);

        bench.clean();
        log.close();
    }
}
