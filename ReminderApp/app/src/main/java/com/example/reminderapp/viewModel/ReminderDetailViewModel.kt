package com.example.reminderapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.reminderapp.Reminder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReminderDetailViewModel : ViewModel(){
    private val _reminder : MutableStateFlow<Reminder?> = MutableStateFlow(null)
    val reminder : StateFlow<Reminder?> = _reminder
    fun setReminder(reminder: Reminder) {
        _reminder.value = reminder
    }


}

