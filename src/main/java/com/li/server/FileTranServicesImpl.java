package com.li.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;


import com.li.rpc.FileInfo;
import com.li.rpc.Info;
import com.li.rpc.RouteGuideGrpc.RouteGuideImplBase;

import io.grpc.stub.StreamObserver;

public class FileTranServicesImpl extends RouteGuideImplBase{
    private static Logger logger = Logger.getLogger(FileTranServicesImpl.class.getName());
    // proto文件中需要返回的info是放在onNext()方法中的
    // 测试文件流
    @Override
    public StreamObserver<FileInfo> sendFile(StreamObserver<Info> responseObserver) {  // 用于回调
        try {
            return new StreamObserver<FileInfo>() {
                final long startTime = System.nanoTime();
                OutputStream os = new FileOutputStream(new File(System.currentTimeMillis() + ".png"));
                @Override
                public void onNext(FileInfo fileInfo) {
                    try {
                        logger.log(Level.INFO, "接收到文件流, 第" + fileInfo.getIndex() + "块内容");
                        fileInfo.getArrs().writeTo(os);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onError(Throwable t) {
                    System.out.println("发生错误");
                    logger.log(Level.WARNING, "sendFile cancelled");
                }
                @Override
                public void onCompleted() {
                    System.out.println("文件传输完成");
                    // 关闭流
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    long seconds = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime);
                    responseObserver.onNext(Info.newBuilder().setMsg("success, spend time :" + seconds).build());
                    responseObserver.onCompleted();
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The end...");
        return null;
    }
    
}
