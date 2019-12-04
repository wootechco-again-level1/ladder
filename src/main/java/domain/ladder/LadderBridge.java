package domain.ladder;

import domain.ladder.exception.DuplicateDirectionException;

import java.util.Objects;

public class LadderBridge {
    private static final int RIGHT_POSITION = 1;
    private static final int LEFT_POSITION = -1;
    private static final int DOWN_POSITION = 0;
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    private final boolean movableLeft;
    private final boolean movableRight;

    private LadderBridge(final boolean movableLeft, final boolean movableRight) {
        checkDuplicateDirection(movableLeft, movableRight);
        this.movableLeft = movableLeft;
        this.movableRight = movableRight;
    }

    private void checkDuplicateDirection(final boolean movableLeft, final boolean movableRight) {
        if (movableLeft && movableRight) {
            throw new DuplicateDirectionException();
        }
    }

    public static LadderBridge of(final boolean movableLeft, final boolean movableRight) {
        return new LadderBridge(movableLeft, movableRight);
    }

    public static LadderBridge first(final boolean movableRight) {
        return of(FALSE, movableRight);
    }

    public LadderBridge next(final boolean movableRight) {
        if (this.movableRight) {
            return of(TRUE, FALSE);
        }

        return of(FALSE, movableRight);
    }

    public LadderBridge last() {
        if (this.movableRight) {
            return of(TRUE, FALSE);
        }

        return of(FALSE, FALSE);
    }

    public int move() {
        if (movableRight) {
            return RIGHT_POSITION;
        }

        if (movableLeft) {
            return LEFT_POSITION;
        }

        return DOWN_POSITION;
    }

    public boolean canMoveRight() {
        return movableRight;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return TRUE;
        if (o == null || getClass() != o.getClass()) return FALSE;
        LadderBridge that = (LadderBridge) o;
        return Objects.equals(movableLeft, that.movableLeft) && Objects.equals(movableRight, that.movableRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movableLeft, movableRight);
    }

    @Override
    public String toString() {
        return "LadderBridge{" + "movableLeft=" + movableLeft + ", movableRight=" + movableRight + '}';
    }
}
