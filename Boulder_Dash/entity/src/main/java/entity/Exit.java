package entity;

/**
 * The Class Exit.
 *
 * Defines exits parameters
 *
 * @author Antony FOUDA
 * @since 19-05-2020
 */


public class Exit extends Factory{

    /**
     * Defines Exit as a Factory object.
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

    public Exit(final String name, final Boolean state, final Boolean collectibility, final Boolean destructibility, final Boolean permeability, final FallingReaction reaction){
        super(name, state, collectibility, destructibility, permeability, reaction);
    }
}