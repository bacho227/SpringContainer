package ge.softgen.loanexpert.controller;

import ge.softgen.loanexpert.model.SecUser;
import ge.softgen.loanexpert.model.forms.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Bacho on 2/9/15.
 */

@Controller
@RequestMapping(value = "/client/")
public class ClientService {
	@PersistenceContext
	private EntityManager em;

	@RequestMapping(value = "addClient", method = RequestMethod.POST)
	@ResponseBody
	public Client addClient(@RequestBody Client client) {
		return client;
	}

	@RequestMapping(value = "editClient", method = RequestMethod.POST)
	@ResponseBody
	public Client editClient(@RequestBody Client client) {
		return client;
	}

	@RequestMapping(value = "removeClient", method = RequestMethod.POST)
	@ResponseBody
	public Client removeClient(@RequestBody Client client) {
		return client;
	}

	@RequestMapping(value = "test", method = RequestMethod.POST)
	@ResponseBody
	public List<SecUser> test() {
		Query q = em.createQuery("SELECT t from SecUser t");
		return q.getResultList();
	}
}
