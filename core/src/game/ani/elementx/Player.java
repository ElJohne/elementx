package game.ani.elementx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;

import javax.xml.soap.Text;

public class Player {
    public static final int FIRE = 1;
    public static final int EARTH = 2;
    public static final int WATER = 3;
    public static final int WIND = 4;
    boolean isPlayerOnTop;
    boolean isPlayerActive;
    int element;
    int playerHealth;
    LinkedList<playerCard> cards;
    LinkedList<cardSlot> handSlots;
    LinkedList<cardSlot> tableSlots;
    int countOnTable;
    boolean someCardTransfered;
    boolean cardPlaced;
    int manaPoint;
    boolean attackDone;
    String healthCount;

    BitmapFont font;
    public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

    Texture iconTexture;
    Sprite iconSprite;

    Sound hitSound;
    boolean playerDead;

    Texture moveOn, moveOff;
    Sprite activeSprt;

    void render(OrthographicCamera camera, SpriteBatch batch, Player enemy){



        if(isPlayerActive) activeSprt.setTexture(moveOn);
        else activeSprt.setTexture(moveOff);
        activeSprt.draw(batch);
        iconSprite.draw(batch);
        boolean tmp = true;
        for (playerCard pc: cards) {
            if(pc.cardAlive) tmp = false;
        }
        if(tmp) playerDead = true;
        if(playerHealth<1)playerDead = true;
        healthCount = Integer.toString(playerHealth);
        font.getData().setScale(3.5f);
        if(isPlayerOnTop){
            font.setColor(Color.ORANGE);
            font.draw(batch, healthCount, 1463,902);
        }
        else {
            font.setColor(Color.LIME);
            font.draw(batch, healthCount, 383,110);
        }


        if(someCardTransfered){
            for (playerCard card : cards) {
                if(card.cardInHand)card.alreadyInHand = false;
            }
        }
        for (playerCard card : cards) {
            if(!card.cardChoosed && !card.alreadyOnTable)card.render(batch, camera, this, enemy);
        }
    }


    void renderTableCards(OrthographicCamera camera, SpriteBatch batch, Player enemy){
        for (playerCard card : cards) {
            if(card.alreadyOnTable && !card.cardChoosed)card.render(batch, camera, this, enemy);
        }
    }
    void renderChoosedCards(OrthographicCamera camera, SpriteBatch batch, Player enemy){
        for (playerCard card : cards) {
            if(card.cardChoosed)card.render(batch, camera, this, enemy);
        }
    }

    Player(boolean isPlayerOnTop, int[] cards, boolean isPlayerActive, int element){
        moveOn = new Texture("moveOn.png");
        moveOff = new Texture("moveOff.png");
        activeSprt = new Sprite(moveOn);
        switch(element){
            case 1:
                iconTexture = new Texture("fireicon.png");
                break;
            case 2:
                iconTexture = new Texture("earthicon.png");
                break;
            case 3:
                iconTexture = new Texture("watericon.png");
                break;
            default:
                iconTexture = new Texture("windicon.png");
        }
        iconSprite = new Sprite(iconTexture);
        iconSprite.setSize(iconSprite.getWidth()/3,iconSprite.getHeight()/3);
        if(isPlayerOnTop){
            iconSprite.setPosition(1713,845);
            activeSprt.setPosition(1438, 964);
        }
        else {
            iconSprite.setPosition(56,50);
            activeSprt.setPosition(240, 170);
        }
        playerHealth=30;
        healthCount = "30";
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(2);
        manaPoint = 5;
        this.isPlayerOnTop = isPlayerOnTop;
        this.isPlayerActive = isPlayerActive;
        this.cards = new LinkedList<>();
        handSlots = new LinkedList<>();
        tableSlots = new LinkedList<>();
        cardPlaced = false;
        attackDone = false;
        playerDead = false;
        this.cards.add(new playerCard(cards[0], this));
        this.cards.add(new playerCard(cards[1], this));
        this.cards.add(new playerCard(cards[2], this));
        this.cards.add(new playerCard(cards[3], this));
        if(!isPlayerOnTop) {
            this.handSlots.add(new cardSlot(1609, 23, 0));
            this.handSlots.add(new cardSlot(1299, 23, 1));
            this.handSlots.add(new cardSlot(989, 23, 2));
            this.handSlots.add(new cardSlot(679, 23, 3));
            this.tableSlots.add(new cardSlot(587, 310, 3));
            this.tableSlots.add(new cardSlot(785, 310, 2));
            this.tableSlots.add(new cardSlot(982, 310, 1));
            this.tableSlots.add(new cardSlot(1180, 310, 0));
            isPlayerActive = true;
        }
        else{
            this.handSlots.add(new cardSlot(135, 1057-262, 3));
            this.handSlots.add(new cardSlot(445, 1057-262, 2));
            this.handSlots.add(new cardSlot(755, 1057-262, 1));
            this.handSlots.add(new cardSlot(1065, 1057-262, 0));
            this.tableSlots.add(new cardSlot(587, 310+13+225, 3));
            this.tableSlots.add(new cardSlot(785, 310+13+225, 2));
            this.tableSlots.add(new cardSlot(982, 310+13+225, 1));
            this.tableSlots.add(new cardSlot(1180, 310+13+225, 0));
            isPlayerActive = false;
        }
        for (cardSlot slot: handSlots){
            slot.isEmpty=true;
        }
        for (cardSlot slot: tableSlots){
            slot.isEmpty=true;
        }
        countOnTable = 0;
        someCardTransfered = false;
        hitSound = Gdx.audio.newSound(Gdx.files.internal("hitSound.mp3"));
    }
    void damage(int dmg){
        playerHealth -= dmg;
        if(playerHealth < 1) this.playerDead = true;
        hitSound.play(100);
    }
    void dispose(){
        for (playerCard pc: cards) {
            pc.dispose();
        }
        hitSound.dispose();
        font.dispose();
    }
}

class cardSlot{
    boolean isEmpty;
    float x;
    float y;
    int priority;
    public cardSlot(float x, float y, int priority){
        this.x = x;
        this.y = y;
        this.priority = priority;
    }
}