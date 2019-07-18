package org.Kader.controller;

import org.Kader.dao.ProductRepository;
import org.Kader.enties.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class controllerMVC {
	
	
	@Autowired 
	private ProductRepository productRepository;
	
	@RequestMapping(value="/index")
	public String index(Model model, @RequestParam(name = "page",defaultValue = "0") int page,
						              @RequestParam(name = "size",defaultValue = "5") int size,
						              @RequestParam(name = "motCle",defaultValue = "")String mc) {

		Page<Product> pageProducts= productRepository.chercherMC("%"+mc+"%",PageRequest.of(page,size));

		model.addAttribute("listProducts",pageProducts.getContent());
		int [] pages=new int[pageProducts.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("size",size);
		model.addAttribute("pageCourant",page);
		model.addAttribute("motCle",mc);
		return "produits";
	}

	@RequestMapping(value="/delete")
	public String delete(Long id,String motCle,int page,int size) {
		productRepository.deleteById(id);
		return "redirect:/index?page="+page+"&size="+size+"&motCle="+motCle;
	}

	@RequestMapping(value="/addProduct",method = RequestMethod.GET)
	public String addProduct(Model model,Product product){
		model.addAttribute("product",new Product());
		return "addProduct";
	}
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public String edit(Model model,Long id,String motCle,int page,int size){
		Product product=productRepository.findById(id).get();
		model.addAttribute("product",product);
		return "edit";
	}

	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(Model model, @Valid Product product, Errors errors){

		if(errors.hasErrors()){
			return "addProduct";
		}else{
			productRepository.save(product);
			model.addAttribute("message","Registration Successfully...");
			model.addAttribute("product",product);
			//return "addProduct";
			return "confirmation";
		}


	}

}
