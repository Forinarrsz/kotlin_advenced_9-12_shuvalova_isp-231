package payment

fun main() {
    val processor = PaymentProcessor()
    val payments = listOf(
        Payment("4_111_111_111_111_111", 1000, CardType.VISA),
        Payment("5_111_111_111_111_111", 2000, CardType.MASTERCARD),
        Payment("4_222_222_222_222_222", 1500, CardType.MIR),
        Payment("1234567812345678", 4000, CardType.UNKNOWN),
        Payment("12345", 1000, CardType.VISA)

    )
    println("~~~бработка платежей~~~")
    payments.forEach {
        payment -> println("\nлатеж ${payment.type}: ${payment.card.take(4)}...,${payment.sum} rub")
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