package com.rayrayj92.uqbus.menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.rayrayj92.uqbus.R;
import com.rayrayj92.uqbus.adapter.BusItem;
import com.rayrayj92.uqbus.adapter.ListViewAdapterInterCamp;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class InterCamp extends Fragment {
	
	ListView ic_list;
	ListViewAdapterInterCamp adapter;
	
	int busImage = R.drawable.ic_bus;
	
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
			"East Bound(To St Lucia)",
			"West Bound(To Gatton)",
	};
	
	String[] LastBusWeekDay = new String[]{
			"Last Bus: 05:05 PM",
			"Last Bus: 05:00 PM",
	};
	
	String[][] BusEast = new String[][]{
			{"6:00","8:15","14:30","17:05"},
			{}};
	
	String[][] BusWest = new String[][]{
			{"6:30","7:45","14:30","17:00"},
			{}};
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_inter_camp, container, false);
        
        ic_list = (ListView)rootView.findViewById(R.id.iclist);
        
        adapter = new ListViewAdapterInterCamp(this.getActivity());
        
        Resources res = getResources();
        
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[0], LastBusWeekDay[0], getRemainTime(BusEast)));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			adapter.addItem(new BusItem(res.getDrawable(R.drawable.ic_bus), bus[1], LastBusWeekDay[1], getRemainTime(BusWest)));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        ic_list.setAdapter(adapter);
        
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
							result = "Over 1 hour";
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
