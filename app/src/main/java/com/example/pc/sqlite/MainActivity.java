package com.example.pc.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc.sqlite.Adapter.CustomNhanVienAdapter;
import com.example.pc.sqlite.DAO.NhanVienDAO;
import com.example.pc.sqlite.DTO.NhanVienDTO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnThemNhanVien;
    EditText edTenNhanVien;
    NhanVienDAO nhanVienDAO;
    ListView listNhanVien;
    List<NhanVienDTO> dsNhanVien;

    CustomNhanVienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThemNhanVien = findViewById(R.id.btnThem);
        edTenNhanVien = findViewById(R.id.edTenNhanVien);

        dsNhanVien = new ArrayList<NhanVienDTO>();

        listNhanVien = findViewById(R.id.listDanhSachNhanVien);

        adapter = new CustomNhanVienAdapter(this,R.layout.layout_customlistnhanvien,dsNhanVien);
        listNhanVien.setAdapter(adapter);
        nhanVienDAO = new NhanVienDAO(this);
        nhanVienDAO.open();

        btnThemNhanVien.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThem:

                String tenNhanVien = edTenNhanVien.getText().toString();

                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                nhanVienDTO.setTennhanvien(tenNhanVien);

                dsNhanVien.add(nhanVienDTO);
                boolean kiemtra = nhanVienDAO.ThemNhanVien(nhanVienDTO);
                if (kiemtra){
                    Toast.makeText(this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }

                break;
        }

    }
}
