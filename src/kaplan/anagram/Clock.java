package kaplan.anagram;

public class Clock {
	private double oldTime;

	public Clock() {
		oldTime = System.currentTimeMillis();
	}

	public double tick() {
		double newTime = System.currentTimeMillis();
		double timeElapsed = (newTime - oldTime) / 1000;
		oldTime = newTime;
		return timeElapsed;
	}
}