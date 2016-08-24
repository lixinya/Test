import java.io.File;
import java.util.Stack;

import javax.annotation.PostConstruct;

public class Test {

	public static void main(String[] args) {
		File file = new File("c:\\CheckTest");// 创建文件
		int level = 0; // 目录层数
		Stack<Boolean> stacks = new Stack<Boolean>(); // 通过栈存储boolean值
		iterorderDirectory(file, level, stacks);
	}

	/**
	 * 
	 * @param file
	 *            文件
	 * @param level
	 *            目录深度
	 * @param stacks
	 *            记录Boolean值
	 * 
	 * 
	 */
	private static void iterorderDirectory(File file, int level,
			Stack<Boolean> stacks) {
		printFileTree(file, level, stacks); // 打印目录树
		if (file.isFile()) {
			return;
		}
		if (file.isDirectory()) {

			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				stacks.push(i == files.length - 1);      // 通过获取子目录个数是否等于i来取得真假值放进栈
				iterorderDirectory(files[i], level + 1, stacks);
				stacks.pop();
			}
			}

	}

	/**
	 * 打印目录生成树
	 * @param file
	 * @param level
	 * @param stacks
	 * @param stacks.size() 栈的长度
	 */
	private static void printFileTree(File file, int level,
			Stack<Boolean> stacks) {

		for (int j = 0; j < stacks.size() - 1; j++) {    // j值要满足栈长度减一
			System.out.print(stacks.get(j) ? "   " : "|  ");
		}
		if (level > 0) {
			System.out.print("|--");
		}
		System.out.println(level == 0 ? file.getPath() : file.getName());
	}
}
