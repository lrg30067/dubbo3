/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.remoting.exchange;

import com.alibaba.dubbo.remoting.exception.RemotingException;
import com.alibaba.dubbo.remoting.message.Request;
import com.alibaba.dubbo.remoting.message.Response;
import com.alibaba.dubbo.remoting.transport.Channel;

/**
 * ExchangeChannel. (API/SPI, Prototype, ThreadSafe)
 *
 * @author william.liangf
 */
public interface ExchangeChannel extends Channel {

    /**
     * send request and receive response sync
     *
     * @param request
     * @return
     * @throws RemotingException
     */
    Response request(Request request) throws RemotingException;

    /**
     * send request and receive response sync
     *
     * @param request
     * @param timeout
     * @return
     * @throws RemotingException
     */
    Response request(Request request, int timeout) throws RemotingException;

    /**
     * get message handler.
     *
     * @return message handler
     */
    ExchangeHandler getExchangeHandler();

    /**
     * graceful close.
     *
     * @param timeout
     */
    void close(int timeout);

}