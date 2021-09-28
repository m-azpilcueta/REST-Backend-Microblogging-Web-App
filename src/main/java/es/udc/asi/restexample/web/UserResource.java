package es.udc.asi.restexample.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.udc.asi.restexample.model.exception.NotFoundException;
import es.udc.asi.restexample.model.exception.OperationNotAllowed;
import es.udc.asi.restexample.model.service.UserService;
import es.udc.asi.restexample.model.service.dto.UserDTOPublic;

@RestController
@RequestMapping("/api/users")
public class UserResource {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<UserDTOPublic> findAll() {
    return userService.findAll();
  }
  
  @GetMapping("/{id}")
  public UserDTOPublic findOne(@PathVariable Long id) throws NotFoundException {
	return userService.findById(id);  
  }
  
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    userService.deleteById(id);
  }
  
  @PutMapping("/{id}/activate")
  public void activate(@PathVariable Long id) throws NotFoundException, OperationNotAllowed {
	  userService.updateActive(id, true);
  }
  
  @PutMapping("/{id}/deactivate")
  public void deactivate(@PathVariable Long id) throws NotFoundException, OperationNotAllowed {
	  userService.updateActive(id, false);
  }
}
