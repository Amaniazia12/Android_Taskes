package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.jar.Attributes;
public class EmployeeDBHealper extends SQLiteOpenHelper {
    private static String name = "EmployeeDB";
    SQLiteDatabase empDB;
    public EmployeeDBHealper(Context ctx) {
        super(ctx, name, null, 1); }
        @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Dept (Dept_ID integer primary key autoincrement , Name text not null )");

        db.execSQL("create table emp (Emp_ID integer primary key autoincrement ,name text not null , title text not null , phone text not null ," +
                "email text not null , DepId integer , FOREIGN KEY (DepId) REFERENCES Department(Dept_ID))"); }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVerstion, int newVersion) {

        db.execSQL("drop table if exists emp ");
        db.execSQL("drop table if exists Dept ");

        onCreate(db); }



    public Cursor getEmployees(String name ) {

        addEmployee("Amany" , "Developer","555555","Amaniazia@gmail.com",5);
        addEmployee("Amany" , "Developer","555555","Amaniazia@gmail.com",5);
        addEmployee("ALi" , "Developer","555555","Ali@gmail.com",2);
        addEmployee("Ahmed" , "Developer","555555","ahmed@gmail.com",2);
        addEmployee("mona" , "Developer","555555","mona@gmail.com",1);
        addEmployee("heba" , "Developer","555555","heba@gmail.com",3);
        addEmployee("hoda" , "Developer","555555","hoda@gmail.com",1);
        addEmployee("noha" , "Developer","555555","noha@gmail.com",5);
        addEmployee("noha" , "Developer2","555555","noha@gmail.com",5);


        adddep("HR",5);
        adddep("PR",2);
        adddep("FR",3);

        empDB=getReadableDatabase();
        Cursor cursor = empDB.rawQuery("SELECT * FROM emp WHERE name like ? ",new String[]{name});
        cursor.moveToFirst();
        empDB.close();
        return cursor; }

    public void adddep(String name, int DepID ) {
        ContentValues row = new ContentValues();
        row.put("Name",name );
        row.put("Dept_ID",DepID );
        empDB=getWritableDatabase();
        empDB.insert("Dept" , null, row);
        empDB.close(); }


    public void addEmployee( String name,String title ,String phone , String Email , int DepID ) {
        ContentValues row = new ContentValues();
        row.put("name",name );
        row.put("title",title);
        row.put("phone",phone);
        row.put("email",Email );
        row.put("DepId",DepID );
        empDB=getWritableDatabase();
        empDB.insert("emp" , null, row);
        empDB.close(); }


    public Cursor getEmpByID(int id ) {
        empDB=getReadableDatabase();
        Cursor cursor = empDB.rawQuery("SELECT * FROM emp WHERE Emp_ID = '" + id + "'",null);
        cursor.moveToFirst();
        empDB.close();
        return cursor;
    }
    public Cursor getDepartment(int id ) {
        empDB=getReadableDatabase();
        Cursor cursor = empDB.rawQuery("SELECT * FROM  Dept WHERE Dept_ID = '" + id + "'",null);
        cursor.moveToFirst();
        empDB.close();
        return cursor;
    }
    public void delete(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //deleting rows
        sqLiteDatabase.delete("emp", null, null);
        sqLiteDatabase.close();
    }


}
