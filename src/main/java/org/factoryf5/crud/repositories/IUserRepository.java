package org.factoryf5.crud.repositories;

import org.factoryf5.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// una clase que nos permite hacer consultas a una base de datos pero hay paquetes q nos lo facilita por defecto
// Tenemos que definir 2 genericos UserModel y Long
@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
}
