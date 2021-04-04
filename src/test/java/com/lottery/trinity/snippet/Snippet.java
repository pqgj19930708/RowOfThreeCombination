package com.lottery.trinity.snippet;

import org.junit.Test;

/**
 * 0-9这十个数可以组成多少个不重复的三位
 * 
 * 
 * https://zhidao.baidu.com/question/2078517802476905228.html
 * 
 * https://zhidao.baidu.com/question/686272909304532732.html
 * 
 * 
 * @author Administrator
 *
 */
public class Snippet {

	/**
	 * 0-9这十个数可以组成多少个不重复的三位
	 */
	@Test
	public void test1() {
		int result = 0;
		for (int x = 1; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (y == x)
					continue;
				for (int z = 0; z < 10; z++) {
					if (z == x || z == y)
						continue;
					System.out.print((x * 100 + y * 10 + z) + " ");
					result++;
				}
				System.out.println();
			}
		}
		System.out.println("共能组成" + result + "个");
	}

	/**
	 * 0到9组成的三位数不重复有多少个
	 */
	@Test
	public void test2() {
		int count = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (i != j && i != k && j != k) {
						System.out.print(i * 100 + j * 10 + k + " ");
						count++;
					}
				}
			}
			System.out.println();
		}
		System.out.println(count);
	}

	/**
	 * 0到9组成的三位数不重复有多少个
	 */
	@Test
	public void test3() {
		int count = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					String s = "" + i + j + k;
					if (i != j && i != k && j != k) {
						count++;
						System.out.println(s);
					}
				}
			}
		}
		System.out.println("总数：" + count);
	}
}
