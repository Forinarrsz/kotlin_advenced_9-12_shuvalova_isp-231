package GameCharacter

fun main() {
    val character = GameCharacter("Герой")

    character.changeState(CharacterState.Running)
    processState(character.currentState)

    character.changeState(CharacterState.Attack(20))
    processState(character.currentState)

    character.changeState(CharacterState.Death("получил смертельную рану"))
    processState(character.currentState)
}