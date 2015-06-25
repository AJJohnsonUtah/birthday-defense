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

    public Position getPathPositionAtIndex(int index) {
        return path[index];
    }

    public Position getStart() {
        return path[0];
    }

    public Position getEnd() {
        return path[path.length - 1];
    }
    
    public PathPosition getNextPathPosition(PathPosition current) {
        PathPosition nextPosition = current;
        nextPosition.setPosition(path[current.getPathIndex() + 1]);
        nextPosition.incrementPathIndex();
        return nextPosition;
    }
    
    public boolean hasNextPathPosition(PathPosition current) {
        return current.getPathIndex() < path.length - 1;
    }
}
