package com.alibaba.dubbo.tracker.zipkin.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.tracker.RpcTracker;
import com.alibaba.dubbo.tracker.TrackerManager;
import com.alibaba.dubbo.tracker.filter.ClientRpcTrackerFilter;

/**
 * @author Xs
 */
@Activate(group = Constants.CONSUMER, order = Integer.MAX_VALUE)
public class BraveClientRpcTrackerFilter implements ClientRpcTrackerFilter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcTracker rpcTracker = TrackerManager.mockRpcTracker("consumer");
        rpcTracker.clientRequestInterceptor().handle(invocation);
        Result result = invoker.invoke(invocation);
        rpcTracker.clientResponseInterceptor().handle(result);
        return result;
    }
}
