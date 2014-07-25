package fr.mbpmx.view;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.database.ScoresDAO;
import fr.mbpmx.game.YamsMain;
import fr.mbpmx.model.Player;
import fr.mbpmx.other.Constants;

public class MainMenuScreen extends YamsScreen {
	private TextButton buttonNewGame, buttonSettings, buttonInstructions,
			buttonHighScores, buttonExit, buttonResume;

	private ScoresDAO scoresDAO;

	@Override
	public void render(float delta) {
		super.render(delta);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		super.show();

		scoresDAO = new ScoresDAO();

		// Creating heading
		Label heading = new Label(YamsMain.TITLE, skin, "big");
		heading.setFontScale(2);

		buttonNewGame = new TextButton("New Game", skin);
		buttonNewGame.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				scoresDAO.delete();

				((Game) Gdx.app.getApplicationListener())
						.setScreen(new NewGameScreen());
			}
		});
		buttonNewGame.pad(15);

		buttonSettings = new TextButton("Settings", skin);
		buttonSettings.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new SettingsScreen());
			}
		});
		buttonSettings.pad(10);

		buttonInstructions = new TextButton("Instructions", skin);
		buttonInstructions.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new InstructionsScreen());
			}
		});
		buttonInstructions.pad(10);

		buttonHighScores = new TextButton("High scores", skin);
		buttonHighScores.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new HighScoresScreen());
			}
		});
		buttonInstructions.pad(10);

		buttonExit = new TextButton("Exit", skin);
		buttonExit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		buttonExit.pad(10);

		table.add(heading).spaceBottom(50).row();
		table.add(buttonNewGame).spaceBottom(15).row();

		if (scoresDAO.exist()) {
			buttonResume = new TextButton("Resume", skin);
			buttonResume.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					// Add the players' names and their scores to continue the
					// game
					List<String> playersNames = new ArrayList<String>();
					playersNames = scoresDAO.getPlayers();

					Constants.p1 = new Player(playersNames.get(0));
					Constants.p2 = new Player(playersNames.get(1));

					scoresDAO.setScores(Constants.p1);
					scoresDAO.setScores(Constants.p2);

					scoresDAO.delete();
					Gdx.app.log("DatabaseTest", "table deleted");

					((Game) Gdx.app.getApplicationListener())
							.setScreen(new GameScreen());
				}
			});
			buttonResume.pad(10);
			table.add(buttonResume).spaceBottom(15).row();
		}

		table.add(buttonSettings).spaceBottom(15).row();
		table.add(buttonInstructions).spaceBottom(15).row();
		table.add(buttonExit);

		stage.addActor(table);
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
