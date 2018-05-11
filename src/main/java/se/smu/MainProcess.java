package se.smu;

public class MainProcess {
	Login loginView;
//	Mainpage mainpage;
	public static void main(String[] args) {

		MainProcess main = new MainProcess();
		main.loginView=new Login();
		main.loginView.setMain(main);
	}
	public void change() {
		loginView.dispose();
//		this.mainpage = new Mainpage();
	}
}
