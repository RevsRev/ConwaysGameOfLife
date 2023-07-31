package rev.conway;

import org.apache.commons.lang3.tuple.Pair;
import rev.pe.graph.graphable.Graphable;
import rev.pe.graph.graphics.GraphicsTransformative;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.Set;

public class GraphableConwaysLife extends Graphable
{
    private final ConwaysLife cLife;

    public GraphableConwaysLife(ConwaysLife cLife) {
        this.cLife = cLife;
    }

    @Override
    public void paintImpl(GraphicsTransformative graphicsTransformative, Rectangle2D rectangle2D)
    {
        cLife.update();
        Set<Pair<Integer,Integer>> cells = cLife.getCells();
        Iterator<Pair<Integer,Integer>> it = cells.iterator();
        while (it.hasNext()) {
            Pair<Integer,Integer> cell = it.next();
            graphicsTransformative.fillRectangle(cell.getLeft(), cell.getRight(), 1, 1);
        }
    }
}
