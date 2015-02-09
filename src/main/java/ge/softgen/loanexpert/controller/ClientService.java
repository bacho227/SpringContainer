package ge.softgen.loanexpert.controller;

import ge.softgen.loanexpert.model.forms.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Bacho on 2/9/15.
 */

@Controller
@RequestMapping(value = "/client/")
public class ClientService {

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
}
