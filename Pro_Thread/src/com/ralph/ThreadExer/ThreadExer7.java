public class ThreadExer7 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        A a = new A(ticket);
        B b = new B(ticket);
        C c = new C(ticket);

        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(b);
        Thread thread3 = new Thread(c);

        thread1.setName("窗口A");
        thread2.setName("窗口B");
        thread3.setName("窗口C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Ticket {
    int tickets = 0;
    int flag = 1;

    public synchronized void sellA() {
        if (flag != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 2;
        if (tickets < 100) {
            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + (++tickets));
        }
        notifyAll();
    }
    public synchronized void sellB() {
        if (flag != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 3;
        if (tickets < 100) {
            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + (++tickets));
        }
        notifyAll();

    }
    public synchronized void sellC() {
        if (flag != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 1;
        if (tickets < 100) {
            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + (++tickets));
        }
        notifyAll();
    }
}

class A implements Runnable {
    Ticket ticket;

    public A(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.tickets < 100) {
            ticket.sellA();
        }
    }
}

class B implements Runnable{
    Ticket ticket;

    public B(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.tickets < 100) {
            ticket.sellB();
        }
    }
}

class C implements Runnable{
    Ticket ticket;

    public C(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.tickets < 100) {
            ticket.sellC();
        }
    }
}