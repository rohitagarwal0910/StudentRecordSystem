import java.util.Iterator;

public class P_iterator<T> implements Iterator<Position_<T>> {
    Position<T> position = null;

    P_iterator(Position<T> start) {
        this.position = start;
    }

    @Override
    public Position_<T> next() {
        Position<T> t = position;
        position = position.after();
        return t;
    }

    @Override
    public boolean hasNext() {
        return position != null;
    }
}