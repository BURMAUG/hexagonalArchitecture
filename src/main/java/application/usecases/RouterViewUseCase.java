package application.usecases;

import domain.entity.Router;

import java.util.function.Predicate;

public interface RouterViewUseCase {
    java.util.List<Router>  getRouters(Predicate<Router> filter);
}
