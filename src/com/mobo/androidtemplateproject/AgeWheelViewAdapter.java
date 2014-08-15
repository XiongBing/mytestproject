package com.mobo.androidtemplateproject;

import java.util.ArrayList;

import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**

 * @author dongxiaoqing
 *
 */
public class AgeWheelViewAdapter extends AbstractWheelTextAdapter {

	private ArrayList<String> ageItems;
	public ArrayList<String> getAgeItems() {
		return ageItems;
	}

	public void setAgeItems(ArrayList<String> ageItems) {
		this.ageItems = ageItems;
	}

	public AgeWheelViewAdapter(Context context,ArrayList<String> ageItems) {
		super(context,R.layout.age_wheel_item,NO_RESOURCE);
		this.ageItems=ageItems;
	}

	@Override
	
	public int getItemsCount() {
		return ageItems.size();
	}

	@Override
	protected CharSequence getItemText(int index) {
		return ageItems.get(index);
	}

	@Override
	public View getItem(int index, View convertView, ViewGroup parent) {
		View view=super.getItem(index, convertView, parent);
		TextView txt = (TextView) view.findViewById(R.id.text_age_wheel_item);
        txt.setText(ageItems.get(index));
        return view;
	}
	
}
