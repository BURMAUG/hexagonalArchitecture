package framework.adapters.input.stdin;

import application.ports.input.RouterViewInputPort;
import application.usecases.RouterViewUseCase;
import domain.entity.Router;
import domain.valueobjects.RouterType;
import framework.adapters.output.file.RouterViewFileAdapter;

public class RouterViewCLIAdapter {
    RouterViewUseCase routerViewUseCase;
    RouterViewCLIAdapter(){
        setAdapters();
    }
    public java.util.List<Router> obtainRelatedRouters(String type){
        return routerViewUseCase.getRouters(Router.filterRouterByType(RouterType.valueOf(type)));
    }
    private void setAdapters(){
        routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance());
    }

}
