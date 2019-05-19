package com.rayrayj92.uqbus.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListViewAdapterInterCamp extends BaseAdapter {
	
	private Context mContext;
	
	private List<BusItem> mItems = new ArrayList<BusItem>();
	
	public ListViewAdapterInterCamp(Context context) {
		mContext = context;
	}
	
	public void addItem(BusItem it) {
		mItems.add(it);
	}
	
	public void setListItems(List<BusItem> lit) {
		mItems = lit;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mItems.get(arg0);
	}
	
	public boolean areAllItemsSelectable() {
		return false;
	}

	public boolean isSelectable(int position) {
		try {
			return mItems.get(position).isSelectable();
		} catch (IndexOutOfBoundsException ex) {
			return false;
		}
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		BusItemViewInterCamp itemView;
		if (convertView == null) {
			itemView = new BusItemViewInterCamp(mContext, mItems.get(position));
		} else {
			itemView = (BusItemViewInterCamp) convertView;
			
			itemView.setIcon(mItems.get(position).getIcon());
			itemView.setText(0, mItems.get(position).getData(0));
			itemView.setText(1, mItems.get(position).getData(1));
			itemView.setText(2, mItems.get(position).getData(2));
		}

		return itemView;
	}
	
}
