package com.apidocker.service;

import java.util.List;
import java.util.Map;

import com.apidocker.model.User;

/**
 * The Interface IUserService.
 * Exponer acciones de mantenimiento para usuarios
 */
public interface IUserService {
	
/**
 * Gets the all users.
 *
 * @return the all users
 */
List<User> getAllUsers();

/**
 * Gets the user by id.
 *
 * @param userId the user id
 * @return the user by id
 */
User getUserById(Long userId);

/**
 * Save user.
 *
 * @param user the user
 * @return the user
 */
User saveUser(User user);

/**
 * Update user.
 *
 * @param userId the user id
 * @param user the user
 * @return the user
 */
User updateUser(Long userId, User user);

/**
 * Delete user.
 *
 * @param userId the user id
 * @return the user
 */
Map<String, Boolean> deleteUser(Long userId);
}

