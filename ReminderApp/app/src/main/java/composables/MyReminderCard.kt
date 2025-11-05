package composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.reminderapp.Data
import com.example.reminderapp.R
import com.example.reminderapp.Reminder
import com.example.reminderapp.viewModel.HomePageViewModel

@Composable
fun ReminderCard(
    reminder: Reminder,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val viewModel: HomePageViewModel = viewModel()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { viewModel.toggleCompletion(reminder) }
            .padding(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = reminder.completed,
                onClick = { viewModel.toggleCompletion(reminder) }
            )

            Text(
                text = reminder.name,
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_arrow_forward_icon),
                contentDescription = "Go to detail",
                modifier = Modifier
                    .padding(16.dp)
                    .size(35.dp)
                    .clickable { navController.navigate("detail/${reminder.id}") }
            )
        }
    }
}
