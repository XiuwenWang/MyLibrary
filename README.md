![工匠精神](smartisan.png)
# library
***
- 网络请求操作类 MxHttpRequest
get请求，post请求，文件下载等等
```
 Params params = new Params();
        params.add("key","value");
        MxHttpRequest.get("url", params, new BaseHttpRequestCallback<BaseBean>() {//打一个参数baseUrl,第二个参数拼接请求参数，第三个参数请求结果回调，传入泛型直接解析出来对象

            @Override
            public void onSuccess(BaseBean baseBean) {
                LogUtils.d("请求成功");
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                LogUtils.d("请求失败");
            }
        });
 ```
 - 图片加载工具类 ImageLoader
基于Glide 实现的，实现加载圆形图片等

 ```
 //加载普通图片
 ImageLoader.getInstance().displayImage("context上下文","图片链接url",imgageView);
 //加载圆形图片
 ImageLoader.getInstance().displayCircleImage("context上下文","图片链接url",imgageView);
 ```

- Uitils目录地下工具类 一些常用工具

