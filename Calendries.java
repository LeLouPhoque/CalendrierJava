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
	private String version =    "VERSION:2.0\r\n";
	private String prodid =     "PRODID://applicamp.com//lienIcal\r\n";
	private String calBegin =   "BEGIN:VCALENDAR\r\n";
	private String calEnd =     "END:VCALENDAR\r\n";
	private String uid =        "applicamp@ical.com";
	private static final String PATH = "C:\\Users\\DEV3\\Desktop\\Calender";
	
	public void writes(String name, List<ICal> LesCals){
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
             for (ICal b:LesCals)
             {
            	 bw.write(writeMid(b));
             }
             bw.write(calEnd);

             bw.close();

             System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
       
	}
	
	 public String writeMid(ICal b){
	    	
		 return ("BEGIN:VEVENT\r\n"
	        		+ "DTSTAMP:"+convertDate(b.getDtStamp())+"\r\n"
	        		+ "UID:"+uid+"\r\n"
	        		+ "DTSTART;VALUE=DATE:"+b.getDtStart()+"\r\n"
	        		+ "DTEND;VALUE=DATE:"+b.getDtend()+"\r\n"
	        		+ "SUMMARY:"+b.getSummary()+"\r\n"
	        		+ "DESCRIPTION:"+b.getDescription()+"\r\n"
	        		+ "LOCATION:"+b.getLocation()+"\r\n"
	        		+ "END:VEVENT\r\n");
	        
	    }
	 
	 public String convertDate(Date uneDate)
	 {
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
		 return (simpleDateFormat.format(uneDate).toString().replaceAll("[^a-zA-Z0-9]",""));
	 }
}
