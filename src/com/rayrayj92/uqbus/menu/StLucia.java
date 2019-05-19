package com.rayrayj92.uqbus.menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.rayrayj92.uqbus.R;
import com.rayrayj92.uqbus.adapter.BusItem;
import com.rayrayj92.uqbus.adapter.ListViewAdapter;

public class StLucia extends Fragment {
	
	ListView st_list;
	ListViewAdapter adapter;
	
	// Holidays in 2015
	String[] holidays = {
			"12-Aug-2015",
			"28-Sep-2015",
			"29-Sep-2015",
			"30-Sep-2015",
			"01-Oct-2015",
			"02-Oct-2015",
			"05-Oct-2015",
			"25-Dec-2015",
			"26-Dec-2015",
			"28-Dec-2015"
	};
	
	String[] bus = new String[]{
		"29",
		"66",
		"139",
		"169",
		"192",
		"209",
		"411",
		"412",
		"N413"
	};
	
	int busImage = R.drawable.ic_bus;
	
	String[] LastBusWeekDay = new String[]{
			"Last Bus: 07:26 PM",
			"Last Bus: 09:30 PM",
			"Last Bus: 06:21 PM",
			"Last Bus: 09:11 PM",
			"Last Bus: 06:10 PM",
			"Last Bus: 09:18 PM",
			"Last Bus: 10:40 PM",
			"Last Bus: 11:37 PM",
			"Last Bus: 5:19 AM"
		};
	
	String[][] Bus29 = new String[][]{{"6:56","7:01","7:06","7:11","7:16","7:21","7:26","7:31","7:36","7:41","7:46","7:51",
		"7:56","8:01","8:06","8:11","8:16","8:21","8:26","8:31","8:36","8:41","8:46","8:51",
		"8:56","9:01","9:06","9:11","9:16","9:21","9:26","9:31","9:36","9:41","9:46","9:51",
		"9:56","10:06","10:16","10:26","10:36","10:46","10:56","11:06","11:16","11:26","11:36","11:46","11:56",
		"12:06","12:16","12:26","12:36","12:46","12:56",
		"13:06","13:16","13:26","13:36","13:46","13:56",
		"14:06","14:16","14:26","14:36","14:46","14:56",
		"15:06","15:11","15:16","15:21","15:26","15:31","15:36",
		"15:41","15:46","15:51","15:56",
		"16:01","16:06","16:11","16:16","16:21","16:26","16:31","16:36","16:41","16:46","16:51","16:56",
		"17:01","17:06","17:11","17:16","17:21","17:26","17:31","17:36","17:41","17:46","17:51","17:56",
		"18:01","18:06","18:11","18:16","18:26","18:36","18:46","18:56","19:06","19:16","19:26"},
			{}};
	
	String[][] Bus169 = new String[][]{{"6:56","7:16","7:35","7:55","8:15","8:35","8:55",
				"9:15","9:35","9:55","10:11","10:26","10:33","10:41","10:56",
				"11:11","11:26","11:41","11:56","12:11","12:26","12:41","12:56",
				"13:11","13:26","13:41","13:56","14:06","14:16","14:26","14:36","14:46","14:56","15:06","15:16",
				"15:26","15:36","15:46","15:56","16:06","16:16","16:26","16:36","16:46","16:56","17:06",
				"17:16","17:26","17:36","17:46","17:56","18:06","18:16","18:26","18:41","18:56","19:11",
				"19:26","19:41","19:56","20:11","20:26","20:41","20:56","21:11"},
				{"10:00","10:30","11:00","11:30","12:00","13:00","13:30","14:00","14:30",
					"15:00","15:30","16:00","16:30","17:00","17:30","18:00"}};
	
	String[][] Bus139 = new String[][]{{"10:03","10:18","10:33","10:48",
		"11:03","11:18","11:33","11:48",
		"12:03","12:18","12:33","12:48",
		"13:03","13:18","13:33","13:48",
		"14:03","14:18","14:21","14:32",
		"14:51","15:02","15:21","15:32","15:32","15:51",
		"16:01","16:11","16:21","16:31","16:41","16:51",
		"17:01","17:11","17:21","17:31","17:41","17:51",
		"18:01","18:11","18:21"},{}};
	
	String[][] Bus209 = new String[][]{{"10:03","10:18","10:33","10:48",
		"11:03","11:18","11:33","11:48",
		"12:03","12:18","12:33","12:48",
		"13:03","13:18","13:33","13:48",
		"14:03","14:18","14:33","14:48",
		"15:03","15:18","15:33","15:48","15:58",
		"16:03","16:18","16:33","16:48","16:58",
		"17:03","17:18","17:33","17:48","17:58",
		"18:03","18:18","18:33","18:48",
		"19:03","19:18","19:33","19:48",
		"20:03","20:18","20:33","20:48",
		"21:03","21:18"},
		{"8:45","9:45","10:45","11:45","12:45","13:45","14:45","15:45","16:45","17:45"}};
	
