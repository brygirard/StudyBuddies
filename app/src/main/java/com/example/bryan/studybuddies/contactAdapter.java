package com.example.bryan.studybuddies;
import java.util.ArrayList;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
public class contactAdapter extends BaseAdapter implements Filterable{
    Context c;
    ArrayList<contact> contacts;
    CustomFilter filter;
    ArrayList<contact> filterList;
    public contactAdapter
            (Context ctx,ArrayList<contact> contacts) {
        // TODO Auto-generated constructor stub
        this.c=ctx;
        this.contacts=contacts;
        this.filterList=contacts;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return contacts.size();
    }
    @Override
    public Object getItem(int pos) {
        // TODO Auto-generated method stub
        return contacts.get(pos);
    }
    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return contacts.indexOf(getItem(pos));
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.custom_row, null);
        }
        TextView nameTxt=(TextView) convertView.findViewById(R.id.contactText);
        ImageView img=(ImageView) convertView.findViewById(R.id.contactIcon);
        //SET DATA TO THEM
        nameTxt.setText(contacts.get(pos).getName());
        nameTxt.setTextColor(Color.BLACK);
        img.setImageResource(contacts.get(pos).getIcon());

        return convertView;
    }
    @Override
    public Filter getFilter() {
        // TODO Auto-generated method stub
        if(filter == null)
        {
            filter=new CustomFilter();
        }
        return filter;
    }

    //INNER CLASS
    class CustomFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // TODO Auto-generated method stub
            FilterResults results=new FilterResults();
            if(constraint != null && constraint.length()>0)
            {
                //CONSTARINT TO UPPER
                constraint=constraint.toString().toUpperCase();
                ArrayList<contact> filters=new ArrayList<contact>();
                //get specific items
                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getName().toUpperCase().contains(constraint))
                    {
                        contact p=new contact(filterList.get(i).getName(), filterList.get(i).getIcon());
                        filters.add(p);
                    }
                }
                results.count=filters.size();
                results.values=filters;
            }else
            {
                results.count=filterList.size();
                results.values=filterList;
            }
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // TODO Auto-generated method stub
            contacts=(ArrayList<contact>) results.values;
            notifyDataSetChanged();
        }
    }
}