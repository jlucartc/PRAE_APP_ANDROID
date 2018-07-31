package com.example.luca.prae_app.view.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;

import com.example.luca.prae_app.R;

public abstract class MyListAdapter implements ListAdapter {

    private Context context;
    private Object[] data;

    public MyListAdapter(Context context, Object[] data){

        this.context = context;
        this.data = data;

    }

    @Override
    public boolean areAllItemsEnabled() {

        if(this.getCount() == this.data.length){
            return true;
        }else{

            return false;

        }

    }

    @Override
    public boolean isEnabled(int i) {
        if(this.data.length >= i+1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {

        return this.data.length;

    }

    @Override
    public Object getItem(int i) {
        if(this.isEnabled(i)){
            return this.data[i];
        }else{
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        if(this.isEnabled(i)){
            return i;
        }else{
            return -1;
        }
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;

        if(v == null){
            v = View.inflate(this.context, R.layout.activity_main,viewGroup);
        }

        return v;

    }

    @Override
    public int getItemViewType(int i) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        if(this.data == null || this.data.length <= 0){

            return true;

        }else{

            return false;

        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
}
