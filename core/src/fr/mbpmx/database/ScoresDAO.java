package fr.mbpmx.database;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.sql.Database;
import com.badlogic.gdx.sql.DatabaseCursor;
import com.badlogic.gdx.sql.DatabaseFactory;
import com.badlogic.gdx.sql.SQLiteGdxException;

import fr.mbpmx.model.Combination;
import fr.mbpmx.model.Player;
import fr.mbpmx.model.ScoreTable;

public class ScoresDAO {
	private Database dbHandler;

	public static final String DATABASE_NAME = "yams";
	public static final int DATABASE_VERSION = 1;

	public static final String TABLE_NAME = "Scores";
	public static final String KEY = "id";
	public static final String PLAYER = "player";
	public static final String COMBINATION_ONE = "one";
	public static final String COMBINATION_TWO = "two";
	public static final String COMBINATION_THREE = "three";
	public static final String COMBINATION_FOUR = "four";
	public static final String COMBINATION_FIVE = "five";
	public static final String COMBINATION_SIX = "six";

	public static final String COMBINATION_TWOPAIRS = "two_pairs";
	public static final String COMBINATION_THREEOFAKIND = "three_of_a_kind";
	public static final String COMBINATION_FULLHOUSE = "full_house";
	public static final String COMBINATION_FOUROFAKIND = "four_of_a_kind";
	public static final String COMBINATION_STRAIGHT = "straight";
	public static final String COMBINATION_YAMS = "yams";
	public static final String COMBINATION_PLUS = "plus";
	public static final String COMBINATION_MINUS = "minus";
	public static final String COMBINATION_CHANCE = "chance";

	private static final String DATABASE_CREATE = "create table if not exists "
			+ TABLE_NAME + "(" + KEY + " integer primary key autoincrement, "
			+ PLAYER + " text not null, " + COMBINATION_ONE + " integer, "
			+ COMBINATION_TWO + " integer, " + COMBINATION_THREE + " integer, "
			+ COMBINATION_FOUR + " integer, " + COMBINATION_FIVE + " integer, "
			+ COMBINATION_SIX + " integer, " + COMBINATION_TWOPAIRS
			+ " integer, " + COMBINATION_THREEOFAKIND + " integer, "
			+ COMBINATION_FULLHOUSE + " integer, " + COMBINATION_FOUROFAKIND
			+ " integer, " + COMBINATION_STRAIGHT + " integer, "
			+ COMBINATION_YAMS + " integer, " + COMBINATION_PLUS + " integer, "
			+ COMBINATION_MINUS + " integer, " + COMBINATION_CHANCE
			+ " integer);";

	private static final String DATABASE_DELETE = "drop table " + TABLE_NAME;

	public ScoresDAO() {
		Gdx.app.log("DatabaseTest", "creation started");
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
		ScoreTable s = p.getScores();
		try {
			dbHandler.execSQL("INSERT INTO scores ('" + PLAYER + "', '"
					+ COMBINATION_ONE + "', '" + COMBINATION_TWO + "', '"
					+ COMBINATION_THREE + "', '" + COMBINATION_FOUR + "', '"
					+ COMBINATION_FIVE + "', '" + COMBINATION_SIX + "', '"
					+ COMBINATION_TWOPAIRS + "', '" + COMBINATION_THREEOFAKIND
					+ "', '" + COMBINATION_FULLHOUSE + "', '"
					+ COMBINATION_FOUROFAKIND + "', '" + COMBINATION_STRAIGHT
					+ "', '" + COMBINATION_YAMS + "', '" + COMBINATION_PLUS
					+ "', '" + COMBINATION_MINUS + "', '" + COMBINATION_CHANCE
					+ "') VALUES ('" + p.getName() + "', '"
					+ s.get(Combination.ONE) + "', '" + s.get(Combination.TWO)
					+ "', '" + s.get(Combination.THREE) + "', '"
					+ s.get(Combination.FOUR) + "', '"
					+ s.get(Combination.FIVE) + "', '" + s.get(Combination.SIX)
					+ "', '" + s.get(Combination.TWOPAIRS) + "', '"
					+ s.get(Combination.THREEOFAKIND) + "', '"
					+ s.get(Combination.FULLHOUSE) + "', '"
					+ s.get(Combination.FOUROFAKIND) + "', '"
					+ s.get(Combination.STRAIGHT) + "', '"
					+ s.get(Combination.YAMS) + "', '"
					+ s.get(Combination.PLUS) + "', '"
					+ s.get(Combination.MINUS) + "', '"
					+ s.get(Combination.CHANCE) + "')");
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		// dbHandler.execSQL();
	}

	public void update(int id) {

	}

	public void delete() {
		try {
			dbHandler.execSQL(DATABASE_DELETE);
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
	}

	public boolean exist() {
		DatabaseCursor cursor = null;

		try {
			cursor = dbHandler.rawQuery("SELECT * FROM " + TABLE_NAME);
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
		return cursor.next();
	}

	public List<String> getPlayers() {
		DatabaseCursor cursor = null;
		ArrayList<String> playerList = new ArrayList<String>();

		try {
			cursor = dbHandler.rawQuery("SELECT * " + " FROM " + TABLE_NAME);
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
		while (cursor.next()) {
			playerList.add(String.valueOf(cursor.getString(1)));
		}
		return playerList;
	}

	public void setScores(Player p) {
		DatabaseCursor cursor = null;
		try {
			cursor = dbHandler.rawQuery("SELECT * " + " FROM " + TABLE_NAME
					+ " WHERE " + PLAYER + " = " + p.getName());
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}

		p.setScore(Combination.ONE, cursor.getInt(2));
		p.setScore(Combination.TWO, cursor.getInt(3));
		p.setScore(Combination.THREE, cursor.getInt(4));
		p.setScore(Combination.FOUR, cursor.getInt(5));
		p.setScore(Combination.FIVE, cursor.getInt(6));
		p.setScore(Combination.SIX, cursor.getInt(7));
		p.setScore(Combination.TWOPAIRS, cursor.getInt(8));
		p.setScore(Combination.THREEOFAKIND, cursor.getInt(9));
		p.setScore(Combination.FULLHOUSE, cursor.getInt(10));
		p.setScore(Combination.FOUROFAKIND, cursor.getInt(11));
		p.setScore(Combination.STRAIGHT, cursor.getInt(12));
		p.setScore(Combination.YAMS, cursor.getInt(13));
		p.setScore(Combination.PLUS, cursor.getInt(14));
		p.setScore(Combination.MINUS, cursor.getInt(15));
		p.setScore(Combination.CHANCE, cursor.getInt(16));
	}
}
