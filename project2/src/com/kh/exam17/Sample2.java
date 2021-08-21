package com.kh.exam17;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class RNumber{
	private int number;
	private Date date;
		
	public RNumber(int number, Date date) {
		this.number = number;
		this.date = date;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "RNumber [number=" + number + ", date=" + date + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RNumber other = (RNumber) obj;
		return number == other.number;
	}
	
	
}

public class Sample2 {

	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<Integer>();
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int count=0 ,overlap = 0;
		
		while(count < 10) {
			int random = (int)(Math.random()*99+1);
			Calendar cal = Calendar.getInstance();
			int firstTime = cal.get(Calendar.SECOND);
			for(int i=0; i<aList.size();i++) {
				if(random == aList.get(i)) {
					overlap++;
				}
			}
			if(overlap >= 1) {
				overlap = 0;
				continue;
			}
			
			while(true) {
				Calendar cal2 = Calendar.getInstance();
				int laterTime = cal2.get(Calendar.SECOND);
				
				if(laterTime - firstTime == 3 | laterTime - firstTime == -57) {
					String date = dFormat.format(cal.getTime());
					aList.add(random);		dateList.add(count, date);
					System.out.println("배열: " + aList + "\n생성된 시간 : " + dateList);	
					count++;
					break;
				}else {
					continue;
				}
			}
			
		}

	}

}
