package domain.ladder;

import java.util.List;

public class LadderLine {
    private final List<LadderBridge> ladderBridges;

    public LadderLine(final List<LadderBridge> ladderBridges) {
        this.ladderBridges = ladderBridges;
    }

    public boolean canMoveRight(final int width) {
        return ladderBridges.get(width).canMoveRight();
    }

    public int width() {
        return ladderBridges.size();
    }

    public LadderBridge get(final int index) {
        return ladderBridges.get(index);
    }

    public boolean isLastPosition(final int position) {
        return width() == position;
    }

    @Override
    public String toString() {
        return "LadderLine{" + "ladderBridges=" + ladderBridges + '}';
    }
}
