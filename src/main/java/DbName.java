import service.QuizService;


public class DbName {

    public static void main(String[] args) throws Exception {

        QuizService quizService = new QuizService();
        System.out.println(quizService.get("1").getQuestions());
        System.out.println(quizService.getAll());

        System.out.println();
    }

}
