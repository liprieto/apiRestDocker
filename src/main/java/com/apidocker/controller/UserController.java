package com.apidocker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apidocker.exception.NotFoundException;
import com.apidocker.model.User;
import com.apidocker.service.IUserService;


/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/api")
public class UserController {

  /** The user repository. */
  @Autowired
  private IUserService userService;

  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
      throws NotFoundException {
    User user = userService.getUserById(userId);
    return ResponseEntity.ok().body(user);
  }

  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/users")
  public User createUser(@Validated @RequestBody User user) {
	  userService.saveUser(user);
    return user;
  }

  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable(value = "id") Long userId, @Validated @RequestBody User user)
      throws NotFoundException {
    User updatedUser = userService.updateUser(userId, user);
    return ResponseEntity.ok(updatedUser);
  }

  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    return userService.deleteUser(userId);
  }
}
