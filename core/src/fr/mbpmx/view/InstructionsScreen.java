package fr.mbpmx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mbpmx.game.YamsMain;

public class InstructionsScreen extends YamsScreen {
    private TextButton buttonBack;

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
        
        //Creating heading
        Label heading = new Label(YamsMain.TITLE, skin, "big");
        heading.setFontScale(2);

        // Creation of the buttons
        buttonBack = new TextButton("Back", skin);
        buttonBack.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game) Gdx.app.getApplicationListener())
                        .setScreen(new MainMenuScreen());
            }
        });
        buttonBack.pad(15); // TODO Select the right padding and place the
                            // button in a table
        table.add(heading).spaceBottom(75).row();
        table.add(buttonBack).spaceBottom(15).row();
        
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
