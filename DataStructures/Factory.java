class Worker implements Runnable {

	int id;

	Barrier wall;

	Worker (int id, Barrier wall) {

		this.id = id;

		this.wall = wall;

	}

	Worker(Barrier barrier) {

		this.wall = barrier;

	}

	public void run() {

		work();

	}

	void work() {

		// do some work for a while

		initialWork();

		System.err.println ("Worker " + id + " has finished its initial work.");

		System.err.println ("Worker " + id + " is waiting for the pack.");

		// now wait for others

		wall.waitForOthers();

		// now do some more work

		remainderWork();

	}

	void initialWork() {

		System.err.println ("Worker " + id + " is doing its initial work.");

	}

	void remainderWork() {

		System.err.println ("Worker " + id + " is doing its remainder work.");

	}

}


class Factory {

	static final int THREAD_COUNT = 10;

	public static void main(String args[]) {

		Barrier barrier = new Barrier() {

			@Override

			public void waitForOthers() {

				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

			}

			@Override

			public void freeAll() {

				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

			}

		};

		Thread[] workers = new Thread[THREAD_COUNT];

		for (int i = 0; i < workers.length; i++)

		{

			workers[i] = new Thread(new Worker(i,barrier)); workers[i].start();

		}

	}

}



interface Barrier

{

public void waitForOthers();

public void freeAll();

}