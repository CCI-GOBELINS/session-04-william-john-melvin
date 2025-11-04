import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScoreViewModel : ViewMode() {

    private val _scoreA: MutableStateFlow<Int> = MutableStateFlow(value = 0)
    val scoreA: StateFlow<Int> = _scoreA

    private val _scoreB: MutableStateFlow<Int> = MutableStateFlow(value = 0)
    val scoreB: StateFlow<Int> = _scoreB

    fun updateScore(newScore: Int) {
        _scoreA.value += newScore
    }

    fun updateScoreB(newScore: Int) {
        _scoreB.value
    }
}