package alex.inversion.retrofit;

import java.util.List;

import alex.inversion.retrofit.request.PostCreateRequest;
import alex.inversion.retrofit.request.PostUpdateRequest;
import alex.inversion.retrofit.response.PostResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface JsonPlaceholderApi {
    @GET("/posts")
    Call<List<PostResponse>> posts(@Query("userId") Integer userId);

    @POST("/posts")
    Call<PostResponse> crate(@Body PostCreateRequest postCreateRequest);

    @PUT("/posts/{id}")
    Call<PostResponse> update(@Path("id") Integer id, @Body PostUpdateRequest postUpdateRequest);

    @DELETE("/posts/{id}")
    Call<Void> delete(@Path("id") Integer id);
}
