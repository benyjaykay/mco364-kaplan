
package kaplan.clock;
public class Clocker {
	private double hour;
	private double minute;
	private double angle;
	private double totalMinutes;

	public Clocker(double hour, double minute) {
		this.hour = hour;
		this.minute = minute;
		totalMinutes = (hour * 60) + minute;
		double hourHandAngle = totalMinutes * .5;
		double minuteHandAngle = totalMinutes * 6;
		angle = (minuteHandAngle % 360) - hourHandAngle;
		if (angle >= 180)
			angle = 360 - angle;
		if(angle <= 0)
			angle = angle + 360;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(double hour) {
		this.hour = hour;
		this.minute = getMinute();
		totalMinutes = (hour * 60) + minute;
		double hourHandAngle = totalMinutes * .5;
		double minuteHandAngle = totalMinutes * 6;
		angle = (minuteHandAngle % 360) - hourHandAngle;
		if (angle >= 180)
			angle = 360 - angle;
		if(angle <= 0)
			angle = angle + 360;
	}

	public double getMinute() {
		return minute;
	}

	public void setMinute(double minute) {
		this.minute = minute;
		this.hour = getHour();
		totalMinutes = (hour * 60) + minute;
		double hourHandAngle = totalMinutes * .5;
		double minuteHandAngle = totalMinutes * 6;
		angle = (minuteHandAngle % 360) - hourHandAngle;
		if (angle >= 180)
			angle = 360 - angle;
		if(angle <= 0)
			angle = angle + 360;
	}

	public double getTotalMinutes() {
		return totalMinutes;
	}


	public double getAngle() {
		return angle;
	}

}
