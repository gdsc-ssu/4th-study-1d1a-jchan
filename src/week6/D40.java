import java.util.*;

public class D40 {
    public static void main(String[] args) {
        solution();
    }

    /**
     * D39
     * ✍️ Title : 나이순 정ㅕ
     * ⏰ Time : 
     * 🤔 Approach : 
     * 🚬 Review : Comparator 연습
     */
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        List<Member> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Member(age, name, i)); 
        }

        list.sort(Comparator.comparingInt((Member m) -> m.age).thenComparingInt(m -> m.order));

        for (Member m : list) {
            System.out.println(m.age + " " + m.name);
        }
    }

    static class Member {
        int age;
        String name;
        int order; 

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
}
