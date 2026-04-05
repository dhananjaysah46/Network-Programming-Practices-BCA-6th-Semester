public class Example {
    public static void main(String[] args) {
        // for(String s:args) {
        // System.out.println("Hello " + s);
        // }

        Person p = new Person();
        p.setName("Ram");
        p.setAddress("KTM");
        p.setAge(22);

        System.out.println(p.toString());
    }
}
