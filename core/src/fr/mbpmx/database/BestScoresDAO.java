package fr.mbpmx.database;

import com.badlogic.gdx.sql.Database;
import com.badlogic.gdx.sql.DatabaseCursor;
import com.badlogic.gdx.sql.DatabaseFactory;
import com.badlogic.gdx.sql.SQLiteGdxException;

import fr.mbpmx.model.Player;

/**
 * This class contains the creation and update of the best scores table.
 * 
 * @author Chloe Brouzes & Maxime Lasserre
 * 
 */
public class BestScoresDAO {
	private Database dbHandler;

	public static final String DATABASE_NAME = "yams";
	public static final int DATABASE_VERSION = 1;

	public static final String TABLE_NAME = "BestScores";
	public static final String KEY = "id";
	public static final String NAME = "name";
	public static final String SCORE = "score";

	private static final String DATABASE_CREATE = "create table if not exists "
			+ TABLE_NAME + "(" + KEY + " integer primary key autoincrement, "
			+ NAME + " text not null, " + SCORE + " integer);";

	private static final String DATABASE_DELETE = "drop table " + TABLE_NAME;

	public BestScoresDAO() {
		dbHandler = DatabaseFactory.getNewDatabase(DATABASE_NAME,
				DATABASE_VERSION, DATABASE_CREATE, null);

		dbHandler.setupDatabase();
		try {
			dbHandler.openOrCreateDatabase();
			dbHandler.execSQL(DATABASE_CREATE);
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
	}

	public void insert(Player p) {
		int numberScores = 0;
		DatabaseCursor cursor = null;

		try {
			cursor = dbHandler.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME);
		} catch (SQLiteGdxException e1) {
			e1.printStackTrace();
		}

		while (cursor.next()) {
			numberScores++;
		}

		if (numberScores < 10) {
			try {
				dbHandler.execSQL("INSERT INTO " + TABLE_NAME + " ('" + NAME
						+ "', '" + SCORE + "') VALUES ('" + p.getName()
						+ "', '" + p.getTotalScore() + "')");
			} catch (SQLiteGdxException e) {
				e.printStackTrace();
			}
		} else if (numberScores >= 10) {
			// id and score of the 10th
			int id = 0, score = 0;
			DatabaseCursor cursorS = null;

			try {
				cursorS = dbHandler.rawQuery("SELECT * FROM " + TABLE_NAME
						+ " ORDER BY " + SCORE + " ASC");
			} catch (SQLiteGdxException e1) {
				e1.printStackTrace();
			}

			cursorS.next();
			id = cursorS.getInt(0);
			score = cursorS.getInt(2);

			// If the new score is highest than the smallest one, we replace it
			if (p.getTotalScore() >= score) {
				update(id, p);
			}
		}
	}

	public void update(int id, Player p) {
		try {
			dbHandler.execSQL("UPDATE " + TABLE_NAME + " " + NAME + "="
					+ p.getName() + ", " + SCORE + "=" + p.getTotalScore()
					+ "')");
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try {
			dbHandler.execSQL(DATABASE_DELETE);
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
	}
}