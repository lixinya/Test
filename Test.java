import java.io.File;
import java.util.Stack;

import javax.annotation.PostConstruct;

public class Test {

	public static void main(String[] args) {
		File file = new File("c:\\CheckTest");// �����ļ�
		int level = 0; // Ŀ¼����
		Stack<Boolean> stacks = new Stack<Boolean>(); // ͨ��ջ�洢booleanֵ
		iterorderDirectory(file, level, stacks);
	}

	/**
	 * 
	 * @param file
	 *            �ļ�
	 * @param level
	 *            Ŀ¼���
	 * @param stacks
	 *            ��¼Booleanֵ
	 * 
	 * 
	 */
	private static void iterorderDirectory(File file, int level,
			Stack<Boolean> stacks) {
		printFileTree(file, level, stacks); // ��ӡĿ¼��
		if (file.isFile()) {
			return;
		}
		if (file.isDirectory()) {

			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				stacks.push(i == files.length - 1);      // ͨ����ȡ��Ŀ¼�����Ƿ����i��ȡ�����ֵ�Ž�ջ
				iterorderDirectory(files[i], level + 1, stacks);
				stacks.pop();
			}
			}

	}

	/**
	 * ��ӡĿ¼������
	 * @param file
	 * @param level
	 * @param stacks
	 * @param stacks.size() ջ�ĳ���
	 */
	private static void printFileTree(File file, int level,
			Stack<Boolean> stacks) {

		for (int j = 0; j < stacks.size() - 1; j++) {    // jֵҪ����ջ���ȼ�һ
			System.out.print(stacks.get(j) ? "   " : "|  ");
		}
		if (level > 0) {
			System.out.print("|--");
		}
		System.out.println(level == 0 ? file.getPath() : file.getName());
	}
}
