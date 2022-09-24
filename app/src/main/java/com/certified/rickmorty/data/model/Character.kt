package com.certified.rickmorty.data.model

/**The model class which represents a single character in the Rick and Morty series
* @param id        The id of the character.
* @param name      The name of the character.
* @param status    The status of the character (Alive, Dead or unknown).
* @param species   The species of the character.
* @param type      The type or subspecies of the character.
* @param gender    The gender of the character ('Female', 'Male', 'Genderless' or 'unknown').
* @param origin    Name and link to the character's origin location.
* @param location  Name and link to the character's last known location endpoint.
* @param image     Link to the character's image. All images are 300x300px and most are medium shots or portraits since they are intended to be used as avatars.
* @param episode   List of episodes in which this character appeared.
* @param url       Link to the character's own URL endpoint.
* @param created   Time at which the character was created in the database.
* */

data class Character(
    val id: Int = -1,
    val name: String = "Crazy Rick",
    val status: String = "Alive",
    val species: String = "",
    val type: String = "",
    val gender: String = "Male",
    val origin: Origin = Origin(),
    val location: Location = Location(),
    val image: String = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
    val episode: List<String> = mutableListOf(),
    val url: String = "",
    val created: String = "",
)