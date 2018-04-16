package com.alibaba.middleware.race.rpc.netty;

import com.alibaba.middleware.race.rpc.async.ResponseCallbackListener;
import com.alibaba.middleware.race.rpc.model.RpcRequest;

import java.util.List;
import java.util.Map;

/**
 * 描述与服务器的连接
 *
 * @author sei.zz
 */
public interface RpcConnection {
    void init();

    void connect();

    void connect(String host, int port);

    Object Send(RpcRequest request, boolean async);

    void close();

    boolean isConnected();

    boolean isClosed();

    boolean containsFuture(String key);

    InvokeFuture<Object> removeFuture(String key);

    void setResult(Object ret);

    void setTimeOut(long timeout);

    void setAsyncMethod(Map<String, ResponseCallbackListener> map);

    List<InvokeFuture<Object>> getFutures(String method);
}
