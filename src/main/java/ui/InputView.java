package ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    public List<String> insertCars() {
        String namesInput = Console.readLine();
        isNotContainingComma(namesInput);
        isContainingBlack(namesInput);

        List<String> names = Arrays.stream(namesInput.split(",")).collect(Collectors.toList());
        isSingleCar(names);
        isNotValidNameLength(names);
        return names;
    }

    public int insertAttempts() {
        return 0;
    }

    private void isNotContainingComma(String namesInput) {
        if (!namesInput.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 각 자동차의 입력은 쉼표(,) 로 구분되어야 합니다.");
        }
    }

    private void isContainingBlack(String namesInput) {
        if (namesInput.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름 입력값에는 공백이 포함되지 않아야 합니다.");
        }
    }

    private void isSingleCar(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 경주 게임에서 2개 이상의 자동차의 이름이 입력되어야 합니다.");
        }
    }

    private void isNotValidNameLength(List<String> names) {
        boolean isValidNameLength = names.stream()
                .allMatch(name -> name.length() <= MAXIMUM_NAME_LENGTH);
        if (!isValidNameLength) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하로 입력해야 합니다.");
        }
    }

    private void isNotNumeral() {

    }
}
