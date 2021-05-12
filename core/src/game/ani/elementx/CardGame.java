package game.ani.elementx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class CardGame extends ApplicationAdapter implements Screen {
	Texture background;
	SpriteBatch batch;
	static public OrthographicCamera camera;
	Vector3 temp123;
	Player p1;
	Player p2;
	String winner;
	BitmapFont font;
	Sprite pauseImg;
	Texture pauseTexture;
	Sprite endImg;
	Texture endTexture;
	Texture endTexture2;
	boolean gameIsOnPause;
	boolean gameOver;
	boolean todosmth;
	boolean buttonClicked;//Your move is over. Transfer the device to another player. (tap the screen to continue)
	Music battleMusic;
	private float timeSeconds = 0f;
	boolean doneCreating = false;

	private MainClass mainClass;

	public CardGame(MainClass mc, Player P1, Player P2)
	{
		mainClass=mc;
		this.p1 = P1;
		this.p2 = P2;
	}

	@Override
	public void create() {
		mainClass.musicStop();
		background = new Texture(Gdx.files.internal("battlefield1.png"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		batch = new SpriteBatch();
		battleMusic = Gdx.audio.newMusic(Gdx.files.internal("song.mp3"));
		battleMusic.play();
		battleMusic.setLooping(true);
		pauseTexture = new Texture("pauseWindow.png");
		pauseImg = new Sprite(pauseTexture,0,0,1920,1080);
		endTexture = new Texture("winnerScreen1.png");
		endTexture2 = new Texture("winnerScreen2.png");
		endImg = new Sprite(endTexture,0,0,1920,1080);
		gameIsOnPause = false;
		gameOver = false;
		font = new BitmapFont();
		todosmth = true;
		doneCreating = true;
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

		timeSeconds += Gdx.graphics.getRawDeltaTime();
		float period = 0.5f;
		if (timeSeconds > period) {
			timeSeconds = 0f;
			todosmth = true;
		}

		batch.begin();
		batch.draw(background, 0, 0);
		if(!gameIsOnPause && !gameOver) {
			p2.renderTableCards(camera, batch, p1);
			p1.renderTableCards(camera, batch, p2);
			if (p1.isPlayerActive) {
				p2.render(camera, batch, p1);
				p1.render(camera, batch, p2);
				if (p1.cardPlaced || p1.attackDone) {
					gameIsOnPause = true;
					todosmth = false;
					timeSeconds = 0f;
					buttonClicked = false;
					p1.cardPlaced = false;
					p2.cardPlaced = false;
					p2.attackDone = false;
					p1.attackDone = false;
					p1.isPlayerActive = false;
					p2.isPlayerActive = true;
				}
			} else {
				p1.render(camera, batch, p2);
				p2.render(camera, batch, p1);
				if (p2.cardPlaced || p2.attackDone) {
					gameIsOnPause = true;
					todosmth = false;
					timeSeconds = 0f;
					buttonClicked = false;
					p2.cardPlaced = false;
					p1.cardPlaced = false;
					p2.attackDone = false;
					p1.attackDone = false;
					p2.isPlayerActive = false;
					p1.isPlayerActive = true;
				}
			}
			p2.renderChoosedCards(camera, batch, p1);
			p1.renderChoosedCards(camera, batch, p2);
			if(p1.playerDead || p2.playerDead) gameOver = true;
		}
		else if (gameIsOnPause && !gameOver){
			pauseImg.draw(batch);
		}
		if (Gdx.input.justTouched() && gameIsOnPause &&	todosmth) {
			gameIsOnPause = false;
		}
		else if(gameOver){
			if(p1.playerDead){
				endImg.setTexture(endTexture2);
			}
			else{
				endImg.setTexture(endTexture);
			}
			endImg.draw(batch);
		}
		if (Gdx.input.justTouched() && gameOver) {
			temp123 = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(temp123);
			float touchX = temp123.x;
			float touchY = temp123.y;
			if(touchY < 620 && touchY > 480 && touchX < 718 && touchX > 350){
				battleMusic.stop();
				mainClass.setOptionsScreen(true);
			}
			else if(touchY < 620 && touchY > 480 && touchX < 1560 && touchX > 1190){
				battleMusic.stop();
				mainClass.setMenuScreen();
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
		endTexture.dispose();
		pauseTexture.dispose();
		font.dispose();
		battleMusic.dispose();
		p1.dispose();
		p2.dispose();
	}
}
