package data.repository
import com.example.reminderapp.Reminder
import com.example.reminderapp.database.ReminderDatabase
import kotlinx.coroutines.flow.Flow import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReminderRepository @Inject constructor
    (val database: ReminderDatabase) {

    suspend fun getAllReminders(): Flow<List<Reminder>> = flow{
        val scores: List<Reminder> = database.reminderDao().getAllReminders()
        emit ( value = scores)
    }
    suspend fun insert(reminder: Reminder): Flow<Reminder> = flow {
        database.reminderDao().insertReminder(reminder)
        emit (value = reminder)
    }

    companion object {
        @Volatile
        private var _inst: ReminderRepository? = null

        val instance: ReminderRepository
            get() = _inst!!

        fun initRepository(): ReminderRepository {
            return _inst ?: synchronized(lock = this) {
                val instance = ReminderRepository(ReminderDatabase.instance)
                _inst = instance
                instance
            }
        }
    }
}