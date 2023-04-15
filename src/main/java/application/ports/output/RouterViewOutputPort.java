package application.ports.output;

import domain.entity.Router;

public interface RouterViewOutputPort {
    java.util.List<Router> fetchRouters();
}
