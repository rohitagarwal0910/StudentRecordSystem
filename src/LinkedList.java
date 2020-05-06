import java.util.Iterator;

public class LinkedList<T> implements LinkedList_<T> {
    Position<T> first_position = null;
    int length = 0;

    @Override
    public Position<T> add(T e) {
        length++;
        first_position = new Position<T>(e, first_position);
        return first_position;
    }

    @Override
    public Iterator<Position_<T>> positions() {
        return new P_iterator<T>(first_position);
    }

    public Iterator<T> values() {
        return new T_Iterator<T>(first_position);
    }

    @Override
    public int count() {
        return length;
    }
}