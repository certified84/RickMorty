package com.certified.rickmorty.data.model

/**The model class which represents a single character in the Rick and Morty series
 * @param name      The name of the planet the character is located.
 * @param url       Link to the location's own endpoint.
 * */

data class Location(val name: String = "", val url: String = "")