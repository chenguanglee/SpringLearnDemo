package com.chenguangli.cus.dubbo.protocol.http;

import com.chenguangli.cus.dubbo.protocol.framework.Invocation;
import com.chenguangli.cus.dubbo.provider.LocalRegister;
import org.apache.lucene.util.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * @author chenguangli
 * @date 2019/12/18 23:21
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        //处理请求, 返回结果
        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            Invocation invocation = (Invocation) ois.readObject();

            Class implClass = LocalRegister.get(invocation.getInterfaceName());

            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());

            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            OutputStream outputStream = resp.getOutputStream();

            outputStream.write(result.getBytes());

        } catch (Exception e) {

        }
    }
}
