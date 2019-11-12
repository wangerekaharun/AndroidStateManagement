package ke.co.appslab.androidstatemanagement.datastates

import java.lang.Exception

sealed class HttpErrorCodes {
    data class Unauthorized(val exception: Throwable) : HttpErrorCodes()
    data class ResourceForbidden(val exception: Throwable) : HttpErrorCodes()
    data class ResourceNotFound(val exception: Throwable) :HttpErrorCodes()
    data class InternalServerError(val exception: Throwable) :HttpErrorCodes()
    data class BadGateWay(val exception: Throwable) : HttpErrorCodes()
    data class ResourceRemoved(val exception: Throwable) : HttpErrorCodes()
    data class RemovedResourceFound(val exception: Throwable) :HttpErrorCodes()
}