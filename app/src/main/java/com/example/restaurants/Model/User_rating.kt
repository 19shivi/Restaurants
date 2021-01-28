import com.google.gson.annotations.SerializedName

data class User_rating (

	@SerializedName("aggregate_rating") val aggregate_rating : String,
	@SerializedName("rating_text") val rating_text : String,
	@SerializedName("rating_color") val rating_color : String,
	@SerializedName("rating_obj") val rating_obj : Rating_obj,
	@SerializedName("votes") val votes : Int
)