package application.ports.input;

import application.ports.output.RouterViewOutputPort;
import application.usecases.RouterViewUseCase;
import domain.entity.Router;

import java.util.List;
import java.util.function.Predicate;

public class RouterViewInputPort implements RouterViewUseCase {
    private RouterViewOutputPort routerViewOutputPort;
    public  RouterViewInputPort(RouterViewOutputPort routerOutputPort){
        this.routerViewOutputPort = routerOutputPort;
    }
    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        List<Router> routers = routerViewOutputPort.fetchRouters();
        return Router.retrieveRouter(routers, filter);
    }
}
