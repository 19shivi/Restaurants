import com.google.gson.annotations.SerializedName

data class All_reviews (

	@SerializedName("reviews") val reviews : List<Reviews>
)