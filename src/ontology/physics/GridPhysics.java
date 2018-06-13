package ontology.physics;

import core.VGDLSprite;
import tools.Vector2d;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Diego
 * Date: 17/10/13
 * Time: 11:21
 * This is a Java port from Tom Schaul's VGDL - https://github.com/schaul/py-vgdl
 */
public class GridPhysics implements Physics {

    /**
     * Size of the grid.
     */
    public Dimension gridsize;

    /**
     * Default constructor, gridsize will be 10x10
     */
    public GridPhysics() {
        this.gridsize = new Dimension(10, 10);
    }

    /**
     * Constructor of the physics, specifying the gridsize
     *
     * @param gridsize Size of the grid.
     */
    public GridPhysics(Dimension gridsize) {
        this.gridsize = gridsize;
    }

    @Override
    public void passiveMovement(VGDLSprite sprite) {
        double speed;
        if (sprite.speed == -1)
            speed = 1;
        else
            speed = sprite.speed;

        if (speed != 0 && sprite.is_oriented) {
            sprite._updatePos(sprite.orientation, (int) (speed * this.gridsize.width));
        }
    }

    @Override
    public void activeMovement(VGDLSprite sprite, Vector2d action, double speed) {
        if (speed == 0) {
            if (sprite.speed == 0)
                speed = 1;
            else
                speed = sprite.speed;
        }

        if (speed != 0 && action != null) {
            sprite._updatePos(action, (int) (speed * this.gridsize.width));
        }
    }

    /**
     * Hamming distance between two rectangles.
     *
     * @param r1 rectangle 1
     * @param r2 rectangle 2
     * @return Hamming distance between the top-left corner of the rectangles.
     */
    public double distance(Rectangle r1, Rectangle r2) {
        return Math.abs(r1.getMinY() - r2.getMinY()) +
                Math.abs(r1.getMinX() - r2.getMinX());
    }
}
