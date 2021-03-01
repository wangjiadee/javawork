package com.ralph.java;

import org.junit.Test;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class FristInetAddress {
    @Test
    public void NetworkTest1(){
        try {
            InetAddress a1 = InetAddress.getByName("www.csdn.net");
//            获取IP和域名
            System.out.println(a1);
//            域名
            System.out.println(a1.getHostName());
//            IP地址
            System.out.println(a1.getHostAddress());
//            获取本地信息
            InetAddress local = InetAddress.getLocalHost();
            System.out.println(local);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void TCPclient(){
        Socket socket = null;
        OutputStream os = null;

        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress i1 = InetAddress.getByName("127.0.0.1");
            socket = new Socket(i1,8899);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            os.write("Fucking u ".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void TCPserver(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);
            //2.调用accept()表示接收来自于客户端的socket 监听c端
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();

            //不建议这样写，可能会有乱码
//        byte[] buffer = new byte[1024];
//        int len;
//        while((len = is.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);
//        }
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());

            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                //5.关闭资源
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    @Test
    public void TcpTransformPictureClient(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("picture_name.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

//    @Test
//    public void TcpTransformPictureServer(){
//        ServerSocket ss = null;
//        Socket socket = null;
//        InputStream is = null;
//        FileInputStream fos = null;
//
//        try {
//            ss = new ServerSocket(9090);
//            socket = ss.accept();
//            is = socket.getInputStream();
//            fos = new FileOutputStream(new File("picture_name.jpg"));
//            byte[] buffer = new byte[1024];
//            int len;
//            while((len = is.read(buffer)) != -1){
//                fos.write(buffer,0,len);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            ss.close();
//        }
//
//    }


    @Test
    public void TcpTransformFileClient() throws IOException{
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("beauty.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        socket.shutdownOutput();

//        接收来自于服务器端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[20];
        int len1;
        while((len1 = is.read(buffer)) != -1){
            baos.write(buffer,0,len1);
        }

        System.out.println(baos.toString());

        fis.close();
        os.close();
        socket.close();
        baos.close();

    }


    @Test
    public void TcpTransformFileServer() throws IOException{
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("beauty2.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("图片传输完成");

        //服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("收到信息".getBytes());

        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();
    }


    @Test
    public void UdpTestclient() throws IOException{
        DatagramSocket socket = new DatagramSocket();
        String str = "Fucking ";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();

    }

    @Test
    public void UdpTestserver() throws IOException {

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }


    @Test
    public void URLTest() {

    }
}
