package com.certified.rickmorty.data.model

/**The model class which represents a single character in the Rick and Morty series
 * @param name      The name of the planet the character originated from.
 * @param url       Link to the origin's own endpoint.
 * */

data class Origin(val name: String = "", val url: String = "")