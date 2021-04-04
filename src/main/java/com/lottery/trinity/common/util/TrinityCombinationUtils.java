package com.lottery.trinity.common.util;

import java.util.*;
import java.util.stream.Collectors;

public class TrinityCombinationUtils {

	private static List<String> resultList = new ArrayList<>();

	private static int fetchCount = 3;// 一共要取三个数

	public static void main(String[] args) {
//		Integer[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		List<Integer> numList = Arrays.asList(arr);
//		List<String> resultList = new ArrayList<>();
//		getAll(resultList, numList, fetchCount, "");
//		System.out.println(resultList);
//		System.out.println(resultList.size());
//		// List<String>→List<Integer>
//		List<Integer> intList = resultList.stream().map(Integer::parseInt).collect(Collectors.toList());
//		System.out.println(intList);
//		System.out.println(intList.size());
	}

	public static List<Long> generate(Long[] arr, int fetchCount) {
		List<Long> numList = Arrays.asList(arr);
		List<String> resultList = new ArrayList<>();
		getAll(resultList, numList, fetchCount, "");
		System.out.println(resultList);
		System.out.println(resultList.size());
		// List<String>→List<Integer>
		List<Long> intList = resultList.stream().map(Long::parseLong).collect(Collectors.toList());
		System.out.println(intList);
		System.out.println(intList.size());
		return intList;
	}

	/**
	 * @param refList      源数组：用于取数的
	 * @param count        用于取几个数
	 * @param resultString 结果字符串：比如“103”
	 * @return
	 */
	public static List<String> getAll(List<String> resultList, List<Long> refList, int count, String resultString) {
		for (int i = 0; i < refList.size(); i++) {
			/*
			 * 每一次循环要初始化 数组 和 结果字符串
			 */
			String tempString = resultString;
			List<Long> tempList = new ArrayList<>(refList);
			String resultNum = tempList.remove(i).toString();
			tempString += resultNum;
			if (count == fetchCount && resultNum.equals("0")) {// 代表第一次取数为0的情况
				continue;
			}
			if (count != 1) {
				getAll(resultList, tempList, count - 1, tempString);
			} else {
				resultList.add(tempString);
			}
		}
		return resultList;
	}
}