package Day10_interface;

public class TestRunner {

}

interface Runner {
	void start();

	void run();

	void stop();
}
class Bird implements Runner{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	public void fly() {
		
	}
	
}
class Car implements Runner {

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	public void fillFuel() {
	}

	public void crek() {

	}
}

class Person implements Runner {

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	public void dance() {

	}

}