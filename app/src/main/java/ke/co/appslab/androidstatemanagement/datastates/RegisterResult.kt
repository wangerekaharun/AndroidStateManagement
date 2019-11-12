package ke.co.appslab.androidstatemanagement.datastates

sealed class RegisterResult {
    data class Success(val data : String) : RegisterResult()
    object InvalidData :RegisterResult()
    data class Error(val error : String) : RegisterResult()
    data class NetworkException(val error : String) : RegisterResult()
    sealed class HttpErrors : RegisterResult() {
        data class Unauthorized(val exception: String) : HttpErrors()
        data class ResourceForbidden(val exception: String) : HttpErrors()
        data class ResourceNotFound(val exception: String) :HttpErrors()
        data class InternalServerError(val exception: String) :HttpErrors()
        data class BadGateWay(val exception: String) : HttpErrors()
        data class ResourceRemoved(val exception: String) : HttpErrors()
        data class RemovedResourceFound(val exception: String) :HttpErrors()
    }
}