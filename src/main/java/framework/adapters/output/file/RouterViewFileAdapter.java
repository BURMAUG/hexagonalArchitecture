package framework.adapters.output.file;

import application.ports.output.RouterViewOutputPort;
import domain.entity.Router;
import domain.valueobjects.RouterId;
import domain.valueobjects.RouterType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RouterViewFileAdapter implements RouterViewOutputPort {
    private static RouterViewFileAdapter fileAdapter;
    @Override
    public List<Router> fetchRouters() {
        return readFileAsString();
    }

    private List<Router> readFileAsString() {
        List<Router> routers = new ArrayList<>();
        try(Stream<String> stream = new BufferedReader(
                new InputStreamReader(
                        RouterViewFileAdapter.class.getResourceAsStream("routers.txt"))).lines()){
            stream.forEach(line -> {
                String[] routerEntry = line.split(";");
                var id = routerEntry[0];
                var type = routerEntry[1];
                Router router = new Router(RouterType.valueOf(type), RouterId.withId(id));
                routers.add(router);
            });
        }
        return routers;
    }
    public static RouterViewFileAdapter getInstance(){
        if (fileAdapter == null){
            fileAdapter = new RouterViewFileAdapter();
        }
        return fileAdapter;
    }
}
