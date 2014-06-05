package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.game.YamsMain;
import fr.mbpmx.model.Player;
import fr.mbpmx.other.Constants;

public class SettingsScreen extends YamsScreen {
	private TextButton buttonBack;
	private TextField playerOne, playerTwo;

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
		Label changeNames = new Label("Enter the players' names", skin);
		playerOne = new TextField("Player 1", skin);
		playerTwo = new TextField("Player 2", skin);

		// Creation of the buttons
		buttonBack = new TextButton("Back", skin, "small");
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (playerOne.getText() != "Player 1"
						|| playerTwo.getText() != "Player 2") {
					Constants.p1 = new Player(playerOne.getText());
					Constants.p2 = new Player(playerTwo.getText());
					Constants.playersInstantiated = true;
				}
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new MainMenuScreen());
			}
		});
		buttonBack.pad(15);

		table.add(heading).spaceBottom(75).row();
		table.add(changeNames).spaceBottom(20).row();
		table.add(playerOne).width(200).spaceBottom(20).row();
		table.add(playerTwo).width(200).spaceBottom(50).row();
		table.add(buttonBack).bottom().right();

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
