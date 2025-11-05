package com.example.reminderapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reminderapp.Data
import com.example.reminderapp.Reminder
import dagger.hilt.android.lifecycle.HiltViewModel
import data.repository.ReminderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(private val repository: ReminderRepository) : ViewModel() {
    private val _reminders: MutableStateFlow<List<Reminder>> = MutableStateFlow(emptyList())
    val reminders: StateFlow<List<Reminder>> = _reminders
    fun toggleCompletion(reminder: Reminder) {
        val index = Data.reminders.indexOfFirst { it.id == reminder.id }
        if (index != -1) {
            Data.reminders[index] = reminder.copy(completed = !reminder.completed)
        }
    }

    fun allReminders (){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllReminders().collect { reminders -> _reminders.value = reminders }
        }
    }

    fun add(reminder: Reminder){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(reminder).collect { allReminders() }
        }

    }
}



