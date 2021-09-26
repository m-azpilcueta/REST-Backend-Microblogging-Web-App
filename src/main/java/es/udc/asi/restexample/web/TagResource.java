package es.udc.asi.restexample.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.udc.asi.restexample.model.service.TagService;
import es.udc.asi.restexample.model.service.dto.TagDTO;
import es.udc.asi.restexample.web.exceptions.RequestBodyNotValidException;

@RestController
@RequestMapping("/api/tags")
public class TagResource {

  @Autowired
  private TagService tagService;

  @GetMapping
  public List<TagDTO> findAll() {
    return tagService.findAll();
  }
  
  @PostMapping
  public TagDTO create(@RequestBody @Valid TagDTO tag, Errors errors) throws RequestBodyNotValidException {
    if (errors.hasErrors()) {
      throw new RequestBodyNotValidException(errors);
    }

    return tagService.create(tag);
  }
}
