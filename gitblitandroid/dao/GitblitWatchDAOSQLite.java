package com.example.dark.gitblitandroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.dark.gitblitandroid.model.Commit;
import com.example.dark.gitblitandroid.model.Depot;
import java.util.ArrayList;

public class GitblitWatchDAOSQLite
  extends SQLiteOpenHelper
{
  private static final String ALL_COMMITS = "select DESCCOMMIT, DATECOMMIT, CREACOMMIT, LINKCOMMIT from COMMITS where IDDEPOT=?;";
  private static final String ALL_DEPOTS = "select _id, NOMDEP, DESCDEP, CREADEP, DATELASTCOMMIT, ACCESDEP from DEPOT;";
  private static final String COL_ACCESDEP = "ACCESDEP";
  private static final String COL_CREACOMMIT = "CREACOMMIT";
  private static final String COL_CREADEP = "CREADEP";
  private static final String COL_DATECOMMIT = "DATECOMMIT";
  private static final String COL_DATELASTCOMMIT = "DATELASTCOMMIT";
  private static final String COL_DESCCOMMIT = "DESCCOMMIT";
  private static final String COL_DESCDEP = "DESCDEP";
  private static final String COL_IDCOMMIT = "_id";
  private static final String COL_IDCOMMITDEPOT = "IDDEPOT";
  private static final String COL_IDDEPOT = "_id";
  private static final String COL_LINKCOMMIT = "LINKCOMMIT";
  private static final String COL_NOMDEP = "NOMDEP";
  private static final String SELECT_COMMIT = "select * from COMMITS where LINKCOMMIT=?;";
  private static final String SELECT_DEPOT = "select * from DEPOT where NOMDEP=? and CREADEP=? ;";
  private static final String TABLE_COMMITS = "COMMITS";
  private static final String TABLE_DEPOT = "DEPOT";
  private static GitblitWatchDAOSQLite instance;
  
  private GitblitWatchDAOSQLite(Context paramContext)
  {
    super(paramContext, "watch.db", null, 1);
  }
  
  public static GitblitWatchDAOSQLite getInstance(Context paramContext)
  {
    if (instance == null) {
      instance = new GitblitWatchDAOSQLite(paramContext.getApplicationContext());
    }
    return instance;
  }
  
  public void addCommit(Commit paramCommit, Depot paramDepot)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("IDDEPOT", Integer.valueOf(paramDepot.getId()));
    localContentValues.put("DESCCOMMIT", paramCommit.getDescription());
    localContentValues.put("DATECOMMIT", paramCommit.getDateCommit());
    localContentValues.put("CREACOMMIT", paramCommit.getDevelopper());
    localContentValues.put("LINKCOMMIT", paramCommit.getLink());
    localSQLiteDatabase.insert("COMMITS", null, localContentValues);
  }
  
  public void addDepot(Depot paramDepot)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("NOMDEP", paramDepot.getNom());
    localContentValues.put("DESCDEP", paramDepot.getDescription());
    localContentValues.put("CREADEP", paramDepot.getCreator());
    localContentValues.put("DATELASTCOMMIT", paramDepot.getLastChange());
    localContentValues.put("ACCESDEP", paramDepot.getAccess());
    localSQLiteDatabase.insert("DEPOT", null, localContentValues);
  }
  
  public boolean commitCompare(Commit paramCommit, Depot paramDepot)
  {
    boolean bool = false;
    Cursor localCursor = getReadableDatabase().rawQuery("select * from COMMITS where LINKCOMMIT=?;", new String[] { paramCommit.getLink() });
    if ((!localCursor.moveToFirst()) || (localCursor.getCount() == 0))
    {
      addCommit(paramCommit, paramDepot);
      bool = true;
    }
    localCursor.close();
    return bool;
  }
  
  public boolean depotCompare(Depot paramDepot)
  {
    boolean bool = false;
    Cursor localCursor = getReadableDatabase().rawQuery("select * from DEPOT where NOMDEP=? and CREADEP=? ;", new String[] { paramDepot.getNom(), paramDepot.getCreator() });
    if ((!localCursor.moveToFirst()) || (localCursor.getCount() == 0))
    {
      addDepot(paramDepot);
      bool = true;
    }
    localCursor.close();
    return bool;
  }
  
  public ArrayList<Commit> getAllCommits(Depot paramDepot)
  {
    ArrayList localArrayList = new ArrayList();
    paramDepot = getReadableDatabase().rawQuery("select DESCCOMMIT, DATECOMMIT, CREACOMMIT, LINKCOMMIT from COMMITS where IDDEPOT=?;", new String[] { Integer.toString(paramDepot.getId()) });
    paramDepot.moveToFirst();
    while (!paramDepot.isAfterLast())
    {
      localArrayList.add(new Commit(paramDepot.getString(0), paramDepot.getString(1), paramDepot.getString(2), paramDepot.getString(3)));
      paramDepot.moveToNext();
    }
    paramDepot.close();
    return localArrayList;
  }
  
  public ArrayList<Depot> getAllDepots()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = getWritableDatabase().rawQuery("select _id, NOMDEP, DESCDEP, CREADEP, DATELASTCOMMIT, ACCESDEP from DEPOT;", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      localArrayList.add(new Depot(localCursor.getInt(0), localCursor.getString(1), localCursor.getString(2), localCursor.getString(3), localCursor.getString(4), localCursor.getString(5)));
      localCursor.moveToNext();
    }
    localCursor.close();
    return localArrayList;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table DEPOT (_id INTEGER PRIMARY KEY AUTOINCREMENT,NOMDEP varchar(30) not null,DESCDEP varchar(256) null,ACCESDEP varchar(256) not null,CREADEP varchar(256) not null,DATELASTCOMMIT varchar(256) not null);");
    paramSQLiteDatabase.execSQL("create table COMMITS (_id INTEGER PRIMARY KEY AUTOINCREMENT,IDDEPOT integer not null,DESCCOMMIT varchar(256) null,DATECOMMIT varchar(256) not null,CREACOMMIT varchar(256),LINKCOMMIT VARCHAR, constraint FK_COMMIT_DEPOT foreign key (IDDEPOT) references DEPOT (_id));");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\dao\GitblitWatchDAOSQLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */