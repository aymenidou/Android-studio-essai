package com.aymen.essai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Contact> {

    private final Context context;
    private final ArrayList<Contact> nom;

    CustomAdapter(Context context, ArrayList<Contact> nom) {
        super(context, R.layout.complex, nom);
        this.context = context;
        this.nom = nom;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.complex, null, true);
        handler hnd = new handler();

        final View rowView;
        if (convertView == null) {
            rowView = convertView;
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.complex, parent, false);
            hnd.c_text = rowView.findViewById(R.id.text_view_1);
            hnd.c_image = rowView.findViewById(R.id.image_view);
            convertView.setTag(hnd);
        }else{
            hnd = (handler) convertView.getTag();
            rowView = convertView;
        }

//        hnd.c_text.setText();


        return convertView;
//        TextView titre = rowView.findViewById(R.id.text_view_1);
//        ImageView image = rowView.findViewById(R.id.image_view);

//        titre.setText(nom.get(position).getId() + " " + nom.get(position).getNom() + " " + nom.get(position).getPrenom());
//        image.setImageResource(R.drawable.user);

        //DataHander handler;
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            rowView = inflater.inflate(R.layout.complex, parent, false);
            //handler = new DataHander();
            //titre =  rowView.findViewById(R.id.list_view);
            //image =  rowView.findViewById(R.id.list_view);
//            rowView.setTag(handler);
//        } else {
//            handler = (DataHander) rowView.getTag();
//        }
//        MovieDataProvider dataProvider;
//        dataProvider=(MovieDataProvider)this.getItem(position);
//        handler.Poster.setImageResource(dataProvider.getMovier_resorce());
//        handler.titles.setText(dataProvider.getMovier_titles());

//        }
//        return rowView;
    }

    public void addi(Contact object) {
        //super.add(object);
        nom.add(object);
    }

//    static class DataHander {
//        ImageView Poster;
//        TextView titles;
//
//    }

    public class handler {
        TextView c_text;
        ImageView c_image;
    }

//    public int getcount() {
//        return this.list.size();
//    }

//    public Object getItem(int position) {
//        return this.list.get(position);
//    }

}
