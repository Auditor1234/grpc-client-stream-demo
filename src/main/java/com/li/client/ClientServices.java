package com.li.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.google.protobuf.ByteString;
import com.li.rpc.FileInfo;
import com.li.rpc.Info;
import com.li.rpc.RouteGuideGrpc;
import com.li.rpc.RouteGuideGrpc.RouteGuideStub;

import io.grpc.stub.StreamObserver;

public class ClientServices {
    private static Logger logger = Logger.getLogger(ClientServices.class.getName());
    private final RouteGuideStub asyncStub;
    private final ClientNetService netService;
    private final String ip = "localhost";
    private final int port = 8081;

    public ClientServices(){
        this.netService = new ClientNetService(ip, port);
        this.asyncStub = RouteGuideGrpc.newStub(this.netService.getChannel());
    }

    public void sendFile() {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<Info> responseObserver = new StreamObserver<Info>() {
            @Override
            public void onNext(Info info) {
                logger.info("end :"+info.getMsg() + "--------");
            }

            @Override
            public void onError(Throwable t) {
                logger.info("sendFile Failed");
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                logger.info("Finished RecordRoute");
                finishLatch.countDown();
            }
        };

        StreamObserver<FileInfo> requestObserver = asyncStub.sendFile(responseObserver);
        try {
            InputStream is = new FileInputStream(new File("./img/grpc.png"));
            byte[] buff = new byte[2048];  // 每次发送2KB的内容
            int len;
            int index = 0;
            while ((len = is.read(buff)) != -1) {
                requestObserver.onNext(FileInfo.newBuilder().setIndex(index).setArrs(ByteString.copyFrom(buff)).build());
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Mark the end of requests
        requestObserver.onCompleted();

        // Receiving happens asynchronously
        try {
            if (!finishLatch.await(1, TimeUnit.MINUTES)) {
                logger.info("send file can not finish within 1 minutes");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("sendFile success");
    }

}
