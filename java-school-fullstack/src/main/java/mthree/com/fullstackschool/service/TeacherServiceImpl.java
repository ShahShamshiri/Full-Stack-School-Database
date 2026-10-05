package mthree.com.fullstackschool.service;

import mthree.com.fullstackschool.dao.TeacherDao;
import mthree.com.fullstackschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherServiceInterface {

    private TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }


    public List<Teacher> getAllTeachers() {

        return teacherDao.getAllTeachers();
    }

    public Teacher getTeacherById(int id) {

        try {
            return teacherDao.findTeacherById(id);

        } catch (DataAccessException e) {

            Teacher teacher = new Teacher();

            teacher.setTeacherFName("Teacher Not Found.");
            teacher.setTeacherLName("Teacher Not Found.");

            return teacher;
        }
    }

    public Teacher addNewTeacher(Teacher teacher) {

        if (teacher.getTeacherFName() == null
                || teacher.getTeacherFName().isBlank()
                || teacher.getTeacherLName() == null
                || teacher.getTeacherLName().isBlank()) {

            teacher.setTeacherFName("First Name blank, teacher NOT added");

            teacher.setTeacherLName("Last Name blank, teacher NOT added");

            return teacher;
        }

        return teacherDao.createNewTeacher(teacher);
    }

    public Teacher updateTeacherData(int id, Teacher teacher) {

        if (id != teacher.getTeacherId()) {

            teacher.setTeacherFName("IDs do not match, teacher not updated");

            teacher.setTeacherLName("IDs do not match, teacher not updated");

            return teacher;
        }

        teacherDao.updateTeacher(teacher);

        return teacher;
    }

    public void deleteTeacherById(int id) {

        teacherDao.deleteTeacher(id);
    }
}
