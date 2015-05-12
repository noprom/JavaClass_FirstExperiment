package com.noprom.app;

public class LibraryBook {

	private String name; // 书名
	private String user; // 借书者或者订阅者

	private boolean isReserved; // 是否被预定
	private boolean isOnLoan; // 是否被借阅

	public LibraryBook(String name) {
		this.name = name;
		this.user = null;
		this.isReserved = false;
		this.isOnLoan = false;
	}

	/**
	 * 预定书籍
	 * 
	 * @param reserver
	 *            预订者
	 * @return 约定成功返回true,否则返回false
	 */
	private boolean reserve(String reserver) {
		if (isReserved) {
			if (reserver.equals(user)) {
				System.err.println("不能重复预定该图书!");
				return false;
			} else {
				System.err.println("该书已被预定!");
				return false;
			}
		} else if (isOnLoan) {
			System.err.println("该书已被借阅!");
			return false;
		}
		System.out.println("《" + name + "》预定成功！预定者：" + reserver);
		this.isReserved = true; // 设置该书已经被预定
		this.isOnLoan = false; // 设置该书还没有被借阅出去
		this.user = reserver; // 设置当前的图书使用者
		return true;
	}

	/**
	 * 是否可以被借阅
	 * 
	 * @return 可以借阅返回true，否则返回false
	 */
	private boolean ableToBorrow() {
		return !this.isOnLoan || !this.isReserved;
	}

	/**
	 * 借阅书籍
	 * 
	 * @param borrower
	 *            结束者
	 * @return 借阅成功返回true,否则返回false
	 */
	private boolean borrow(String borrower) {
		if (isReserved) {
			if (!borrower.equals(user)) {
				System.err.println("该书已被预定!");
				return false;
			}
		} else if (isOnLoan) {
			System.err.println("该书已被借阅!");
			return false;
		}
		System.out.println("《" + name + "》借阅成功！借阅者：" + borrower);
		this.isOnLoan = true; // 设置该书已经被借阅
		this.user = borrower; // 设置该书的借阅者
		return true;
	}

	/**
	 * 取消预定
	 * 
	 * @param canceler
	 *            取消者
	 * @return 取消成功返回true，否则返回false
	 */
	private boolean cancelReservation(String canceler) {
		if (isReserved == false) {
			System.err.println("该书还未被预定!");
			return false;
		} else if (!canceler.equals(user)) {
			System.err.println("您不是该书的预订者，不能够取消预定！");
			return false;
		} else {
			System.out.println("《" + name + "》取消预定成功！");
			this.isReserved = false; // 设置该图书未被预定
			this.isOnLoan = false; // 设置该图书未被借阅
			this.user = null;
			return true;
		}
	}

	/**
	 * 还书
	 * 
	 * @param returner
	 *            还书者
	 * @return 还书成功返回true，否则返回false
	 */
	private boolean returnBook(String returner) {
		if (isOnLoan == false) {
			System.err.println("该书还未被借阅!");
			return false;
		} else if (!returner.equals(user)) {
			System.err.println("您不是该书的借阅者，不能够归还此书!");
			return false;
		} else {
			System.out.println("还书成功！");
			this.isReserved = false; // 设置当前图书未被预定
			this.isOnLoan = false; // 设置当前图书未被借阅
			this.user = null;
			return true;
		}
	}

	@Override
	public String toString() {
		String result = "LibraryBook [name=" + name + ", user=" + user
				+ ", isReserved=" + isReserved + ", isOnLoan=" + isOnLoan + "]";
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		LibraryBook book = new LibraryBook("三毛流浪记");

		book.reserve("小明");
		book.toString();
		book.cancelReservation("小明");
		book.toString();

		book.borrow("小明");
		book.toString();
		book.returnBook("小明");
		book.toString();

		if (book.ableToBorrow()) {
			System.out.println("该图书当前可以被借阅");
		} else {
			System.err.println("该图书当前不可以被借阅");
		}

		book.reserve("小张");
		book.borrow("小张");
		book.returnBook("小张");

	}
}
