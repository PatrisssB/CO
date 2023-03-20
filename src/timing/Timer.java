package timing;

public class Timer implements ITimer 
{

	private long elapsedTime = 0;
	// this is EndTime - StartTime
	private long storedTime = 0;
	// FinalTime
	private TimerState state;

	public Timer() 
    {
		state = TimerState.Stop;
	}

	public void start() 
    {
		storedTime = 0;
		resume();
	}

	public long stop() 
   {
		if (state.equals(TimerState.Run))
		{
			elapsedTime = System.nanoTime() - elapsedTime;
			state = TimerState.Stop;
			storedTime += elapsedTime;
		}
			return storedTime;
	}

	public long pause() 
  {
		elapsedTime = System.nanoTime() - elapsedTime;
		state = TimerState.Pause;
		storedTime += elapsedTime;

		return elapsedTime;
	}
	public void resume() 
  {
		state = TimerState.Run;
		elapsedTime = System.nanoTime();
	}
}
