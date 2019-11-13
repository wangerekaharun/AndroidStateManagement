package ke.co.appslab.androidstatemanagement.ui.refactoredregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ke.co.appslab.androidstatemanagement.R
import ke.co.appslab.androidstatemanagement.datastates.RegisterResult
import retrofit2.Response
import java.lang.Exception

class RefactoredRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refactored_register)

    }

    fun registerUser(fullName : String , email :String,password : String) : RegisterResult{
        return try {
            val response = registerRequest(fullName, email, password)
            if (response!!.isSuccessful) {
                if (response != null) {
                    RegisterResult.Success(response.body()!!)
                }else{
                    RegisterResult.InvalidData
                }
            }else{
                when(response.code()){
                    401 -> RegisterResult.HttpErrors.Unauthorized(response.message())
                    403 -> RegisterResult.HttpErrors.ResourceForbidden(response.message())
                    404 -> RegisterResult.HttpErrors.ResourceNotFound(response.message())
                    500 -> RegisterResult.HttpErrors.InternalServerError(response.message())
                    502 -> RegisterResult.HttpErrors.BadGateWay(response.message())
                    301 -> RegisterResult.HttpErrors.ResourceRemoved(response.message())
                    302 -> RegisterResult.HttpErrors.RemovedResourceFound(response.message())
                    else -> RegisterResult.Error(response.message())
                }
            }
        }catch (error : Exception){
            RegisterResult.NetworkException(error.message!!)
        }
    }

    private fun handleRegisterResult(result: RegisterResult){
        when(result){
            is RegisterResult.Success -> {
                saveUserDetails(result.data)
                proceedToDashBoard()
            }
            is RegisterResult.HttpErrors.Unauthorized -> showError(result.exception)
            is RegisterResult.HttpErrors.ResourceForbidden -> showError(result.exception)
            is RegisterResult.HttpErrors.ResourceNotFound -> showError(result.exception)
            is RegisterResult.HttpErrors.InternalServerError -> showError(result.exception)
            is RegisterResult.HttpErrors.BadGateWay -> showError(result.exception)
            is RegisterResult.HttpErrors.RemovedResourceFound -> showError(result.exception)
            is RegisterResult.NetworkException -> showError(result.error)
            is RegisterResult.Error -> showError(result.error)

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
