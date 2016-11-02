package com.mingxiu.apptest.api;

import com.mingxiu.apptest.data.CreatedResult;
import com.mingxiu.apptest.data.Data;
import com.mingxiu.apptest.data.entity.Comment;
import com.mingxiu.apptest.data.entity.CommentInfo;
import com.mingxiu.apptest.data.entity.Image;
import com.mingxiu.apptest.data.entity._User;
import com.mingxiu.apptest.ui.user.UserModel;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * 版权所有：个人
 * 作者：Created by a.wen.
 * 创建时间：2016/10/25
 * Email：13872829574@qq.com
 * 内容描述：
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */

public interface ApiService {
    @GET("login")
    Observable<_User> login(
            @Query("username") String username,
            @Query("password") String password);

    @POST("users")
    Observable<CreatedResult> createUser(@Body _User user);

    @GET("users")
    Observable<Data<_User>> getAllUser(
            @Query("skip") int skip,
            @Query("limit") int limit);

    @GET("classes/Image")
    Observable<Data<Image>> getAllImages(
            @Query("where") String where,
            @Query("order") String order,
            @Query("skip") int skip,
            @Query("limit") int limit);

    @GET("classes/Comment")
    Observable<Data<CommentInfo>> getCommentList(
            @Query("include") String include,
            @Query("where") String where,
            @Query("skip") int skip,
            @Query("limit") int limit);

    @POST("classes/Comment")
    Observable<CreatedResult> createComment(@Body Comment mComment);

    @Headers("Content-Type: image/png")
    @POST("files/{name}")
    Observable<CreatedResult> upFile(
            @Path("name") String name,
            @Body RequestBody body);

    @PUT("users/{uid}")
    Observable<CreatedResult> upUser(
            @Header("X-LC-Session") String session,
            @Path("uid") String uid,
            @Body UserModel.Face face);

}
