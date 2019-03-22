
public class Quiz01_gift {
	public static void main(String[] args) {
		/*
         * 개별 Quiz
         * 만들려고 하는 시스템은 백화점 경품 추첨 시스템입니다.
         * 경품 추첨시 1000 점수가 나오면
         * 경품으로 Tv, NoteBook, 냉장고, 한우세트, 휴지
         * 경품 추첨시 900 점수가 나오면
         * 경품으로 NoteBook, 냉장고, 한우세트, 휴지
         * 경품 추첨시 800 점수가 나오면
         * 경품으로 냉장고, 한우세트, 휴지
         * 경품 추첨시 700 점수가 나오면
         * 경품으로 한우세트, 휴지
         * 경품 추첨시 600 점수가 나오면
         * 경품으로 휴지
         * 그 외는 100 ~ 500 까지는 칫솔
         * 
         * 사용자가 와서 경품 시스템을 사용하게 되면 랜덤하게 100 ~ 1000까지의 점수가 나온다.
         */
        
        int score = (int)(Math.random() * 10 + 1) * 100;
        String gift = "";
        
        switch(score) {
        	case 1000:
        		gift += "Tv ";
        	case 900:
        		gift += "NoteBook ";
        	case 800:
        		gift += "냉장고 ";
        	case 700:
        		gift += "한우세트 ";
        	case 600:
        		gift += "휴지";
        		break;
        	default:
        		gift = "칫솔";
        }
        System.out.println("점수: " + score + " / " + "경품: " + gift);
	}

}
