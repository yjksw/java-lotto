package lotto.domain.lotto;

public class InvalidLottoNumberException extends RuntimeException {
    public InvalidLottoNumberException(String message) {
        super(message);
    }
}
