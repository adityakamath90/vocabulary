package bwellthy.vocabulary.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import bwellthy.vocabulary.R;
import bwellthy.vocabulary.manager.VocabTable;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class
 * also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your
    // app
    private static final String DATABASE_NAME = "vocab.db";
    // any time you make changes to your database objects, you may have to increase the database
    // version
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = DatabaseHelper.class.getSimpleName();
    private static DatabaseHelper mDatabaseHelper;
    private Dao<VocabTable, Integer> mWordDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }


    public static DatabaseHelper getInstance(Context ctx) {


        if (mDatabaseHelper == null) {
            mDatabaseHelper = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mDatabaseHelper;
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            Log.d(TAG, "Creating database");
            TableUtils.createTable(connectionSource, VocabTable.class);

        } catch (SQLException e) {
            Log.d(TAG, "Could not create database");
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int
            i, int i2) {

    }

    /**
     * Method to get all pages from database
     *
     * @return list of pages
     */
    public List<VocabTable> getAllWprds() {

        List<VocabTable> pageList = null;

        try {
            pageList = mDatabaseHelper.getWordDao().queryForAll();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return pageList;

    }

    public Dao<VocabTable, Integer> getWordDao() throws SQLException {
        if (mWordDao == null) {
            mWordDao = getDao(VocabTable.class);
        }
        return mWordDao;
    }

    public void insertWords(List<VocabTable> wordsList) {

        //TODO Check for bulk insert
        Dao<VocabTable, Integer> wordDao = null;


        try {
            wordDao = mDatabaseHelper.getWordDao();
            for (VocabTable vocabTable : wordsList) {

                wordDao.createOrUpdate(vocabTable);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
