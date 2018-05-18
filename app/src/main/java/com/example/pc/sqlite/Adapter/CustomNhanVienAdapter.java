package com.example.pc.sqlite.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pc.sqlite.DTO.NhanVienDTO;
import com.example.pc.sqlite.R;

import java.util.List;

public class CustomNhanVienAdapter extends ArrayAdapter<NhanVienDTO> {

    Context context;
    int resource;
    List<NhanVienDTO> object;


    public CustomNhanVienAdapter(@NonNull Context context, int resource, @NonNull List<NhanVienDTO> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.object = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource,parent,false);

        TextView textView = view.findViewById(R.id.txtNhanVien);
        textView.setText(object.get(position).getTennhanvien().toString());

        return view;
    }
}
