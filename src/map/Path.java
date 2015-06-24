package map;

import towers.Position;

public class Path {

    private Position[] path;

    public Path(MapType mapType) {
        switch (mapType) {
            case CAKE:
                path = new Position[]{new Position(0, 0),
                    new Position(100, 0),
                    new Position(100, 400),
                    new Position(400, 400)
                };
                break;
            case TABLE:
                break;
            default:
                path = null;
        }
    }

    Position[] getPath() {
        return path;
    }

    Position getStart() {
        return path[0];
    }

    Position getEnd() {
        return path[path.length - 1];
    }
}
