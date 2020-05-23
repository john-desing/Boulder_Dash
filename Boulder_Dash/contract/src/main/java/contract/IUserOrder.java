package contract;

/**
 * The Interface IController.
 *
 * Shows methods other package need from UserOrder
 *
 * @author John Medy MBOKO
 * @since  19-05-2020
 */

public interface IUserOrder {

    /**
     * Gets the player
     *
     * @return the player
     */

    int getPlayer();

    /**
     * Gets the order
     *
     * @return the order
     */

    ControllerOrder getOrder();
}