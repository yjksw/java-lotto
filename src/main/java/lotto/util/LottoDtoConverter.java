package lotto.util;

import lotto.dto.LottoDto;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDtoConverter {
    public LottoDto convertLottoToDto(final Lotto lotto) {
        List<String> numbers = lotto.getNumbers()
                .stream()
                .map(lottoNumber -> lottoNumber.toString())
                .collect(Collectors.toList());
        return LottoDto.of(numbers);
    }

    public List<Lotto> convertDtoToLottos(final List<LottoDto> lottos) {
        return lottos
                .stream()
                .map(this::convertDtoToLotto)
                .collect(Collectors.toList());
    }

    public Lotto convertDtoToLotto(final LottoDto dto) {
        List<LottoNumber> numbers = dto.getNumbers()
                .stream()
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return Lotto.of(numbers);
    }
}
