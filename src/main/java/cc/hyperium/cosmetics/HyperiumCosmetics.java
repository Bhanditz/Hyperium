package cc.hyperium.cosmetics;

import cc.hyperium.cosmetics.backpack.EnderDragonBackpack;
import cc.hyperium.cosmetics.wings.WingsCosmetic;
import cc.hyperium.event.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mitchellkatz on 3/17/18. Designed for production use on Sk1er.club
 */
public class HyperiumCosmetics {

    private final ChromaWinCosmetic chromaWin;
    private final List<AbstractCosmetic> cosmeticList = new ArrayList<>();
    private final FlipCosmetic flipCosmetic;
    private final Deadmau5Cosmetic deadmau5Cosmetic;
    private final WingsCosmetic wingsCosmetic;
    private final DragonCosmetic dragonCosmetic;
    private final ButtCosmetic buttCosmetic;
    private final KillCounterMuscles killCounterMuscles;
    private EnderDragonBackpack enderDragonBackpack;
    private DragonCompanion dragonCompanion;

    /**
     * Hyperium Cosmetics - Default Constructor/Cosmetic Registry
     */
    public HyperiumCosmetics() {
        registerCosmetic(killCounterMuscles = new KillCounterMuscles());
        registerCosmetic(chromaWin = new ChromaWinCosmetic());
        registerCosmetic(buttCosmetic = new ButtCosmetic());
        registerCosmetic(flipCosmetic = new FlipCosmetic());
        registerCosmetic(deadmau5Cosmetic = new Deadmau5Cosmetic());
        registerCosmetic(wingsCosmetic = new WingsCosmetic());
        registerCosmetic(dragonCosmetic = new DragonCosmetic());
        registerCosmetic(enderDragonBackpack = new EnderDragonBackpack());
        registerCosmetic(dragonCompanion = new DragonCompanion());
    }

    public List<AbstractCosmetic> getCosmeticList() {
        return cosmeticList;
    }

    public KillCounterMuscles getKillCounterMuscles() {
        return killCounterMuscles;
    }

    public EnderDragonBackpack getEnderDragonBackpack() {
        return enderDragonBackpack;
    }

    public DragonCompanion getDragonCompanion() {
        return dragonCompanion;
    }

    /**
     * Register Cosmetic - Register a Cosmetic Class
     *
     * @param cosmetic - Given Cosmetic Class
     */
    private void registerCosmetic(AbstractCosmetic cosmetic) {
        cosmeticList.add(cosmetic);
        EventBus.INSTANCE.register(cosmetic);
    }

    /**
     * Get Cosmetic - Get a specific cosmetic from Enum Value
     *
     * @param givenType - Given Cosmetic Enum
     * @return - Given Abstract Cosmetic Class
     */
    public AbstractCosmetic getCosmetic(EnumCosmeticType givenType) {

        switch (givenType) {

            case CHROMA_WIN:
                return this.chromaWin;
            case BUTT:
                return this.buttCosmetic;
            case FLIP:
                return this.flipCosmetic;
            case DEADMAU5:
                return this.deadmau5Cosmetic;
            case WINGS:
                return this.wingsCosmetic;
            case DRAGON:
                return this.dragonCosmetic;
            default:
                return null;

        }

    }

    public ButtCosmetic getButtCosmetic() {
        return this.buttCosmetic;
    }

    public DragonCosmetic getDragonCosmetic() {
        return this.dragonCosmetic;
    }


    public ChromaWinCosmetic getChromaWin() {
        return this.chromaWin;
    }

    public FlipCosmetic getFlipCosmetic() {
        return this.flipCosmetic;
    }

    public Deadmau5Cosmetic getDeadmau5Cosmetic() {
        return this.deadmau5Cosmetic;
    }

    public WingsCosmetic getWingsCosmetic() {
        return this.wingsCosmetic;
    }

    public KillCounterMuscles getKillCounterMusclesCosmetic() {
        return this.killCounterMuscles;
    }

    /**
     * EnumCosmeticType - Used to distinguish cosmetics
     * and their types
     */
    public enum EnumCosmeticType {

        DAB,
        CHROMA_WIN,
        BUTT,
        FLIP,
        DEALWITHIT,
        DEADMAU5,
        WINGS,
        DRAGON

    }
}
