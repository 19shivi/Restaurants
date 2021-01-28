import com.google.gson.annotations.SerializedName

data class R (

	@SerializedName("res_id") val res_id : Int,
	@SerializedName("is_grocery_store") val is_grocery_store : Boolean,
	@SerializedName("has_menu_status") val has_menu_status : Has_menu_status
)