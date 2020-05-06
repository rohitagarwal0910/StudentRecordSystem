class Position<T> implements Position_<T> {
    T thing;
    Position<T> next;

    Position(T thing, Position<T> next) {
        this.thing = thing;
        this.next = next;
    }

    @Override
    public T value() {
        return thing;
    }

    @Override
    public Position<T> after() {
        return next;
    }
}