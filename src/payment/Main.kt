package payment

fun main() {
    val processor = PaymentProcessor()
    val payments = listOf(
        Payment("4111111111111111", 1000, CardType.VISA),
        Payment("5111111111111111", 2000, CardType.MASTERCARD),
        Payment("2222222222222222", 1500, CardType.MIR),
        Payment("1234567812345678", 4000, CardType.UNKNOWN),
        Payment("12345", 1000, CardType.VISA)

    )
    println("~~~обработка платежей~~~")
    payments.forEach {
        payment -> println("\nплатеж ${payment.type}: ${payment.card.take(4)}..., ${payment.sum} rub")
        val result = processor.pay(payment)
        processor.show(result)
    }

    println("\n===работа с enum===")
    val cardType = CardType.VISA
    println("card type: $cardType")
    println("number: ${cardType.ordinal}")
    println("all types: ${CardType.values().joinToString()}")

    val payment1 = Payment("4111111111111111", 1000, CardType.VISA)
    val payment2 = payment1.copy(type = CardType.MASTERCARD, sum = 2000)

    println("\n===сравнение data class===")
    println("payment 1: $payment1")
    println("payment 2: $payment2")
    println("сравнение: ${payment1 == payment2}")
}