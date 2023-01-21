package com.example.concordianapp.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Employee {

  @Id
  public Long id;
  public String name;
  public String email;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Employee employee = (Employee) o;
    return id != null && Objects.equals(id, employee.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
