package racingCar.domain;

import java.util.Objects;

public class Position {
    private static int DEFAULT_POSITION = 0;
    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상의 값이어야 합니다.");
        }
        this.position = position;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
