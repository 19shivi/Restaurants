import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class Has_menu_status (

	@Transient var delivery :Int,
	@SerializedName("takeaway") val takeaway : Int
)