package com.kh.exam17;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

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
		SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		GregorianCalendar gcStart = new GregorianCalendar();
		GregorianCalendar gcEnd = null;
		Random rd = new Random();
		List<RNumber> iList = new ArrayList<RNumber>();
		while(iList.size() < 10) {
			gcEnd = new GregorianCalendar();
			if(((gcStart.get(Calendar.SECOND) + 3) % 60) == gcEnd.get(Calendar.SECOND)) {
				RNumber temp = new RNumber(rd.nextInt(15) + 1, gcEnd.getTime()); 
				if(!iList.contains(temp)) {
					iList.add(temp);
					System.out.println(iList);
				}
				gcStart = gcEnd;
			}
		}
	}

}
