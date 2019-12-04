package domain.user;

import domain.ladder.LadderLine;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private List<User> users;

    public Users(final List<User> users) {
        this.users = users;
    }

    public int size() {
        return users.size();
    }

    public Users move(final LadderLine ladderLine) {
        return new Users(
                Collections.unmodifiableList(users.stream()
                        .map(user -> user.move(ladderLine))
                        .collect(Collectors.toList())
        ));
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(users.stream()
                .map(User::getName)
                .collect(Collectors.toList())
        );
    }

    public List<Integer> getPositions() {
        return Collections.unmodifiableList(users.stream()
                .map(User::getPosition)
                .collect(Collectors.toList())
        );
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public String toString() {
        return "Users{" + "users=" + users + '}';
    }
}