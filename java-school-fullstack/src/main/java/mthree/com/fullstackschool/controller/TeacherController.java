package mthree.com.fullstackschool.controller;

import mthree.com.fullstackschool.model.Teacher;
import mthree.com.fullstackschool.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {

        return teacherServiceImpl.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {

        return teacherServiceImpl.getTeacherById(id);
    }

    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher teacher) {

        return teacherServiceImpl.addNewTeacher(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(
            @PathVariable int id,
            @RequestBody Teacher teacher) {

        return teacherServiceImpl.updateTeacherData(id, teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id) {

        teacherServiceImpl.deleteTeacherById(id);
    }
}
