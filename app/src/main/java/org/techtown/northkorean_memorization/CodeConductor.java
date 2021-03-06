package org.techtown.northkorean_memorization;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class CodeConductor extends AppCompatActivity {
    private final String tableName = "Words";
    private final String databaseName = "Words.db";

    public Boolean updateDBdd(int[] bookMark, int[] memorized) {

        Test_DatabaseAdapter.DatabaseHelper helper = new Test_DatabaseAdapter.DatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        if (db != null) {

            for (int i = 0; i < 1; ++i) {
                updateSQLee(db, tableName, "BookMark", bookMark[i], 1);
                Log.d("Test_Test_updateDB", bookMark[i] + "th BookMark change into 1");
            }
            for (int i = 0; i < 1; ++i) {
                updateSQLee(db, tableName, "Memorized", memorized[i], 1);
                Log.d("Test_Test_updateDB", memorized[i] + "th Memorized change into 1");
            }
            db.close();
        }
        else
            return false;

        return true;
    }

    /**
     * SQL문을 함수형태로 좀더 쉽게 만든건데 쉽게 느껴지려나..? 나중에도 쓸것같아서 만들어 둠
     * db의 inputTableName에서 id번째 행의 what 속성을 Value로 바꿈
     */
    private void updateSQLee(SQLiteDatabase db, String inputTableName, String what, int id, int value) {
        db.execSQL("UPDATE " + tableName + " SET " + what + " = 1 where _id = " + id);
    }
    /**
     * 암기가 체크된 단어의 개수 리턴 하는 함수
     */
    private int getMemorizedCount() {
        Test_DatabaseAdapter.DatabaseHelper helper = new Test_DatabaseAdapter.DatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from Words where Memorized=1", null);
        int loadedSize = cursor.getCount();

        db.close();

        return loadedSize;
    }

}
