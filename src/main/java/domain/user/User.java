package domain.user;

import domain.ladder.LadderLine;
import domain.user.exception.InvalidNameException;
import domain.user.exception.InvalidNameLengthException;

import java.util.Objects;

public class User {
    public static final String ALL = "all";
    private static final int NAME_LENGTH_CONDITION = 5;

    private final String name;
    private final int position;

    public User(final String name, final int position) {
        validName(name);
        validNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void validName(final String name) {
        if (ALL.equals(name)) {
            throw new InvalidNameException();
        }
    }

    private void validNameLength(final String name) {
        if (name.length() > NAME_LENGTH_CONDITION) {
            throw new InvalidNameLengthException();
        }
    }

    public User move(final LadderLine ladderLine) {
        if (ladderLine.isLastPosition(position)) {
            return new User(name, position + ladderLine.get(position - 1).move());
        }

        return new User(name, position + ladderLine.get(position).move());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return position == user.position && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", position=" + position + '}';
    }
}
