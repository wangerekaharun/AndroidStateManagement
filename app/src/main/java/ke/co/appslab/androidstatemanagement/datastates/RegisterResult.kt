package ke.co.appslab.androidstatemanagement.datastates

sealed class RegisterResult {
    data class Success(val data : String) : RegisterResult()
    object InvalidData :RegisterResult()
    data class Error(val error : Throwable) : RegisterResult()
    data class HttpErrors(val httpErrors : HttpErrorCodes) : RegisterResult()
}