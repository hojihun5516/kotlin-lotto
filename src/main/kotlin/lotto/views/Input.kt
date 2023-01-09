package lotto.views

import lotto.LottoNumber
import lotto.LottoNumbers

object Input {
    fun getPriceForBuying(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("It is not a number")
    }

    fun getWinnerLottoNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readLine()?.split(",")?.map { LottoNumber(it.toInt()) }
            ?: throw IllegalArgumentException("It is not a number")
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException("It must be a 6 numbers without duplication")
        }
        return LottoNumbers(numbers)
    }

    fun getBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readLine()?.toIntOrNull() ?: throw IllegalArgumentException("It is not a number"))
    }
}
