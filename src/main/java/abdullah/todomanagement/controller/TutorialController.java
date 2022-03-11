package abdullah.todomanagement.controller;

import abdullah.todomanagement.config.TokenException;
import abdullah.todomanagement.config.TokenManager;
import abdullah.todomanagement.model.Todo;
import abdullah.todomanagement.model.Tutorial;
import abdullah.todomanagement.repository.TutorialRepository;
import abdullah.todomanagement.service.ITodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
public class TutorialController {

	@Autowired
	private TutorialRepository tutorialRepository;

	@RequestMapping(value = "/tutorials", method = RequestMethod.GET)
	public List<Tutorial> getAllTutorials() {
		return tutorialRepository.findAll();
	}

	@RequestMapping(value = "/tutorials", method = RequestMethod.DELETE)
	public void deleteAllTutorials() {
		tutorialRepository.deleteAll();
	}

	@RequestMapping(value = "/tutorials/{id}", method = RequestMethod.GET)
	public Tutorial getTutorialById(@PathVariable Long id) {
		return tutorialRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@RequestMapping(value = "/tutorials/{id}", method = RequestMethod.PUT)
	public Tutorial updateTutorialById(@PathVariable Long id,@RequestBody Tutorial tutorial) {
		Tutorial dbTutorial =  tutorialRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		BeanUtils.copyProperties(tutorial,dbTutorial);
		dbTutorial = tutorialRepository.save(dbTutorial);
		return dbTutorial;
	}

	@RequestMapping(value = "/tutorials/{id}", method = RequestMethod.DELETE)
	public void deleteTutorialById(@PathVariable Long id) {
		tutorialRepository.deleteById(id);
	}

	@RequestMapping(value = "/tutorials", method = RequestMethod.POST)
	public Tutorial saveTutorials(@RequestBody Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}

	@RequestMapping(value = "/tutorials/search", method = RequestMethod.GET)
	public List<Tutorial> findByTitle(@RequestParam String title) {
		return tutorialRepository.findByTitleIsLike(title);
	}
}
