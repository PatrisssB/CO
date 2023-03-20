/*package testbench;

import logging.*;
import timing.*;
import bench.*;

public class TestDemoBench {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog logger = new ConsoleLogger();
        IBenchmark benchmark = new DemoBenchmark();
        TimeUnit Milisecond = TimeUnit.Milli;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;

        benchmark.initialize(100);
        timer.start();
        benchmark.run();
        long time = timer.stop();
        logger.writeTime("Finished in", time, Microsecond);
        logger.writeTime("Finished in", time, Milisecond);
        logger.writeTime("Finished in", time, Second);
        logger.close();
        benchmark.clean();

        //new thing that needs to be done
        final int workload = 100;
        benchmark.initialize(workload);
        for (int i = 0; i < 12; i++) {
            timer.resume();
            benchmark.run();
            long time1 = timer.pause();
            logger.writeTime("Finished in", time1, Second);
        }
        timer.stop();
        logger.writeTime("Finished in", time, Second);
    }
}*/
package testbench;

import bench.cpu.CPUDigitsOfPi;
import logging.*;
import timing.*;
import bench.*;

import java.math.BigInteger;

public class TestDemoBench
{
    public static void main(String[] args)
    {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        TimeUnit Milisecond = TimeUnit.Milli;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        //BigInteger pi = new BigInteger()
        IBenchmark bench = new CPUDigitsOfPi();
        bench.initialize();
        bench.warmUp();
        timer.start();
        bench.run(0,5000);
        long time = timer.stop();
        log.writeTime("Finished in", time, Milisecond);
        log.close();
        bench.clean();
    }
}