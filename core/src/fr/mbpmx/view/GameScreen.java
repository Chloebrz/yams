package fr.mbpmx.view;

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

    private TextButton buttonOne, buttonTwo, buttonThree, buttonFour,
            buttonFive, buttonSix, buttonTwoPairs, buttonThreeOfAKind,
            buttonFullHouse, buttonFourOfAKind, buttonStraight, buttonYams,
            buttonPlus, buttonMinus, buttonChance;

    private Table dicesTable;

    private Label heading;

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
        buttonOne = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.ONE.toString(), skin, "small"));
        scoreTable.add(buttonOne).row();

        buttonTwo = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.TWO.toString(), skin, "small"));
        scoreTable.add(buttonTwo).row();

        buttonThree = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.THREE.toString(), skin, "small"));
        scoreTable.add(buttonThree).row();

        buttonFour = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.FOUR.toString(), skin, "small"));
        scoreTable.add(buttonFour).row();

        buttonFive = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.FIVE.toString(), skin, "small"));
        scoreTable.add(buttonFive).row();

        buttonSix = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.SIX.toString(), skin, "small"));
        scoreTable.add(buttonSix).row();

        buttonTwoPairs = new TextButton("", skin, "small");
        scoreTable
                .add(new Label(Combination.TWOPAIRS.toString(), skin, "small"));
        scoreTable.add(buttonTwoPairs).row();

        buttonThreeOfAKind = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.THREEOFAKIND.toString(), skin,
                "small"));
        scoreTable.add(buttonThreeOfAKind).row();

        buttonFullHouse = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.FULLHOUSE.toString(), skin,
                "small"));
        scoreTable.add(buttonFullHouse).row();

        buttonFourOfAKind = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.FOUROFAKIND.toString(), skin,
                "small"));
        scoreTable.add(buttonFourOfAKind).row();

        buttonStraight = new TextButton("", skin, "small");
        scoreTable
                .add(new Label(Combination.STRAIGHT.toString(), skin, "small"));
        scoreTable.add(buttonStraight).row();

        buttonYams = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.YAMS.toString(), skin, "small"));
        scoreTable.add(buttonYams).row();

        buttonPlus = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.PLUS.toString(), skin, "small"));
        scoreTable.add(buttonPlus).row();

        buttonMinus = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.MINUS.toString(), skin, "small"));
        scoreTable.add(buttonMinus).row();

        buttonChance = new TextButton("", skin, "small");
        scoreTable.add(new Label(Combination.CHANCE.toString(), skin, "small"));
        scoreTable.add(buttonChance).row();
    }

    public void addScore() {
        buttonOne.addListener(new AddScoreListener(Combination.ONE));
        buttonTwo.addListener(new AddScoreListener(Combination.TWO));
        buttonThree.addListener(new AddScoreListener(Combination.THREE));
        buttonFour.addListener(new AddScoreListener(Combination.FOUR));
        buttonFive.addListener(new AddScoreListener(Combination.FIVE));
        buttonSix.addListener(new AddScoreListener(Combination.SIX));
        buttonTwoPairs.addListener(new AddScoreListener(Combination.TWOPAIRS));
        buttonThreeOfAKind.addListener(new AddScoreListener(
                Combination.THREEOFAKIND));
        buttonFullHouse
                .addListener(new AddScoreListener(Combination.FULLHOUSE));
        buttonFourOfAKind.addListener(new AddScoreListener(
                Combination.FOUROFAKIND));
        buttonStraight.addListener(new AddScoreListener(Combination.STRAIGHT));
        buttonYams.addListener(new AddScoreListener(Combination.YAMS));
        buttonPlus.addListener(new AddScoreListener(Combination.PLUS));
        buttonMinus.addListener(new AddScoreListener(Combination.MINUS));
        buttonChance.addListener(new AddScoreListener(Combination.CHANCE));
    }

    public void confirm(final Combination c) {
        Dialog dialog = new Dialog("Comfirm", skin, "small") {
            @Override
            protected void result(Object object) {
                if (object.equals(true)) {
                    controller.setCurrentPlayer(Constants
                            .changePlayer(controller.getCurrentPlayer()));
                    Dialog dialog = new Dialog("Change player", skin, "small");
                    dialog.text(
                            "Up to you to bet him,\n"
                                    + controller.getCurrentPlayer().getName())
                            .button("OK").show(stage);
                    heading.setText(controller.getCurrentPlayer().getName());
                    controller.addScore(c);
                    controller.setThrowsLeft(Constants.NUMBER_OF_THROWS);
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
                System.out.println("Coucou c'est moi le AddScoreListener !!");
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