	String[][] Bus66 = new String[][]{{"6:00", "6:05", "6:10", "6:15", "6:20", "6:25", "6:30", "6:35", "6:40", "6:45", "6:50", "6:55", "7:00", "7:05", "7:10", "7:15", "7:20", "7:25", "7:30", "7:35", "7:40", "7:45", "7:50", "7:55", "8:00", "8:05", "8:10", "8:15", "8:20", "8:25", "8:30", "8:35", "8:40", "8:45", "8:50", "8:55", "9:00", "9:05", "9:10", "9:15", "9:20", "9:25", "9:30", "9:40", "9:50", "10:00", "10:10", "10:20", "10:30", "10:40", "10:50", "11:00", "11:10", "11:20", "11:30", "11:40", "11:50", "12:00", "12:10", "12:20", "12:30", "12:40", "12:50","13:00", "13:10", "13:20", "13:30", "13:40", "13:50", "14:00", "14:10", "14:20", "14:30", "14:40", "14:50", "15:00", "15:05", "15:10", "15:15", "15:20", "15:25", "15:30", "15:35", "15:40", "15:45", "15:50", "15:55", "16:00", "16:05", "16:10", "16:15", "16:20", "16:25", "16:30", "16:35", "16:40", "16:45", "16:50", "16:55", "17:00", "17:05", "17:10", "17:15", "17:20", "17:25", "17:30", "17:35", "17:40", "17:45", "17:50", "17:55", "18:00", "18:10", "18:20", "18:30", "18:40", "18:50", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30"},{"7:00", "7:15", "7:30", "7:45", "8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15"}};
	
	String[][] Bus411 = new String[][]{{"6:25 ", "6:51 ", "7:08 ", "7:26 ", "7:46 ", "8:05 ", "8:25 ", "8:45 ", "9:05 ", "9:25 ", "9:55 ", "10:25 ", "10:55 ", "11:25 ", "11:55 ", "12:25", "12:55", "13:25 ", "13:55 ", "14:25 ", "14:55 ", "15:10 ", "15:25 ", "15:46 ", "16:05 ", "16:20 ", "16:35 ", "16:51 ", "17:13 ", "17:33 ", "18:07 ", "18:37", "19:10 ", "19:40 ", "20:05 ", "20:40 ", "21:40 ", "22:40"},{}};
	
	String[][] Bus412 = new String[][]{{"5:50", "6:05", "6:20", "6:30", "6:40", "6:50", "7:00", "7:10", "7:20 ", "7:30 ", "7:40 ", "7:50 ", "8:00 ", "8:10 ", "8:20 ", "8:30 ", "8:40 ", "8:50 ", "9:00 ", "9:10 ", "9:20", "9:30 ", "9:40 ", "9:50 ", "10:00 ", "10:10 ", "10:20 ", "10:30 ", "10:40 ", "10:50 ", "11:00 ", "11:10 ", "11:20 ", "11:30 ", "11:40 ", "11:50 ", "12:00 ", "12:10 ", "12:20 ", "12:30", "12:40 ", "12:50", "13:00 ", "13:10 ", "13:20 ", "13:30", "13:40 ", "13:45 ", "13:50 ", "13:55 ", "14:00 ", "14:10 ", "14:20 ", "14:25 ", "14:30 ", "14:35 ", "14:40 ", "14:50 ", "14:55 ", "15:00 ", "15:05", "15:10", "15:15 ", "15:20 ", "15:25 ", "15:30 ", "15:35 ", "15:40 ", "15:45 ", "15:50 ", "15:55 ", "16:00 ", "16:05 ", "16:10 ", "16:15 ", "16:20 ", "16:25 ", "16:30 ", "16:35 ", "16:40 ", "16:45 ", "16:50", "16:55 ", "17:00 ", "17:05 ", "17:10 ", "17:15 ", "17:20 ", "17:25 ", "17:30 ", "17:35 ", "17:40 ", "17:45 ", "17:50 ", "17:55 ", "18:00 ", "18:10 ", "18:20 ", "18:30 ", "18:40 ", "18:50 ", "19:00 ", "19:10", "19:20 ", "19:35 ", "19:50 ", "20:05 ", "20:20 ", "20:35 ", "20:52 ", "21:07 ", "21:22 ", "21:37 ", "21:52 ", "22:07 ", "22:22 ", "22:37 ", "22:52 ", "23:07 ", "23:22 ", "23:37"},{"6:05 ", "6:20 ", "6:35 ", "6:50 ", "7:05 ", "7:20 ", "7:35 ", "7:50 ", "8:05 ", "8:20 ", "8:35 ", "8:50 ", "9:05 ", "9:20 ", "9:35 ", "9:50", "10:05 ", "10:20 ", "10:35 ", "10:50 ", "11:05 ", "11:20 ", "11:35 ", "11:50 ", "12:05 ", "12:20 ", "12:35 ", "12:50", "13:05 ", "13:20 ", "13:35 ", "13:50 ", "14:05 ", "14:20 ", "14:35 ", "14:50", "15:05 ", "15:20 ", "15:35 ", "15:50 ", "16:05 ", "16:20 ", "16:35 ", "16:50 ", "17:05 ", "17:20 ", "17:35 ", "17:50 ", "18:05 ", "18:20 ", "18:35 ", "18:50 ", "19:05 ", "19:20 ", "19:35 ", "19:50 ", "20:05", "20:20", "20:35 ", "20:50 ", "21:05 ", "21:20 ", "21:35 ", "21:50 ", "22:05 ", "22:20 ", "22:35 ", "22:50 ", "23:05"}};
	
	String[][] Bus192 = new String[][]{{"6:20 ", "6:40 ", "7:00 ", "7:20 ", "7:40 ", "8:02 ", "8:25 ", "8:45 ", "9:10 ", "9:40 ", "10:10 ", "10:40 ", "11:10 ", "11:40 ", "12:10 ", "12:40", "13:10 ", "13:40 ", "14:10 ", "14:40 ", "15:10 ", "15:40 ", "16:10 ", "16:40 ", "17:10 ", "17:40 ", "18:10"},{}};
	
	String[][] BusN413 = new String[][]{{},{"1:19", "2:19", "3:19", "4:19", "5:19"}};
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_st_lucia, container, false);
        
        st_list = (ListView)rootView.findViewById(R.id.stlist);
        
        adapter = new ListViewAdapter(this.getActivity());
        
        Resources res = getResources();
        
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[0], LastBusWeekDay[0], getRemainTime(Bus29)));
		} catch (NotFoundException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[1], LastBusWeekDay[1], getRemainTime(Bus66)));
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[2], LastBusWeekDay[2], getRemainTime(Bus139)));
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[3], LastBusWeekDay[3], getRemainTime(Bus169)));
		} catch (NotFoundException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[4], LastBusWeekDay[4], getRemainTime(Bus192)));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[5], LastBusWeekDay[5], getRemainTime(Bus209)));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[6], LastBusWeekDay[6], getRemainTime(Bus411)));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[7], LastBusWeekDay[7], getRemainTime(Bus412)));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[8], LastBusWeekDay[8], getRemainTime(BusN413)));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        st_list.setAdapter(adapter);

        return rootView;
    }
	
	/*
	 * Returns remaining time.
	 * */
	@SuppressLint("SimpleDateFormat")
	public String getRemainTime(String[][] fullBusTime) throws ParseException{
		
		String[] busTime = null;
		
		Calendar cal = Calendar.getInstance();
		
		int getCurrentDay = cal.get(Calendar.DAY_OF_WEEK);
		
		if(getCurrentDay == Calendar.SATURDAY || getCurrentDay == Calendar.SUNDAY)
		{
			busTime = fullBusTime[1];
		}
		else 
		{
			busTime = fullBusTime[0];
		}
		
		SimpleDateFormat fm = new SimpleDateFormat("dd-MMM-yyyy");
		Date today = new Date();
		
		for(int i=0; i < holidays.length; i++)
		{
			if(holidays[i].equals(fm.format(today)))
			{
				busTime = fullBusTime[1];
				break;
			}
			
		}
		
		String result = "";
		
		Date now = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		
		String cDate =  dateFormat.format(now);
		Date currentDate = dateFormat.parse(cDate);
		
		long smallest = Long.MAX_VALUE;
		int tempBox;
		
		if(busTime.length == 0)
		{
			result = "No Service";
		}
		
		for(int i=0; i < busTime.length; i++)
		{
			Date bTime = dateFormat.parse(busTime[i]);
			
			long timeDiff = bTime.getTime() - currentDate.getTime();
			
			long ans = timeDiff/60000;
			
			if(ans >= 0)
			{
				List<Integer> timeList = new ArrayList<Integer>();
				int time = (int) (long)ans;
				
				timeList.add(time);
				
				for(int j=0; j<timeList.size(); j++)
				{
					if(timeList.get(j) < smallest)
					{
						smallest = timeList.get(j);
						tempBox = (int) (long)smallest;
						String temp = Integer.toString(tempBox);
						if (tempBox == 0)
						{
							result = "Now";
						}
						else if (tempBox == 1)
						{
							result = temp + " Min";
						}
						else if (tempBox >= 60)
						{
							result = "No Service";
						}
						else
						{
							result = temp + " Mins";
						}
					}
				}
			}
			else
			{
				result ="No Service";
			}
			
		}
		
		return result;
	}
	
}
