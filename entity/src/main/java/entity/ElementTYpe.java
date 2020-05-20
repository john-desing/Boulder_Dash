
package entity;

// TODO: Auto-generated Javadoc
/**
 * The Class ElementType.
 */
public class ElementType extends Entity {

    /** The element char. */
    private String elementChar;

    /**
     * Instantiates a new element type.
     *
     * @param elementChar the element char
     */
    public ElementType(final String elementChar) {
        this.setElementChar(elementChar);

    }

    /**
     * Gets the element char.
     *
     * @return the element char
     */
    public String getElementChar() {
        return this.elementChar;
    }

    /**
     * Sets the element char.
     *
     * @param elementChar the new element char
     */
    public void setElementChar(final String elementChar) {
        this.elementChar = elementChar;
    }
}
