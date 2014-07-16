package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.model.Player;
import fr.mbpmx.other.Constants;

public class NewGameScreen extends YamsScreen {
	private TextButton buttonCancel, buttonStart;
	private TextField playerOne, playerTwo;
	private CheckBox displayScores;

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

		Label heading = new Label("New Game", skin);
		heading.setFontScale(2);

		// Creation of the text field
		Label changeNames = new Label("Enter the players' names", skin);
		playerOne = new TextField("Player 1", skin);
		playerTwo = new TextField("Player 2", skin);

		// Creation of the buttons
		buttonCancel = new TextButton("Cancel", skin, "small");
		buttonCancel.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new MainMenuScreen());
			}
		});
		buttonCancel.pad(15);
		
		buttonStart = new TextButton("Start", skin, "small");
		buttonStart.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Constants.p1 = new Player(playerOne.getText());
				Constants.p2 = new Player(playerTwo.getText());
				Constants.DISPLAY_SCORES = displayScores.isChecked();
				
				((Game) Gdx.app.getApplicationListener())
						.setScreen(new GameScreen());
			}
		});
		buttonStart.pad(15);
		
		// Creation of the check box
		displayScores = new CheckBox("Display the score", skin);

		table.add(heading).spaceBottom(75).row();
		table.add(changeNames).spaceBottom(20).row();
		table.add(playerOne).width(200).spaceBottom(20).row();
		table.add(playerTwo).width(200).spaceBottom(50).row();
		table.add(displayScores).row();
		table.add(buttonCancel).bottom().left();
		table.add(buttonStart).bottom().right();

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
