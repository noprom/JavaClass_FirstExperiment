package com.noprom.app;

/**
 * 一个方法类
 * 
 * @author noprom
 *
 */
public class Method {

	/**
	 * 求一个数组中的最小值
	 * 
	 * @param arr
	 *            数组
	 * @return 最小值
	 */
	private int minValue(int[] arr) {
		int min = 0x7f7f7f7f;
		for (int val : arr) {
			if (val < min)
				min = val;
		}
		return min;
	}

	/**
	 * 数组求和
	 * 
	 * @param arr
	 *            原数组
	 * @return 新数组
	 */
	private Integer[] cumulativeSums(int[] arr) {
		Integer newArr[] = new Integer[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			int tmpSum = 0;
			for (int j = 0; j <= i; ++j) {
				tmpSum += arr[j];
			}
			newArr[i] = tmpSum;
		}
		return newArr;
	}

	public static void main(String[] args) {
		Method method = new Method();

		// 找一个数组中的最小值
		int arr[] = { 0, 1, 9, -100, 30, -20 };
		int min = method.minValue(arr);
		System.out.print("Min value of the arr {");
		for (int val : arr) {
			System.out.print(" " + val);
		}
		System.out.println(" } is " + min);

		// 数组求和
		int priArr[] = { 1, 2, 3 };
		Integer newArr[] = method.cumulativeSums(priArr);
		// 打印原数组的值
		System.out.print("Old array is {");
		for (int val : priArr) {
			System.out.print(" " + val);
		}
		System.out.println(" }");
		
		// 打印新数组的值
		System.out.print("New array is {");
		for (int val : newArr) {
			System.out.print(" " + val);
		}
		System.out.println(" }");

		// 一个包含星期的字符串数组
		String[] weekend = { "Sunday", "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday" };
		System.out.print("Seven days of a week are : ");
		for (String day : weekend) {
			System.out.print(day + " ");
		}

	}

}
