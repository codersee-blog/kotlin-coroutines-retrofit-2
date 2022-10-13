import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface UserApi {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    // Works exactly the same, as above
    @HTTP(method = "GET", path = "users")
    suspend fun httpUsers(): Response<List<User>>

    @POST("users")
    suspend fun postUsers(): Response<List<User>>

    @PUT("users")
    suspend fun putUsers(): Response<List<User>>

    @PATCH("users")
    suspend fun patchUsers(): Response<List<User>>

    @DELETE("users")
    suspend fun deleteUsers(): Response<List<User>>

    @DELETE("users")
    suspend fun failingDeleteUsers(@Body user: User): Response<User>

    @HTTP(method = "DELETE", path = "users", hasBody = true)
    suspend fun workingDeleteUsers(@Body user: User): Response<User>

    @OPTIONS("users")
    suspend fun optionsUsers(): Response<List<User>>

    // Must be Void
    @HEAD("users")
    suspend fun headUsers(): Response<Void>

    // Replaces the BASE_URL
    @GET("http://localhost:8090/v3/users")
    suspend fun getUsersV3(): Response<List<User>>

    @GET
    suspend fun getUsersDynamic(@Url url: String): Response<List<User>>

    @GET("users/{userId}")
    suspend fun getUserById(@Path("userId") userId: Int): Response<User>

    @GET("users?sort_order=asc")
    suspend fun getUsersStaticQueryParam(): Response<List<User>>

    @GET("users")
    suspend fun getUsersDynamicQueryParam(@Query("sort_order") order: String): Response<List<User>>

    @GET("users")
    suspend fun getUsersDynamicQueryMap(@QueryMap parameters: Map<String, String>): Response<List<User>>

    @Headers("User-Agent: codersee-application")
    @GET("users")
    suspend fun getUsersSingleStaticHeader(): Response<List<User>>

    @Headers(
        value = [
            "User-Agent: codersee-application",
            "Custom-Header: my-custom-header"
        ]
    )
    @GET("users")
    suspend fun getUsersMultipleStaticHeaders(): Response<List<User>>

    @GET("users")
    suspend fun getUsersDynamicHeader(@Header("Authorization") token: String): Response<List<User>>

    @GET("users")
    suspend fun getUsersHeaderMap(@HeaderMap headers: Map<String, String>): Response<List<User>>

    @POST("users")
    suspend fun postUsersWithPayload(@Body user: User): Response<User>

    @FormUrlEncoded
    @POST("users")
    suspend fun postUsersFormUrlEncoded(@Field("field_one") fieldOne: String): Response<User>

    @Multipart
    @POST("users")
    suspend fun postUsersMultipart(@Part("something") partOne: RequestBody): Response<User>
}