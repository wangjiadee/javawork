package com.Proxy.module;

public class NetWorkTest {
    public static void main(String[] args) {
        ProxyServer ps = new ProxyServer(new Server());
        ps.browse();
    }

}


interface Network{
    public void browse();
}



class Server implements Network{
    @Override
    public void browse() {
        System.out.println("Connect Network servering!");
    }
}

class ProxyServer implements Network{

    private  Network work;

    public ProxyServer(Network work){
        this.work =work;
    }

    public void check(){
        System.out.println("Check networking Correctness!");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}

