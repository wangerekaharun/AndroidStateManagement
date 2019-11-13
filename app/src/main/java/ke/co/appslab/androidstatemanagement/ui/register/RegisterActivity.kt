package ke.co.appslab.androidstatemanagement.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ke.co.appslab.androidstatemanagement.R
import retrofit2.Response
import java.io.IOException

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun registerUser(fullName : String , email :String,password : String){
        try {
            val response = registerRequest(fullName, email, password)
            if (response!!.isSuccessful){
                if(response != null){
                    saveUserDetails(response.body())
                    proceedToDashBoard()
                }

            }else{
                when(response.code()){
                    401 -> showError("Unauthorized")
                    403 -> showError("Access to resource is forbidden")
                    404 -> showError("Resource not found")
                    500 -> showError("Internal Server error")
                    502 -> showError("Bad Gateway")
                    301 -> showError("Resource has been removed permanently")
                    302 -> showError("Resource moved,but has has been found ")
                    else -> showError("All cases have not been covered!!")

                }
            }
        }catch (error : IOException){
            Log.d("Error",error.message)
        }
    }

    private fun showError(s: String) {

    }

    private fun proceedToDashBoard() {

    }

    private fun saveUserDetails(body: String?) {

    }

    fun registerRequest(fullName : String , email :String,password : String) : Response<String>? {

        return null
    }
}
