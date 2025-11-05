package data.repository
import com.example.reminderapp.Reminder
import com.example.reminderapp.database.ReminderDatabase
import kotlinx.coroutines.flow.Flow import kotlinx.coroutines.flow.flow
class ReminderRepository(val database: ReminderDatabase) {

    suspend fun getAllScores(): Flow<List<Reminder>> = flow{
        val scores: List<Reminder> = database.reminderDao().getAllScores()
        emit ( value = scores)
    }
    suspend fun save(reminder: Reminder): Flow<Reminder> = flow {
        reminder.reminderDao().save(reminder)
        emit (value = reminder)
    }

    companion object {
        @Volatile
        private var _inst: ReminderRepository? = null
            val instance: ReminderRepository
                get() = _inst!!

        fun getInstance(): ReminderRepository {
            return _inst ?: synchronized(lock = this) {
                val instance = ReminderRepository(ReminderDatabase.instance)
                _inst = instance
                instance
            }
        }
    }
}