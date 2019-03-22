package kr.or.bit.ex31_db_sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DbHelper mDbHelper;
    SQLiteDatabase mDb;
    EditText mEditName;
    EditText mEditKorean;
    EditText mEditMath;
    ListView mListMember;
    Cursor mCursor;
    ArrayList<String> mArMember = new ArrayList<String>();
    ArrayAdapter<String> mAdapter;
    int mSelIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditName = (EditText)findViewById(R.id.editName);
        mEditKorean = (EditText)findViewById(R.id.editKorean);
        mEditMath = (EditText)findViewById(R.id.editMath);

        mDbHelper = new DbHelper(this);
        mDb = mDbHelper.getWritableDatabase(); //DB 쓰기작업 가능 ....

        initListView();
        readAllRecords();
    }

    //inner class
    class DbHelper extends SQLiteOpenHelper {
        //DB생성 ..
        public DbHelper(Context context) {
            super(context, "ReportCard", null, 1);
        }

        //Table 생성
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table Student (" +
                    "_id integer PRIMARY KEY autoincrement, " +
                    "name TEXT, korean integer, math integer);");
        }

        //버전
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists Student");
            onCreate(db);
        }
    }

    public void onBtnAdd() {
        String strName = mEditName.getText().toString();
        String strKorean = mEditKorean.getText().toString();
        String strMath = mEditMath.getText().toString();

        String strQuery = "insert into Student(name, korean, math) values (' "
                + strName + " ', " + strKorean + ", " + strMath + ");";
        mDb.execSQL(strQuery);

        readAllRecords();
        mCursor.moveToLast();
        mSelIndex = mCursor.getInt(0);
    }

    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.buttonAdd :
                onBtnAdd();
                break;
            case R.id.buttonDel :
                onBtnDel();
                break;
            case R.id.buttonUpdate :
                onBtnUpdate();
                break;
        }
    }

    public void readAllRecords() {
        mArMember.clear();

        String strQuery = "select _id, name, korean, math from Student";
        mCursor = mDb.rawQuery(strQuery, null);

        for(int i=0; i < mCursor.getCount(); i++) {
            mCursor.moveToNext();
            int nId = mCursor.getInt(0);
            String strName = mCursor.getString(1);
            int nKorean = mCursor.getInt(2);
            int nMath = mCursor.getInt(3);
            String strRecord = nId + ": " + strName + " / " + nKorean + " / " + nMath;
            Log.d("tag", "Rec-" + strRecord);
            mArMember.add(strRecord);
        }
        mAdapter.notifyDataSetChanged();
    }

    public void initListView() {
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mArMember);
        mListMember = (ListView)findViewById(R.id.listMember);
        mListMember.setAdapter(mAdapter); //binding ...
        mListMember.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mListMember.setDivider(new ColorDrawable(Color.GRAY));
        mListMember.setDividerHeight(2);
        mListMember.setOnItemClickListener(mItemListener);
    }

    public void viewRecord(int nIndex) {
        mCursor.moveToPosition(nIndex);
        int nId = mCursor.getInt(0);
        String strName = mCursor.getString(1);
        int nKorean = mCursor.getInt(2);
        int nMath = mCursor.getInt(3);

        mEditName.setText(strName);
        mEditKorean.setText(Integer.toString(nKorean));
        mEditMath.setText(Integer.toString(nMath));
        mSelIndex = nId;
    }

    AdapterView.OnItemClickListener mItemListener = new
            AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView parent, View view, int position, long id) {
                    viewRecord(position);
                }
            };

    public void onBtnDel() {
        mDb.execSQL("delete from Student where _id = " + mSelIndex);
        readAllRecords();
    }

    public void onBtnUpdate() {
        String strName = mEditName.getText().toString();
        String strKorean = mEditKorean.getText().toString();
        String strMath = mEditMath.getText().toString();

        String strQuery = "update Student set name = ' " + strName +
                " ', korean = " + strKorean + ", math = " + strMath +
                " where _id = " + mSelIndex;
        mDb.execSQL(strQuery);
        readAllRecords();
    }

}

