package com.n1cks.starwarstest.features.peoplelist.ui.item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.n1cks.starwarstest.core.domain.model.Person

@Composable
fun PersonItem(
    person: Person,
    onPersonClick: () -> Unit
) {
    Card(
        onClick = onPersonClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 12.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFB0B0B0)),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            Text(
                text = person.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3F51B5)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Height: ${person.height} cm, Mass: ${person.mass} kg, " +
                        "Hair: ${person.hairColor}, Eyes: ${person.eyeColor}",
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}