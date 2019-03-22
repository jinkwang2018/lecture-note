import java.io.Serializable;
import java.util.*;

/*
��    ¥ : 2018-02-23
�ۼ��ڸ� : ������
��    ��: Ÿ�Ӷ��� ���� ����
*/
public class TimeLine implements Serializable {

	private Map<Integer, Post> posts;

	public TimeLine() {
		// �� ���� ����ޱ� ���ؼ� LinkedHashMap
		// �� ��ȣ ������ ���� �޾ƾ���
		posts = new LinkedHashMap<>();
	} // ������

	public Map<Integer, Post> getPosts() {
		return posts;
	}

	public void showPosts() { // �Խñ� �����ֱ�

		if (posts.isEmpty()) {
			System.out.println("�Խù��� �����ϴ�");
		} else {
			for (Map.Entry<Integer, Post> e : posts.entrySet()) {
				e.getValue().printPost();
			}
		}

	} // end - showPosts

	public String date_Calculate() { // �ۼ��� ���
		String rightnow = null;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH) + 1);
		int date = cal.get(Calendar.DATE);

		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		rightnow = Integer.toString(year) + "��" + Integer.toString(month) + "��" + Integer.toString(date) + "��" + "  "
				+ Integer.toString(hour) + "��" + Integer.toString(minute) + "��" + Integer.toString(second) + "��";

		return rightnow; // ���ϰ��� ���� �Խñ� �ۼ��ð����� ���

	} // end - date_Calculate

	public void writePost(String username) { // �Խñ� ����

		Scanner sc = new Scanner(System.in);

		List<String> content = new ArrayList<String>();
		boolean outWritePost = true;
		boolean exit_exist = false;
		boolean exit_140 = false;

		while (outWritePost) {
			// �ִ� 5�� �ٳ��� �Է� �䱸
			for (int i = 1; i < 6; i++) {

				if (i == 1) {
					System.out.println("�ִ� 5��, 140�� �̳�, ���� ���ϸ� exit �Է�");
					System.out.println();
				}
				System.out.print(i + "��° �� : ");
				String temp = sc.nextLine();

				// 5�� �� �Ⱥ��� ���Ḧ ���� �ϰ� ������
				if (temp.equals("exit")) {
					exit_exist = true;
					System.out.println("�Է��� �����մϴ�");
					break;
				}
				// ���� ���ڵ��� content�� ������� ����
				content.add(temp);

				if (i == 5) {
					System.out.println("5�� ��� �Է��ϼ̽��ϴ�");
					System.out.println("�Է��� �����մϴ�");
					System.out.println();
				}
			}

			// �Է¹��� ���� ���ڼ� ��� ���ؼ� ��ø��Ű��
			String size = null;
			for (int i = 0; i < content.size(); i++) {
				size += content.get(i);
			}
			Post post = new Post();
			int contentNum = 0;

			// 140�� �̻��̸� ���Է� �䱸
			char[] contentsize_char = size.toCharArray();

			// exit �Է����� ���� �����Ѵٸ� �ִ�ġ�� 140�� -> 144�� ����
			if (exit_exist) {
				if (contentsize_char.length <= 144) {

					// �� ��ȣ +1 ó��
					contentNum = posts.size() + 1;
					post.setContent(content);
					post.setDate(date_Calculate());
					post.setWriter(username);
					post.setContentNum(contentNum);

					posts.put(contentNum, post);

					// ����� �Է� �޾����Ƿ� ���Ḧ ���� boolean ��ȯ
					outWritePost = false;
				} else {
					System.out.println("140�� �ʰ��Դϴ�");
					System.out.println("�ٽ� �Է����ֽʽÿ�");
				}
			}

			// exit_exist�� false �� 140�� �������� ������ ����
			else {
				if (contentsize_char.length <= 140) {

					// �� ��ȣ +1 ó��
					contentNum = posts.size() + 1;
					post.setContent(content);
					post.setDate(date_Calculate());
					post.setWriter(username);
					post.setContentNum(contentNum);

					posts.put(contentNum, post);

					// ����� �Է� �޾����Ƿ� ���Ḧ ���� boolean ��ȯ
					outWritePost = false;
				} else {
					System.out.println("140�� �ʰ��Դϴ�");
					System.out.println("�ٽ� �Է����ֽʽÿ�");
				}
			}
		} // end - while
		Bitgram.putToDB(); // �ش� ���� ���Ͽ� ����

	} // end - writePost

	public void deletePost(int contentNum, String this_user) { // �� ����

		Map<Integer, Post> temp_map = (Bitgram.userinfo.get(this_user)).mytimeline.getPosts();

		if (temp_map.size() >= contentNum) { // ���� �Է°��� map�� ������� �۴ٸ�, �ش� content�� �����ϹǷ� ���� ����
			temp_map.remove(contentNum);

			Map<Integer, Post> temp_map2 = new LinkedHashMap<>();

			int setContentnum = 0;
			for (Map.Entry<Integer, Post> e : temp_map.entrySet()) {

				// ������� ���ư��鼭 ó������ �� ��ҵ���
				// �� ��ȣ�� 1, 2, 3 ... ���������� ����
				setContentnum++;

				Post post = e.getValue();
				post.setContentNum(setContentnum);

				temp_map2.put(setContentnum, post);
			}
			temp_map.clear();

			for (Map.Entry<Integer, Post> e : temp_map2.entrySet()) {
				temp_map.put(e.getKey(), e.getValue());
			}
			System.out.println("�Խñ��� ���������� �����Ǿ����ϴ�");
		} else { // �Է¹��� ���ڿ� �ش��ϴ� �Խñ��� �������� ���� ��
			System.out.println("�ش�Ǵ� �Խñ��� �������� �ʽ��ϴ�.");
		}
		Bitgram.putToDB(); // �ش� ���� ���Ͽ� ����
	} // end - deletePost

	public void changePost(int contentNum) { // �� ����

		Scanner sc = new Scanner(System.in);
		Post post = new Post();

		if (posts.size() >= contentNum) {
			for (Map.Entry<Integer, Post> e : posts.entrySet()) {
				if (contentNum == e.getKey()) {
					post = e.getValue();
					List<String> content = new ArrayList<String>();
					boolean outWritePost = true;
					boolean exit_exist = false;
					boolean exit_140 = false;

					while (outWritePost) {
						// �ִ� 5�� �ٳ��� �Է� �䱸
						for (int i = 1; i < 6; i++) {

							if (i == 1) {
								System.out.println("�ִ� 5��, 140�� �̳�, ���� ���ϸ� exit �Է�");
								System.out.println();
							}

							System.out.print(i + "��° �� : ");
							String temp = sc.nextLine();

							// 5�� �� �Ⱥ��� ���Ḧ ���� �ϰ� ������
							if (temp.equals("exit")) {
								exit_exist = true;
								System.out.println("�Է��� �����մϴ�");
								break;
							}

							// ���� ���ڵ��� content�� ������� ����
							content.add(temp);

							if (i == 5) {
								System.out.println("5�� ��� �Է��ϼ̽��ϴ�");
								System.out.println("�Է��� �����մϴ�");
								System.out.println();
							}
						}

						// �Է¹��� ���� ���ڼ� ��� ���ؼ� ��ø��Ű��
						String size = null;
						for (int i = 0; i < content.size(); i++) {
							size += content.get(i);
						}

						// 140�� �̻��̸� ���Է� �䱸
						char[] contentsize_char = size.toCharArray();

						// exit �Է����� ���� �����Ѵٸ� �ִ�ġ�� 140�� -> 144�� ����
						if (exit_exist) {
							if (contentsize_char.length <= 144) {

								// �� ��ȣ +1 ó��
								post.setContent(content);
								post.setDate(date_Calculate());
								post.setWriter(post.getWriter());
								post.setContentNum(contentNum);

								posts.put(contentNum, post);

								// ����� �Է� �޾����Ƿ� ���Ḧ ���� boolean ��ȯ
								outWritePost = false;
							} else {
								System.out.println("140�� �ʰ��Դϴ�");
								System.out.println("�ٽ� �Է����ֽʽÿ�");
							}
						}

						// exit_exist�� false �� 140�� �������� ������ ����
						else {
							if (contentsize_char.length <= 140) {

								// �� ��ȣ +1 ó��
								post.setContent(content);
								post.setDate(date_Calculate());
								post.setWriter(post.getWriter());
								post.setContentNum(contentNum);

								posts.put(contentNum, post);

								// ����� �Է� �޾����Ƿ� ���Ḧ ���� boolean ��ȯ
								outWritePost = false;
							} else {
								System.out.println("140�� �ʰ��Դϴ�");
								System.out.println("�ٽ� �Է����ֽʽÿ�");
							}
						}
					}
				}
			}

			int setContentnum = 0;
			for (Map.Entry<Integer, Post> e : posts.entrySet()) {

				// ������� ���ư��鼭 ó������ �� ��ҵ���
				// �� ��ȣ�� 1, 2, 3 ... ���������� ����
				setContentnum++;
				e.getValue().setContentNum(setContentnum);

			}
			System.out.println("�Խñ��� ���������� �����Ǿ����ϴ�");
		} else {
			System.out.println("�ش�Ǵ� �Խñ��� �������� �ʽ��ϴ�.");
		}
		Bitgram.putToDB(); // �ش� ���� ���Ͽ� ����
	} // end - changePost

} // end - class
