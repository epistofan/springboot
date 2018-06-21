package hello;

import hello.domain.Equation;
import org.springframework.data.repository.CrudRepository;

public interface EqnRepository extends CrudRepository<Equation, String> {

}
