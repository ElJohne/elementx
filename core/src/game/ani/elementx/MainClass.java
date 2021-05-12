package game.ani.elementx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL30;

public class MainClass extends Game implements ApplicationListener {

    CardGame cardGame;
    MainMenu mainMenu;
    PlayersMenu pMenu;
    Music music;

    @Override
    public void create() {
        music = Gdx.audio.newMusic(Gdx.files.internal("main-theme-elementx.mp3"));
        setMenuScreen();
    }
    void setGameScreen(Player p1, Player p2)
    {
        cardGame=new CardGame(this, p1, p2);
        this.setScreen(cardGame);
    }
    void setMenuScreen()
    {
        musicPlay();
        mainMenu=new MainMenu(this);
        setScreen(mainMenu);
    }
    void setOptionsScreen(boolean turnMusic)
    {
        if(turnMusic) musicPlay();
        pMenu=new PlayersMenu(this);
        setScreen(pMenu);
    }

    void musicPlay(){
        music.play();
        music.setLooping(true);
    }

    void musicStop(){
        music.stop();
    }

    @Override
    public void dispose() {

        super.dispose();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}
