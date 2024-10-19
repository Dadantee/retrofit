package alex.inversion.retrofit;

import alex.inversion.retrofit.request.PostCreateRequest;
import alex.inversion.retrofit.request.PostUpdateRequest;
import alex.inversion.retrofit.response.PostResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");

        JsonPlaceholderApi api = JsonPlaceHolderService.getInstance().api();

        System.out.println("GET:/posts--------------------");
        Response<List<PostResponse>> postResponses = api.posts(null).execute();
        System.out.println(postResponses.isSuccessful());
        System.out.println(postResponses.code());
        System.out.println(postResponses.headers());
        List<PostResponse> posts = postResponses.body();
        System.out.println(posts);

        System.out.println("POST:/posts--------------------");
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setBody("create");
        createRequest.setTitle("create");
        createRequest.setUserId(1);
        PostResponse postResponseCreate = api.crate(createRequest).execute().body();
        System.out.println(postResponseCreate);
        System.out.println(postResponseCreate.getBody());

        System.out.println("PUT:/posts--------------------");
        PostUpdateRequest updateRequest = new PostUpdateRequest();
        updateRequest.setBody("update");
        updateRequest.setTitle("update");
        updateRequest.setUserId(1);
        updateRequest.setId(1);
        PostResponse postResponseUpdate = api.update(updateRequest.getId(),updateRequest).execute().body();
        System.out.println(postResponseUpdate);

        System.out.println("DELETE:/posts--------------------");
        Integer code = api.delete(1).execute().code();
        System.out.println(code);

    }
}
