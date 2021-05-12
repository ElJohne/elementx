package game.ani.elementx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.Arrays;


public class PlayersMenu extends ApplicationAdapter implements Screen {

    Texture background;
    Texture background2;
    float timeSeconds;
    boolean todosmth;
    Sprite backgr;
    SpriteBatch batch;
    static public OrthographicCamera camera;
    Vector3 temp123;
    Player p1, p2;
    boolean firstPicked;
    boolean doneCreating = false;
    Sound clickSound;

    private MainClass mainClass;

    public PlayersMenu(MainClass mc)
    {
        mainClass=mc;
    }

    @Override
    public void create() {
        background = new Texture(Gdx.files.internal("pickelement1.png"));
        background2 = new Texture(Gdx.files.internal("pickelement2.png"));
        backgr = new Sprite(background);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        batch = new SpriteBatch();
        firstPicked = false;
        todosmth= true;
        doneCreating = true;
        clickSound = Gdx.audio.newSound(Gdx.files.internal("placing.wav"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render();
        if(!doneCreating)this.create();
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0);

        if (Gdx.input.isTouched() && !firstPicked) {
            temp123 = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(temp123);
            float touchX = temp123.x;
            float touchY = temp123.y;
            if (touchY < 268 && touchY > 126 && touchX < 1442 && touchX > 1070) {
                int[] array2 = {0,0,0,0};
                array2[0] = 1 + (int) (Math.random() * 8);
                array2[1] = 1 + (int) (Math.random() * 8);
                array2[2] = 1 + (int) (Math.random() * 8);
                array2[3] = 1 + (int) (Math.random() * 8);
                p1 = new Player(false, array2, false,Player.WIND);
                firstPicked = true;
                todosmth = false;
                timeSeconds = 0;
                clickSound.play(100);
            }
            else if (touchY < 268 && touchY > 126 && touchX < 841 && touchX > 465) {
                int[] array2 = {0,0,0,0};
                array2[0] = 9 + (int) (Math.random() * 8);
                array2[1] = 9 + (int) (Math.random() * 8);
                array2[2] = 9 + (int) (Math.random() * 8);
                array2[3] = 9 + (int) (Math.random() * 8);
                p1 = new Player(false, array2, false, Player.WATER);
                firstPicked = true;
                todosmth = false;
                timeSeconds = 0;
                clickSound.play(100);
            }
            else if (touchY < 504 && touchY > 365 && touchX < 841 && touchX > 465) {
                int[] array2 = {0,0,0,0};
                array2[0] = 17 + (int) (Math.random() * 8);
                array2[1] = 17 + (int) (Math.random() * 8);
                array2[2] = 17 + (int) (Math.random() * 8);
                array2[3] = 17 + (int) (Math.random() * 8);
                p1 = new Player(false, array2, false, Player.FIRE);
                firstPicked = true;
                todosmth = false;
                timeSeconds = 0;
                clickSound.play(100);
            }
            else if (touchY < 504 && touchY > 365 && touchX < 1442 && touchX > 1070) {
                int[] array2 = {0,0,0,0};
                array2[0] = 25 + (int) (Math.random() * 8);
                array2[1] = 25 + (int) (Math.random() * 8);
                array2[2] = 25 + (int) (Math.random() * 8);
                array2[3] = 25 + (int) (Math.random() * 8);
                p1 = new Player(false, array2, false, Player.EARTH);
                firstPicked = true;
                todosmth = false;
                timeSeconds = 0;
                clickSound.play(100);
            }
        }

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        float period = 0.5f;
        if (timeSeconds > period) {
            timeSeconds = 0f;
            todosmth = true;
        }

        if (Gdx.input.isTouched() && firstPicked) {
            temp123 = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(temp123);
            float touchX = temp123.x;
            float touchY = temp123.y;
            if (touchY < 268 && touchY > 126 && touchX < 1442 && touchX > 1070) {
                int[] array2 = {0,0,0,0};
                array2[0] = 1 + (int) (Math.random() * 8);
                array2[1] = 1 + (int) (Math.random() * 8);
                array2[2] = 1 + (int) (Math.random() * 8);
                array2[3] = 1 + (int) (Math.random() * 8);
                p2 = new Player(true, array2, true, Player.WIND);
                clickSound.play(100);
                mainClass.setGameScreen(p1,p2);
            }
            else if (touchY < 268 && touchY > 126 && touchX < 841 && touchX > 465) {
                int[] array2 = {0,0,0,0};
                array2[0] = 9 + (int) (Math.random() * 8);
                array2[1] = 9 + (int) (Math.random() * 8);
                array2[2] = 9 + (int) (Math.random() * 8);
                array2[3] = 9 + (int) (Math.random() * 8);
                p2 = new Player(true, array2, true, Player.WATER);
                clickSound.play(100);
                mainClass.setGameScreen(p1,p2);
            }
            else if (touchY < 504 && touchY > 365 && touchX < 841 && touchX > 465) {
                int[] array2 = {0,0,0,0};
                array2[0] = 17 + (int) (Math.random() * 8);
                array2[1] = 17 + (int) (Math.random() * 8);
                array2[2] = 17 + (int) (Math.random() * 8);
                array2[3] = 17 + (int) (Math.random() * 8);
                p2 = new Player(true, array2, true, Player.FIRE);
                clickSound.play(100);
                mainClass.setGameScreen(p1,p2);
            }
            else if (touchY < 504 && touchY > 365 && touchX < 1442 && touchX > 1070) {
                int[] array2 = {0,0,0,0};
                array2[0] = 25 + (int) (Math.random() * 8);
                array2[1] = 25 + (int) (Math.random() * 8);
                array2[2] = 25 + (int) (Math.random() * 8);
                array2[3] = 25 + (int) (Math.random() * 8);
                p2 = new Player(true, array2, true, Player.EARTH);
                clickSound.play(100);
                mainClass.setGameScreen(p1,p2);
            }
        }
        if(firstPicked){
            backgr.setTexture(background2);
        }
        backgr.draw(batch);

        batch.end();
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
        background2.dispose();
        batch.dispose();
        p1.dispose();
        p2.dispose();
    }
}
