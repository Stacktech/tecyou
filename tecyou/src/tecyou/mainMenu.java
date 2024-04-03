package tecyou;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mainMenu {
	static ArrayList<Bill> billList = new ArrayList<Bill>();
	
	static {
		billList.add(new Bill("外食", "現金", "支出", 600, "2022-10-12", "昭和けん"));
		billList.add(new Bill("中食", "Alipay", "支出",650 , "2022-12-20", "eon"));
		billList.add(new Bill("給料", "ごうぎん", "収入", 78000, "2023-1-30", "ローソン"));
		billList.add(new Bill("ガソリン代", "クレジット", "支出", 5000, "2023-2-5", "出光"));
		billList.add(new Bill("服代", "paypay", "支出", 2000, "2023-2-15", "gu"));
		
		billList.add(new Bill("内食", "現金", "支出", 6000, "2023-4-15", "くらすし"));
		billList.add(new Bill("外食", "paypay", "支出", 500, "2023-3-12", "はますし"));
		billList.add(new Bill("外食", "paypay", "支出", 4500, "2023-4-1", "昭和けん"));
	}

	public static void main(String[] args) {
		run();

	}
	
	public static void showMain() {
		System.out.println("----------手帳------------");
		System.out.println("1.記入or修正  2.削除  3.調べる  4.閉じる");
		System.out.println("指令番号を入力");
	}
	
	public static void run() {
		showMain();
		
		//指令番号を入力
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			int num = s.nextInt();
			//判断
			switch (num) {
				case 1:
					set();
					break;
				
				case 2:
					System.out.println("減らす");
					break;
				
				case 3:
					select();
					break;
				
				case 4:
					System.out.println("閉じる");
					flag = false;
//					return;
				default :
					System.out.println("入力し直しください");
			}
		}
		System.out.println("プログラム閉じた");
		
		
	}

	private static void set() {
		System.out.println("手帳→記入or修正");
		System.out.println("1.記入 2.修正");
		Scanner s = new Scanner(System.in);
		int op = s.nextInt();
		switch(op) {
		case 1:
			add();
			break;
		case 2:
			correct();
			break;
		}
		showMain();
	}

	


	//新規and修正
	private static void add() {
		System.out.println("nameを入力");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		String account = s.nextLine();
		String type = s.nextLine();
		int money = s.nextInt();
		String time= s.nextLine();
		String describe = s.nextLine();
		
		billList.add(new Bill(name,account,type,money,time,describe));
//		billList.add(new Bill("中食", "paypay", "支出", 1200, "2023-4-16", "..."));
	}
	
	private static void correct() {
		// TODO Auto-generated method stub
		
	}

	private static void select() {
		System.out.println("手帳　→　調べる");
		System.out.println("1.すべてを調べる　2.時間で調べる　3.account種類で調べる");
		Scanner s = new Scanner(System.in);
		int op =s.nextInt();
		switch (op) {
		case 1:
			selectAll();
			break;
		case 2:
			selectByDate();
			break;
		case 3:
			selectByType();
			break;
		}
		
		//マインメニュー
		showMain();
	}

	private static void selectByType() {
		System.out.println("メモ/調べる/accountで調べる");
		System.out.println("収入or支出を入力してください");
		Scanner s = new Scanner(System.in);
		String type = s.next();
		//コレクションlist からstreamを生成
		Stream<Bill> stream  = billList.stream();
//		streamからlistへ
		List<Bill> a = billList.stream().filter(bills ->{
			String type1 = bills.getType();
			return type1.equals(type);
		}).collect(Collectors.toList());
		print(a);
	}

	private static void selectByDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		
		System.out.println("メモ/調べる/時間で調べる");
		System.out.println("スタート時間を入力してください");
		Scanner s = new Scanner(System.in);
		String start = s.next();
		System.out.println("終了時間を入力してください");
		String end = s.next();
		
		List<Bill> b = billList.stream().filter(bills ->{
			String time = bills.getTime();
			//将字符串解析成时间
			try {
				Date startDate = format.parse(start);
				Date endDate = format.parse(end);
				Date timeDate = format.parse(time);
				if( timeDate.before(endDate) && timeDate.after(startDate)) {
					return true;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		print(b);
	}

	private static void selectAll() {
		print(billList);
		
	}

	private static void print(List<Bill> b2) {
		System.out.println("ID\t\t名前\t\tアカウント\t\tタイプ\t\t金額\t\t\t時刻\t\t\t\tメモ");
		for( int i=0;i<b2.size(); i++) {
			Bill b = b2.get(i);
			System.out.println(i+1+"\t\t"+b.getName()+"\t\t"+b.getAccount()+"\t\t"+b.getType()+"\t\t"+b.getMoney()+"\t\t\t"+b.getTime()+"\t\t\t"+b.getMemo());
			
		}
		
	}

}
