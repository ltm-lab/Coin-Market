package KMUbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class coin {

	public static ArrayList<Integer> price = new ArrayList<>(Arrays.asList(1, 1));
	public static ArrayList<Integer> tm_price = new ArrayList<>(Arrays.asList(30, 30));
	public static ArrayList<Double> percent = new ArrayList<>(Arrays.asList(0.0, 0.0));
	public static int due = 1;

	public static void main(String[] args) {

		today();
		tomorrow();
		today();
		tomorrow();
		today();

	}

	public static void tomorrow() {
		due++;
		Random random = new Random();

		ArrayList<Integer> tm_price = new ArrayList<>();
		for (int i = 0; i < 2; i++) { // ���� ���� ��ŭ
			int a = (int) (Math.random() * 100);

			tm_price.add(i, a); // ���� ���� �������� ������Ʈ

		}

		// percent ������Ʈ
		ArrayList<Double> percent = new ArrayList<>();
		for (int i = 0; i < 2; i++) {

			if (tm_price.get(i) >= price.get(i)) { // ���� ���� or �Ȱ���

				double a = ((tm_price.get(i) - price.get(i)) / (double) price.get(i)) * 100;
				percent.add(i, a); // ����� ����

			} else {

				double b = ((price.get(i) - tm_price.get(i)) / (double) tm_price.get(i)) * 100;
				percent.add(i, -b); // �϶��� ����
			}

		}

		System.out.printf("���� 1�� ���� " + tm_price.get(0) + "�� �� ���Դϴ�.\n");
		System.out.printf("���� 2�� ���� " + tm_price.get(1) + "�� �� ���Դϴ�.\n");

		System.out.printf("���� 1�� (����)������ " + percent.get(0) + "�ۼ�Ʈ, ���� 2�� (����)������" + percent.get(1) + "�ۼ�Ʈ\n");
	}

	public static void today() {
		price = tm_price; // ���� ������ ���� ���ݿ� ������Ʈ

		System.out.print("@@@@" + due + "��°@@@@\n");

		System.out.printf("���� 1�� ����" + price.get(0) + "��, ���� 2�� ����" + price.get(1) + "��\n");

		System.out.printf("���� 1�� ������ " + percent.get(0) + "�ۼ�Ʈ, ���� 2�� ������" + percent.get(1) + "�ۼ�Ʈ\n");

	}

}
