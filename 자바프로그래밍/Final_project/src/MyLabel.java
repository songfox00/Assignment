import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;

class MyLabel extends JLabel implements Runnable {
		private Thread timerThread = null;
		public MyLabel() {
			setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 20));
			setHorizontalAlignment(JLabel.RIGHT);
			timerThread = new Thread(MyLabel.this);
			timerThread.start();
		}
		
		public String makeClockText() {
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month=c.get(Calendar.MONTH)+1;
			int day=c.get(Calendar.DATE);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			String clockText = Integer.toString(year);
			clockText=clockText.concat("년 ");
			clockText = clockText.concat(Integer.toString(month));
			clockText = clockText.concat("월 ");
			clockText = clockText.concat(Integer.toString(day));
			clockText = clockText.concat("일 ");
			clockText = clockText.concat(Integer.toString(hour));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			
			return clockText;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e){return;}
				setText(makeClockText());
			}
		}
	}
