package org.soyphea;

import lombok.extern.slf4j.Slf4j;
import org.soyphea.domain.Subject;
import org.soyphea.domain.Teacher;
import org.soyphea.repositories.SubjectRepository;
import org.soyphea.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MyRunner {

    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public MyRunner(SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        Subject subject = new Subject();
        Teacher teacher = new Teacher();

        teacher.setGender("Female");
        teacher.setName("Sidara");

        subject.setName("Spring Framework5");
        subject.setSchedule("Evening");

        subject.getTeachers().add(teacher);
        teacher.getSubjects().add(subject);
        return args -> {
            {
                subjectRepository.save(subject);
            }

            {
                teacherRepository.save(teacher);
            }
            {
            log.info("Subject count:{}",subjectRepository.count());
            }

        };
    }
}
