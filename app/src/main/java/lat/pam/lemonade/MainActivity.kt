package lat.pam.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import lat.pam.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GettingLemonade(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}

@Composable
fun GettingLemonade(modifier: Modifier = Modifier) {
    // Menggunakan array drawable dan string untuk gambar dan deskripsi
    val imageList = intArrayOf(R.drawable.lemon_tree, R.drawable.lemon_squeeze, R.drawable.lemon_drink, R.drawable.lemon_restart)
    val descList = arrayOf(
        stringResource(R.string.tap_lemon_tree),
        stringResource(R.string.tap_lemon),
        stringResource(R.string.tap_lemonade),
        stringResource(R.string.tap_empty_glass)
    )

    // Menyimpan nilai iteration untuk memantau urutan
    var iteration by remember { mutableStateOf(0) }

    // Fungsi untuk menangani klik
    fun onClick() {
        iteration = (iteration + 1) % imageList.size
    }

    Column(
        modifier = modifier.wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageList[iteration]),
            contentDescription = descList[iteration],
            modifier = Modifier.clickable { onClick() }
        )

        Text(
            text = descList[iteration]
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun GettingLemonadePreview() {
    GettingLemonade(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}
