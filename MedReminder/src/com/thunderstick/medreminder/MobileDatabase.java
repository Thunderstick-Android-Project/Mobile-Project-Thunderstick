package com.thunderstick.medreminder;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MobileDatabase {
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_MEDNAME = "medname";
	public static final String KEY_QTY = "qty";
	public static final String KEY_ROL = "rol";
	public static final String KEY_ADDDATE = "adddate";
	public static final String KEY_MEAL = "meal";
	public static final String KEY_SESSION = "session";
	public static final String KEY_GAP = "gap";
	public static final String KEY_AMOUNT = "amount";
	
	private static final String DATABASE_NAME = "MedReminder";
	private static final String DATABASE_TABLE = "item";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_MEDNAME + " TEXT NOT NULL, " +
					KEY_QTY + " INTEGER NOT NULL," +
					KEY_ROL + "INTEGER NOT NULL," +
					KEY_ADDDATE + "TEXT NOT NULL," +
					KEY_MEAL + "TEXT);"
			);	
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
	}
	
	public MobileDatabase(Context c){
		ourContext = c;
	}
	
	public MobileDatabase open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void close(){
		 ourHelper.close();
	 }
	
	public long insertNewItem(String medname, Integer qty, Integer rol, String adddate, String meal) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_MEDNAME, medname);
		cv.put(KEY_QTY, qty);
		cv.put(KEY_ROL, rol);
		cv.put(KEY_ADDDATE, adddate);
		cv.put(KEY_MEAL, meal);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}
	
	public String getInfo() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_MEDNAME, KEY_QTY, KEY_ROL, KEY_ADDDATE, KEY_MEAL};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		
	
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_MEDNAME);
		int iQty = c.getColumnIndex(KEY_QTY);
		int iRol = c.getColumnIndex(KEY_ROL);
		int iDate = c.getColumnIndex(KEY_ADDDATE);
		int iMeal = c.getColumnIndex(KEY_MEAL);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + c.getString(iRow) + " 			" + c.getString(iName) + "			 " + c.getString(iQty) + "			" + c.getString(iRol) + "			" + c.getString(iDate) + "			" + c.getString(iMeal) + "\n";
		}
		
		return result;
	}

}
