package engine;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

    private int value;
    private static Map<Integer, Direction> map = new HashMap<>();

    Direction(int value) {
        this.value = value;
    }

    static {
        for (Direction direction : Direction.values()) {
            map.put(direction.value, direction);
        }
    }

    public static Direction valueOf(int direction) {
        return map.get(direction);
    }

    public int getValue() {
        return value;
    }
}
