import framework.adapters.input.stdin.RouterViewCLIAdapter;

public class App {
    public static void main(String[] args) {
        RouterViewCLIAdapter cli = new RouterViewCLIAdapter();
        String type = "CORE";
        System.out.println(cli.obtainRelatedRouters(type));
    }
}
