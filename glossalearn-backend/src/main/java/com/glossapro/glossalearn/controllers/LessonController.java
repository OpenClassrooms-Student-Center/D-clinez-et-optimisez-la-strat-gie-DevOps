package com.glossapro.glossalearn.controllers;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.glossapro.glossalearn.requests.CreateLessonRequest;
import com.glossapro.glossalearn.requests.UpdateLessonRequest;
import com.glossapro.glossalearn.responses.GetLessonResponse;
import com.glossapro.glossalearn.responses.GetLessonsResponse;
import com.glossapro.glossalearn.responses.LessonViewModel;
import com.glossapro.glossalearn.services.LessonService;
import com.glossapro.glossalearn.entities.LessonEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class LessonController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private LessonService lessonService;

    @GetMapping(value = "/lessons")
    public ResponseEntity<GetLessonsResponse> getAllLessons() {
        List<LessonViewModel> lessons = this.lessonService.getAll();

        GetLessonsResponse response = new GetLessonsResponse();
        response.setData(Set.copyOf(lessons));

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/lessons/{id}")
    public ResponseEntity<GetLessonResponse> getLessonById(@PathVariable("id") UUID id) {
        LessonViewModel lesson = this.lessonService.getLessonById(id);

        GetLessonResponse response = new GetLessonResponse();
        response.setData(lesson);

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/lessons")
    public ResponseEntity<GetLessonResponse> addLesson(@RequestBody CreateLessonRequest request) {
        LessonViewModel created = this.lessonService.add(request);

        GetLessonResponse response = new GetLessonResponse();
        response.setData(created);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/lessons")
    public ResponseEntity<GetLessonResponse> updateLesson(@RequestBody UpdateLessonRequest request) {
        LessonViewModel updated = this.lessonService.update(request);

        GetLessonResponse response = new GetLessonResponse();
        response.setData(updated);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/lessons/{id}")
    public ResponseEntity<Boolean> deleteLessonById(@PathVariable("id") UUID id) {
        this.lessonService.delete(id);
        return ResponseEntity.ok(true);
    }
}