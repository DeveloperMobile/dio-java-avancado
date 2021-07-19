package aula3;

public class ThreadsExemplo {
    public static void main(String[] args) {
        GeradorPDF geradorPDF = new GeradorPDF();
        BarraDoCarregamento barraDoCarregamento = new BarraDoCarregamento(geradorPDF);
        barraDoCarregamento.start();
        geradorPDF.start();

        /* Thread thread = new Thread(new BarrraDoCarregamento2());
        Thread thread1 = new Thread(new BarrraDoCarregamento3());

        thread.start();
        thread1.start();

        System.out.println("Nome da thread: " + thread.getName());
        System.out.println("Nome da thread: " + thread1.getName());

        BarrraDoCarregamento4 barrraDoCarregamento4 = new BarrraDoCarregamento4();
        barrraDoCarregamento4.start(); */
    }
}

class GeradorPDF extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Iniciar Geração de PDF");
            Thread.sleep(5000);
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("PDF Gerado");
    }
}

class BarraDoCarregamento extends Thread {
    private Thread inicarGerarPDF;

    public BarraDoCarregamento(Thread inicarGerarPDF) {
        this
                .inicarGerarPDF = inicarGerarPDF;
    }

    @Override
    public void run() {
        Integer total = 10;

        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { e.printStackTrace(); }

            if (!inicarGerarPDF.isAlive()) {
                break;
            }

            System.out.println("Loading........" + "%" + total);
            total = total + 10;
        }
    }
}

class BarrraDoCarregamento2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("roda BarraCarregamento2 :");
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

class BarrraDoCarregamento3 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("roda BarraCarregamento3 :");
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

class BarrraDoCarregamento4 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("roda BarraCarregamento4 : " + this.getName());
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
