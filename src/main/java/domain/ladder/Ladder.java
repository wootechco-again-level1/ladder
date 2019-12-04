package domain.ladder;

import domain.ladder.exception.InvalidLadderHeightException;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 1;

    private final List<LadderLine> ladderLines;

    public Ladder(final List<LadderLine> ladderLines) {
        validHeight(ladderLines.size());
        this.ladderLines = ladderLines;
    }

    private void validHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new InvalidLadderHeightException();
        }
    }

    public int height() {
        return ladderLines.size();
    }

    public int width() {
        return ladderLines.iterator().next().width();
    }

    public boolean canMoveRight(final int height, final int width) {
        return ladderLines.get(height).canMoveRight(width);
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    @Override
    public String toString() {
        return "Ladder{" + "ladderLines=" + ladderLines + '}';
    }
}
