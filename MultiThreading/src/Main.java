class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}

pubic class Main {
    public static void main(String[] args) {
        NumberThread t = new NmberThread();
        t.start();
    }
}