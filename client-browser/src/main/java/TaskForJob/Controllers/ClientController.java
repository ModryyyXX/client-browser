package TaskForJob.Controllers;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import TaskForJob.db.DBConnector;
import TaskForJob.model.Client;



@Controller
public class ClientController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(){
        return new ModelAndView("home", "clientKey", new Client());
    }
    

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String HomeForm(@ModelAttribute("clientKey") Client client) {


        return "home";
    }

    

    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView AddPage(){
        return new ModelAndView("add", "clientKey", new Client());
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String AddForm(@ModelAttribute("clientKey") Client client) {



        Client client1 = new Client();
        client1 = client;
        DBConnector app = new DBConnector();
		app.addClient(client1);

        return "redirect:home";
    }

   
@RequestMapping(value = "/remove", method = RequestMethod.GET)
public ModelAndView removePage(){
    return new ModelAndView("remove", "removeKey", new Client());
}


@RequestMapping(value = "/remove", method = RequestMethod.POST)
public String removeForm(@ModelAttribute("removeKey") Client client) {

	DBConnector app = new DBConnector();
	app.removeClient(client.getId());

    return "redirect:home";
}

@RequestMapping(value = "/all", method = RequestMethod.GET)
public String usersPage(Model model){

	 DBConnector app = new DBConnector();
    model.addAttribute("clientslist", app.getListOfAllClients());
    return "all";
}


@RequestMapping(value = "/display", method = RequestMethod.GET)
public ModelAndView dPage(){
    return new ModelAndView("display", "displayKey", new Client());
}

@RequestMapping(value = "/display", method = RequestMethod.POST)
public String displayForm(final Model model, @ModelAttribute("displayKey") Client client, 
		final RedirectAttributes redirectAttributes,
		final BindingResult mapping1BindingResult) {

	DBConnector app = new DBConnector();
	
	Client client2 = app.detailsOfClient(client.getId());
	client = client2;
	model.addAttribute("displayKey",app.detailsOfClient(client.getId()));
	
	redirectAttributes.addFlashAttribute("displayKey",  client);
    return "redirect:result";
}

@RequestMapping(value = "/result", method = RequestMethod.GET)
public String resultPage( @ModelAttribute("displayKey") final Client client,
        final BindingResult mapping1BindingResult,
        final Model model){
	model.addAttribute("displayKey", client);
	
    return "result";
}

}