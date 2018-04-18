package bean;

/**
 * 坐标
 * @author sjf0115
 * @Date Created in 下午4:39 17-10-30
 */
public class Coordinate {

    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    public double x;
    public double y;
    public double z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate() {
        this(0.0D, 0.0D);
    }

    public Coordinate(double x, double y) {
        this(x, y, 0.0D / 0.0);
    }


}
