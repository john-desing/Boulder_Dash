package entity;

/**
 * The Class Rock.
 *
 * Defines rocks parameters
 *
 * @author Antony FOUDA
 * @since 19-05-2020
 */

public class Rock extends Factory{

    /**
     * Defines Rock as a Factory object
     *
     * @param name
     *          the sprite's name
     * @param state
     *          isFalling or not
     * @param collectibility
     *          isCollectable or not(diamonds)
     * @param destructibility
     *          isDestructible or not
     * @param permeability
     *          isDiggable or not
     * @param reaction
     *          Reaction to falling object
     */

    public Rock(final String name, final Boolean state, final Boolean collectibility, final Boolean destructibility, final Boolean permeability, final FallingReaction reaction){
        super(name, state, collectibility, destructibility, permeability, reaction);
    }
}



