package entity;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */
public class Map extends Entity {

    /** The id. */
    private final int id;
    
    /** The label. */
    private final String label;
    
    /** The width. */
    private final int width;
    
    /** The height. */
    private final int height;
    
    /** The diamond number for win. */
    private final int diamondNumberForWin;
    
    /** The filling maps. */
    private final ArrayList<FillingMap> fillingMaps = new ArrayList<FillingMap>();

    /**
     * Instantiates a new map.
     *
     * @param id the id
     * @param label the label
     * @param width the width
     * @param height the height
     * @param diamondNumberForWin the diamond number for win
     */
    public Map(final int id, final String label, final int width, final int height, final int diamondNumberForWin) {
        this.id = id;
        this.label = label;
        this.width = width;
        this.height = height;
        this.diamondNumberForWin = diamondNumberForWin;
    }

    /**
     * Adds the.
     *
     * @param fillingMap the filling map
     */
    public void add(final FillingMap fillingMap) {
        this.fillingMaps.add(fillingMap);
    }

    /**
     * Gets the diamond number for win.
     *
     * @return the diamond number for win
     */
    public int getDiamondNumberForWin() {
        return this.diamondNumberForWin;
    }

    /**
     * Gets the element label.
     *
     * @return the element label
     */
    public String getelementLabel() {
        return this.label;
    }

    /**
     * Gets the filling maps.
     *
     * @return the filling maps
     */
    public ArrayList<FillingMap> getFillingMaps() {
        return this.fillingMaps;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    public int getWidth() {
        return this.width;
    }

}