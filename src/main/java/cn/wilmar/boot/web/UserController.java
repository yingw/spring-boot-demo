package cn.wilmar.boot.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.wilmar.boot.model.User;
import cn.wilmar.boot.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserRepository userRepo;

	// @GetMapping("/users")
	// public List<User> listUsers(@RequestParam(defaultValue = "") String name)
	// {
	// return userRepo.findByNameLike("%"+name+"%");
	// }

	@PostMapping("/users/new")
	// @ResponseBody
	public String createUser(@RequestParam String name) {
		logger.info("UserController.createUser()");
		User user = userRepo.save(new User(name));
		return "redirect:/users/" + user.getId();
	}

	@ApiOperation(value = "List users", notes = "List users with name.")
	@GetMapping("/users")
	public ModelAndView listUsers(
			@ApiParam(name = "name", value = "user's name", required = false)
			@RequestParam(defaultValue = "") String name) {
		logger.info("UserController.listUsers()");
		List<User> users = userRepo.findByNameLike("%" + name + "%");
		return new ModelAndView("users/list", "users", users);
	}

	@GetMapping("/users/{id}")
	public ModelAndView getUser(@PathVariable("id") long id) {
		logger.debug("Sample Debug Message");
		logger.trace("Sample Trace Message");
		logger.error("some error!");
		return new ModelAndView("users/view", "user", userRepo.findOne(id));
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		User user = new User();
		model.put("user", user);
		return "users/form";
	}
}