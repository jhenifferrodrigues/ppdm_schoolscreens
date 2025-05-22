package com.example.ppdm_schoolscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ContactDetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDED))
    ) {
        // Parte azul
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .background(Color(0xFF758BF8)) // Altere essa cor conforme desejar
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Avatar
                Image(
                    painter = painterResource(id = R.drawable.avatar), // Substitua por sua imagem
                    contentDescription = "Avatar",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Nome e Cargo
                Text(
                    text = "Jenny Wilson",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Sr. UI/UX Designer",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }

            // Ícones de ação no rodapé da Box
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val actions = listOf(
                    Pair("Email", R.drawable.qmail),
                    Pair("Call", R.drawable.telefone),
                    Pair("Whatsapp", R.drawable.wpp),
                    Pair("Favorite", R.drawable.estrela)
                )

                actions.forEach { (label, icon) ->
                    ActionButton(label, icon, iconColor = Color.White, textColor = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sessões de informação
        InfoSection(title = "Email", items = listOf(
            "Official: michael.mitc@example.com",
            "Personal: michael@example.com"
        ))

        InfoSection(title = "Phone number", items = listOf("(209) 555-0104"))
        InfoSection(title = "Team", items = listOf("Project Operation Team"))
        InfoSection(title = "Leads by", items = listOf("Darrell Steward"))

        Spacer(modifier = Modifier.height(24.dp))

        // Botão final
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(50.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3347b0))
        ) {
            Text("Add to contact", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun ActionButton(label: String, iconRes: Int, iconColor: Color = Color.DarkGray, textColor: Color = Color.DarkGray) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(32.dp)
        )
        Text(label, fontSize = 12.sp, color = textColor)
    }
}

@Composable
fun InfoSection(title: String, items: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFF3347b0))
        items.forEach {
            Text(it, fontSize = 13.sp, color = Color.DarkGray)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ContactScreenPreview() {
    ContactDetailsScreen()
}