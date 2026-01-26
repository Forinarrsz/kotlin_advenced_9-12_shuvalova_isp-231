package GameCharacter
class GameCharacter(val name: String) {
    var currentState: CharacterState = CharacterState.Idle

    fun changeState(newState: CharacterState) {
        currentState = newState
    }
}
fun processState(state: CharacterState) {
    when (state) {
        is CharacterState.Idle -> println("Персонаж бездействует")
        is CharacterState.Running -> println("Персонаж бежит")
        is CharacterState.Attack -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.Death -> println("Персонаж погиб: ${state.reason}")
    }
}