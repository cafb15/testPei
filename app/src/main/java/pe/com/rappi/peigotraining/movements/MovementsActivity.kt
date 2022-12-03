package pe.com.rappi.peigotraining.movements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import pe.com.rappi.peigotraining.movements.ui.MovementsScreen
import pe.com.rappi.peigotraining.ui.theme.PeiGoTrainingTheme

class MovementsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            PeiGoTrainingTheme(
                statusBarColor = Color.Transparent
            ) {
                MovementsScreen()
            }
        }
    }
}