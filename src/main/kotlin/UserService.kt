import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.ResponseBody
import retrofit2.Call

class UserService {

    private val retrofit = RetrofitClient.getClient()
    private val userApi = retrofit.create(UserApi::class.java)

    suspend fun successfulUsersResponse() {
        val usersResponse = userApi.getUsers()

        val successful = usersResponse.isSuccessful
        val httpStatusCode = usersResponse.code()
        val httpStatusMessage = usersResponse.message()

        val body: List<User>? = usersResponse.body()

        println("Successful: $successful")
        println("HTTP status code: $successful")
        println("HTTP status message: $successful")
        println("Body: $body")
    }

    suspend fun errorUsersResponse() {
        val usersResponse = userApi.getUsers()

        val errorBody: ResponseBody? = usersResponse.errorBody()

        val mapper = ObjectMapper()
        val mappedBody: ErrorResponse? = errorBody?.let { notNullErrorBody ->
            mapper.readValue(notNullErrorBody.string(), ErrorResponse::class.java)
        }

        println("Mapped body: $mappedBody")
    }

    suspend fun headersUsersResponse() {
        val usersResponse = userApi.getUsers()

        val headers = usersResponse.headers()
        val customHeaderValue = headers["custom-header"]

        println("Custom header value: $customHeaderValue")
    }
}