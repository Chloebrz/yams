package fr.mbpmx.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.controller.Controller;
import fr.mbpmx.model.Combination;
import fr.mbpmx.other.Constants;

public class GameScreen extends YamsScreen {
	private Controller controller;

	private Skin skinDices;

	private Table scoreTable;
	private List<TextButton> dicesButtons;
	private TextButton throwDices, exit;

	private Table dicesTable;

	private Label heading, scores;

	private LinkedHashMap<Combination, TextButton> textButtons;

	@Override
	public void render(float delta) {
		super.render(delta);

		Table.drawDebug(stage);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		super.show();

		controller = new Controller();
		textButtons = new LinkedHashMap<Combination, TextButton>();

		skinDices = new Skin(Gdx.files.internal("ui/dices.json"),
				new TextureAtlas("ui/dices.pack"));

		// Create heading (displaying the current player's name)
		heading = new Label(controller.getCurrentPlayer().getName(), skin,
				"small");
		heading.setFontScale(2);

		scores = new Label("", skin);

		dicesTable = new Table();
		createDices();

		throwDices = new TextButton("Throw the dices", skin);
		throwDices.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				controller.throwDices();
				for (int i = 0; i < 5; i++) {
					dicesButtons.get(i).setStyle(
							skinDices.get("dice"
									+ controller.getDices().get(i).getValue()
											.getValue()
									+ controller.getDices().get(i).isToThrow(),
									TextButtonStyle.class));
				}
			}
		});

		exit = new TextButton("Exit", skin, "small");
		exit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Dialog dialog = new Dialog("Comfirm", skin, "small") {
					@Override
					protected void result(Object object) {
						if (object.equals(true)) {
							// TODO save the scores in the database
						}
						Gdx.app.exit();
					}
				};
				dialog.text("Do you want to save the game?")
						.button("Yes", true);
				dialog.button("No", false).show(stage);
			}
		});

		// Add buttons to the table
		if (Constants.DISPLAY_SCORES) {
			dicesTable.add(scores).row();
		}
		for (int i = 0; i < 3; i += 2) {
			dicesTable.add(dicesButtons.get(i));
			dicesTable.add(dicesButtons.get(i + 1)).spaceBottom(15).row();
		}
		dicesTable.add(dicesButtons.get(4)).center().spaceBottom(30).row();
		dicesTable.add(throwDices);
		dicesTable.add(exit);

		scoreTable = new Table();
		createScoresTable();
		scoreTable.left().center();

		table.add(heading).row();
		table.add(scoreTable).space(10);
		table.add(dicesTable);
		stage.addActor(table);

		addScore();
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

	public void createDices() {
		dicesButtons = new ArrayList<TextButton>();
		for (int i = 0; i < 5; i++) {
			TextButton dice = new TextButton("", skinDices, "dice1true");
			dice.addListener(new AddDiceListener(i));
			dicesButtons.add(dice);
		}
	}

	public void createScoresTable() {

		for (Combination c : Combination.class.getEnumConstants()) {
			TextButton textButton = new TextButton("  ", skin, "small");
			textButtons.put(c, textButton);
		}

		for (Map.Entry<Combination, TextButton> entry : textButtons.entrySet()) {
			scoreTable.add(new Label(entry.getKey().toString(), skin, "small"));
			scoreTable.add(entry.getValue()).spaceBottom(5).row();
		}
	}

	public void addScore() {
		for (Map.Entry<Combination, TextButton> entry : textButtons.entrySet()) {
			entry.getValue().addListener(new AddScoreListener(entry.getKey()));
		}
	}

	public void updateScoreTable() {
		for (Map.Entry<Combination, TextButton> entry : textButtons.entrySet()) {
			if (controller.getCurrentPlayer().getScores().get(entry.getKey()) == -1) {
				entry.getValue().setText("  ");
			} else {
				entry.getValue().setText(
						""
								+ controller.getCurrentPlayer().getScores()
										.get(entry.getKey()));
			}
		}
	}

	public void confirm(final Combination c) {
		Dialog dialog = new Dialog("Comfirm", skin, "small") {
			@Override
			protected void result(Object object) {
				if (object.equals(true) && controller.getNumberTurnsLeft() > 0) {
					controller.changePlayer(c);
					heading.setText(controller.getCurrentPlayer().getName());
					updateScoreTable();

					for (int i = 0; i < 5; i++) {
						dicesButtons.get(i)
								.setStyle(
										skinDices
												.get("dice"
														+ controller.getDices()
																.get(i)
																.getValue()
																.getValue()
														+ "true",
														TextButtonStyle.class));
					}

					Dialog dialog = new Dialog("Change player", skin, "small");
					// dialog.setBackground(background);
					dialog.text(
							"Your turn,\n"
									+ controller.getCurrentPlayer().getName())
							.button("OK").show(stage);
					scores.setText(""
							+ controller.getCurrentPlayer().getTotalScore());

				} else if (object.equals(true)
						&& controller.getNumberTurnsLeft() == 0) {
					controller.addScore(c);
					((Game) Gdx.app.getApplicationListener())
							.setScreen(new GameOverScreen());
				}
			}
		};
		dialog.text(
				"Do you comfirm\nyou want to choose\n" + c.toString()
						+ "\nand add " + controller.getCurrentScore(c)
						+ " points?").button("Yes", true);
		dialog.button("Cancel", false).show(stage);
	}

	public class AddScoreListener extends ClickListener {
		Combination combination;

		public AddScoreListener(Combination combination) {
			super();
			this.combination = combination;
		}

		@Override
		public void clicked(InputEvent event, float x, float y) {
			if (controller.getCurrentPlayer().getScores().get(combination) == -1
					&& controller.getThrowsLeft() < Constants.NUMBER_OF_THROWS) {
				confirm(combination);
			}
		}
	}

	public class AddDiceListener extends ClickListener {
		int diceNumber;

		public AddDiceListener(int diceNumber) {
			this.diceNumber = diceNumber;
		}

		@Override
		public void clicked(InputEvent event, float x, float y) {
			if (controller.getThrowsLeft() < Constants.NUMBER_OF_THROWS) {
				controller
						.getDices()
						.get(diceNumber)
						.setToThrow(
								!controller.getDices().get(diceNumber)
										.isToThrow());
				dicesButtons.get(diceNumber).setStyle(
						skinDices.get(
								"dice"
										+ controller.getDices().get(diceNumber)
												.getValue().getValue()
										+ controller.getDices().get(diceNumber)
												.isToThrow(),
								TextButtonStyle.class));
			}
		}
	}
}
