package PIM;

import java.util.Scanner;

import Tools.Display;
import Tools.InputJudgment;

/*
 * @author 牛年
 * @author 17130110034
 * @author 1310140596@qq.com
 * */

//主界面
public class PIMManager {		
	public static void main(String[] args) throws Exception {
		PIMData data=new PIMData();
		Scanner sc=new Scanner(System.in);
		String ch;
		Display.Welcome();
		ch=sc.nextLine();
		while(!(ch.equals("Quit") || ch.equals("5"))) {
			switch (InputJudgment.choose(ch)) {
				case 1:data.List();Display.Welcome();break;
				case 2:data.Create();Display.Welcome();break;
				case 3:data.Save();Display.Welcome();break;
				case 4:data=data.Load();Display.Welcome();break;
				default:System.out.println("Please input again!");break;
			}
			ch=sc.nextLine();
		}System.out.println("Goodby!");
	}
}
