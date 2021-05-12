package game.ani.elementx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class MainMenu extends ApplicationAdapter implements Screen {

    Texture background;
    SpriteBatch batch;
    public OrthographicCamera camera;
    Vector3 temp123;
    boolean doneCreating = false;
    Sound clickSound;


    private MainClass mainClass;

    public MainMenu(MainClass mc)
    {
        mainClass=mc;
    }

    @Override
    public void create() {
        background = new Texture(Gdx.files.internal("mm.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        batch = new SpriteBatch();
        mainClass.musicPlay();
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

        if (Gdx.input.justTouched()) {
            temp123 = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(temp123);
            float touchX = temp123.x;
            float touchY = temp123.y;
            if (touchY < 516 && touchY > 213 && touchX < 1251 && touchX > 683) {
                clickSound.play(100);
                mainClass.setOptionsScreen(false);
            }
        }
        batch.end();
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
        batch.dispose();
        clickSound.dispose();
    }
}
