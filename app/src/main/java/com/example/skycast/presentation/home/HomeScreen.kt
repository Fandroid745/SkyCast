import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skycast.presentation.home.HomeForecastState
import com.example.skycast.presentation.home.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state
    var city by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Enter city name") }
        )

        Button(onClick = { viewModel.loadForecast(city) }) {
            Text("Get Forecast")
        }

        when (val currentState = state) {
            is HomeForecastState.Loading -> {
                CircularProgressIndicator()
            }

            is HomeForecastState.Success -> {
                val forecast = currentState.forecast
                Text("City: ${forecast.cityName}")
                Text("Temperature: ${forecast.temperature}°C")
                Text("Condition: ${forecast.description}")
            }

            is HomeForecastState.Error -> {
                val message = currentState.message
                Text(
                    text = "Error: $message",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}