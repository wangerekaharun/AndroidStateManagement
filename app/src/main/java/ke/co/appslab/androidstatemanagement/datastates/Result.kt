package ke.co.appslab.androidstatemanagement.datastates

sealed class Result {
    data class Success(val data : List<String>) : Result()
    data class Failure(val exception : String) : Result()
}