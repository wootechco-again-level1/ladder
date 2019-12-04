import domain.LadderGame;
import domain.user.User;
import presentation.LadderController;
import view.InputView;
import view.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        LadderGame ladderGame = LadderController.play(
                InputView.inputNames(),
                InputView.inputResults(),
                InputView.inputHeight()
        );

        OutputView.printUsers(ladderGame.getUsers());
        OutputView.printLadder(ladderGame.getLadder());
        OutputView.printResults(ladderGame.getResults());

        outputResult(ladderGame);
    }

    private static void outputResult(final LadderGame ladderGame) {
        String name;
        do {
            name = InputView.inputResultOfUser();
            OutputView.outputResult(name, ladderGame.result());
        } while (!name.equals(User.ALL));
    }
}
