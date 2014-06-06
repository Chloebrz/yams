package fr.mbpmx.view;

import java.util.LinkedHashMap;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.controller.Controller;
import fr.mbpmx.model.Combination;
import fr.mbpmx.other.Constants;

public class GameScreen extends YamsScreen {
    private Controller controller;

    // private Skin skinDices;

    private Table scoreTable;
    private TextButton dice1, dice2, dice3, dice4, dice5;
    private TextButton throwDices;

    private Table dicesTable;

    private Label heading;
    
    private LinkedHashMap<Combination, TextButton> textButtons = new LinkedHashMap<Combination, TextButton>();

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
        // skinDices = new Skin(Gdx.files.internal("ui/dices.json"),
        // new TextureAtlas("ui/dices.pack"));

        // Create heading (displaying the current player's name)
        heading = new Label(controller.getCurrentPlayer().getName(), skin);
        heading.setFontScale(2);

        dicesTable = new Table();

        createDices();

        throwDices = new TextButton("Jeter les dés", skin);
        throwDices.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.throwDices();
                dice1.setText(controller.getDices().get(0).toString());
                dice2.setText(controller.getDices().get(1).toString());
                dice3.setText(controller.getDices().get(2).toString());
                dice4.setText(controller.getDices().get(3).toString());
                dice5.setText(controller.getDices().get(4).toString());
            }
        });

        // Add buttons to the table
        dicesTable.add(dice1).spaceBottom(15).row();
        dicesTable.add(dice2).spaceBottom(15).row();
        dicesTable.add(dice3).spaceBottom(15).row();
        dicesTable.add(dice4).spaceBottom(15).row();
        dicesTable.add(dice5).spaceBottom(15).row();
        dicesTable.add(throwDices);

        scoreTable = new Table();
        createScoresTable();
        scoreTable.left().center();

        table.add(heading).row();
        table.add(scoreTable).space(75);
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
        dice1 = new TextButton("Dé 1", skin);
        dice1.addListener(new AddDiceListener(0));
        dice2 = new TextButton("Dé 2", skin);
        dice2.addListener(new AddDiceListener(1));
        dice3 = new TextButton("Dé 3", skin);
        dice3.addListener(new AddDiceListener(2));
        dice4 = new TextButton("Dé 4", skin);
        dice4.addListener(new AddDiceListener(3));
        dice5 = new TextButton("Dé 5", skin);
        dice5.addListener(new AddDiceListener(4));
    }

    public void createScoresTable() {
        
        for (Combination c : Combination.class.getEnumConstants()) {
            TextButton textButton = new TextButton("", skin, "small");
            textButtons.put(c, textButton);
        }
        
        for (Map.Entry<Combination, TextButton> entry : textButtons.entrySet())
        {
            scoreTable.add(new Label(entry.getKey().toString(), skin, "small"));
            scoreTable.add(entry.getValue()).row();
        }
    }

    public void addScore() {
        for (Map.Entry<Combination, TextButton> entry : textButtons.entrySet())
        {
            entry.getValue().addListener(new AddScoreListener(entry.getKey()));
        }
    }
    
    public void updateScoreTable() {
        for (Map.Entry<Combination, TextButton> entry : textButtons.entrySet())
        {
            if(controller.getCurrentPlayer().getScores().get(entry.getKey()) == -1) {
                entry.getValue().setText("");
            } else {
                entry.getValue().setText("" + controller.getCurrentPlayer().getScores().get(entry.getKey()));
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
                    Dialog dialog = new Dialog("Change player", skin, "small");
                    dialog.text(
                            "Up to you to beat him,\n"
                                    + controller.getCurrentPlayer().getName())
                            .button("OK").show(stage);
                } else if(object.equals(true) && controller.getNumberTurnsLeft() == 0) {
                    controller.addScore(c);
                    ((Game) Gdx.app.getApplicationListener())
                    .setScreen(new GameOverScreen());
                }
            }
        };
        dialog.text(
                "Do you comfirm\nyou want to choose\n" + c.toString()
                        + "\nand add " + controller.getCurrentScore(c)
                        + " points ?").button("Yes", true);
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
            }
        }
    }
}
