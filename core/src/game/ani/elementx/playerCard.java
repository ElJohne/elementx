package game.ani.elementx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class playerCard {

    public static final int WIND_GRIFFIN = 1;
    public static final int WIND_VALKYRIE = 2;
    public static final int WIND_ANGEL = 3;
    public static final int WIND_HARPY = 4;
    public static final int WIND_PEGAS = 5;
    public static final int WIND_SPHINX = 6;
    public static final int WIND_FAIRY = 7;
    public static final int WIND_VYVERN = 8;
    public static final int WATER_ELEMENTAL = 9;
    public static final int WATER_MERMAID = 10;
    public static final int WATER_KRAKEN = 11;
    public static final int WATER_AVANKS = 12;
    public static final int WATER_DROWNER = 13;
    public static final int WATER_HYDRA = 14;
    public static final int WATER_DRAGON = 15;
    public static final int WATER_NYMPH = 16;
    public static final int FIRE_PHOENIX = 17;
    public static final int FIRE_SALAMANDER = 18;
    public static final int FIRE_GIN = 19;
    public static final int FIRE_KING_DRAGON = 20;
    public static final int FIRE_GOLEM = 21;
    public static final int FIRE_CERBER = 22;
    public static final int FIRE_GAKI = 23;
    public static final int FIRE_SCORPION = 24;
    public static final int EARTH_GREMLIN = 25;
    public static final int EARTH_GARGOYLES = 26;
    public static final int EARTH_KRONOS = 27;
    public static final int EARTH_GARGONA = 28;
    public static final int EARTH_MINOTAUR = 29;
    public static final int EARTH_GNOME = 30;
    public static final int EARTH_EATER = 31;
    public static final int EARTH_CYCLOP = 32;

    String cardName;
    BitmapFont font;

    Sound hitSound;
    Sound placeSound;
    Sound chooseSound;

    Vector3 temp123;
    Rectangle rect;
    Sprite cardFront;
    Sprite cardBack;
    Sprite ChoosedField;
    Texture cardBackText, cardFrontText, CFTexture;
    int maxHP, currentHP, MP, SP, AP;
    boolean cardInHand;
    boolean cardAlive;
    boolean cardChoosed;
    boolean attackDone;
    boolean isCardVisible;
    boolean isCardActive;
    boolean alreadyOnTable;
    boolean alreadyInHand;
    OrthographicCamera camera;
    int handSlotUsed;
    int tableSlotUsed;
    float endX;
    float endY;
    float pixelsX;
    float pixelsY;
    float startScale;
    float endScale;
    float pixelsScale;
    int dScale;
    int dx, dy;
    float timeAnim;
    boolean isAnimActive;
    boolean isHitting;
    float timeSeconds2 = 0f;
    float timeSeconds = 0f;
    Texture hitTexture;
    Sprite hitSprite;
    boolean firstRender;


    playerCard(int CardID, Player player){
        switch (CardID){
            case WIND_GRIFFIN:
                cardName = "GRIFFIN";
                maxHP = 5;
                AP = 4;
                MP = 4;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("wind_griffin.png"));
                break;
            case WIND_VALKYRIE:
                cardName = "VALKYRIE";
                maxHP = 6;
                AP = 4;
                MP = 4;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("wind_valkyrie.png"));
                break;
            case WIND_ANGEL:
                cardName = "ANGEL";
                maxHP = 7;
                AP = 5;
                MP = 6;
                SP = 7;
                cardFrontText = new Texture(Gdx.files.internal("wind_angel.png"));
                break;
            case WIND_HARPY:
                cardName = "HARPY";
                maxHP = 2;
                AP = 2;
                MP = 1;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("wind_harpy.png"));
                break;
            case WIND_PEGAS:
                cardName = "PEGAS";
                maxHP = 4;
                AP = 4;
                MP = 4;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("wind_pegas.png"));
                break;
            case WIND_SPHINX:
                cardName = "SPHINX";
                maxHP = 6;
                AP = 4;
                MP = 5;
                SP = 6;
                cardFrontText = new Texture(Gdx.files.internal("wind_sphinx.png"));
                break;
            case WIND_FAIRY:
                cardName = "FAIRY";
                maxHP = 3;
                AP = 3;
                MP = 2;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("wind_fairy.png"));
                break;
            case WIND_VYVERN:
                cardName = "VYVERN";
                maxHP = 5;
                AP = 4;
                MP = 4;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("wind_vyvern.png"));
                break;//38 30
            case WATER_ELEMENTAL:
                cardName = "ELEMENTAL";
                maxHP = 4;
                AP = 4;
                MP = 5;
                SP = 10;
                cardFrontText = new Texture(Gdx.files.internal("water_elemental.png"));
                break;
            case WATER_MERMAID:
                cardName = "MERMAID";
                maxHP = 4;
                AP = 4;
                MP = 3;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("water_mermaid.png"));
                break;
            case WATER_KRAKEN:
                cardName = "KRAKEN";
                maxHP = 5;
                AP = 5;
                MP = 7;
                SP = 7;
                cardFrontText = new Texture(Gdx.files.internal("water_kraken.png"));
                break;
            case WATER_AVANKS:
                cardName = "AVANKS";
                maxHP = 4;
                AP = 5;
                MP = 3;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("water_avanks.png"));
                break;
            case WATER_DROWNER:
                cardName = "DROWNER";
                maxHP = 2;
                AP = 3;
                MP = 1;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("water_drowner.png"));
                break;
            case WATER_HYDRA:
                cardName = "HYDRA";
                maxHP = 4;
                AP = 4;
                MP = 4;
                SP = 0;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("water_hydra.png"));
                break;
            case WATER_DRAGON:
                cardName = "DRAGON";
                maxHP = 5;
                AP = 5;
                MP = 5;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("water_dragon.png"));
                break;
            case WATER_NYMPH:
                cardName = "NYMPH";
                maxHP = 4;
                AP = 3;
                MP = 3;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("water_nymph.png"));
                break;//33 33
            case FIRE_PHOENIX:
                cardName = "PHOENIX";
                maxHP = 5;
                AP = 4;
                MP = 6;
                SP = 8;
                cardFrontText = new Texture(Gdx.files.internal("fire_phoenix.png"));
                break;
            case FIRE_SALAMANDER:
                cardName = "SALAMANDER";
                maxHP = 6;
                AP = 5;
                MP = 5;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("fire_salamander.png"));
                break;
            case FIRE_GIN:
                cardName = "GIN";
                maxHP = 5;
                AP = 6;
                MP = 5;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("fire_gin.png"));
                break;
            case FIRE_KING_DRAGON:
                cardName = "KING DRAGON";
                maxHP = 6;
                AP = 6;
                MP = 7;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("fire_king_dragon.png"));
                break;
            case FIRE_GOLEM:
                cardName = "GOLEM";
                maxHP = 5;
                AP = 6;
                MP = 7;
                SP = 10;
                cardFrontText = new Texture(Gdx.files.internal("fire_golem.png"));
                break;
            case FIRE_CERBER:
                cardName = "CERBER";
                maxHP = 4;
                AP = 3;
                MP = 3;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("fire_cerber.png"));
                break;
            case FIRE_GAKI:
                cardName = "GAKI";
                maxHP = 3;
                AP = 3;
                MP = 2;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("fire_gaki.png"));
                break;
            case FIRE_SCORPION:
                cardName = "SCORPION";
                maxHP = 4;
                AP = 3;
                MP = 3;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("fire_scorpion.png"));
                break;//38 36
            case EARTH_GREMLIN:
                cardName = "GREMLIN";
                maxHP = 2;
                AP = 2;
                MP = 1;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("earth_gremlin.png"));
                break;
            case EARTH_GARGOYLES:
                cardName = "GARGOYLES";
                maxHP = 3;
                AP = 3;
                MP = 2;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("earth_gargoyles.png"));
                break;
            case EARTH_KRONOS:
                cardName = "KRONOS";
                maxHP = 5;
                AP = 6;
                MP = 8;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("earth_kronos.png"));
                break;
            case EARTH_GARGONA:
                cardName = "GARGONA";
                maxHP = 4;
                AP = 4;
                MP = 4;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("earth_gargona.png"));
                break;
            case EARTH_MINOTAUR:
                cardName = "MINOTAUR";
                maxHP = 5;
                AP = 6;
                MP = 4;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("earth_minotaur.png"));
                break;
            case EARTH_GNOME:
                cardName = "GNOME";
                maxHP = 6;
                AP = 7;
                MP = 5;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("earth_gnome.png"));
                break;
            case EARTH_EATER:
                cardName = "EATER";
                maxHP = 5;
                AP = 6;
                MP = 4;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("earth_eater.png"));
                break;
            case EARTH_CYCLOP:
                cardName = "CYCLOP";
                maxHP = 5;
                AP = 7;
                MP = 5;
                SP = 0;
                cardFrontText = new Texture(Gdx.files.internal("earth_cyclop.png"));
                break;
            default:
                cardName = "DEFAULT";
                maxHP = 5;
                AP = 4;
                MP = 4;
                SP = 1;
                cardFrontText = new Texture("wind_griffin.png");
                break;//35 41
        }
        font = new BitmapFont();
        currentHP = maxHP;
        isHitting=false;
        rect = new Rectangle(400, -235, 500, 750);
        cardFront = new Sprite(cardFrontText, 0, 0, 500, 750);
        cardBackText = new Texture(Gdx.files.internal("cardback.png"));
        cardBack = new Sprite(cardBackText, 0, 0, 500, 750);
        hitTexture = new Texture(Gdx.files.internal("hit.png"));
        hitSprite = new Sprite(hitTexture, 0, 0, 0, 0);
        cardFront.setScale(0.35F);
        cardBack.setScale(0.35F);
        cardFront.setPosition(400, -235);
        cardBack.setPosition(400, -235);
        cardInHand = true;
        cardAlive = true;
        attackDone = false;
        isCardVisible = true;
        isCardActive = true;
        alreadyOnTable = false;
        alreadyInHand = false;
        isAnimActive = false;
        handSlotUsed = 0;
        tableSlotUsed = 0;
        camera = CardGame.camera;
        if(player.isPlayerOnTop)CFTexture = new Texture(Gdx.files.internal("card_info_up.png"));
        else CFTexture = new Texture(Gdx.files.internal("card_info_down.png"));
        ChoosedField = new Sprite(CFTexture);
        ChoosedField.setPosition(0,0);
        hitSound = Gdx.audio.newSound(Gdx.files.internal("hitSound.mp3"));
        placeSound = Gdx.audio.newSound(Gdx.files.internal("placing.wav"));
        chooseSound = Gdx.audio.newSound(Gdx.files.internal("choosing.wav"));
        firstRender = true;
    }

    public void dispose(){
        cardFrontText.dispose();
        cardBackText.dispose();
        hitSound.dispose();
        placeSound.dispose();
        chooseSound.dispose();
        font.dispose();
        CFTexture.dispose();
        hitTexture.dispose();

    }

    public void render(SpriteBatch batch, OrthographicCamera camera, Player player, Player enemy) {
        if (Gdx.input.justTouched() && cardAlive && ((player.isPlayerActive) || (!player.isPlayerActive && alreadyOnTable))) {
            temp123 = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(temp123);
            float touchX = temp123.x;
            float touchY = temp123.y;
            boolean allOtherNotActive = true;
            for (playerCard pc: player.cards) {
                if(pc.cardChoosed) allOtherNotActive = false;
            }
            boolean tmpIsSomeCardChoosed = false;
            for (playerCard pc: enemy.cards) {
                if(pc.cardChoosed) tmpIsSomeCardChoosed = true;
            }
            if (isCardActive && cardFront.getX() < touchX && cardFront.getX() + cardFront.getWidth() > touchX && cardFront.getY() < touchY && cardFront.getY() + cardFront.getHeight() > touchY) {
                if(cardChoosed) {
                    chooseSound.stop();
                    chooseSound.play(100);
                    cardChoosed = false;
                }
                if(!cardChoosed && allOtherNotActive && !tmpIsSomeCardChoosed && cardAlive) {
                    chooseSound.stop();
                    chooseSound.play(100);
                    cardChoosed = true;
                }
                if (!cardChoosed) setDefaultPosition(player);
                isCardActive = false;
                /*if (cardChoosed) {
                    if (!player.isPlayerOnTop) {
                        moveTo(20, 1060 - 750, 1F, 0.35f, 0.3f);
                    } else {
                        moveTo(1400, 20, 1F, 0.35f, 0.3f);
                    }
                } else {
                    moveTo(player.handSlots.get(handSlotUsed).x, player.handSlots.get(handSlotUsed).y, 0.35f, 1f, 0.5f);
                }*/
            }
        }
        if (cardChoosed && cardInHand && player.isPlayerActive) {
            temp123 = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(temp123);
            float touchY = temp123.y;
            float touchX = temp123.x;
            if (!player.isPlayerOnTop && (800 > touchY && 300 < touchY && 520 < touchX)) {
                cardInHand = false;
                player.handSlots.get(handSlotUsed).isEmpty = true;
                player.someCardTransfered = true;
                player.countOnTable++;
                player.cardPlaced = true;
                cardChoosed = false;
                placeSound.play(100);
            } else if (player.isPlayerOnTop && (800 > touchY && 300 < touchY && 1400 > touchX)) {
                cardInHand = false;
                player.handSlots.get(handSlotUsed).isEmpty = true;
                player.someCardTransfered = true;
                player.countOnTable++;
                player.cardPlaced = true;
                cardChoosed = false;
                placeSound.play(100);
            }

        }
        if(!player.cardPlaced && cardAlive && player.isPlayerActive && cardChoosed && alreadyOnTable && !player.attackDone && Gdx.input.justTouched()){
            temp123 = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(temp123);
            float touchX = temp123.x;
            float touchY = temp123.y;
            if(!enemy.isPlayerOnTop && touchX > 240 && touchX < 470 && touchY < 160 && touchY > 15){
                enemy.damage(this.AP);
                player.attackDone = true;
                this.attackDone = true;
                cardChoosed = false;
                setDefaultPosition(player);
            }
            else if(enemy.isPlayerOnTop && touchX > 1480 && touchX < 1680 && touchY < 955 && touchY > 810){
                enemy.damage(this.AP);
                player.attackDone = true;
                this.attackDone = true;
                cardChoosed = false;
                setDefaultPosition(player);
            }
            for (playerCard pc: enemy.cards) {
                if(touchY >= pc.rect.y && touchY <= (pc.rect.y+(pc.rect.height*0.3f)) && touchX >= pc.rect.x && touchX <= pc.rect.x+(pc.rect.width*0.3f)){
                    if(pc.cardAlive && pc.alreadyOnTable) {
                        pc.damage(this.AP);
                        player.attackDone = true;
                        this.attackDone = true;
                        cardChoosed = false;
                        setDefaultPosition(player);
                        break;
                    }
                }
            }
        }

        if (cardAlive && !isAnimActive) {
            if (cardInHand) {
                cardFront = new Sprite(cardFrontText, (currentHP-1) * 500, 0, 500, 750);
                cardBack = new Sprite(cardBackText, 0, 0, 500, 750);
                for (int i = 0; i < 4; i++) {
                    if (player.handSlots.get(i).isEmpty && !alreadyInHand) {
                        rect.setPosition(player.handSlots.get(i).x, player.handSlots.get(i).y);
                        //moveTo(player.handSlots.get(i).x, player.handSlots.get(i).y, 0.35f, 0.35f, 2);
                        player.handSlots.get(i).isEmpty = false;
                        handSlotUsed = i;
                        for (playerCard pc : player.cards) {
                            if (pc.cardInHand && pc != this && player.handSlots.get(pc.handSlotUsed).priority < player.handSlots.get(handSlotUsed).priority)pc.alreadyInHand = false;
                        }
                        alreadyInHand = true;
                    }
                }

                cardFront.setPosition(rect.x, rect.y);
                cardBack.setPosition(rect.x, rect.y);
                if (!cardChoosed) {
                    cardFront.setSize(cardFront.getWidth() * 0.35f, cardFront.getHeight() * 0.35f);
                    cardBack.setSize(cardBack.getWidth() * 0.35f, cardBack.getHeight() * 0.35f);
                } else {
                    cardFront.setSize(cardFront.getWidth(), cardFront.getHeight());
                    cardBack.setSize(cardBack.getWidth() * 0.35f, cardBack.getHeight() * 0.35f);
                    if (!player.isPlayerOnTop) {
                        rect.setPosition(20, 1060 - 750);
                        cardFront.setPosition(rect.x, rect.y);
                    } else {
                        rect.setPosition(1400, 20);
                        cardFront.setPosition(rect.x, rect.y);
                    }
                }
            } else {
                cardFront = new Sprite(cardFrontText, (currentHP-1) * 500, 0, 500, 750);
                cardBack = new Sprite(cardBackText, 0, 0, 500, 750);
                for (int i = 0; i < 4; i++) {
                    if (player.tableSlots.get(i).isEmpty && !alreadyOnTable) {
                        rect.setPosition(player.tableSlots.get(i).x, player.tableSlots.get(i).y);
                        //moveTo(player.tableSlots.get(i).x, player.tableSlots.get(i).y, 0.3F, 0.35f, 2);
                        player.tableSlots.get(i).isEmpty = false;
                        alreadyOnTable = true;
                        tableSlotUsed = i;
                        player.handSlots.get(handSlotUsed).isEmpty = true;
                        for (playerCard pc : player.cards) {
                            pc.alreadyInHand = false;
                        }
                    }
                }
                cardFront.setPosition(rect.x, rect.y);
                if (!cardChoosed) {
                    cardFront.setSize(cardFront.getWidth() * 0.3F, cardFront.getHeight() * 0.3F);
                    cardBack.setSize(cardBack.getWidth() * 0.3F, cardBack.getHeight() * 0.3F);
                } else {
                    cardFront.setSize(cardFront.getWidth(), cardFront.getHeight());
                    cardBack.setSize(cardBack.getWidth() * 0.3F, cardBack.getHeight() * 0.3F);
                    if (!player.isPlayerOnTop) {
                        rect.setPosition(20, 1060 - 750);
                        cardFront.setPosition(rect.x, rect.y);
                    } else {
                        rect.setPosition(1400, 20);
                        cardFront.setPosition(rect.x, rect.y);
                    }
                }

                cardBack.setPosition(rect.x, rect.y);
            }
        } else if (isAnimActive) {
            rect.setPosition(dx == 1 ? rect.x - pixelsX : rect.x + pixelsX, dy == 1 ? rect.y - pixelsY : rect.y + pixelsY);
            cardFront.setPosition(rect.x, rect.y);
            //cardFront.setSize(cardFront.getWidth() * (dScale==1?startScale-pixelsScale:startScale+pixelsScale), cardFront.getHeight() * (dScale==1?startScale+pixelsScale:startScale-pixelsScale));
            //if(dScale == 1) startScale-= pixelsScale;
            //else startScale+=pixelsScale;
            if (rect.x > endX - 1 && rect.x < endX + 1) {
                isAnimActive = false;
            }
        }

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        float period = 0.5f;
        if (timeSeconds > period) {
            timeSeconds = 0f;
            isCardActive = true;
        }
        if ((player.isPlayerActive && cardAlive) || (alreadyOnTable && cardAlive)) cardFront.draw(batch, 1);
        else cardBack.draw(batch);
        /*if(isHitting){
            timeSeconds2 += Gdx.graphics.getRawDeltaTime();
            if(timeSeconds2 > 0.5){
                isHitting = false;
            }

            if(timeSeconds2>0.001)hitSprite = new Sprite(hitTexture, 0, 0, 512, 512);
            if(timeSeconds2>0.05)hitSprite = new Sprite(hitTexture, 512, 0, 512, 512);
            if(timeSeconds2>0.10)hitSprite = new Sprite(hitTexture, 512*2, 0, 512, 512);
            if(timeSeconds2>0.15)hitSprite = new Sprite(hitTexture, 512*3, 0, 512, 512);
            if(timeSeconds2>0.20)hitSprite = new Sprite(hitTexture, 512*4, 0, 512, 512);
            if(timeSeconds2>0.25)hitSprite = new Sprite(hitTexture, 512*5, 0, 512, 512);
            if(timeSeconds2>0.30)hitSprite = new Sprite(hitTexture, 512*6, 0, 512, 512);
            if(timeSeconds2>0.35)hitSprite = new Sprite(hitTexture, 512*7, 0, 512, 512);
            if(timeSeconds2>0.40)hitSprite = new Sprite(hitTexture, 512*8, 0, 512, 512);
            if(timeSeconds2>0.45)hitSprite = new Sprite(hitTexture, 512*9, 0, 512, 512);
            hitSprite.setPosition(rect.x-37, rect.y);
            hitSprite.setScale(0.5f);
            hitSprite.draw(batch);
        }*/
        font.setColor(Color.WHITE);
        font.getData().setScale(6);
        if(cardChoosed && !player.isPlayerOnTop && cardInHand) font.draw(batch, cardName, 750, 970);
        if(cardChoosed && player.isPlayerOnTop && cardInHand) font.draw(batch, cardName, 750, 145);
        if(cardChoosed && cardInHand) ChoosedField.draw(batch);
        if(firstRender){
            cardInHand = true;
            alreadyOnTable = false;
            firstRender = false;
        }
    }

    void moveTo(float endX, float endY, float endScale, float currentScale, float seconds){
        this.endX = endX;
        this.endY = endY;
        this.timeAnim = seconds;
        isAnimActive = true;
        float tmpX = rect.x-endX;
        float tmpY = rect.y-endY;
        if(tmpX < 0) dx = -1;
        else dx = 1;
        if(tmpY < 0) dy = -1;
        else dy = 1;
        pixelsX = Math.abs(tmpX) / (Gdx.graphics.getFramesPerSecond() * seconds);
        pixelsY = Math.abs(tmpY) / (Gdx.graphics.getFramesPerSecond() * seconds);
        this.endScale = endScale;
        startScale = currentScale;
        float tmpScale = endScale-currentScale;
        if(tmpScale < 0) dScale = -1;
        else dScale = 1;
        pixelsScale = Math.abs(tmpScale) / (Gdx.graphics.getFramesPerSecond() * seconds);
    }

    void setDefaultPosition(Player player){
        if(cardInHand) {
            rect.setPosition(player.handSlots.get(handSlotUsed).x, player.handSlots.get(handSlotUsed).y);
        }
        else{
            rect.setPosition(player.tableSlots.get(tableSlotUsed).x, player.tableSlots.get(tableSlotUsed).y);
        }
    }

    void death(){
        cardAlive = false;
        hitSound.play(100);
    }
    void damage(int dmg){
        currentHP -= dmg;
        if(currentHP < 1) this.death();
        hitSound.play(100);
        isHitting= true;
    }
    int getCurrentHP(){
        return currentHP;
    }
    int getMP(){
        return MP;
    }
    int getSP(){
        return SP;
    }
    int getAP(){
        return AP;
    }
    float getPosX(){
        return rect.x;
    }
    float getPosY(){
        return rect.y;
    }
}
