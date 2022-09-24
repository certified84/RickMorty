package com.certified.rickmorty.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.certified.rickmorty.R
import com.certified.rickmorty.data.model.Character
import com.certified.rickmorty.ui.theme.Primary

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun ItemCharacter(character: Character, onClick: (() -> Unit)? = null, onLongClick: (() -> Unit)? = null) {

    var expand = remember { mutableStateOf(false) }
    var details by remember { mutableStateOf(false) }

    Surface(
        color = Primary,
        onClick = {
            expand.value = !expand.value
            Log.d("TAG", "ItemCharacter: Expand: ${expand.value}")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
            .clip(RoundedCornerShape(24.dp))
//            .combinedClickable(
//                onClick = onClick,
//                onLongClick = { Log.d("TAG", "ItemCharacter: Show dialog") }
//            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
//                .padding(all = 8.dp)
//                .clip(RoundedCornerShape(8.dp)),
        ) {

            AsyncImage(
                model = character.image, contentDescription = "Character Image",
                placeholder = painterResource(id = R.drawable.place_holder),
                modifier = Modifier
//                    .height(145.dp)
                    .fillMaxWidth()
//                    .padding(all = 8.dp)
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            )

            if (expand.value) {

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = character.name, fontSize = 24.sp, fontWeight = FontWeight.Bold,
//                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "${character.gender} - ${character.status}",
                    fontSize = 14.sp,
//                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun ItemCharacterPreview() {
    ItemCharacter(character = Character(), {

    }) {

    }
}