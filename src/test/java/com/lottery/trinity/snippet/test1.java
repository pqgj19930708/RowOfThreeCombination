package com.lottery.trinity.snippet;

import java.util.*;

/**
 * Java,0-9这十个数可以组成多少个不重复的三位，编写合适的程序
 * 
 * https://zhidao.baidu.com/question/2078517802476905228.html
 * 
 * @author Administrator
 *
 */
public class test1 {

	private static List<String> resultList = new ArrayList<>();

	private static int total = 3;// 一共要取三个数

	public static void main(String[] args) {
		Integer[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Integer> numList = Arrays.asList(arr);
		getAll(numList, total, "");
		System.out.println(resultList);
		System.out.println(resultList.size());
	}

	/**
	 * @param refList      源数组：用于取数的
	 * @param count        用于取几个数
	 * @param resultString 结果字符串：比如“103”
	 * @return
	 */
	public static List<String> getAll(List<Integer> refList, int count, String resultString) {
		for (int i = 0; i < refList.size(); i++) {
			/*
			 * 每一次循环要初始化 数组 和 结果字符串
			 */
			String tempString = resultString;
			List<Integer> tempList = new ArrayList<>(refList);
			String resultNum = tempList.remove(i).toString();
			tempString += resultNum;
			if (count == total && resultNum.equals("0")) {// 代表第一次取数为0的情况
				continue;
			}
			if (count != 1) {
				getAll(tempList, count - 1, tempString);
			} else {
				resultList.add(tempString);
			}
		}
		return resultList;
	}
}