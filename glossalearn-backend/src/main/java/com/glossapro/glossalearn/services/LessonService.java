package com.glossapro.glossalearn.services;

import com.glossapro.glossalearn.repositories.LessonRepository;
import com.glossapro.glossalearn.entities.LessonEntity;
import com.glossapro.glossalearn.requests.CreateLessonRequest;
import com.glossapro.glossalearn.requests.UpdateLessonRequest;
import com.glossapro.glossalearn.responses.LessonViewModel;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@CacheConfig(cacheNames = "lessonCache")
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ModelMapper mapper;

    @Cacheable(cacheNames = "lessons")
    @Transactional
    public List<LessonViewModel> getAll() {
        waitSomeTime();
        return mapper.map(this.lessonRepository.findAll(), new TypeToken<List<LessonViewModel>>() {
        }.getType());
    }

    @CacheEvict(cacheNames = "lessons", allEntries = true)
    public LessonViewModel add(CreateLessonRequest request) {

        LessonEntity lesson = mapper.map(request, LessonEntity.class);
        lesson.setId(UUID.randomUUID());

        return mapper.map(this.lessonRepository.save(lesson), LessonViewModel.class);
    }

    @CacheEvict(cacheNames = "lessons", allEntries = true)
    public LessonViewModel update(UpdateLessonRequest request) {

        LessonEntity lesson = mapper.map(request, LessonEntity.class);

        Optional<LessonEntity> optLesson = this.lessonRepository.findById(lesson.getId());
        if (optLesson.isEmpty())
            return null;
        LessonEntity repLesson = optLesson.get();
        repLesson.setTitle(lesson.getTitle());
        return mapper.map(this.lessonRepository.save(repLesson), LessonViewModel.class);
    }

    @Caching(evict = {@CacheEvict(cacheNames = "lesson", key = "#id"),
            @CacheEvict(cacheNames = "lessons", allEntries = true)})
    public void delete(UUID id) {
        this.lessonRepository.deleteById(id);
    }

    @Cacheable(cacheNames = "lesson", key = "#id", unless = "#result == null")
    public LessonViewModel getLessonById(UUID id) {
        waitSomeTime();
        return mapper.map(this.lessonRepository.findById(id).orElse(null), LessonViewModel.class);
    }

    private void waitSomeTime() {
        System.out.println("Long Wait Begin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Long Wait End");
    }
}