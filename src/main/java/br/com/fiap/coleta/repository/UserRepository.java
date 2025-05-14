package br.com.fiap.coleta.repository;

import br.com.fiap.coleta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


}
