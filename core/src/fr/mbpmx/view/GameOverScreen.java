package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.game.YamsMain;
import fr.mbpmx.other.Constants;

public class GameOverScreen extends YamsScreen {
	private TextButton buttonMenu, buttonExit;
	private String playerOneScore, playerTwoScore, winner;

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

		Label heading = new Label(YamsMain.TITLE, skin);
		heading.setFontScale(2);

		// Creation of the text field
		playerOneScore = Constants.p1.getName() + ": "
				+ Constants.p1.getTotalScore() + " points!";
		playerTwoScore = Constants.p2.getName() + ": "
				+ Constants.p2.getTotalScore() + " points!";

		if (Constants.p1.getTotalScore() < Constants.p2.getTotalScore()) {
			winner = "And the winner is\n" + Constants.p2.getName() + "!";
		} else if (Constants.p1.getTotalScore() > Constants.p2.getTotalScore()) {
			winner = "And the winner is\n" + Constants.p1.getName() + "!";
		} else {
			winner = "Wahou! You have exactly\nthe same score!";
		}

		// Creation of the buttons
		buttonMenu = new TextButton("Menu", skin, "small");
		buttonMenu.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new MainMenuScreen());
			}
		});

		buttonExit = new TextButton("Exit", skin, "small");
		buttonExit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});

		table.add(heading).spaceBottom(75).row();
		table.add(playerOneScore).center().width(200).spaceBottom(20).row();
		table.add(playerTwoScore).center().width(200).spaceBottom(50).row();
		table.add(winner).spaceBottom(50).row();
		table.add(buttonMenu).left();
		table.add(buttonExit).right();

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
