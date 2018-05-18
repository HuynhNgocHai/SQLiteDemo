package com.example.pc.sqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pc.sqlite.DTO.NhanVienDTO;
import com.example.pc.sqlite.SQLiteHelper.TaoDatabaseNhanVien;

public class NhanVienDAO {
    SQLiteDatabase database;
    TaoDatabaseNhanVien taoDatabaseNhanVien;
    public NhanVienDAO(Context context){
        taoDatabaseNhanVien = new TaoDatabaseNhanVien(context);
    }

    public void open(){
        database = taoDatabaseNhanVien.getWritableDatabase();
    }
    public void close(){
        taoDatabaseNhanVien.close();
    }
    public boolean ThemNhanVien(NhanVienDTO nv){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TaoDatabaseNhanVien.TENNHANVIEN_TBNHANVIEN,nv.getTennhanvien().toString() );

        long id_nhanvien = database.insert(TaoDatabaseNhanVien.TABLE_NHANVIEN,null,contentValues);

        if (id_nhanvien != 0){
            return true;
        }else
            return false;
    }
}
