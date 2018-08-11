package Tools;

@SuppressWarnings("ALL")
public abstract class NeonThread extends Thread {
    protected boolean kill = false;
    protected int threadPower = 0;
    public static final int WAITVERYSHORT = 10;
    public static final int WAITSHORT = 50;
    public static final int WAITNORMAL = 250;
    public static final int WAITLONG = 500;
    public static final int WAITVERYLONG = 1000;
    public static final int WAITVERYVERYLONG = 10000;
    public static final int WAITONEMINUTE = 60000;
    public static final int THREADPOWER_SLOW = 1000;

    /**
     * This Methode is not in use. Use neonStart() instead.
     */
    @Deprecated
    public void run() {
        do {
            threadDoWork();
          //  System.out.println(threadPower);
            if (threadPower != 0) {

                neonWait(THREADPOWER_SLOW);
            }
        } while (!kill);

    }

    /**
     * put here the main code you wanna progress in a own task. It will run above it
     * as long you dont call the Methode killTask;
     */
    protected abstract void threadDoWork();

    /**
     * This methode will stop your task or Thread at the next thread cycle.
     */
    public void killTask() {
        kill = true;
        System.gc();
    }

    /**
     * A fast way to make youre thread or task stop for about 200 milliseconds.
     */
    protected void neonWait() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * A simple way to make the thread waiting for a defined amount of time. Use
     * NeonThread.WAIT... for using predefined timeperiods.
     *
     * @param time
     *            the Amount of millseconds you wanna wait.
     */
    protected void neonWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * If you have to run an inner class in a new asyncron thread, use this methode.
     *
     * @param task
     *            the object you wanna start in a asynchron Task. It has to extend
     *            NeonThread.
     * @param threadPower
     */
    protected void neonAddAsyncTask(NeonThread task, int threadPower) {
        this.threadPower = threadPower;
        task.neonStart();

    }

    /**
     * This Method activates a NeonThread main Thread.
     */
    public void neonStart() {
        start();

    }

    /**
     * This Method activates a NeonThread main Thread with a customable waitinterval
     * after each taskcycle.
     */
    public void neonStart(int threadPower) {
        this.threadPower = threadPower;
        start();

    }

}
