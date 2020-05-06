import java.util.Iterator;

public class T_Iterator<T> implements Iterator<T> {
    Position<T> position;

    T_Iterator(Position<T> start) {
        this.position = start;
    }

    @Override
    public T next() {
        Position<T> t = position;
        position = position.after();
        return t.value();
    }

    @Override
    public boolean hasNext() {
        return position != null;
    }
}