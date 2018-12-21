package eu.iamgio.pokedex.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The category of items an item falls into
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum ItemCategory {

    STAT_BOOSTS(1),
    EFFORT_DROP(2),
    MEDICINE(3),
    OTHER(4),
    IN_A_PINCH(5),
    PICKY_HEALING(6),
    TYPE_PROTECTION(7),
    BAKING_ONLY(8),
    COLLECTIBLES(9),
    EVOLUTION(10),
    SPELUNKING(11),
    HELD_ITEMS(12),
    CHOICE(13),
    EFFORT_TRAINING(14),
    BAD_HELD_ITEMS(15),
    TRAINING(16),
    PLATES(17),
    SPECIES_SPECIFIC(18),
    TYPE_ENHANCEMENT(19),
    EVENT_ITEMS(20),
    GAMEPLAY(21),
    PLOT_ADVANCEMENT(22),
    UNUSED(23),
    LOOT(24),
    ALL_MAIL(25),
    VITAMINS(26),
    HEALING(27),
    PP_RECOVERY(28),
    REVIVAL(29),
    STATUS_CURES(30),
    MULCH(31),
    SPECIAL_BALLS(32),
    STANDARD_BALLS(33),
    DEX_COMPLETION(34),
    SCARVES(35),
    ALL_MACHINES(36),
    FLUTES(37),
    APRICORN_BALLS(38),
    APRICORN_BOX(39),
    DATA_CARDS(40),
    JEWELS(41),
    MIRACLE_SHOOTER(42),
    MEGA_STONES(43),
    MEMORIES(44),
    Z_CRYSTALS(45);

    /**
     * The identifier for this resource
     */
    private int id;
}
