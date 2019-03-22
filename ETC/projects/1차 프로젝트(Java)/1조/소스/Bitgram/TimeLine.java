import java.io.Serializable;
import java.util.*;

/*
날    짜 : 2018-02-23
작성자명 : 김정권
기    능: 타임라인 내용 구현
*/
public class TimeLine implements Serializable {

	private Map<Integer, Post> posts;

	public TimeLine() {
		// 들어간 순서 보장받기 위해서 LinkedHashMap
		// 글 번호 때문에 보장 받아야함
		posts = new LinkedHashMap<>();
	} // 생성자

	public Map<Integer, Post> getPosts() {
		return posts;
	}

	public void showPosts() { // 게시글 보여주기

		if (posts.isEmpty()) {
			System.out.println("게시물이 없습니다");
		} else {
			for (Map.Entry<Integer, Post> e : posts.entrySet()) {
				e.getValue().printPost();
			}
		}

	} // end - showPosts

	public String date_Calculate() { // 작성일 출력
		String rightnow = null;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH) + 1);
		int date = cal.get(Calendar.DATE);

		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		rightnow = Integer.toString(year) + "년" + Integer.toString(month) + "월" + Integer.toString(date) + "일" + "  "
				+ Integer.toString(hour) + "시" + Integer.toString(minute) + "분" + Integer.toString(second) + "초";

		return rightnow; // 리턴값은 현재 게시글 작성시간으로 출력

	} // end - date_Calculate

	public void writePost(String username) { // 게시글 쓰기

		Scanner sc = new Scanner(System.in);

		List<String> content = new ArrayList<String>();
		boolean outWritePost = true;
		boolean exit_exist = false;
		boolean exit_140 = false;

		while (outWritePost) {
			// 최대 5개 줄내에 입력 요구
			for (int i = 1; i < 6; i++) {

				if (i == 1) {
					System.out.println("최대 5줄, 140자 이내, 종료 원하면 exit 입력");
					System.out.println();
				}
				System.out.print(i + "번째 줄 : ");
				String temp = sc.nextLine();

				// 5줄 다 안보고 종료를 빨리 하고 싶으면
				if (temp.equals("exit")) {
					exit_exist = true;
					System.out.println("입력을 종료합니다");
					break;
				}
				// 받은 글자들이 content에 순서대로 담긴다
				content.add(temp);

				if (i == 5) {
					System.out.println("5줄 모두 입력하셨습니다");
					System.out.println("입력을 종료합니다");
					System.out.println();
				}
			}

			// 입력받은 내용 글자수 계산 위해서 중첩시키기
			String size = null;
			for (int i = 0; i < content.size(); i++) {
				size += content.get(i);
			}
			Post post = new Post();
			int contentNum = 0;

			// 140자 이상이면 재입력 요구
			char[] contentsize_char = size.toCharArray();

			// exit 입력으로 일찍 종료한다면 최대치가 140자 -> 144자 변경
			if (exit_exist) {
				if (contentsize_char.length <= 144) {

					// 글 번호 +1 처리
					contentNum = posts.size() + 1;
					post.setContent(content);
					post.setDate(date_Calculate());
					post.setWriter(username);
					post.setContentNum(contentNum);

					posts.put(contentNum, post);

					// 제대로 입력 받았으므로 종료를 위해 boolean 변환
					outWritePost = false;
				} else {
					System.out.println("140자 초과입니다");
					System.out.println("다시 입력해주십시오");
				}
			}

			// exit_exist가 false 면 140자 제한으로 로직이 실행
			else {
				if (contentsize_char.length <= 140) {

					// 글 번호 +1 처리
					contentNum = posts.size() + 1;
					post.setContent(content);
					post.setDate(date_Calculate());
					post.setWriter(username);
					post.setContentNum(contentNum);

					posts.put(contentNum, post);

					// 제대로 입력 받았으므로 종료를 위해 boolean 변환
					outWritePost = false;
				} else {
					System.out.println("140자 초과입니다");
					System.out.println("다시 입력해주십시오");
				}
			}
		} // end - while
		Bitgram.putToDB(); // 해당 내용 파일에 저장

	} // end - writePost

	public void deletePost(int contentNum, String this_user) { // 글 삭제

		Map<Integer, Post> temp_map = (Bitgram.userinfo.get(this_user)).mytimeline.getPosts();

		if (temp_map.size() >= contentNum) { // 만약 입력값이 map의 사이즈보다 작다면, 해당 content는 존재하므로 삭제 가능
			temp_map.remove(contentNum);

			Map<Integer, Post> temp_map2 = new LinkedHashMap<>();

			int setContentnum = 0;
			for (Map.Entry<Integer, Post> e : temp_map.entrySet()) {

				// 순서대로 돌아가면서 처음부터 들어간 요소들의
				// 글 번호를 1, 2, 3 ... 순차적으로 갱신
				setContentnum++;

				Post post = e.getValue();
				post.setContentNum(setContentnum);

				temp_map2.put(setContentnum, post);
			}
			temp_map.clear();

			for (Map.Entry<Integer, Post> e : temp_map2.entrySet()) {
				temp_map.put(e.getKey(), e.getValue());
			}
			System.out.println("게시글이 성공적으로 삭제되었습니다");
		} else { // 입력받은 숫자에 해당하는 게시글이 존재하지 않을 때
			System.out.println("해당되는 게시글이 존재하지 않습니다.");
		}
		Bitgram.putToDB(); // 해당 내용 파일에 저장
	} // end - deletePost

	public void changePost(int contentNum) { // 글 수정

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
						// 최대 5개 줄내에 입력 요구
						for (int i = 1; i < 6; i++) {

							if (i == 1) {
								System.out.println("최대 5줄, 140자 이내, 종료 원하면 exit 입력");
								System.out.println();
							}

							System.out.print(i + "번째 줄 : ");
							String temp = sc.nextLine();

							// 5줄 다 안보고 종료를 빨리 하고 싶으면
							if (temp.equals("exit")) {
								exit_exist = true;
								System.out.println("입력을 종료합니다");
								break;
							}

							// 받은 글자들이 content에 순서대로 담긴다
							content.add(temp);

							if (i == 5) {
								System.out.println("5줄 모두 입력하셨습니다");
								System.out.println("입력을 종료합니다");
								System.out.println();
							}
						}

						// 입력받은 내용 글자수 계산 위해서 중첩시키기
						String size = null;
						for (int i = 0; i < content.size(); i++) {
							size += content.get(i);
						}

						// 140자 이상이면 재입력 요구
						char[] contentsize_char = size.toCharArray();

						// exit 입력으로 일찍 종료한다면 최대치가 140자 -> 144자 변경
						if (exit_exist) {
							if (contentsize_char.length <= 144) {

								// 글 번호 +1 처리
								post.setContent(content);
								post.setDate(date_Calculate());
								post.setWriter(post.getWriter());
								post.setContentNum(contentNum);

								posts.put(contentNum, post);

								// 제대로 입력 받았으므로 종료를 위해 boolean 변환
								outWritePost = false;
							} else {
								System.out.println("140자 초과입니다");
								System.out.println("다시 입력해주십시오");
							}
						}

						// exit_exist가 false 면 140자 제한으로 로직이 실행
						else {
							if (contentsize_char.length <= 140) {

								// 글 번호 +1 처리
								post.setContent(content);
								post.setDate(date_Calculate());
								post.setWriter(post.getWriter());
								post.setContentNum(contentNum);

								posts.put(contentNum, post);

								// 제대로 입력 받았으므로 종료를 위해 boolean 변환
								outWritePost = false;
							} else {
								System.out.println("140자 초과입니다");
								System.out.println("다시 입력해주십시오");
							}
						}
					}
				}
			}

			int setContentnum = 0;
			for (Map.Entry<Integer, Post> e : posts.entrySet()) {

				// 순서대로 돌아가면서 처음부터 들어간 요소들의
				// 글 번호를 1, 2, 3 ... 순차적으로 갱신
				setContentnum++;
				e.getValue().setContentNum(setContentnum);

			}
			System.out.println("게시글이 정상적으로 수정되었습니다");
		} else {
			System.out.println("해당되는 게시글이 존재하지 않습니다.");
		}
		Bitgram.putToDB(); // 해당 내용 파일에 저장
	} // end - changePost

} // end - class
