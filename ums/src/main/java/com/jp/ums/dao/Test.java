package com.jp.ums.dao;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		int[] a = { 6, 3, 5, 9, 1, 2 };

		System.out.println(Arrays.toString(a));

		bubbleSort(a);

		System.out.println(Arrays.toString(a));
	}

	public static void bubbleSort(int[] a) {

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a.length - 1 - i; j++) {

				if (a[j] > a[j + 1]) {

					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

			}

		}

	}

}
