
package kaplan.clock;
import junit.framework.TestCase;

public class ClockTest extends TestCase {

	public void testClock() throws InterruptedException {
		Clocker clock = new Clocker(3, 52);
		System.out.println(clock.getAngle());
		assertEquals(164.0, clock.getAngle());
	}

	public void testThreeThirty() throws InterruptedException {
		Clocker clock = new Clocker(3, 30);
		System.out.println(clock.getAngle());
		assertEquals(75.0, clock.getAngle());
	}
	public void testThreeOclock(){
		Clocker clock = new Clocker(3, 00);
		System.out.println(clock.getAngle());
		assertEquals(270.0, clock.getAngle());
	}
}
