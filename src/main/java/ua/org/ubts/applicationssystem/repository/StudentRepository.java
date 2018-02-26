package ua.org.ubts.applicationssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.org.ubts.applicationssystem.entity.Student;

import java.util.List;

/**
 * Created by Yaroslav on 18.07.2017.
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.middleName = ?2 AND s.lastName = ?3")
    Student findByName(String firstName, String middleName, String lastName);

    @Query("SELECT s FROM Student s WHERE s.entryYear.value IN :years")
    List<Student> findByEntryYears(@Param("years") Integer[] entryYears);

}
