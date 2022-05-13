package com.example.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Calendries {
	private static final String version =    "VERSION:2.0\r\n";
	private static final String prodid =     "PRODID://test.com//lienIcal\r\n";
	private static final String calBegin =   "BEGIN:VCALENDAR\r\n";
	private static final String calEnd =     "END:VCALENDAR\r\n";
	private static final String uid =        "test@ical.com";
	private static final String PATH = "C:\\Users\\DEV3\\Desktop\\Calender"; // location of the repo of your calender
	
	public void write(String name, List<ICal> LesCals){
    	File file = new File(PATH);
    	
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
             FileWriter fw = new FileWriter(new File(file,name + ".ics"));
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write(calBegin);
             bw.write(version);
             bw.write(prodid);
             for (ICal planing:LesCals)
             {
            	 bw.write(evenement(planing));
             }
             bw.write(calEnd);

             bw.close();

             System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
       
	}
	
	 public String evenement(ICal planing){
	    	
		 return ("BEGIN:VEVENT\r\n"
	        		+ "DTSTAMP:"+convertDate(planing.getDtStamp())+"\r\n"
	        		+ "UID:"+uid+"\r\n"
	        		+ "DTSTART;TZID=Europe/Paris:"+planing.getDtStart()+"T110000\r\n"
	        		+ "DTEND;TZID=Europe/Paris:"+(planing.getDtend()+1)+"T110000\r\n"
	        		+ "SUMMARY:"+planing.getSummary()+"\r\n"
	        		+ "DESCRIPTION:"+planing.getDescription()+"\r\n"
	        		+ "LOCATION:"+planing.getLocation()+"\r\n"
	        		+ "END:VEVENT\r\n");
	        
	    }
	 
	 public String convertDate(Date uneDate)
	 {
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
		 return (simpleDateFormat.format(uneDate).toString().replaceAll("[^a-zA-Z0-9]",""));
	 }
}
