package com.glossapro.glossalearn.configurations;

import com.glossapro.glossalearn.entities.LessonEntity;
import com.glossapro.glossalearn.entities.TagEntity;
import com.glossapro.glossalearn.requests.CreateLessonRequest;
import com.glossapro.glossalearn.requests.UpdateLessonRequest;
import com.glossapro.glossalearn.responses.LessonViewModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper configureModelMapper() {

        Converter<Set<String>, Set<TagEntity>> tagsConverter = context -> context.getSource().stream()
                .map(tag -> {
                    TagEntity tagModel = new TagEntity();
                    tagModel.setName(tag);
                    return tagModel;
                })
                .collect(Collectors.toSet());


        Converter<Set<TagEntity>, Set<String>> revertTagsConverter = context -> context.getSource().stream()
                .map(TagEntity::getName)
                .collect(Collectors.toSet());

        ModelMapper modelMapper = new ModelMapper();


        modelMapper.typeMap(CreateLessonRequest.class, LessonEntity.class).addMappings(mapper ->
                mapper.using(tagsConverter).map(CreateLessonRequest::getTags, LessonEntity::setTags)
        );

        modelMapper.typeMap(UpdateLessonRequest.class, LessonEntity.class).addMappings(mapper ->
                mapper.using(tagsConverter).map(UpdateLessonRequest::getTags, LessonEntity::setTags)
        );

        modelMapper.typeMap(LessonEntity.class, LessonViewModel.class).addMappings(mapper ->
                mapper.using(revertTagsConverter).map(LessonEntity::getTags, LessonViewModel::setTags)
        );


        return modelMapper;
    }
}
