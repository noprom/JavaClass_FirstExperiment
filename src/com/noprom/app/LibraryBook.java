package com.noprom.app;

public class LibraryBook {

	private String name; // 书名
	private String user; // 借书者或者订阅者

	private boolean isReserved; // 是否被预定
	private boolean isOnLoan; // 是否被借阅

	public LibraryBook(String name) {
		this.isReserved = false;
		this.isOnLoan = false;
		this.name = name;
	}

	/**
	 * 预定书籍
	 * 
	 * @param reserver
	 *            预订者
	 * @return 约定成功返回true,否则返回false
	 */
	private boolean reserve(String reserver) {
		if (isReserved || isOnLoan) {
			System.err.println("该书不能被预定!");
			return false;
		}
		System.out.println("《"+name+"》借阅成功！借阅者："+reserver);
		this.isReserved = true;
		this.user = reserver;
		return true;
	}

	/**
	 * 是否可以被借阅
	 * 
	 * @return
	 */
	private boolean ableToBorrow() {
		return !this.isOnLoan;
	}

	/**
	 * 借阅书籍
	 * @param borrower 结束者
	 * @return 借阅成功返回true,否则返回false
	 */
	private boolean borrow(String borrower){
		if (isReserved) {
			System.err.println("该书已被预订!");
			return false;
		}else if(isOnLoan){
			System.err.println("该书已被借阅!");
			return false;
		}
		this.isOnLoan = true;
		this.user = borrower;
		return true;
	}
	
	/**
	 * 取消预定
	 * @param canceler 取消者
	 */
	private void cancelReservation(String canceler){
		if(isReserved == false){
			System.err.println("该书还未被预定!");
		}else if(!canceler.equals(user)){
			System.err.println("您不是该书的预订者，不能够取消预定！");
		}else {
			System.out.println("《"+name+"》取消预定成功！");
			isReserved = false;
			isOnLoan = false;
		}
	}
	
	/**
	 * 还书
	 * @param returner 还书者
	 */
	private void returnBook(String returner){
		if(isReserved == false){
			System.err.println("该书还未被预定!");
		}else if(isOnLoan == false){
			System.err.println("该书还未被借阅!");
		}else if(!returner.equals(user)){
			System.err.println("您不是该书的借阅者，不能够归还此书!");
		}else{
			System.out.println("还书成功！");
			isReserved = false;
			isOnLoan = false;
		}
	}
	
	public static void main(String[] args) {
		LibraryBook book = new LibraryBook("三毛流浪记");
		
		book.reserve("小明");
		book.cancelReservation("小明");
		
//		book.borrow("小明");

//		book.returnBook("小明");
	}

}
