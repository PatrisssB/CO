package bench.cpu;

import bench.IBenchmark;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CPUDigitsOfPi implements IBenchmark
{
    @Override
    public void run()
    {

    }

    @Override
    public void run(Object... params)
    {
        int Option = ( Integer) params[0];

        switch (Option)
        {
            case 0 ->
            {
                BigDecimal result1 = calculatePi((Integer) params[1]);
                System.out.println(result1);
                break;
            }
            case 1 ->
            {
                BigDecimal result1 = calculatePi((Integer) params[1]);
                System.out.println(result1);
                break;
            }

            default -> throw new IllegalArgumentException("Option invalid! Must choose between 0 1 and 2!");
        }
    }
        public static BigDecimal calculatePi(int precision)
        {
            BigInteger firstFactorial;
            BigInteger secondFactorial;
            BigInteger firstMultiplication;
            BigInteger firstExponent;
            BigInteger secondExponent;
            int firstNumber = 1102;
            BigInteger firstAddition;
            BigDecimal currentPi = BigDecimal.ONE;
            BigDecimal pi = BigDecimal.ONE;
            BigDecimal one = BigDecimal.ONE;
            int secondNumber = 2;
            int fourthNumber = 9801;
            BigDecimal prefix = BigDecimal.ONE;
            //DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            for(int i=0; i<precision; i++)
            {
                firstFactorial = factorial(4*i);
                secondFactorial = factorial(i);
                firstMultiplication = BigInteger.valueOf(26390*i);
                firstExponent = exponent(secondFactorial, 4);
                secondExponent = exponent(BigInteger.valueOf(396),4*i);
                firstAddition = BigInteger.valueOf(firstNumber).add(firstMultiplication);
                currentPi = currentPi.add(new BigDecimal(firstFactorial.multiply(firstAddition)).divide(new BigDecimal(firstExponent.multiply(secondExponent)), new MathContext(10000)));
                //Date date=new Date();
                //System.out.println("Interation: " + i + " at " + dateFormat.format(date));
            }

            double thirdNumber = Math.sqrt(2.0);
            prefix =new BigDecimal(secondNumber*thirdNumber);
            prefix = prefix.divide(new BigDecimal(fourthNumber), new MathContext(precision));

            currentPi = currentPi.multiply(prefix, new MathContext(precision));

            pi = one.divide(currentPi, new MathContext(precision));

            //System.out.println("Pi is: " + pi);
            return pi;
        }
        public static BigInteger factorial(int a)
        {

            BigInteger result=new BigInteger("1");
            BigInteger smallResult = new BigInteger("1");
            long x=a;
            if (x==1) return smallResult;
            while(x>1)
            {
                result= result.multiply(BigInteger.valueOf(x));

                x--;
            }
            return result;
        }
        public static BigInteger exponent(BigInteger a, int b)
        {
            BigInteger answer=new BigInteger("1");

            for(int i=0;i<b;i++)
            {
                answer = answer.multiply(a);
            }

            return answer;
        }


    @Override
    public void initialize() {
        initialize(null);
    }

    @Override
    public void initialize(Object... params)
    {

    }

    @Override
    public void clean()
    {

    }

    @Override
    public void warmUp()
    {
        calculatePi(800);
    }

    @Override
    public void cancel()
    {
    }
}
