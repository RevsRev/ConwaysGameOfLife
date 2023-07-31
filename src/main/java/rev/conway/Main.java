package rev.conway;

import org.apache.commons.lang3.tuple.Pair;
import rev.pe.graph.canvas.Canvas;
import rev.pe.graph.graphable.Graphable;
import rev.pe.graph.graphable.impl.GraphableAxes;
import rev.pe.graph.graphics.GraphicsTransformative;
import rev.pe.graph.graphics.impl.GraphicsLinear;
import rev.pe.graph.ui.GraphFrame;
import rev.pe.graph.ui.GraphFrameUpdateRunnable;
import rev.pe.math.linear.vec.Vec2;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;

public class Main
{

    private static int WIDTH = 3600;
    private static int HEIGHT = 1800;

    public static void main(String[] args) {
        GraphicsTransformative graphicsT = new GraphicsLinear(new Vec2(1,0), new Vec2(0,1));

        ConwaysLife conwaysLife = new ConwaysLife(initialConfiguration());
        GraphableConwaysLife graphableConwaysLife = new GraphableConwaysLife(conwaysLife);

        Canvas canvas = new Canvas(graphicsT);
        canvas.setCanvasCalc(new Rectangle2D.Double(-200, -200, 400, 400));
        canvas.setCanvasWindow(new Rectangle2D.Double(-100,-100,200,200));
        canvas.addGraphable(graphableConwaysLife);

        Graphable axes = new GraphableAxes();
        axes.setColor(Color.LIGHT_GRAY);
        canvas.addGraphable(axes);

        GraphFrame frame = new GraphFrame(WIDTH, HEIGHT, canvas);

        GraphFrameUpdateRunnable.startGraphUpdateThread(frame);

        frame.setVisible(true);

    }

    public static Set<Pair<Integer,Integer>> initialConfiguration() {
        HashSet<Pair<Integer,Integer>> configuration = new HashSet<>();
        configuration.add(Pair.of(1,1));
        configuration.add(Pair.of(2,1));
        configuration.add(Pair.of(3,1));
        configuration.add(Pair.of(4,1));
        configuration.add(Pair.of(5,1));
        configuration.add(Pair.of(6,1));
        configuration.add(Pair.of(1,2));
        configuration.add(Pair.of(2,3));
        configuration.add(Pair.of(3,3));
        configuration.add(Pair.of(4,2));
        configuration.add(Pair.of(5,2));
        configuration.add(Pair.of(6,3));
        return configuration;
    }

}
