package towers;

public abstract class Path {
	Position [] path;
	
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
