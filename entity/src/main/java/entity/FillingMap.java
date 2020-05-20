package entity;

// TODO: Auto-generated Javadoc
/**
 * The Class FillingMap.
 */
public class FillingMap extends Entity {

    /** The x. */
    private int x;

    /** The y. */
    private int y;

    /** The element type. */
    private ElementType elementType;

    /**
     * Instantiates a new filling map.
     *
     * @param elementType the element type
     * @param x           the x coordinate.
     * @param y           the y coordinate.
     */
    public FillingMap(final ElementType elementType, final int x, final int y) {
        this.setElementType(elementType);
        this.setX(x);
        this.setY(y);
    }

    /**
     * Gets the element char.
     *
     * @return the element char
     */
    public String getElementChar() {
        return this.elementType.getElementChar();
    }

    /**
     * Gets the x coordinate.
     *
     * @return the x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the y coordinate.
     *
     * @return the y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the element type.
     *
     * @param elementType the new element type
     */
    public void setElementType(final ElementType elementType) {
        this.elementType = elementType;
    }

    /**
     * Sets the x coordinate.
     *
     * @param x the new x
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate.
     *
     * @param y the new y
     */
    public void setY(final int y) {
        this.y = y;
    }

}
