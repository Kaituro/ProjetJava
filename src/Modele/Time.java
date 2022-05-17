package Modele;

import javafx.fxml.FXML;

public class Time {
	@FXML
	private int hour;
	@FXML
	private int minute;
	@FXML
	private int second;


public Time(int hour,int minute,int second) {
	this.hour=hour;
	this.minute=minute;
	this.second=second;
}

public Time(String currentTime) {
	String [] time=currentTime.split(":");
	hour=Integer.parseInt(time[0]);
	minute=Integer.parseInt(time[1]);
	second=Integer.parseInt(time[2]);
}

public String GetCurrentTime() {
	return hour + ":" + minute + ":" +second;
}

public void oneSecondPassed() {
	second--;
	if (second<=0) {
		minute--;
		second=59;
		if (minute<=0) {
			if (hour==0) {
				minute=59;	
			}else {
				hour--;
				minute=59;
			}
			
			
					
		}
	}
}
}
